package com.xq.myfragment.activity.tabvp;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.xq.myfragment.R;

import java.util.ArrayList;


public class TabVpActivity extends AppCompatActivity {

    private String[] titles1 = {"推荐", "体育", "视频", "美图"};
    private String[] titles2 = {"推荐", "体育", "视频"};
    private String[] titles3 = {"推荐", "体育", "视频", "美图", "段子"};
    private ArrayList<Fragment> fragmentLists = new ArrayList<>();
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentPagerAdapter pagerAdapter  = new FragmentPagerAdapter(getSupportFragmentManager()) {

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Fragment1();
                case 1:
                    return new Fragment2();
                case 2:
                    return new Fragment3();
                case 3:
                    return new Fragment4();
            }
            return new Fragment1();
        }

        @Override
        public int getCount() {
            return titles1.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles1[position];
        }
    };

    private FragmentStatePagerAdapter statePagerAdapter  = new FragmentStatePagerAdapter(getSupportFragmentManager()) {

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Fragment1();
                case 1:
                    return new Fragment2();
                case 2:
                    return new Fragment3();
                case 3:
                    return new Fragment4();
            }
            return new Fragment1();
        }

        @Override
        public int getCount() {
            return titles1.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles1[position];
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_vp);

        tabLayout = (TabLayout) findViewById(R.id.tab);
        viewPager = (ViewPager) findViewById(R.id.vp_content);

        for (String aTitles1 : titles1) {
            TabLayout.Tab tab = tabLayout.newTab();//创建tab
            tab.setText(aTitles1);//设置文字
            tab.setIcon(R.mipmap.ic_launcher);//设置图标
            tabLayout.addTab(tab);//添加到tabLayout中
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

//        viewPager.setAdapter(pagerAdapter);
        viewPager.setAdapter(statePagerAdapter);
//        viewPager.setOffscreenPageLimit(titles1.length);

        tabLayout.setupWithViewPager(viewPager);
    }
}
