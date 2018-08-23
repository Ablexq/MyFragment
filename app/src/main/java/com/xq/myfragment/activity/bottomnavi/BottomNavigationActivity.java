package com.xq.myfragment.activity.bottomnavi;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.xq.myfragment.R;

import java.util.ArrayList;


@SuppressWarnings("deprecation")
public class BottomNavigationActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private MenuItem menuItem;


    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_view);
        int maxItemCount = bottomNavigationView.getMaxItemCount();//最多五个
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //解决item 数大于 3 个时位移
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        //解决Item图标不显示原始颜色
        bottomNavigationView.setItemIconTintList(null);

//        /**设置MenuItem的字体颜色,等同于xml文件中 app:itemTextColor="@color/bottomtxtcolor"**/
//        Resources resource= getBaseContext().getResources();
//        ColorStateList csl= resource.getColorStateList(R.color.bottomtxtcolor);
//        bottomNavigationView.setItemTextColor(csl);
//        /**设置MenuItem默认选中项**/
//        bottomNavigationView.getMenu().getItem(0).setChecked(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager_bottom);
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        fragments.add(new Fragment4());
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.addOnPageChangeListener(onPageChangeListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.tab_menu_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.tab_menu_discovery:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.tab_menu_attention:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.tab_menu_profile:
                    viewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        }
    };

    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (menuItem != null) {
                menuItem.setChecked(false);
            } else {
                bottomNavigationView.getMenu().getItem(0).setChecked(false);
            }
            menuItem = bottomNavigationView.getMenu().getItem(position);
            menuItem.setChecked(true);
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
