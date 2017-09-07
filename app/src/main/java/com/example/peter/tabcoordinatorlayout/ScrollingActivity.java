package com.example.peter.tabcoordinatorlayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

/**
 * メイン画面
 *
 * @author ryo.yamada
 * @since 1.0 2017/08/03
 */
public class ScrollingActivity extends AppCompatActivity {

    /**
     * onCreateメソッド。
     *
     * @param savedInstanceState savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        // Adapterの準備
        FragmentManager fragmentManager = getSupportFragmentManager();
        BookFragmentPageAdapter adapter = new BookFragmentPageAdapter(fragmentManager);
        // ViewPagerにAdapterをセット
        viewPager.setAdapter(adapter);

        // TabLayoutをViewPagerと紐付け
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        NestedScrollView nestedScrollView = (NestedScrollView) findViewById(R.id.nested_scroll);
        nestedScrollView.setFillViewport(true);

    }

    /**
     * onCreateOptionMenuメソッド。
     * メニューに表示される項目を追加する
     *
     * @param menu menu
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    /**
     * onOptionItemSelected。
     * メニュー項目を通知する。
     *
     * @param item item
     * @return true/false
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return item.getItemId() == R.id.action_settings || super.onOptionsItemSelected(item);
    }
}
