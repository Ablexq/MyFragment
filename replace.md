replace
=========


<font color="#ff0000">1、切换tab

//初始化第一个

Fragment1============1===onAttach===============
Fragment1============2===onCreate===============
Fragment1============3===onCreateView===============
Fragment1============4===onActivityCreated===============
Fragment1============5===onStart===============
Fragment1============6===onResume===============
======================VisibleFragment===============Fragment1{443c58b #0 id=0x7f0b006a}
Fragment2============1===onAttach===============
Fragment2============2===onCreate===============

//点击第二个

Fragment1============7===onPause===============
Fragment1============8===onStop===============
Fragment1============9===onDestroyView===============
Fragment1============10===onDestroy===============
Fragment1============11===onDetach===============

Fragment2============3===onCreateView===============
Fragment2============4===onActivityCreated===============
Fragment2============5===onStart===============
Fragment2============6===onResume===============
======================VisibleFragment===============null
======================VisibleFragment===============Fragment2{73ba81 #1 id=0x7f0b006a}
Fragment3============1===onAttach===============
Fragment3============2===onCreate===============

//点击第三个

Fragment2============7===onPause===============
Fragment2============8===onStop===============
Fragment2============9===onDestroyView===============
Fragment2============10===onDestroy===============
Fragment2============11===onDetach===============

Fragment3============3===onCreateView===============
Fragment3============4===onActivityCreated===============
Fragment3============5===onStart===============
Fragment3============6===onResume===============
======================VisibleFragment===============Fragment3{9272f67 #0 id=0x7f0b006a}
Fragment4============1===onAttach===============
Fragment4============2===onCreate===============

//点击第四个

Fragment3============7===onPause===============
Fragment3============8===onStop===============
Fragment3============9===onDestroyView===============
Fragment3============10===onDestroy===============
Fragment3============11===onDetach===============

Fragment4============3===onCreateView===============
Fragment4============4===onActivityCreated===============
Fragment4============5===onStart===============
Fragment4============6===onResume===============
======================VisibleFragment===============null
======================VisibleFragment===============Fragment4{6cac114 #1 id=0x7f0b006a}
Fragment1============1===onAttach===============
Fragment1============2===onCreate===============

//点击第一个

Fragment4============7===onPause===============
Fragment4============8===onStop===============
Fragment4============9===onDestroyView===============
Fragment4============10===onDestroy===============
Fragment4============11===onDetach===============

Fragment1============3===onCreateView===============
Fragment1============4===onActivityCreated===============
Fragment1============5===onStart===============
Fragment1============6===onResume===============


<font color="#00ff00">结论：replace 每一个fragment都会走整个生命 

<font color="#ff0000">2、只加载一个界面或多个界面：点击详情后返回

//显示

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

<font color="#00ff00">结论：只有一个fragment 走生命周期