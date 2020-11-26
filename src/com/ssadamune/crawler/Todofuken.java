package com.ssadamune.crawler;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class Todofuken {

    // ====================================================
    // field
    // ====================================================

    private String name;
    private Integer maxHouses;
    private Integer maxMansions;
    private HashSet<Integer> allHouses;
    private HashSet<Integer> allMansions;
    static Logger log = Logger.getLogger("todofuken");

    // ====================================================
    // constructor
    // ====================================================

    Todofuken(String name) {
        this.name = name;
    }

    Todofuken(String name, int maxHouses, int maxMansions) {
        this.name = name;
        this.maxHouses = maxHouses;
        this.maxMansions = maxMansions;
    }

    // ====================================================
    // public
    // ====================================================

    public String getName() {
        return name;
    }

    public void parseAllHouses(Handle handler) {
        HouseParser hp = new HouseParser();
        parseAllProperties(hp, true, handler);
        hp.outputSurpirses();
    }

    public void parseAllMansions(Handle handler) {
        MansionParser mp = new MansionParser();
        parseAllProperties(mp, false, handler);
        mp.outputSurpirses();
    }

    // ====================================================
    // private method
    // ====================================================

    private Set<Integer> getAllHouses() {
        if (allHouses == null)
            this.allHouses = bulidSet(maxHouses, "chukoikkodate");
        return allHouses;

    }

    private Set<Integer> getAllMansions() {
        if (allMansions == null)
            this.allMansions = bulidSet(maxMansions, "ms/chuko");
        return allMansions;
    }

    private void parseAllProperties(Parser parser, boolean isHouse, Handle handler) {
        String propertyType = isHouse ? "house" : "mansion";
        Set<Integer> ncSet = isHouse ? this.getAllHouses() : this.getAllMansions();

        int num = 0;
        int maxNum = ncSet.size();

        log.info("Crawler find " + maxNum + " " + propertyType + "s in " + getName());
        for (int nc : ncSet) {
            Document doc = readBukkengaiyo(isHouse ? houseUrl(nc) : mansionUrl(nc));
            Property property = parser.parse(doc);
            if (property == null)
                continue;
            handler.handle(property);
            num += 1;
            if (num % 100 == 0)
                System.out.println(num + "/" + maxNum + " " + propertyType + "s handled");
        }
        log.info("<Finish> " + num + " " + propertyType + "s in " + getName() + " crawled");
    }

    private HashSet<Integer> bulidSet(Integer maxProperties, String urlFragment) {
        HashSet<Integer> set = new HashSet<>();

        /** regex pattern of link, which included the uc-code */
        String pattern = urlFragment + "/tokyo/sc_" + this.name + "/nc_(\\d*)(/)";

        int curPage = 1;
        int endPage = 0;
        int num = 0;

        do {
            String url = "https://suumo.jp/" + urlFragment + "/tokyo/sc_" + this.name + "/pnz1" + curPage + ".html";
            Document doc = readIchiran(url);

            /** set endPage */
            if (curPage == 1) {
                Elements pages = doc.select("ol[class=pagination-parts]").first().select("li");
                endPage = Integer.parseInt(pages.last().text());
            }

            /** extract nc-code from all links in the document */
            for (Element link : doc.select("a[href]")) {
                String curLink = link.attr("href");
                Matcher m = Pattern.compile(pattern).matcher(curLink);
                if (!m.find() || !set.add(Integer.parseInt(m.group(1))))
                    continue;
                num++;
                if (maxProperties != null && maxProperties <= num) 
                    break;
            }
            curPage++;

        } while (curPage <= endPage && (maxProperties == null || maxProperties > num));

        return set;
    }

    private Document readIchiran(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return doc;
    }

    private String houseUrl(int nc) {
        return "https://suumo.jp/chukoikkodate/tokyo/sc_" + name + "/nc_" + nc + "/bukkengaiyo/";
    }

    private String mansionUrl(int nc) {
        return "https://suumo.jp/ms/chuko/tokyo/sc_" + name + "/nc_" + nc + "/bukkengaiyo/";
    }

    /**
     * read bukkengaiyo-page
     * 
     * @param tdfk         todofuken name
     * @param typeFragment "ms/chuko" for mansion, "chukoikkodate" for house
     * @param ncCode       code of property
     * @return a json Document of current page
     * @throws IOException
     */
    private static Document readBukkengaiyo(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (org.jsoup.HttpStatusException hse) {
            log.warning("HttpStatusException: " + hse.getStatusCode() + ", at: \n" + hse.getUrl());
        } catch (IOException ioe) {
            log.warning(ioe.getMessage());
        }
        return doc;
    }

}
