package com.xq.myfragment.activity.replace;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xq.myfragment.R;


import java.util.List;

public class ReplaceActivity extends AppCompatActivity implements View.OnClickListener {

    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment4 fragment4;
    private int mCurrentIndex;
    private FragmentManager manager;
    private ImageView home_tab_one_iconIv;
    private ImageView home_tab_two_iconIv;
    private ImageView home_tab_three_iconIv;
    private ImageView home_tab_four_iconIv;
    private TextView home_tab_one_textTv;
    private TextView home_tab_two_textTv;
    private TextView home_tab_three_textTv;
    private TextView home_tab_four_textTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replace_layout);

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

        fragment1 = new Fragment1();
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment1);
        transaction.commitAllowingStateLoss();

    }

    public void setCurrentItem(int index) {
        if (mCurrentIndex != index) {
            mCurrentIndex = index;

            switch (mCurrentIndex) {

                case 0:
                    if (fragment1 == null) {
                        fragment1 = new Fragment1();
                    }
                    switchContent(fragment1);

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
                    if (fragment2 == null) {
                        fragment2 = new Fragment2();
                    }
                    switchContent(fragment2);

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
                    if (fragment3 == null) {
                        fragment3 = new Fragment3();
                    }
                    switchContent(fragment3);

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
                    if (fragment4 == null) {
                        fragment4 = new Fragment4();
                    }
                    switchContent(fragment4);

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
    }

    private void switchContent(Fragment to) {
        FragmentTransaction transaction = manager.beginTransaction();

        if (!to.isAdded()) {
            transaction.replace(R.id.container, to);
        }

        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_tab_one:
                setCurrentItem(0);
                break;

            case R.id.home_tab_two:
                setCurrentItem(1);
                break;

            case R.id.home_tab_three:
                setCurrentItem(2);
                break;

            case R.id.home_tab_four:
                setCurrentItem(3);
                break;

            default:
                break;
        }

        getVisibleFragment();
    }

    public Fragment getVisibleFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments != null && fragments.size() > 0) {
            for (int i = 0; i < fragments.size(); i++) {
                Fragment fragment = fragments.get(i);
                System.out.println("======================VisibleFragment===============" + fragments.get(i));
                if (fragment != null && fragment.isVisible()) {
                    return fragment;
                }
            }
        }
        return null;
    }
}
