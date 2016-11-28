package com.polysoft.threecarpenter.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentview());
        ButterKnife.bind(this);
        initData();
        initView();

    }

    public abstract int setContentview();

    public abstract void initView();

    public abstract void initData();

    public void hideKeyBoard() {
        View veiw = getCurrentFocus();
        if (veiw != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            veiw.clearFocus();
            imm.hideSoftInputFromWindow(veiw.getWindowToken(), 0);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    /**
     * 吐司通知
     *
     * @param content
     */
    public void makeToast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();

    }

    /**
     * 消息提示
     */
    public void centerToast(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }


}
