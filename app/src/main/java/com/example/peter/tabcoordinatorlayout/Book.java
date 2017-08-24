package com.example.peter.tabcoordinatorlayout;

/**
 * Bookクラス
 *
 * @author ryo.yamada
 * @since 1.0 2017/08/03
 */
class Book {

    /**
     * 著者名
     */
    private String author;

    /**
     * タイトル
     */
    private String title;

    /**
     * コンストラクタ
     */
    Book() {
    }

    /**
     * コンストラクタ
     *
     * @param author 著者名
     * @param title  タイトル
     */
    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    /**
     * 著者名を取得する。
     *
     * @return author 著者名
     */
    String getAuthor() {
        return author;
    }

    /**
     * 著者名を設定する。
     *
     * @param author 著者名
     */
    void setAuthor(String author) {
        this.author = author;
    }

    /**
     * タイトルを取得する。
     *
     * @return title タイトル
     */
    String getTitle() {
        return title;
    }

    /**
     * タイトルを設定する。
     *
     * @param title タイトル
     */
    void setTitle(String title) {
        this.title = title;
    }
}
