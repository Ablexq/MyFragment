package com.xq.myfragment.activity.radiogroup;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.xq.myfragment.R;
import com.xq.myfragment.activity.bottomnavi.Fragment1;
import com.xq.myfragment.activity.bottomnavi.Fragment2;
import com.xq.myfragment.activity.bottomnavi.Fragment3;
import com.xq.myfragment.activity.bottomnavi.Fragment4;
import com.xq.myfragment.view.NoScrollViewPager;

import java.util.ArrayList;


public class RadioGroupActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private NoScrollViewPager viewPager;
    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        radioGroup = (RadioGroup) findViewById(R.id.radio_group_button);
        viewPager = (NoScrollViewPager) findViewById(R.id.viewpager_bottom);

        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        fragments.add(new Fragment4());
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.addOnPageChangeListener(onPageChangeListener);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.radio_button_home:
                        viewPager.setCurrentItem(0, false);
                        break;
                    case R.id.radio_button_discovery:
                        viewPager.setCurrentItem(1, false);
                        break;
                    case R.id.radio_button_attention:
                        viewPager.setCurrentItem(2, false);
                        break;
                    case R.id.radio_button_profile:
                        viewPager.setCurrentItem(3, false);
                        break;
                }
            }
        });
        // 保证第一次会回调OnCheckedChangeListener
//        RadioButton radioButton = (RadioButton) findViewById(R.id.radio_button_home);
//        radioButton.setChecked(true);
        //或
        radioGroup.check(R.id.radio_button_home);
    }

    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    radioGroup.check(R.id.radio_button_home);
                    break;
                case 1:
                    radioGroup.check(R.id.radio_button_discovery);
                    break;
                case 2:
                    radioGroup.check(R.id.radio_button_attention);
                    break;
                case 3:
                    radioGroup.check(R.id.radio_button_profile);
                    break;
                default:
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments != null && fragments.size() > 0 ? fragments.size() : 0;
        }
    };
}
