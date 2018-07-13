package com.xq.myfragment.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lenovo on 2018/7/13.
 */

public class MyPagerAdapter extends PagerAdapter {

    /* ----------------------------必须--------------------------------------- */
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }

    /* -----------------------------非必须------------------------------------- */
    // 0/该函数用以返回给定对象的位置，给定对象是由 instantiateItem() 的返回值。
    // 1/在 ViewPager.dataSetChanged() 中将对该函数的返回值进行判断，
    // 以决定是否最终触发 PagerAdapter.instantiateItem() 函数。
    // 2/在 PagerAdapter 中的实现是直接传回 POSITION_UNCHANGED。如果该函数不被重载，
    // 则会一直返回 POSITION_UNCHANGED，从而导致 ViewPager.dataSetChanged() 被调用时，
    // 认为不必触发 PagerAdapter.instantiateItem()。很多人因为没有重载该函数，
    // 而导致调用PagerAdapter.notifyDataSetChanged() 后，什么都没有发生。
    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    //在每次 ViewPager 需要一个用以显示的 Object 的时候，该函数都会被 ViewPager.addNewItem() 调用。
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    //在数据集发生变化的时候，一般 Activity 会调用 PagerAdapter.notifyDataSetChanged()，
    // 以通知 PagerAdapter，而 PagerAdapter 则会通知在自己这里注册过的所有 DataSetObserver。
    // 其中之一就是在 ViewPager.setAdapter() 中注册过的 PageObserver。
    // PageObserver 则进而调用 ViewPager.dataSetChanged()，
    // 从而导致 ViewPager 开始触发更新其内含 View 的操作。
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

}
