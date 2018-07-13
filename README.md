
[viewpager](https://github.com/Ablexq/MyFragment/blob/master/viewpager.md)

[addhideshow](https://github.com/Ablexq/MyFragment/blob/master/addhideshow.md)

[replace](https://github.com/Ablexq/MyFragment/blob/master/replace.md)

[PagerAdapter区别](https://github.com/Ablexq/MyFragment/blob/master/PagerAdapter.md)


```

/**
 * Return true if the fragment is currently visible to the user.  This means
 * it: (1) has been added, (2) has its view attached to the window, and 
 * (3) is not hidden.
 */
final public boolean isVisible() {
    return isAdded() && !isHidden() && mView != null
            && mView.getWindowToken() != null && mView.getVisibility() == View.VISIBLE;
}

```

isVisible 与 isHidden 值相反



```
/**
 *  设置fragment是否可见
 *  在fragment实例状态下保存并恢复
 *  isVisibleToUser 为true则可见（默认） ，false则不可见
 */
public void setUserVisibleHint(boolean isVisibleToUser) {
    if (!mUserVisibleHint && isVisibleToUser && mState < STARTED
            && mFragmentManager != null && isAdded()) {
        mFragmentManager.performPendingDeferredStart(this);
    }
    mUserVisibleHint = isVisibleToUser;
    mDeferStart = mState < STARTED && !isVisibleToUser;
}

/**
 * fragment 是否可见（默认可见）
 */
public boolean getUserVisibleHint() {
    return mUserVisibleHint;
}

```




```

/**
 * 添加到activity时为true
 */
final public boolean isAdded() {
    return mHost != null && mAdded;
}
```


懒加载的实现：
```
public abstract class LazyFragment extends Fragment {  

    protected boolean isVisible;

    /**
     * 在这里实现Fragment数据的缓加载.
     * 有viewpager才会调用，没有则需要主动调用getUserVisibleHint
     * @param isVisibleToUser
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
```

```
public class OpenResultFragment extends LazyFragment{  
    // 标志位，标志已经初始化完成。  
    private boolean isPrepared;  

    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {  
        Log.d(LOG_TAG, "onCreateView");  
        View view = inflater.inflate(R.layout.fragment_open_result, container, false);  

        isPrepared = true;  
        onVisible();  
        return view;  
    }  

   @Override
    protected void onVisible() {
        if (!isPrepared || !isVisible) {
            return;
        }
        // 创建fragment时请求数据
    }

    @Override
    protected void onInvisible() {

    }

}  
```



```
//设置在空闲状态下视图层次结构中当前页的任何一侧应保留的页数。限制在空闲状态下屏幕上保留多少页。
private static final int DEFAULT_OFFSCREEN_PAGES = 1;//默认1页

public void setOffscreenPageLimit(int limit) {
    if (limit < DEFAULT_OFFSCREEN_PAGES) {
        Log.w(TAG, "Requested offscreen page limit " + limit + " too small; defaulting to "
                + DEFAULT_OFFSCREEN_PAGES);
        limit = DEFAULT_OFFSCREEN_PAGES;
    }
    if (limit != mOffscreenPageLimit) {
        mOffscreenPageLimit = limit;
        populate();
    }
}
```