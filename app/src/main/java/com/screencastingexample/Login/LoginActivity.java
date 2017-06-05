package com.screencastingexample.Login;

import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.screencastingexample.Activity.BaseActivity;
import com.screencastingexample.Models.RequstModels.LoginRequest.LoginRequestBody;
import com.screencastingexample.Models.RequstModels.LoginRequest.LoginRequestData;
import com.screencastingexample.Models.RequstModels.LoginRequest.LoginRequestEnvelope;
import com.screencastingexample.R;
import com.screencastingexample.utils.AppContext;

/**
 * Created by akshayborgave on 03/06/17.
 */

public class LoginActivity extends BaseActivity implements LoginMVP.View{

    Button mLogin;

    EditText mUserName;
    EditText mPassword;
    LoginPresenter mLoginPresenter;
    @Override
    protected void setUpUI() {

        mLoginPresenter = new LoginPresenter(this);
        mLogin = (Button) findViewById(R.id.loginButton);
        mPassword = (EditText) findViewById(R.id.password);
        mUserName = (EditText) findViewById(R.id.userName);


        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showProgressBar("Authenticating...");
                mLoginPresenter.authenticateStudent(getLoginRequest());

            }
        });

    }

    private LoginRequestEnvelope getLoginRequest(){

        LoginRequestEnvelope loginRequestEnvelope = new LoginRequestEnvelope();

        LoginRequestBody loginRequestBody = new LoginRequestBody();

        LoginRequestData loginRequestData = new LoginRequestData();


        loginRequestData.setPassword(mPassword.getText().toString());
        loginRequestData.setUserName(mUserName.getText().toString());
        loginRequestData.setSplashGainToken(AppContext.getSplashGainToken());

        loginRequestBody.setLoginStudentData(loginRequestData);
        loginRequestEnvelope.setLoginRequestBody(loginRequestBody);


        return loginRequestEnvelope;
    }

    @Override
    public void onAuthenticationDone(long studentId) {

        hideProgressBar();

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_login_layout;
    }

    @Override
    public void onErrorReceived(Throwable t) {

        if(t == null){

            Toast.makeText(this, "No Response...", Toast.LENGTH_LONG).show();
        }
        hideProgressBar();
    }
}
