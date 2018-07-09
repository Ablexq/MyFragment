

viewpager
===

<font color="#ff0000">1、点击tab

进入首页

Fragment1============0===setUserVisibleHint===============false
Fragment2============0===setUserVisibleHint===============false
Fragment3============0===setUserVisibleHint===============false
Fragment4============0===setUserVisibleHint===============false
Fragment1============0===setUserVisibleHint===============true
Fragment1============1===onAttach===============
Fragment1============2===onCreate===============
Fragment2============1===onAttach===============
Fragment2============2===onCreate===============
Fragment3============1===onAttach===============
Fragment3============2===onCreate===============
Fragment4============1===onAttach===============
Fragment4============2===onCreate===============
Fragment1============3===onCreateView===============
Fragment1============4===onActivityCreated===============
Fragment1============5===onStart===============
Fragment1============6===onResume===============
Fragment2============3===onCreateView===============
Fragment2============4===onActivityCreated===============
Fragment3============3===onCreateView===============
Fragment3============4===onActivityCreated===============
Fragment4============3===onCreateView===============
Fragment4============4===onActivityCreated===============
Fragment2============5===onStart===============
Fragment2============6===onResume===============
Fragment3============5===onStart===============
Fragment3============6===onResume===============
Fragment4============5===onStart===============
Fragment4============6===onResume===============

点击第二个tab
Fragment1============0===setUserVisibleHint===============false
Fragment2============0===setUserVisibleHint===============true

点击第三个tab
Fragment2============0===setUserVisibleHint===============false
Fragment3============0===setUserVisibleHint===============true

点击第四个tab
Fragment3============0===setUserVisibleHint===============false
Fragment4============0===setUserVisibleHint===============true

<font color="#00ff00">结论：fragment初始化后只会走setUserVisibleHint方法


2、

Fragment1============0===setUserVisibleHint===============false
Fragment2============0===setUserVisibleHint===============false
Fragment3============0===setUserVisibleHint===============false
Fragment4============0===setUserVisibleHint===============false
Fragment1============0===setUserVisibleHint===============true
Fragment1============1===onAttach===============
Fragment1============2===onCreate===============
Fragment2============1===onAttach===============
Fragment2============2===onCreate===============
Fragment3============1===onAttach===============
Fragment3============2===onCreate===============
Fragment4============1===onAttach===============
Fragment4============2===onCreate===============
Fragment1============3===onCreateView===============
Fragment1============4===onActivityCreated===============
Fragment1============5===onStart===============
Fragment1============6===onResume===============
Fragment2============3===onCreateView===============
Fragment2============4===onActivityCreated===============
Fragment3============3===onCreateView===============
Fragment3============4===onActivityCreated===============
Fragment4============3===onCreateView===============
Fragment4============4===onActivityCreated===============
Fragment2============5===onStart===============
Fragment2============6===onResume===============
Fragment3============5===onStart===============
Fragment3============6===onResume===============
Fragment4============5===onStart===============
Fragment4============6===onResume===============
Fragment1============7===onPause===============
Fragment2============7===onPause===============
Fragment3============7===onPause===============
Fragment4============7===onPause===============
Fragment1============8===onStop===============
Fragment2============8===onStop===============
Fragment3============8===onStop===============
Fragment4============8===onStop===============
Fragment1============5===onStart===============
Fragment2============5===onStart===============
Fragment3============5===onStart===============
Fragment4============5===onStart===============
Fragment1============6===onResume===============
Fragment2============6===onResume===============
Fragment3============6===onResume===============
Fragment4============6===onResume===============

<font color="#00ff00">结论：setOffscreenPageLimit 与 懒加载 影响走 onResume 的fragment个数
