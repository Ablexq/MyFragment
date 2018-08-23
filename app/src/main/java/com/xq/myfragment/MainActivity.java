package com.xq.myfragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xq.myfragment.activity.bottomnavi.BottomNavigationActivity;
import com.xq.myfragment.activity.hideshow.HideShowActivity;
import com.xq.myfragment.activity.hideshow2.HideShowActivity2;
import com.xq.myfragment.activity.radiogroup.RadioGroupActivity;
import com.xq.myfragment.activity.replace.ReplaceActivity;
import com.xq.myfragment.activity.tabvp.TabVpActivity;
import com.xq.myfragment.activity.viewpager.ViewPagerActivity;
import com.xq.myfragment.activity.viewpager2.ViewPagerActivity2;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mTv1 = ((TextView) this.findViewById(R.id.tv1));
        TextView mTv2 = ((TextView) this.findViewById(R.id.tv2));
        TextView mTv3 = ((TextView) this.findViewById(R.id.tv3));
        TextView mTv4 = ((TextView) this.findViewById(R.id.tv4));
        TextView mTv5 = ((TextView) this.findViewById(R.id.tv5));
        TextView mTv6 = ((TextView) this.findViewById(R.id.tv6));
        TextView mTv7 = ((TextView) this.findViewById(R.id.tv7));
        TextView mTv8 = ((TextView) this.findViewById(R.id.tv8));
        mTv1.setOnClickListener(this);
        mTv2.setOnClickListener(this);
        mTv3.setOnClickListener(this);
        mTv4.setOnClickListener(this);
        mTv5.setOnClickListener(this);
        mTv6.setOnClickListener(this);
        mTv7.setOnClickListener(this);
        mTv8.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv1:
                startActivity(new Intent(MainActivity.this, HideShowActivity.class));
                break;
            case R.id.tv2:
                startActivity(new Intent(MainActivity.this, ReplaceActivity.class));
                break;
            case R.id.tv3:
                startActivity(new Intent(MainActivity.this, ViewPagerActivity.class));
                break;

            case R.id.tv4:
                startActivity(new Intent(MainActivity.this, TabVpActivity.class));
                break;

            case R.id.tv5:
                startActivity(new Intent(MainActivity.this, HideShowActivity2.class));
                break;

            case R.id.tv6:
                startActivity(new Intent(MainActivity.this, ViewPagerActivity2.class));
                break;

            case R.id.tv7:
                startActivity(new Intent(MainActivity.this, BottomNavigationActivity.class));
                break;

            case R.id.tv8:
                startActivity(new Intent(MainActivity.this, RadioGroupActivity.class));
                break;

            default:
                break;
        }
    }
}
