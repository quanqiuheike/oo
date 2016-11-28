package com.polysoft.threecarpenter.view;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.polysoft.threecarpenter.R;
import com.polysoft.threecarpenter.base.BaseActivity;
import com.polysoft.threecarpenter.fragment.MainFragment;
import com.polysoft.threecarpenter.fragment.MineFragment;
import com.polysoft.threecarpenter.fragment.OrderFragment;

import butterknife.Bind;

public class MainActivity extends BaseActivity {
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.viewPager_main)
    ViewPager viewPager;

    private String[] tabName;


    @Override
    public int setContentview() {
        return R.layout.activity_main;
    }

    public void initData() {
        tabName = new String[]{"首页", "订单", "我的"};
    }

    public void initView() {
        FragmentManager manager = getSupportFragmentManager();

        viewPager.setAdapter(new FragmentPagerAdapter(manager) {

            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return MainFragment.getInstance();
                    case 1:
                        return new OrderFragment();
                    case 2:
                        return new MineFragment();
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return tabName.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tabName[position];
            }
        });
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(Color.rgb(0, 0, 0), Color.rgb(0, 0, 255));
        tabLayout.setBackgroundColor(Color.rgb(255, 255, 255));
        tabLayout.setSelectedTabIndicatorColor(Color.DKGRAY);
        tabLayout.setSelectedTabIndicatorHeight(0);
    }
}
