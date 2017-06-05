package com.screencastingexample.Login;

import com.screencastingexample.Models.RequstModels.LoginRequest.LoginRequestEnvelope;

/**
 * Created by akshayborgave on 04/06/17.
 */

public class LoginPresenter implements LoginMVP.Presenter, LoginMVP.Presenter.StudentResponseHandler  {

    private LoginMVP.View mView;
    private LoginMVP.Model mModel;

    public LoginPresenter(LoginMVP.View view) {

        mModel = new LoginModel();
        mView = view;
    }

    @Override
    public void authenticateStudent(LoginRequestEnvelope loginRequestEnvelope) {

        mModel.authenticateStudent(this, loginRequestEnvelope);
    }

    @Override
    public void onStudentAuthenticationCompleted(long studentId) {

        if(mView != null){

            mView.onAuthenticationDone(studentId);
        }

    }

    @Override
    public void onErrorReceived(Throwable t) {

        if(mView != null){

            mView.onErrorReceived(t);
        }
    }
}
