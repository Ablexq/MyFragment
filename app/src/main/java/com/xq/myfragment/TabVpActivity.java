package com.xq.myfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.xq.myfragment.activity.hideshow.Fragment1;
import com.xq.myfragment.activity.hideshow.Fragment2;
import com.xq.myfragment.activity.hideshow.Fragment3;
import com.xq.myfragment.activity.hideshow.Fragment4;


public class TabVpActivity extends AppCompatActivity {

    private String[] titles = {"推荐", "体育", "视频", "美图"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_vp);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        ViewPager vp_content = (ViewPager) findViewById(R.id.vp_content);

        for (String title : titles) {
            TabLayout.Tab tab = tabLayout.newTab();//创建tab
            tab.setText(title);//设置文字
            tab.setIcon(R.mipmap.ic_launcher);//设置图标
            tabLayout.addTab(tab);//添加到tabLayout中
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(TabVpActivity.this, tab.getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        vp_content.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return new Fragment1();
                } else if (position == 1) {
                    return new Fragment2();
                } else if (position == 2) {
                    return new Fragment3();
                } else if (position == 3) {
                    return new Fragment4();
                }
                return null;
            }

            @Override
            public int getCount() {
                return titles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });

        tabLayout.setupWithViewPager(vp_content);
    }
}
