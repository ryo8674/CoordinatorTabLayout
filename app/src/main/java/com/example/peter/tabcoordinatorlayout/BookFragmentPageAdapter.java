package com.example.peter.tabcoordinatorlayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * FragmentPagerAdapter
 *
 * @author ryo.yamada
 * @since 1.0 2017/08/03
 */
public class BookFragmentPageAdapter extends FragmentPagerAdapter {

    private static final int CONST_ZERO = 0;
    private static final int CONST_ONE = 1;
    private static final int CONST_TWO = 2;
    private static final String RECOMMEND_BOOK = "おすすめ";
    private static final String NEW_BOOK = "最新刊";
    private static final String AUTHOR = "author";
    private static final String TITLE = "title";
    /**
     * 著者名の配列
     */
    private static final String[] NEW_AUTHOR = {"住野よる", "米沢穂信", "中村文則", "川上途行", "上橋菜穂子",
            "湊かなえ", "上橋菜穂子", "田中尚喜", "中路啓太", "上橋菜穂子",
            "中村文則", "上橋菜穂子", "内藤了", "林宏司", "東野圭吾", "池井戸潤"};

    /* タイトルの配列 */
    private static final String[] NEW_TITLE = {"君の膵臓を食べたい", "満願", "去年の冬、きみと別れ", "ナースコール！こちら蓮田市リハビリテーション病院",
            "鹿の王4", "豆の上で踊る", "鹿の王3", "百歳まで歩く", "もののふ莫迦",
            "鹿の王1", "教団X", "鹿の王2", "MIX 猟奇犯罪捜査班・藤堂比奈子",
            "コード・ブルー ドクターヘリ緊急救命 2ndシーズン", "ナミヤ雑貨店の奇蹟", "アキラとあきら"};

    /**
     * 著者名の配列
     */
    private static final String[] RECOMMEND_AUTHOR = {"伊坂幸太郎", "佐々木譲", "宮部みゆき", "島田荘司", "東川篤哉",
            "東野圭吾", "柳広司", "横山秀夫", "歌野晶午", "海堂尊",
            "綾辻行人", "誉田哲也", "貫井徳郎", "貴志祐介", "道尾秀介", "高野和明"};

    /**
     * タイトルの配列
     */
    private static final String[] RECOMMEND_TITLE = {"モダンタイムス", "廃墟に乞う", "火車", "占星術殺人事件", "謎解きはディナーのあとで",
            "容疑者Xの献身", "ジョーカー・ゲーム", "半落ち", "葉桜の季節に君を想うということ", "ナイチンゲールの沈黙",
            "10角館の殺人", "ストロベリーナイト", "慟哭", "悪の教典", "カラスの親指", "13階段"};


    /**
     * タブ名
     */
    private static final String[] TAB_NAME = {RECOMMEND_BOOK, NEW_BOOK};

    /**
     * コンストラクタ
     */
    BookFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * ページに表示するフラグメントを取得する。
     *
     * @param position position
     * @return fragment 表示するフラグメント
     */
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = MainFragment.newInstance();
        Bundle bundle = new Bundle();
        switch (position) {
            case CONST_ZERO:
                bundle.putStringArray(AUTHOR, RECOMMEND_AUTHOR);
                bundle.putStringArray(TITLE, RECOMMEND_TITLE);
                fragment.setArguments(bundle);
                break;
            case CONST_ONE:
                bundle.putStringArray(AUTHOR, NEW_AUTHOR);
                bundle.putStringArray(TITLE, NEW_TITLE);
                fragment.setArguments(bundle);
                break;
            default:
                bundle.putStringArray(AUTHOR, RECOMMEND_AUTHOR);
                bundle.putStringArray(TITLE, RECOMMEND_TITLE);
                fragment.setArguments(bundle);
                break;
        }
        return fragment;
    }

    /**
     * ViewPagerのページ数を取得
     *
     * @return ページ数
     */
    @Override
    public int getCount() {
        return CONST_TWO;
    }

    /**
     * 各ページのタブ名を取得
     *
     * @param position position
     * @return タブ名
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return TAB_NAME[position];
    }
}
