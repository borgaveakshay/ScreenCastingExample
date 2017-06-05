package com.screencastingexample.Models.RequstModels.LoginRequest;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by akshayborgave on 03/06/17.
 */
@Root(name = "soap12:Envelope")
@NamespaceList({
        @Namespace( prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
        @Namespace( prefix = "xsd", reference = "http://www.w3.org/2001/XMLSchema"),
        @Namespace( prefix = "soap12", reference = "http://www.w3.org/2003/05/soap-envelope")
})
public class LoginRequestEnvelope {

    @Element(name = "soap12:Body", required = false)
    private LoginRequestBody mLoginRequestBody;

    public LoginRequestBody getLoginRequestBody() {
        return mLoginRequestBody;
    }

    public void setLoginRequestBody(LoginRequestBody mLoginRequestBody) {
        this.mLoginRequestBody = mLoginRequestBody;
    }
}
