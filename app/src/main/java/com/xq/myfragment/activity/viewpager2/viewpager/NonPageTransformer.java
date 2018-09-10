package com.xq.myfragment.activity.viewpager2.viewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * ViewPager切换
 * 
 * @author xq
 *
 */

public class NonPageTransformer implements ViewPager.PageTransformer {
	@Override
	public void transformPage(View page, float position) {
		page.setScaleX(0.999f);// hack
	}

	public static final ViewPager.PageTransformer INSTANCE = new NonPageTransformer();
}