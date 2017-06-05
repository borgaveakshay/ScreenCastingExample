package com.screencastingexample.utils;

import android.app.Application;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by akshayborgave on 03/06/17.
 */

public class AppContext extends Application {


    private static Retrofit mRetrofit;

    private static String BASE_URL;

    private static String mSplashGainToken;

    public static String getSplashGainToken() {
        return mSplashGainToken;
    }

    public static void setSplashGainToken(String mSplashGainToken) {
        AppContext.mSplashGainToken = mSplashGainToken;
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static void setBaseUrl(String baseUrl) {
        BASE_URL = baseUrl;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        setBaseUrl("http://mgu.eklavvya.in/");
        setSplashGainToken("ahgdjas68237298]gvEQCAHA23");

    }




    public static Retrofit getRetrofitInstance(){

        if(mRetrofit == null){

            Strategy strategy = new AnnotationStrategy();
            Serializer serializer = new Persister(strategy);

           mRetrofit =  new Retrofit.Builder()
                    .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
                    .baseUrl(getBaseUrl())
                    .client(getOkHttpClient())
                    .build();
        }

        return mRetrofit;
    }

    private static OkHttpClient getOkHttpClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .build();

        return okHttpClient;
    }
}
