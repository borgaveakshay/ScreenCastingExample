package com.screencastingexample.Models.RequstModels.LoginRequest;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by akshayborgave on 04/06/17.
 */

@Root(name = "soap12:Body", strict = false)
public class LoginRequestBody {

    @Element(name = "AuthenticateStudent",required = false)
    private LoginRequestData mLoginStudentData;

    public LoginRequestData getLoginStudentData() {
        return mLoginStudentData;
    }

    public void setLoginStudentData(LoginRequestData mLoginStudentData) {
        this.mLoginStudentData = mLoginStudentData;
    }
}
