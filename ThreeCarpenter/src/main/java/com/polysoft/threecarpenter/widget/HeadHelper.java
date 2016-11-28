package com.polysoft.threecarpenter.widget;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.polysoft.threecarpenter.R;

/**
 * Created by xu on 2016/11/18.
 */
public class HeadHelper {


    ImageView back, iv_message;
    TextView headTittle, tv_location;


    private HeadHelper(final Object object) {
        if (object == null) {
            System.out.println("context  is   null");
            return;
        }
        if (object instanceof Activity) {
            final Activity context = (Activity) object;
            back = (ImageView) context.findViewById(R.id.iv_head_back);
            iv_message = (ImageView) context.findViewById(R.id.iv_message_right);
            headTittle = (TextView) context.findViewById(R.id.tv_head_tittle);
            tv_location = (TextView) context.findViewById(R.id.tv_location);
            if (back != null) {
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        context.finish();
                    }
                });
            }
            if (tv_location != null) {
                //地理位置点击
                tv_location.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent();
                    }
                });
            }
        } else if (object instanceof View) {
            final View context = (View) object;
            back = (ImageView) context.findViewById(R.id.iv_head_back);
            iv_message = (ImageView) context.findViewById(R.id.iv_message_right);
            headTittle = (TextView) context.findViewById(R.id.tv_head_tittle);
            tv_location = (TextView) context.findViewById(R.id.tv_location);

            if (tv_location != null) {
                //地理位置点击
                tv_location.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent();
                    }
                });
            }
        }
    }

    public static HeadHelper getHeadHelper(Activity context) {

        return new HeadHelper(context);
    }

    public static HeadHelper getHeadHelper(View context) {

        return new HeadHelper(context);
    }

    public void setTittleName(String name) {
        headTittle.setText(name);
    }

    public void setBackInVisable() {
        back.setVisibility(View.INVISIBLE);
    }

    public void setMainTittle() {
        tv_location.setVisibility(View.VISIBLE);
        iv_message.setVisibility(View.VISIBLE);
        back.setVisibility(View.INVISIBLE);
    }

}
