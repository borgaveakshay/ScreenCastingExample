package com.screencastingexample.Login;

import android.util.Log;

import com.screencastingexample.Models.RequstModels.LoginRequest.LoginRequestEnvelope;
import com.screencastingexample.Models.ResponseModels.LoginResponse.LoginResponseEnvelope;
import com.screencastingexample.utils.AppContext;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by akshayborgave on 04/06/17.
 */

public class LoginModel implements LoginMVP.Model {


    LoginMVP.Network mLoginAPI = AppContext.getRetrofitInstance().create(LoginMVP.Network.class);

    @Override
    public void authenticateStudent(final LoginMVP.Presenter.StudentResponseHandler studentResponseHandler, LoginRequestEnvelope loginRequestEnvelope) {

        mLoginAPI.authenticate(loginRequestEnvelope).enqueue(new Callback<LoginResponseEnvelope>() {
            @Override
            public void onResponse(Call<LoginResponseEnvelope> call, Response<LoginResponseEnvelope> response) {

                if(response.errorBody() == null){

                    //studentResponseHandler.onStudentAuthenticationCompleted(response.body().getLoginResponseBody().getLoginResponseData().getStudentId());
                }
                else {
                    studentResponseHandler.onErrorReceived(null);
                }
            }

            @Override
            public void onFailure(Call<LoginResponseEnvelope> call, Throwable t) {

                Log.i("Error", t.getLocalizedMessage());
                studentResponseHandler.onErrorReceived(t);

            }
        });
    }
}
