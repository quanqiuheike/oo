package com.polysoft.threecarpenter.fragment;


import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;

import com.polysoft.threecarpenter.R;
import com.polysoft.threecarpenter.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class Order_First_Fragment extends BaseFragment {

    View view;

    public Order_First_Fragment() {
    }


    @Override
    public View createView() {
        view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_order__first_, null, false);
        ButterKnife.bind(view);
        return view;
    }

    @Override
    public void initData() {

    }


    @Override
    public void initView() {

    }

}
