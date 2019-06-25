package com.potevio.daggertestagain.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.potevio.daggertestagain.R;
import com.potevio.daggertestagain.base.BaseActivity;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.IMainView{

    private final static String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.account)
    EditText account;

    @BindView(R.id.password)
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initDagger() {
        getShareComponent().inject(this);
    }

    @Override
    public void onFail(int code) {
        Toast.makeText(this, "login fail!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(int code,String msg) {
        Log.i(TAG,"code:"+code+"  msg:"+msg);
        Toast.makeText(this, "login success!", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.login)
    void onAttemptLogin() {
        Map<String,String> paramsMap = new HashMap<>();
        paramsMap.put("name",account.getText().toString());
        paramsMap.put("password",password.getText().toString());
        paramsMap.put("imei","123");
        paramsMap.put("appversion","1.3.8");

        mPresenter.attemptLogin(paramsMap);
    }


}
