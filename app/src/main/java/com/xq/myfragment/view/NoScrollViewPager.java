package com.xq.myfragment.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 自定义的 viewpager 不能左右滑动
 */
public class NoScrollViewPager extends ViewPager {
    private boolean noScroll = true;

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoScrollViewPager(Context context) {
        super(context);
    }

    public void setNoScroll(boolean noScroll) {
        this.noScroll = noScroll;
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        return !noScroll && super.onTouchEvent(arg0);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        return !noScroll && super.onInterceptTouchEvent(arg0);
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item);
    }

}

/*-----------------------------------------------------------------*/
//使用如下：
//        mViewPager = (MainViewPager) findViewById(R.id.viewPager);
//        mViewPager.setNoScroll(true);
//        mViewPager.setOffscreenPageLimit(3);
//        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
//
//            @Override
//            public int getCount() {
//                return 4;
//            }
//
//            @Override
//            public Fragment getItem(int position) {
//                switch (position) {
//                    case 0:
//                        if (mFoxLiveFragment == null) {
//                            mFoxLiveFragment = new FoxLiveFragment();
//                        }
//                        return mFoxLiveFragment;
//
//                    case 1:
//                        if (mFriendsCircleFragment == null) {
//                            mFriendsCircleFragment = new FriendsCircleFragment();
//                        }
//                        return mFriendsCircleFragment;
//
//                    case 2:
//                        if (null == mFoxShopFragment) {
//                            mFoxShopFragment = new FoxShopFragment();
//                        }
//                        return mFoxShopFragment;
//                    case 3:
//                        if (mUserCenterFragment == null) {
//                            mUserCenterFragment = new UserCenterFragment();
//                        }
//                        mUserCenterFragment.scrollToTop();
//                        return mUserCenterFragment;
//                        }
//                return null;
//            }
//        });