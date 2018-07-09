package com.xq.myfragment.fragment;

import android.support.v4.app.Fragment;

public abstract class LazyFragment extends Fragment {

    protected boolean isVisible;

    /**
     * 在这里实现Fragment数据的缓加载.
     * 有viewpager才会调用，没有则需要主动调用getUserVisibleHint
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected abstract void onVisible();

    protected abstract void onInvisible();
}