package com.xq.myfragment.activity.viewpager2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xq.myfragment.DetailActivity;
import com.xq.myfragment.R;


public class Fragment4 extends LazyFragment {
    private boolean isPrepared;

  
     /*================================================================================*/

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        System.out.println("Fragment4============-1===onHiddenChanged===============" + hidden);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        System.out.println("Fragment4============0===setUserVisibleHint===============" + isVisibleToUser);
    }


    @Override
    protected void onVisible() {
        if (!isPrepared || !isVisible) {
            return;
        }
        System.out.println("Fragment4================onVisible==================");
    }

    @Override
    protected void onInvisible() {

    }

    /*------------------------------------------------------------------------------------------------*/

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        System.out.println("Fragment4============1===onAttach===============");
        System.out.println("Fragment4----1----onAttach--------getUserVisibleHint----------" + getUserVisibleHint());
        System.out.println("Fragment4----1----onAttach--------isVisible----------" + isVisible());
        System.out.println("Fragment4----1----onAttach--------isHidden----------" + isHidden());
        System.out.println("Fragment4----1----onAttach--------isAdded----------" + isAdded());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("Fragment4============2===onCreate===============");
        System.out.println("Fragment4----1----onCreate--------getUserVisibleHint----------" + getUserVisibleHint());
        System.out.println("Fragment4----1----onCreate--------isVisible----------" + isVisible());
        System.out.println("Fragment4----1----onCreate--------isHidden----------" + isHidden());
        System.out.println("Fragment4----1----onCreate--------isAdded----------" + isAdded());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment, container, false);

        isPrepared=true;

        TextView textView = (TextView) view.findViewById(R.id.tv);
        String msg = "Fragment4";
        textView.setText(msg);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DetailActivity.class));
            }
        });
        System.out.println("Fragment4============3===onCreateView===============");
        System.out.println("Fragment4----1----onCreateView--------getUserVisibleHint----------" + getUserVisibleHint());
        System.out.println("Fragment4----1----onCreateView--------isVisible----------" + isVisible());
        System.out.println("Fragment4----1----onCreateView--------isHidden----------" + isHidden());
        System.out.println("Fragment4----1----onCreateView--------isAdded----------" + isAdded());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("Fragment4============4===onActivityCreated===============");
        System.out.println("Fragment4----1----onActivityCreated--------getUserVisibleHint----------" + getUserVisibleHint());
        System.out.println("Fragment4----1----onActivityCreated--------isVisible----------" + isVisible());
        System.out.println("Fragment4----1----onActivityCreated--------isHidden----------" + isHidden());
        System.out.println("Fragment4----1----onActivityCreated--------isAdded----------" + isAdded());
    }

    /*-------------------------------------------------------created-----------------------------------------------------*/

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("Fragment4============5===onStart===============");
        System.out.println("Fragment4----1----onStart--------getUserVisibleHint----------" + getUserVisibleHint());
        System.out.println("Fragment4----1----onStart--------isVisible----------" + isVisible());
        System.out.println("Fragment4----1----onStart--------isHidden----------" + isHidden());
        System.out.println("Fragment4----1----onStart--------isAdded----------" + isAdded());
    }

    /*-------------------------------------------------------started-----------------------------------------------------*/

    @Override
    public void onResume() {
        super.onResume();

        onVisible();

        System.out.println("Fragment4============6===onResume===============");
        System.out.println("Fragment4----1----onResume--------getUserVisibleHint----------" + getUserVisibleHint());
        System.out.println("Fragment4----1----onResume--------isVisible----------" + isVisible());
        System.out.println("Fragment4----1----onResume--------isHidden----------" + isHidden());
        System.out.println("Fragment4----1----onResume--------isAdded----------" + isAdded());
    }

    /*-------------------------------------------------------resumed-----------------------------------------------------*/

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("Fragment4============7===onPause===============");
        System.out.println("Fragment4----1----onPause--------getUserVisibleHint----------" + getUserVisibleHint());
        System.out.println("Fragment4----1----onPause--------isVisible----------" + isVisible());
        System.out.println("Fragment4----1----onPause--------isHidden----------" + isHidden());
        System.out.println("Fragment4----1----onPause--------isAdded----------" + isAdded());
    }

    /*-------------------------------------------------------paused-----------------------------------------------------*/

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("Fragment4============8===onStop===============");
        System.out.println("Fragment4----1----onStop--------getUserVisibleHint----------" + getUserVisibleHint());
        System.out.println("Fragment4----1----onStop--------isVisible----------" + isVisible());
        System.out.println("Fragment4----1----onStop--------isHidden----------" + isHidden());
        System.out.println("Fragment4----1----onStop--------isAdded----------" + isAdded());
    }

    /*-------------------------------------------------------stopped-----------------------------------------------------*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("Fragment4============9===onDestroyView===============");
        System.out.println("Fragment4----1----onDestroyView--------getUserVisibleHint----------" + getUserVisibleHint());
        System.out.println("Fragment4----1----onDestroyView--------isVisible----------" + isVisible());
        System.out.println("Fragment4----1----onDestroyView--------isHidden----------" + isHidden());
        System.out.println("Fragment4----1----onDestroyView--------isAdded----------" + isAdded());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Fragment4============10===onDestroy===============");
        System.out.println("Fragment4----1----onDestroy--------getUserVisibleHint----------" + getUserVisibleHint());
        System.out.println("Fragment4----1----onDestroy--------isVisible----------" + isVisible());
        System.out.println("Fragment4----1----onDestroy--------isHidden----------" + isHidden());
        System.out.println("Fragment4----1----onDestroy--------isAdded----------" + isAdded());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("Fragment4============11===onDetach===============");
        System.out.println("Fragment4----1----onDetach--------getUserVisibleHint----------" + getUserVisibleHint());
        System.out.println("Fragment4----1----onDetach--------isVisible----------" + isVisible());
        System.out.println("Fragment4----1----onDetach--------isHidden----------" + isHidden());
        System.out.println("Fragment4----1----onDetach--------isAdded----------" + isAdded());
    }
    /*-------------------------------------------------------destroyed-----------------------------------------------------*/
}
