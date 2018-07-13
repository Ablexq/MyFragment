package com.xq.myfragment.fragment;

import android.support.v4.app.Fragment;

/*
*用于懒加载
*/
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

/*-------------------------------------------------------------------------*/
//使用如下：
//public class OpenResultFragment extends LazyFragment{
//    // 标志位，标志已经初始化完成。
//    private boolean isPrepared;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        Log.d(LOG_TAG, "onCreateView");
//        View view = inflater.inflate(R.layout.fragment_open_result, container, false);
//        //XXX初始化view的各控件
//        isPrepared = true;
//        onVisible();
//        return view;
//    }
//
//    @Override
//    protected void onVisible() {
//        if (!isPrepared || !isVisible) {
//            return;
//        }
//        reqKnowledgeCata();// 创建fragment时请求列表数据
//    }
//
//    @Override
//    protected void onInvisible() {
//
//    }
//
//}
