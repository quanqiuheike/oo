package com.polysoft.threecarpenter.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.polysoft.threecarpenter.MyApplication;
import com.polysoft.threecarpenter.R;
import com.polysoft.threecarpenter.view.LoginActivity;

import java.util.List;

/**
 * Created by xu on 2016/11/21.
 */
public class ViewPagerAdapter extends PagerAdapter {

    private List<Integer> mList;
    private Activity mContext;
    private boolean canOverScroll;

    public ViewPagerAdapter(List<Integer> list, Activity context, boolean canOverScroll) {
        this.mContext = context;
        this.mList = list;
        this.canOverScroll = canOverScroll;
    }

    @Override
    public int getCount() {
        return canOverScroll ? Integer.MAX_VALUE : mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view;
        //能无线滚动
        if (canOverScroll) {
            view = View.inflate(mContext, R.layout.adapter_ad, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_backIv);
            imageView.setImageResource(mList.get(position % mList.size()));
        } else {
            //不能无限滚动
            view = View.inflate(mContext, R.layout.adapter_ad, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_backIv);
            imageView.setImageResource(mList.get(position));
            if (position == mList.size() - 1) {
                Button b = (Button) view.findViewById(R.id.bt_In);
                b.setVisibility(View.VISIBLE);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MyApplication.setBooleanSP("alreadyIn", true);
                        Intent intent = new Intent(mContext, LoginActivity.class);
                        mContext.startActivity(intent);
                        mContext.finish();
                    }
                });
            }
        }
        container.addView(view);

        return view;
    }

    /**
     * 销毁page position： 当前需要消耗第几个page object:当前需要消耗的page
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}