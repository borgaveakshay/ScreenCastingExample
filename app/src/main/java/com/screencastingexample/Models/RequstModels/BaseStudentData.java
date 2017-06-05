package com.screencastingexample.Models.RequstModels;

import org.simpleframework.xml.Element;

/**
 * Created by akshayborgave on 04/06/17.
 */

public class BaseStudentData {

    @Element(name = "SplashgainToken")
    private String mSplashGainToken;

    public String getSplashGainToken() {
        return mSplashGainToken;
    }

    public void setSplashGainToken(String mSplashGainToken) {
        this.mSplashGainToken = mSplashGainToken;
    }
}
