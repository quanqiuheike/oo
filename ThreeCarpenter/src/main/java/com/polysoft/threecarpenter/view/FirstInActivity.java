package com.polysoft.threecarpenter.view;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.polysoft.threecarpenter.R;
import com.polysoft.threecarpenter.adapter.ViewPagerAdapter;
import com.polysoft.threecarpenter.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class FirstInActivity extends BaseActivity {


    @Bind(R.id.vp_show)
    ViewPager vpShow;
    @Bind(R.id.linear_parent)
    LinearLayout linearParent;
    private List<Integer> list;

    @Override
    public int setContentview() {
        return R.layout.activity_first_in;
    }

    @Override
    public void initView() {


        for (int i = 0; i < list.size(); i++) {
            View v = new View(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(50, 50);
            params.leftMargin = 20;
            params.rightMargin = 20;
            v.setLayoutParams(params);
            v.setBackgroundResource(R.drawable.indecator);
            if (i == 0) {
                v.setSelected(true);
            } else {
                v.setSelected(false);
            }
            linearParent.addView(v);
        }
        //ViewPager切换监听
        vpShow.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < list.size(); i++) {
                    linearParent.getChildAt(i).setSelected(i == position);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        vpShow.setAdapter(new ViewPagerAdapter(list, this, false));
    }

    @Override
    public void initData() {
        //初始化图片数据
        list = new ArrayList<>();
        list.add(android.R.mipmap.sym_def_app_icon);
        list.add(android.R.mipmap.sym_def_app_icon);
        list.add(android.R.mipmap.sym_def_app_icon);

    }
}
