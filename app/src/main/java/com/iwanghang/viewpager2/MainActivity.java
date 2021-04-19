package com.iwanghang.viewpager2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "byWh";
    public static Activity mActivity = null;

    // 创建一些视图View，用于放置到我们的ViewPager容器中
    private List<View> views;
    private ViewPager2 mViewPager2_01;
    // 因为viewpager的使用要街注意一个适配器，所以要创建一个适配器的对象
    private EcgResultAdapter mEcgResultAdapter;
    private Page01Adapter mPage01Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 屏幕常亮
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        mActivity = this;
        initResultViews();
    }

    private void initResultViews() {
        views = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(this);
        // 向ViewPager中添加view
        views.add(inflater.inflate(R.layout.pp_01_01, null));
        views.add(inflater.inflate(R.layout.pp_01_02, null));
        views.add(inflater.inflate(R.layout.pp_01_03, null));
        // 创建ViewPager以及添加适配器
        mViewPager2_01 = findViewById(R.id.viewpager2);
        mPage01Adapter = new Page01Adapter(views, this, callBack_01);
        mViewPager2_01.setAdapter(mPage01Adapter);
        // 为ViewPager2 注册监听事件
        mViewPager2_01.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                doWhLog( "registerOnPageChangeCallback - onPageScrolled - position - " + position);
                if (position == 0) {
                    TextView text_pp_01_01 = findViewById(R.id.text_pp_01_01);
                    text_pp_01_01.setText("11111111");
                } else if (position == 1) {
                    TextView text_pp_01_02 = findViewById(R.id.text_pp_01_02);
                    text_pp_01_02.setText("222222222");
                } else if (position == 2) {
                    TextView text_pp_01_03 = findViewById(R.id.text_pp_01_03);
                    text_pp_01_03.setText("333333333");
                }
            }
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                doWhLog( "registerOnPageChangeCallback - onPageSelected - position - " + position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                doWhLog( "registerOnPageChangeCallback - onPageScrollStateChanged - state - " + state);
            }
        });
    }

    private Page01Adapter.CallBack callBack_01 = new Page01Adapter.CallBack() {
        @Override
        public void onClick(int position) {
            doWhLog( "Page01Adapter - onClick - " + position);
            switch (position) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;

            }
        }
    };

    public static void doWhLog(String logInfo) {
        Log.d(TAG, logInfo);
    }

}