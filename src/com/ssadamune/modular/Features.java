package com.ssadamune.modular;

import java.util.Map;

public class Features {
    public static final Map<String, Integer> map = Map.ofEntries(
            // 住所・交通
            Map.entry("２沿線以上利用可", 100),
            Map.entry("始発駅", 101),
            // 住所・便利
            Map.entry("市街地が近い", 111),
            Map.entry("スーパー 徒歩10分以内", 112),
            Map.entry("総合病院 徒歩10分以内", 113),
            Map.entry("小学校 徒歩10分以内", 114),
            // 住所・環境
            Map.entry("都市近郊", 120),
            Map.entry("閑静な住宅地", 121),
            Map.entry("周辺交通量少なめ", 122),
            Map.entry("整備された歩道", 123),
            Map.entry("緑豊かな住宅地", 124),
            Map.entry("リバーサイド", 125),
            Map.entry("大型タウン内", 126),
            Map.entry("区画整理地内", 127),
            Map.entry("避暑地", 128),
            // 住所・娯楽
            Map.entry("ゴルフ場が近い", 130),
            Map.entry("テニスコートが近い", 131),
            Map.entry("スキー場が近い", 132),
            // 住所・地形
            Map.entry("高台に立地", 140),
            Map.entry("平坦地", 141),
            Map.entry("駅まで平坦", 142),

            // 方位・採光
            Map.entry("陽当り良好", 200),
            Map.entry("全室２面採光", 201),
            Map.entry("３面採光", 202),
            // 方位・通風
            Map.entry("通風良好", 210),
            // 方位・視野
            Map.entry("前面棟無", 220),
            Map.entry("眺望良好", 221),
            Map.entry("山が見える", 222),
            Map.entry("湖・池が見える", 223),
            Map.entry("オーシャンビュー", 224),
            Map.entry("花火大会鑑賞", 225),
            Map.entry("田園風景", 226),
            // 方位・南向き
            Map.entry("南向き", 230),
            Map.entry("東南向き", 231),
            Map.entry("南西向き", 232),
            Map.entry("南面バルコニー", 233),
            Map.entry("全室南向き", 234),
            Map.entry("全室南西向き", 235),
            Map.entry("全室東南向き", 236),
            // 方位・階層
            Map.entry("最上階・上階なし", 240),
            Map.entry("高層階", 241),
            // 方位・角住戸
            Map.entry("角住戸", 250),

            // 物件・安全防災
            Map.entry("セキュリティ充実", 300),
            Map.entry("耐震基準適合証明書", 301),
            Map.entry("制震・免震・耐震", 302),
            Map.entry("設計住宅性能評価書", 303),
            Map.entry("建設住宅性能評価書（新築時）", 304),
            Map.entry("融雪対策", 305),
            // 物件・駐車駐輪
            Map.entry("駐輪場", 310),
            Map.entry("平面駐車場", 311),
            Map.entry("自走式駐車場", 312),
            Map.entry("ハイルーフ駐車場空きあり", 313),
            Map.entry("EV車充電設備", 314),
            // 物件・建物施設
            Map.entry("宅配ボックス", 330),
            Map.entry("エレベーター", 331),
            Map.entry("共有施設充実", 332),
            Map.entry("２４時間有人管理", 333),
            Map.entry("キッズルーム・託児所", 334),
            Map.entry("バリアフリー", 335),
            Map.entry("屋上", 336),
            Map.entry("温泉付", 337),
            Map.entry("共用露天風呂", 337),
            Map.entry("プール", 338),
            // 物件・住宅設備
            Map.entry("高速ネット対応", 340),
            Map.entry("BS・CS・CATV", 341),
            Map.entry("ＴＶモニタ付インターホン", 342),
            Map.entry("床暖房", 343),
            Map.entry("オール電化", 344),
            Map.entry("スマートキー", 345),
            Map.entry("高気密高断熱住宅", 346),
            // 物件・政策
            Map.entry("ペット相談", 350),
            Map.entry("バイク置場", 351),
            Map.entry("２４時間ゴミ出し可", 352),
            Map.entry("駐車２台可", 353),

            // 部屋・リフォーム
            Map.entry("内装リフォーム", 400),
            Map.entry("外装リフォーム", 401),
            Map.entry("内外装リフォーム", 402),
            Map.entry("フローリング張替", 403),
            Map.entry("修繕・点検の記録", 404),
            Map.entry("スケルトン渡し", 405),
            Map.entry("自然素材使用", 406),
            Map.entry("ウッドデッキ", 407),
            // 部屋・リノベーション
            Map.entry("リノベーション", 410),
            Map.entry("複層ガラス", 411),
            Map.entry("全居室複層ガラスか複層サッシ", 412),
            Map.entry("全居室フローリング", 413),
            Map.entry("適合リノベーション", 414),
            // 部屋・間取り
            Map.entry("和室", 420),
            Map.entry("全居室６畳以上", 421),
            Map.entry("可動間仕切り", 422),
            Map.entry("吹抜け", 423),
            Map.entry("ロフト", 424),
            Map.entry("天井高２．５ｍ以上", 425),
            Map.entry("ゲストルーム", 426),
            Map.entry("浴室１坪以上", 427),
            // 部屋・バルコニー&庭
            Map.entry("ワイドバルコニー", 430),
            Map.entry("ルーフバルコニー", 431),
            Map.entry("２面以上バルコニー", 432),
            Map.entry("テラス", 433),
            Map.entry("専用庭", 434),
            Map.entry("南庭", 435),
            Map.entry("バルコニー・屋上に水栓あり", 436),
            Map.entry("庭１０坪以上", 437),
            // 部屋・LDK
            Map.entry("ＬＤＫ１５畳以上", 440),
            Map.entry("ＬＤＫ１８畳以上", 441),
            Map.entry("ＬＤＫ２０畳以上", 442),
            // 部屋・キッチン
            Map.entry("システムキッチン", 450),
            Map.entry("対面式キッチン", 451),
            Map.entry("食器洗乾燥機", 452),
            Map.entry("ディスポーザー（生ごみ粉砕処理器）", 453),
            Map.entry("浄水器", 454),
            Map.entry("ＩＨクッキングヒーター", 455),
            Map.entry("アイランドキッチン", 456),
            // 部屋・洗濯洗面浴室
            Map.entry("浴室乾燥機", 460),
            Map.entry("省エネ給湯器", 461),
            Map.entry("オートバス", 462),
            Map.entry("シャワー付洗面化粧台", 463),
            Map.entry("浴室に窓", 464),
            Map.entry("ミストサウナ", 465),
            Map.entry("ＴＶ付浴室", 466),
            Map.entry("ジェットバス", 467),
            Map.entry("オーディオバス", 468),
            // 部屋・トイレ
            Map.entry("温水洗浄便座", 470),
            Map.entry("節水型トイレ", 471),
            Map.entry( "高機能トイレ", 472),
            Map.entry("トイレ２ヶ所", 473),
            // 部屋・収納
            Map.entry("全居室収納", 480),
            Map.entry("ウォークインクローゼット", 481),
            Map.entry("納戸", 482),
            Map.entry("シューズインクローク", 483),
            Map.entry("パントリー（食器・食品の収納庫）", 484),
            Map.entry("床下収納", 485),

            // その他
            Map.entry("即入居可", 900),
            Map.entry("年内入居可", 901),
            Map.entry("年度内入居可", 902),
            Map.entry("フラット３５Sに対応", 910),
            Map.entry("フラット３５・S適合証明書", 910),
            Map.entry("瑕疵保証付（不動産会社独自）", 920),
            Map.entry("瑕疵保険（国交省指定）保証利用可", 921),
            Map.entry("瑕疵保険（国交省指定）保証付", 921),
            Map.entry("新築時・増改築時の設計図", 930),
            Map.entry("建築確認完了検査済証", 940),
            Map.entry("建築士等の建物検査報告書", 941),
            Map.entry("建設住宅性能評価書（既存住宅）", 942),
            Map.entry("長期優良住宅認定通知書", 943),
            Map.entry("省エネルギー対策", 999)
            );

}
