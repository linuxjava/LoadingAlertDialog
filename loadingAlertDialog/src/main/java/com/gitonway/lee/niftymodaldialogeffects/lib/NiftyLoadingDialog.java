package com.gitonway.lee.niftymodaldialogeffects.lib;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.pnikosis.materialishprogress.ProgressWheel;

/**
 * Created by guochang on 2015/5/24.
 */
public class NiftyLoadingDialog extends Dialog{
    private static final int DEFAULT_RIM_COLOR = Color.WHITE;
    private static final int DEFAULT_BAR_COLOR = 0XFF5588FF;
    private static final int RIM_LTGRAY = Color.LTGRAY;
    private static final int BAR_WHITE = Color.WHITE;
    private TextView mMsgTv;
    private ProgressBar mProgressBar;
    private ProgressWheel mMaterialProgress;

    public NiftyLoadingDialog(Context context) {
        super(context, R.style.dialog_untran);
        init();
    }

    public NiftyLoadingDialog(Context context, int theme) {
        super(context, theme);
        init();
    }


    private void init(){
        setContentView(R.layout.loading_dialog_layout);

        mMsgTv = (TextView) findViewById(R.id.msg_tv);
        mMaterialProgress = (ProgressWheel) findViewById(R.id.progressWheel);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mMaterialProgress.setRimColor(DEFAULT_RIM_COLOR);
        mMaterialProgress.setBarColor(DEFAULT_BAR_COLOR);
    }

    public NiftyLoadingDialog setMsg(String msg){
        if(TextUtils.isEmpty(msg)){
            mMsgTv.setVisibility(View.GONE);
        }else {
            mMsgTv.setVisibility(View.VISIBLE);
            mMsgTv.setText(msg);
        }

        return this;
    }

    public NiftyLoadingDialog setRimColor(int resId){
        mMaterialProgress.setRimColor(resId);
        return this;
    }

    public NiftyLoadingDialog setRimWidth(int rimWidth){
        mMaterialProgress.setRimWidth(rimWidth);
        return this;
    }

    public NiftyLoadingDialog setBarColor(int resId){
        mMaterialProgress.setBarColor(resId);
        return this;
    }

    public NiftyLoadingDialog setBarWidth(int barWidth){
        mMaterialProgress.setBarWidth(barWidth);
        return this;
    }

    public NiftyLoadingDialog isMaterial(boolean material) {
        if(material){
            mProgressBar.setVisibility(View.INVISIBLE);
            mMaterialProgress.setVisibility(View.VISIBLE);
        }else {
            mProgressBar.setVisibility(View.VISIBLE);
            mMaterialProgress.setVisibility(View.INVISIBLE);
        }
        return this;
    }

    public NiftyLoadingDialog isCancelable(boolean cancelable) {
        setCancelable(cancelable);
        return this;
    }

    public NiftyLoadingDialog isCancelableOnTouchOutside(boolean cancelable) {
        this.setCanceledOnTouchOutside(cancelable);
        return this;
    }
}
