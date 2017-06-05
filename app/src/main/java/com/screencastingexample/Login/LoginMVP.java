package com.screencastingexample.Login;

import com.screencastingexample.Models.RequstModels.LoginRequest.LoginRequestEnvelope;
import com.screencastingexample.Models.ResponseModels.LoginResponse.LoginResponseEnvelope;
import com.screencastingexample.NetworkInterfaces.BaseModel;
import com.screencastingexample.NetworkInterfaces.BasePresenter;
import com.screencastingexample.NetworkInterfaces.BaseView;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by akshayborgave on 03/06/17.
 */

public interface LoginMVP {


    interface  View extends BaseView{


        void onAuthenticationDone(long studentId);

        void onErrorReceived(Throwable t);


    }

     interface Model extends BaseModel{


         void authenticateStudent(Presenter.StudentResponseHandler studentResponseHandler, LoginRequestEnvelope loginRequestEnvelope);


    }


     interface Presenter extends BasePresenter{


         interface StudentResponseHandler {

             void onStudentAuthenticationCompleted( long studentId);

             void onErrorReceived(Throwable t);
         }

         void authenticateStudent(LoginRequestEnvelope loginRequestEnvelope);


     }


    interface Network {
        @Headers({
                "Content-Type: text/xml",
                "Accept-Charset: utf-8"
        })
//        @Headers({
//                "Content-Type: application/soap+xml",
//                "Accept-Charset: utf-8"
//        })
        @POST("/AndroidVideoStreamingService.asmx?op=AuthenticateStudent")
        Call<LoginResponseEnvelope> authenticate(@Body LoginRequestEnvelope loginRequestEnvelope);
    }


}
