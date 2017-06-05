package com.screencastingexample.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by akshayborgave on 03/06/17.
 */

public abstract class BaseActivity extends AppCompatActivity {


    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        setUpUI();
    }


    public void showProgressBar(String message){

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage(message);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();

    }


    public void hideProgressBar(){

        if(mProgressDialog != null && mProgressDialog.isShowing()){

            mProgressDialog.dismiss();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mProgressDialog != null && mProgressDialog.isShowing()){

            mProgressDialog.dismiss();
        }
    }

    protected abstract void setUpUI();

    protected abstract int setLayoutId();
}
