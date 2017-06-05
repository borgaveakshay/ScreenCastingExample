package com.screencastingexample.Models.ResponseModels.LoginResponse;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by akshayborgave on 04/06/17.
 */
@Root(name = "AuthenticateStudentResponse")
@Namespace(reference = "http://tempuri.org/")
public class LoginResponseData {

    @Element(name = "AuthenticateStudentResult")
    private String mStudentId;

    public String getStudentId() {
        return mStudentId;
    }

    public void setStudentId(String mStudentId) {
        this.mStudentId = mStudentId;
    }
}
