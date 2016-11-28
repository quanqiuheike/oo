package com.polysoft.threecarpenter.view;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.polysoft.threecarpenter.MyApplication;
import com.polysoft.threecarpenter.R;
import com.polysoft.threecarpenter.base.BaseActivity;
import com.polysoft.threecarpenter.widget.HeadHelper;

import butterknife.Bind;
import butterknife.OnClick;

public class ForgetPwdActivity extends BaseActivity {

    @Bind(R.id.et_phoneNum)
    EditText etPhoneNum;
    @Bind(R.id.bt_getVerificationCode)
    Button btGetVerificationCode;
    @Bind(R.id.et_verificationCode)
    EditText etVerificationCode;
    @Bind(R.id.et_newPwd)
    EditText etNewPwd;
    @Bind(R.id.et_pwdComfirm)
    EditText etPwdComfirm;
    @Bind(R.id.tv_error_show)
    TextView tvErrorShow;
    @Bind(R.id.bt_ok)
    Button btOk;

    private static final String KEY = "codeTime";
    long coldDown = 60000;//60s 冷却时间
    long finishTime = 0L;


    @Override

    public int setContentview() {
        return R.layout.activity_forget_pwd;
    }

    public void initView() {
        HeadHelper headHelper = HeadHelper.getHeadHelper(this);
        headHelper.setTittleName("忘记密码");
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.bt_getVerificationCode, R.id.bt_ok})
    public void onClick(View view) {
        switch (view.getId()) {
            //获取验证码4
            case R.id.bt_getVerificationCode:

                countDowm(coldDown);
                finishTime = System.currentTimeMillis() + coldDown;
                break;
            //确认
            case R.id.bt_ok:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (finishTime != 0L) {
            MyApplication.getInstance().setLongSP("CodeTime", finishTime);
        }
    }

    @Override
    protected void onResume() {
        super.onStart();
        long lastTime = MyApplication.getInstance().getLongSP("CodeTime");
        if (lastTime != 0) {
            long remainTime = lastTime - System.currentTimeMillis();
            if (remainTime > 1000)
                countDowm(remainTime);
        }
    }


    public void countDowm(final long now) {
        new CountDownTimer(now, 1000) {
            @Override
            public void onTick(long l) {
                if (btGetVerificationCode == null) {
                    return;
                }
                btGetVerificationCode.setClickable(false);
                btGetVerificationCode.setEnabled(false);
                int i = (int) Math.floor(l / 1000);
                btGetVerificationCode.setText(i + "s后重新获取");
            }

            @Override
            public void onFinish() {
                if (btGetVerificationCode == null) {
                    return;
                }
                btGetVerificationCode.setClickable(true);
                btGetVerificationCode.setEnabled(true);
                btGetVerificationCode.setText(R.string.getVerificationCode);

            }
        }.start();
    }

}
