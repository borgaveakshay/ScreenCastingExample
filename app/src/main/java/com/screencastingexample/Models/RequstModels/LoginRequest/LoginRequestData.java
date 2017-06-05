package com.screencastingexample.Models.RequstModels.LoginRequest;

import com.screencastingexample.Models.RequstModels.BaseStudentData;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by akshayborgave on 04/06/17.
 */
@Root(name = "AuthenticateStudent", strict = false)
@Namespace(reference = "http://tempuri.org/")
public class LoginRequestData extends BaseStudentData {

    @Element(name = "UserName", required = false)
    private String mUserName;

    @Element(name = "Password", required = false)
    private String mPassword;


    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
    }
}
