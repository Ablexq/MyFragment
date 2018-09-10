package com.xq.myfragment.activity.viewpager2;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xq.myfragment.R;
import com.xq.myfragment.activity.viewpager2.viewpager.ScaleInTransformer;

import java.util.ArrayList;

public class ViewPagerActivity2 extends AppCompatActivity implements View.OnClickListener {

    private ImageView home_tab_one_iconIv;
    private ImageView home_tab_two_iconIv;
    private ImageView home_tab_three_iconIv;
    private ImageView home_tab_four_iconIv;
    private TextView home_tab_one_textTv;
    private TextView home_tab_two_textTv;
    private TextView home_tab_three_textTv;
    private TextView home_tab_four_textTv;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ViewPager mViewPager;

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_layout);

        LinearLayout oneLLayout = (LinearLayout) findViewById(R.id.home_tab_one);
        LinearLayout twoLLayout = (LinearLayout) findViewById(R.id.home_tab_two);
        LinearLayout threeLLayout = (LinearLayout) findViewById(R.id.home_tab_three);
        LinearLayout fourLLayout = (LinearLayout) findViewById(R.id.home_tab_four);
        oneLLayout.setOnClickListener(this);
        twoLLayout.setOnClickListener(this);
        threeLLayout.setOnClickListener(this);
        fourLLayout.setOnClickListener(this);
        home_tab_one_iconIv = (ImageView) findViewById(R.id.home_tab_one_icon);
        home_tab_two_iconIv = (ImageView) findViewById(R.id.home_tab_two_icon);
        home_tab_three_iconIv = (ImageView) findViewById(R.id.home_tab_three_icon);
        home_tab_four_iconIv = (ImageView) findViewById(R.id.home_tab_four_icon);
        home_tab_one_textTv = (TextView) findViewById(R.id.home_tab_one_text);
        home_tab_two_textTv = (TextView) findViewById(R.id.home_tab_two_text);
        home_tab_three_textTv = (TextView) findViewById(R.id.home_tab_three_text);
        home_tab_four_textTv = (TextView) findViewById(R.id.home_tab_four_text);

        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        fragments.add(new Fragment4());
        mViewPager = ((ViewPager) findViewById(R.id.viewpager));
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setPageMargin(dip2px(this, 20));
        mViewPager.setPageTransformer(true, new ScaleInTransformer());
        mViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments != null && fragments.size() > 0 ? fragments.size() : 0;
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switchPage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    private void switchPage(int position) {
        switch (position) {
            case 0:
                home_tab_one_iconIv.setBackgroundResource(R.drawable.frag1_two);
                home_tab_one_textTv.setTextColor(Color.parseColor("#ff7612"));
                home_tab_two_iconIv.setBackgroundResource(R.drawable.frag2_one);
                home_tab_two_textTv.setTextColor(Color.parseColor("#b5bbca"));
                home_tab_three_iconIv.setBackgroundResource(R.drawable.frag3_one);
                home_tab_three_textTv.setTextColor(Color.parseColor("#b5bbca"));
                home_tab_four_iconIv.setBackgroundResource(R.drawable.frag4_one);
                home_tab_four_textTv.setTextColor(Color.parseColor("#b5bbca"));
                break;

            case 1:
                home_tab_one_iconIv.setBackgroundResource(R.drawable.frag1_one);
                home_tab_one_textTv.setTextColor(Color.parseColor("#b5bbca"));
                home_tab_two_iconIv.setBackgroundResource(R.drawable.frag2_two);
                home_tab_two_textTv.setTextColor(Color.parseColor("#ff7612"));
                home_tab_three_iconIv.setBackgroundResource(R.drawable.frag3_one);
                home_tab_three_textTv.setTextColor(Color.parseColor("#b5bbca"));
                home_tab_four_iconIv.setBackgroundResource(R.drawable.frag4_one);
                home_tab_four_textTv.setTextColor(Color.parseColor("#b5bbca"));
                break;

            case 2:
                home_tab_one_iconIv.setBackgroundResource(R.drawable.frag1_one);
                home_tab_one_textTv.setTextColor(Color.parseColor("#b5bbca"));
                home_tab_two_iconIv.setBackgroundResource(R.drawable.frag2_one);
                home_tab_two_textTv.setTextColor(Color.parseColor("#b5bbca"));
                home_tab_three_iconIv.setBackgroundResource(R.drawable.frag3_two);
                home_tab_three_textTv.setTextColor(Color.parseColor("#ff7612"));
                home_tab_four_iconIv.setBackgroundResource(R.drawable.frag4_one);
                home_tab_four_textTv.setTextColor(Color.parseColor("#b5bbca"));
                break;

            case 3:
                home_tab_one_iconIv.setBackgroundResource(R.drawable.frag1_one);
                home_tab_one_textTv.setTextColor(Color.parseColor("#b5bbca"));
                home_tab_two_iconIv.setBackgroundResource(R.drawable.frag2_one);
                home_tab_two_textTv.setTextColor(Color.parseColor("#b5bbca"));
                home_tab_three_iconIv.setBackgroundResource(R.drawable.frag3_one);
                home_tab_three_textTv.setTextColor(Color.parseColor("#b5bbca"));
                home_tab_four_iconIv.setBackgroundResource(R.drawable.frag4_two);
                home_tab_four_textTv.setTextColor(Color.parseColor("#ff7612"));
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_tab_one:
                mViewPager.setCurrentItem(0);
                switchPage(0);
                break;

            case R.id.home_tab_two:
                mViewPager.setCurrentItem(1);
                switchPage(1);
                break;

            case R.id.home_tab_three:
                mViewPager.setCurrentItem(2);
                switchPage(2);
                break;

            case R.id.home_tab_four:
                mViewPager.setCurrentItem(3);
                switchPage(3);
                break;

            default:
                break;
        }
    }


}
