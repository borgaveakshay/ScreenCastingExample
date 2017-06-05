package com.screencastingexample.Models.ResponseModels.LoginResponse;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/**
 * Created by akshayborgave on 03/06/17.
 */
@Root(name = "soap : Envelope")
@NamespaceList({
        @Namespace( prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
        @Namespace( prefix = "xsd", reference = "http://www.w3.org/2001/XMLSchema"),
        @Namespace( prefix = "soap", reference = "http://www.w3.org/2003/05/soap-envelope")
})
public class LoginResponseEnvelope {

    //public static final String ROOT_NAME = "n0:loginResponse";


//    @Element(name = "soap:Body", required = false)
//
//    private String loginReult;
//
//    public String getLoginReult() {
//        return loginReult;
//    }
//
//    public void setLoginReult(String loginReult) {
//        this.loginReult = loginReult;
//    }


    @Element(name = "soap : Body", required = false)
    private LoginResponseBody mLoginResponseBody;

    public LoginResponseBody getLoginResponseBody() {
        return mLoginResponseBody;
    }

    public void setLoginResponseBody(LoginResponseBody mLoginResponseBody) {
        this.mLoginResponseBody = mLoginResponseBody;
    }



}
