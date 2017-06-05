package com.screencastingexample.Models.ResponseModels.LoginResponse;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by akshayborgave on 04/06/17.
 */
@Root(name = "soap : Body", strict = false)
public class LoginResponseBody {

    @Element(name = "AuthenticateStudentResponse", required = false)
    private LoginResponseData mLoginResponseData;

    public LoginResponseData getLoginResponseData() {
        return mLoginResponseData;
    }

    public void setLoginResponseData(LoginResponseData mLoginResponseData) {
        this.mLoginResponseData = mLoginResponseData;
    }
}
