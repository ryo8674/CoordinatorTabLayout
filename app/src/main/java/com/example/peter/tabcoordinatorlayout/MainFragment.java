package com.example.peter.tabcoordinatorlayout;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

/**
 * FragmentNewクラス :最新刊のFragmentを表示する。
 *
 * @author ryo.yamada
 * @since 1.0 2017/08/03
 */
public class MainFragment extends Fragment {

    private static final String BOOK = "book";

    /**
     * インスタンスを生成する。
     *
     * @return インスタンス
     */
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    /**
     * onViewCreatedメソッド。
     *
     * @param view               view
     * @param savedInstanceState savedInstanceState
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        //noinspection unchecked
        List<Book> newBookList = (List<Book>) bundle.getSerializable(BOOK);

        BookListAdapter adapter = new BookListAdapter(getContext(), R.layout.activity_scrolling, newBookList);
        ListView listView = view.findViewById(R.id.list_view);
        listView.setNestedScrollingEnabled(true);
        listView.setAdapter(adapter);
    }

    /**
     * onCreateViewメソッド。
     *
     * @param inflater           inflater
     * @param container          container
     * @param savedInstanceState savedInstanceState
     * @return Fragmentに関連づけるView
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, null);
    }
}
