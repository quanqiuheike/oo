package com.polysoft.threecarpenter.view;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.polysoft.threecarpenter.R;
import com.polysoft.threecarpenter.base.BaseActivity;
import com.polysoft.threecarpenter.utils.CommonUtils;
import com.polysoft.threecarpenter.widget.HeadHelper;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity {


    @Bind(R.id.loginName)
    EditText et_loginName;
    @Bind(R.id.password)
    EditText et_password;
    @Bind(R.id.tv_error)
    TextView tvError;
    @Bind(R.id.tv_forgetPwd)
    TextView tvForgetPwd;
    @Bind(R.id.login_progress)
    ProgressBar loginProgress;
    @Bind(R.id.email_login_form)
    LinearLayout emailLoginForm;
    @Bind(R.id.login_form)
    ScrollView loginForm;
    @Bind(R.id.bt_sign_in)
    Button btSignIn;
    private String name;
    private String pwd;


    @Override
    public int setContentview() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        HeadHelper.getHeadHelper(this);
    }

    @Override
    public void initData() {

    }

    //登陆按钮点击
    @OnClick({R.id.tv_forgetPwd, R.id.bt_sign_in})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_forgetPwd:
                Intent intent = new Intent(LoginActivity.this, ForgetPwdActivity.class);
                startActivity(intent);

                break;
            case R.id.bt_sign_in:
//                if (check())
                doLogin();


                break;
        }
    }

    /**
     * 请求登陆
     */
    private void doLogin() {
//        RetrofitService.getRetrofit().login(name, pwd)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<ArrayList<ZhuangbiImage>>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        makeToast(e.toString());
//                        e.printStackTrace();
//                    }
//
//                    @Override
//                    public void onNext(ArrayList<ZhuangbiImage> zhuangbiImages) {
//                        makeToast("完成");
//                        System.out.println(zhuangbiImages.size());
//
//                    }
//                });
        Intent toMainActivity = new Intent(LoginActivity.this, AgreementActivity.class);
        startActivity(toMainActivity);
        LoginActivity.this.finish();


    }

    /**
     * 检验输入是否合法
     */
    private boolean check() {
        name = et_loginName.getText().toString().trim();
        pwd = et_password.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            tvError.setText("请输入用户名");
            return false;
        }
        if (TextUtils.isEmpty(pwd)) {
            tvError.setText("请输入密码");
            return false;
        }
        if (!CommonUtils.isMobilePhone(name)) {
            tvError.setText("请输入正确手机号");
            return false;
        }
        tvError.setText("");
        return true;

    }


}

