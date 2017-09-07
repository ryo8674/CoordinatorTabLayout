package com.example.peter.tabcoordinatorlayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * FragmentPagerAdapter
 *
 * @author ryo.yamada
 * @since 1.0 2017/08/03
 */
class BookFragmentPageAdapter extends FragmentPagerAdapter {

    private static final int RECOMMEND_BOOK_PAGE = 0;
    private static final int NEW_BOOK_PAGE = 1;
    private static final String RECOMMEND_BOOK = "おすすめ";
    private static final String NEW_BOOK = "最新刊";
    private static final String BOOK = "book";

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
     * Bookクラスのリストを返すメソッド
     * pageで入れる値を切り替え
     * @param page page
     * @return Book型のList
     */
    private List<Book> getBookList(int page) {
        List<Book> bookList = new ArrayList<>();
        Book book;
        switch (page) {
            case NEW_BOOK_PAGE:
                for (int i = 0; i < NEW_AUTHOR.length; i++) {
                    book = new Book(NEW_AUTHOR[i], NEW_TITLE[i]);
                    bookList.add(book);
                }
                break;
            case RECOMMEND_BOOK_PAGE:
                for (int i = 0; i < RECOMMEND_AUTHOR.length; i++) {
                    book = new Book(RECOMMEND_AUTHOR[i], RECOMMEND_TITLE[i]);
                    bookList.add(book);
                }
                break;
        }
        return bookList;
    }

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
        bundle.putSerializable(BOOK, (Serializable) getBookList(position));
        fragment.setArguments(bundle);

        return fragment;
    }

    /**
     * ViewPagerのページ数を取得
     *
     * @return ページ数
     */
    @Override
    public int getCount() {
        return TAB_NAME.length;
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
