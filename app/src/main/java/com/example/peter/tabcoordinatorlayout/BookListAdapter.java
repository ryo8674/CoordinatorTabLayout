package com.example.peter.tabcoordinatorlayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * BookListAdapterクラス
 *
 * @author ryo.yamada
 * @since 1.0 2017/08/03
 */
class BookListAdapter extends ArrayAdapter<Book> {

    /**
     * 本のリスト
     */
    private final List<Book> bookList;
    /**
     * LayoutInflater
     */
    private final LayoutInflater layoutInflater;

    /**
     * コンストラクタ
     *
     * @param context    クラスのオブジェクト
     * @param resourceId リソースID
     * @param bookList   データのリスト
     */
    BookListAdapter(Context context, int resourceId, List<Book> bookList) {
        super(context, resourceId, bookList);
        this.bookList = new ArrayList<>();
        this.bookList.addAll(bookList);

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * ViewHolder
     */
    private class ViewHolder {
        TextView textAuthor;
        TextView textTitle;
    }

    /**
     * getViewメソッド
     *
     * @param position    リストの番号
     * @param convertView リストのView情報
     * @param parent      親のView
     * @return view view
     */
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        ViewHolder holder;

        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_list, null);

            holder = new ViewHolder();
            holder.textAuthor = view.findViewById(R.id.author);
            holder.textTitle = view.findViewById(R.id.title);
            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        Book book = bookList.get(position);
        holder.textAuthor.setText(book.getAuthor());
        holder.textTitle.setText(book.getTitle());

        return view;
    }
}

