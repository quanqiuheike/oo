package com.polysoft.threecarpenter.base;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
    public View view;
    public Context context;
    public Bundle savedInstanceState;
    private BaseActivity mActivity;

    // 初始化数据
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = (Context) getActivity();
        this.savedInstanceState = savedInstanceState;
    }

    // 加载布局
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initData();
        view = createView();

        return view;
    }

    // 填充数据
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    @Override
    public void onStart() {

        super.onStart();

    }

    @Override
    public void onHiddenChanged(boolean hidden) {

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (BaseActivity) activity;
    }

    //获取宿主Activity
    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }

    /**
     * 加载布局
     *
     * @return
     */
    public abstract View createView();

    /**
     * 填充数据
     */
    public abstract void initData();


    /**
     * 初始化其他组件
     */
    public abstract void initView();

}
