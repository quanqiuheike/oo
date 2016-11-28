package com.polysoft.threecarpenter.view;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.polysoft.threecarpenter.R;
import com.polysoft.threecarpenter.base.BaseActivity;
import com.polysoft.threecarpenter.widget.HeadHelper;

import butterknife.Bind;
import butterknife.OnClick;

public class AgreementActivity extends BaseActivity {


    @Bind(R.id.cb_isAgree)
    CheckBox cbIsAgree;
    @Bind(R.id.bt_noAgree)
    Button btNoAgree;
    @Bind(R.id.bt_agree)
    Button btAgree;

    @Override
    public int setContentview() {
        return R.layout.activity_agreement;
    }

    @Override
    public void initView() {
        HeadHelper headHelper = HeadHelper.getHeadHelper(this);
        headHelper.setBackInVisable();
        headHelper.setTittleName("入职协议");
        cbIsAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                btAgree.setClickable(b);
                btAgree.setEnabled(b);
            }
        });

    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.bt_noAgree, R.id.bt_agree})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_noAgree:
                this.finish();
                break;
            case R.id.bt_agree:
                Intent intent = new Intent(AgreementActivity.this, MainActivity.class);
                startActivity(intent);
                this.finish();
                break;
        }
    }
}
