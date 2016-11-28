package com.polysoft.threecarpenter.fragment;


import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.polysoft.threecarpenter.R;
import com.polysoft.threecarpenter.adapter.ViewPagerAdapter;
import com.polysoft.threecarpenter.base.BaseFragment;
import com.polysoft.threecarpenter.widget.HeadHelper;

import java.util.ArrayList;


public class MainFragment extends BaseFragment {
    ViewPager vpAutoScroll;
    LinearLayout llIndex;
    private View view;
    /**
     * 轮播图片的数量
     */
    private int imgs = 3;

    private static MainFragment mainFragment = new MainFragment();
    //轮播数据
    private ArrayList<Integer> list;

    public MainFragment() {
    }

    public static MainFragment getInstance() {

        if (mainFragment == null) {
            mainFragment = new MainFragment();
        }
        return mainFragment;
    }


    @Override
    public View createView() {
        view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_main, null, false);
        return view;
    }

    @Override
    public void initData() {
        list = new ArrayList<>();
        list.add(android.R.mipmap.sym_def_app_icon);
        list.add(android.R.mipmap.sym_def_app_icon);
        list.add(android.R.mipmap.sym_def_app_icon);

    }


    public void initHeader() {
        HeadHelper headHelper = HeadHelper.getHeadHelper(view);
        headHelper.setMainTittle();
        headHelper.setTittleName(getString(R.string.app_name));
    }

    @Override
    public void initView() {
        initHeader();
        //初始化轮播图的小点
        llIndex = (LinearLayout) view.findViewById(R.id.ll_index);
        vpAutoScroll = (ViewPager) view.findViewById(R.id.vp_autoScroll);
        for (int i = 0; i < imgs; i++) {
            View v = new View(getContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(30, 30);
            params.leftMargin = 20;
            params.rightMargin = 20;
            v.setLayoutParams(params);
            v.setBackgroundResource(R.drawable.indecator);
            if (i == 0) {
                v.setSelected(true);
            } else {
                v.setSelected(false);
            }
            llIndex.addView(v);
        }
        //轮播图监听
        vpAutoScroll.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < imgs; i++) {
                    llIndex.getChildAt(i).setSelected(i == position % imgs);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        vpAutoScroll.setAdapter(new ViewPagerAdapter(list, getHoldingActivity(), true));
        vpAutoScroll.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                switch (keyEvent.getAction()) {
                    case KeyEvent.ACTION_DOWN:


                        return false;
                }
                return false;
            }
        });


    }


}
