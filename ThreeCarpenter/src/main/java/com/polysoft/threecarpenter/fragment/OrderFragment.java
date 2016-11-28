package com.polysoft.threecarpenter.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.polysoft.threecarpenter.R;
import com.polysoft.threecarpenter.base.BaseFragment;
import com.polysoft.threecarpenter.widget.HeadHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 *
 */
public class OrderFragment extends BaseFragment {

    View view;
    @Bind(R.id.tab_order)
    TabLayout tab;
    @Bind(R.id.vp_Order)
    ViewPager vpOrder;
    private String[] tabName;

    public OrderFragment() {
    }


    @Override
    public View createView() {
        view = View.inflate(getHoldingActivity(), R.layout.fragment_order, null);
        ButterKnife.bind(view);
        return view;
    }

    @Override
    public void initData() {
        tabName = new String[]{"订单任务", "进行中订单", "历史订单"};

    }


    public void initHeader() {
        HeadHelper headHelper = HeadHelper.getHeadHelper(view);
        headHelper.setTittleName("订单");
        headHelper.setBackInVisable();


    }

    @Override
    public void initView() {
        initHeader();
        vpOrder.setAdapter(new FragmentPagerAdapter(getHoldingActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new Order_First_Fragment();
                    case 1:
                        return new Order_First_Fragment();
                    case 2:
                        return new Order_First_Fragment();
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return null;
            }
        });
        tab.setupWithViewPager(vpOrder);
        for (int i = 0; i < 3; i++) {
            View tittle = View.inflate(getContext(), R.layout.order_layout, null);
            tab.getTabAt(i).setCustomView(tittle);
            ((TextView) tittle.findViewById(R.id.iv_tabName)).setText(tabName[i]);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
