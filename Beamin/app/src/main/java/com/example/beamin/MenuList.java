package com.example.beamin;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MenuList extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager viewPager;
    private MenuAdapter menuAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);

        //한식, 분식, 돈까스-회-일식, 치킨, 피자, 중국집, 패스트푸드, 족발-보쌈, 찜-탕 9개 메뉴 구성
        mTabLayout = (TabLayout) findViewById(R.id.layout_tab);
        mTabLayout.addTab(mTabLayout.newTab().setText("한식"));
        mTabLayout.addTab(mTabLayout.newTab().setText("분식"));
        mTabLayout.addTab(mTabLayout.newTab().setText("돈까스-회-일식"));
        mTabLayout.addTab(mTabLayout.newTab().setText("치킨"));
        mTabLayout.addTab(mTabLayout.newTab().setText("피자"));
        mTabLayout.addTab(mTabLayout.newTab().setText("중국집"));
        mTabLayout.addTab(mTabLayout.newTab().setText("패스트푸드"));
        mTabLayout.addTab(mTabLayout.newTab().setText("족발-보쌈"));
        mTabLayout.addTab(mTabLayout.newTab().setText("찜-탕"));

        viewPager = (ViewPager) findViewById(R.id.pager_content);
        menuAdapter = new MenuAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        viewPager.setAdapter(menuAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}
//MenuList