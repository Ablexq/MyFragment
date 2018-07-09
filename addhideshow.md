
add、hide、show
--------------

<font color="#ff0000">1、切换tab</font>

Fragment1============1===onAttach===============
Fragment1============2===onCreate===============
Fragment1============3===onCreateView===============
Fragment1============4===onActivityCreated===============
Fragment1============5===onStart===============
Fragment1============6===onResume===============
fragment===============Fragment1{443c58b #0 id=0x7f0b006a}

Fragment2============1===onAttach===============
Fragment2============2===onCreate===============
Fragment1============-1===onHiddenChanged===============true//隐藏，前个页面
Fragment2============3===onCreateView===============
Fragment2============4===onActivityCreated===============
Fragment2============5===onStart===============
Fragment2============6===onResume===============
fragment===============Fragment1{443c58b #0 id=0x7f0b006a}
fragment===============Fragment2{73ba81 #1 id=0x7f0b006a}

Fragment3============1===onAttach===============
Fragment3============2===onCreate===============
Fragment2============-1===onHiddenChanged===============true
Fragment3============3===onCreateView===============
Fragment3============4===onActivityCreated===============
Fragment3============5===onStart===============
Fragment3============6===onResume===============
fragment===============Fragment1{443c58b #0 id=0x7f0b006a}
fragment===============Fragment2{73ba81 #1 id=0x7f0b006a}
fragment===============Fragment3{9272f67 #2 id=0x7f0b006a}

Fragment4============1===onAttach===============
Fragment4============2===onCreate===============
Fragment3============-1===onHiddenChanged===============true
Fragment4============3===onCreateView===============
Fragment4============4===onActivityCreated===============
Fragment4============5===onStart===============
Fragment4============6===onResume===============
fragment===============Fragment1{443c58b #0 id=0x7f0b006a}
fragment===============Fragment2{73ba81 #1 id=0x7f0b006a}
fragment===============Fragment3{9272f67 #2 id=0x7f0b006a}
fragment===============Fragment4{6cac114 #3 id=0x7f0b006a}

Fragment4============-1===onHiddenChanged===============true//隐藏
Fragment1============-1===onHiddenChanged===============false//显示
fragment===============Fragment1{443c58b #0 id=0x7f0b006a}

Fragment1============-1===onHiddenChanged===============true
Fragment2============-1===onHiddenChanged===============false
fragment===============Fragment1{443c58b #0 id=0x7f0b006a}
fragment===============Fragment2{73ba81 #1 id=0x7f0b006a}

Fragment2============-1===onHiddenChanged===============true
Fragment3============-1===onHiddenChanged===============false
fragment===============Fragment1{443c58b #0 id=0x7f0b006a}
fragment===============Fragment2{73ba81 #1 id=0x7f0b006a}
fragment===============Fragment3{9272f67 #2 id=0x7f0b006a}

Fragment3============-1===onHiddenChanged===============true
Fragment4============-1===onHiddenChanged===============false

<font color="#00ff00">结论：初始化后点击tab切换 只调用onHiddenChanged方法</font>

<font color="#ff0000">2、点击只加载一个页面，详情后返回</font>

//进入界面

Fragment1============1===onAttach===============
Fragment1============2===onCreate===============
Fragment1============3===onCreateView===============
Fragment1============4===onActivityCreated===============
Fragment1============5===onStart===============
Fragment1============6===onResume===============

//详情

Fragment1============7===onPause===============
Fragment1============8===onStop===============

//返回

Fragment1============5===onStart===============
Fragment1============6===onResume===============



<font color="#ff0000">3、点击加载过四个界面：点击详情后返回</font>

Fragment1============1===onAttach===============
Fragment1============2===onCreate===============
Fragment1============3===onCreateView===============
Fragment1============4===onActivityCreated===============
Fragment1============5===onStart===============
Fragment1============6===onResume===============
fragment===============Fragment1{443c58b #0 id=0x7f0b006a}

Fragment2============1===onAttach===============
Fragment2============2===onCreate===============
Fragment1============-1===onHiddenChanged===============true//前个页面走onHiddenChanged
Fragment2============3===onCreateView===============
Fragment2============4===onActivityCreated===============
Fragment2============5===onStart===============
Fragment2============6===onResume===============
fragment===============Fragment1{443c58b #0 id=0x7f0b006a}
fragment===============Fragment2{73ba81 #1 id=0x7f0b006a}

Fragment3============1===onAttach===============
Fragment3============2===onCreate===============
Fragment2============-1===onHiddenChanged===============true
Fragment3============3===onCreateView===============
Fragment3============4===onActivityCreated===============
Fragment3============5===onStart===============
Fragment3============6===onResume===============
fragment===============Fragment1{443c58b #0 id=0x7f0b006a}
fragment===============Fragment2{73ba81 #1 id=0x7f0b006a}
fragment===============Fragment3{9272f67 #2 id=0x7f0b006a}

Fragment4============1===onAttach===============
Fragment4============2===onCreate===============
Fragment3============-1===onHiddenChanged===============true
Fragment4============3===onCreateView===============
Fragment4============4===onActivityCreated===============
Fragment4============5===onStart===============
Fragment4============6===onResume===============
fragment===============Fragment1{443c58b #0 id=0x7f0b006a}
fragment===============Fragment2{73ba81 #1 id=0x7f0b006a}
fragment===============Fragment3{9272f67 #2 id=0x7f0b006a}
fragment===============Fragment4{6cac114 #3 id=0x7f0b006a}


//进入第三个页面详情返回

Fragment4============-1===onHiddenChanged===============true//隐藏
Fragment3============-1===onHiddenChanged===============false//显示

//详情

Fragment1============7===onPause===============
Fragment2============7===onPause===============
Fragment3============7===onPause===============
Fragment4============7===onPause===============

Fragment1============8===onStop===============
Fragment2============8===onStop===============
Fragment3============8===onStop===============
Fragment4============8===onStop===============

//返回

Fragment1============5===onStart===============
Fragment2============5===onStart===============
Fragment3============5===onStart===============
Fragment4============5===onStart===============

Fragment1============6===onResume===============//返回时四个页面都走onStart、onresume
Fragment2============6===onResume===============
Fragment3============6===onResume===============
Fragment4============6===onResume===============

fragment===============Fragment1{443c58b #0 id=0x7f0b006a}
fragment===============Fragment2{73ba81 #1 id=0x7f0b006a}
fragment===============Fragment3{9272f67 #2 id=0x7f0b006a}



//进入第二个页面详情返回

Fragment3============-1===onHiddenChanged===============true
Fragment2============-1===onHiddenChanged===============false

//进入详情
Fragment1============7===onPause===============
Fragment2============7===onPause===============
Fragment3============7===onPause===============
Fragment4============7===onPause===============

Fragment1============8===onStop===============
Fragment2============8===onStop===============
Fragment3============8===onStop===============
Fragment4============8===onStop===============

//返回
Fragment1============5===onStart===============
Fragment2============5===onStart===============
Fragment3============5===onStart===============
Fragment4============5===onStart===============

Fragment1============6===onResume===============//返回时四个页面都走onresume
Fragment2============6===onResume===============
Fragment3============6===onResume===============
Fragment4============6===onResume===============

<font color="#00ff00">结论：详情返回都走一遍onPause、onStop、onStart、onResume</font>

