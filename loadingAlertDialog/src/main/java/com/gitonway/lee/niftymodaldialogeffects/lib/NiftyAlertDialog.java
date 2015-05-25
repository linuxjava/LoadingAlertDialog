package com.gitonway.lee.niftymodaldialogeffects.lib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.gitonway.lee.niftymodaldialogeffects.lib.effects.BaseEffects;
import com.gitonway.lee.niftymodaldialogeffects.lib.util.ColorUtils;


/*
 * Copyright 2014 litao
 * https://github.com/sd6352051/NiftyDialogEffects
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class NiftyAlertDialog extends Dialog implements DialogInterface{
    private Effectstype type = null;
    //整个dialog，包括透明部分
    private LinearLayout mLinearLayoutView;
    //dialog可见部分
    private RelativeLayout mRelativeLayoutView;
    private LinearLayout mLinearLayoutMsgView;
    private LinearLayout mLinearLayoutTopView;
    private FrameLayout mFrameLayoutCustomView;
    private View mDialogView, mCustomView, mTopTitleDivider, mBottomHorDivider, mBottomVerDivider;
    private TextView mTitle;
    private TextView mMessage;
    private ImageView mIcon;
    //取消
    private Button mButton1;
    //确定
    private Button mButton2;
    private int mDuration = -1;
    private boolean isCancelable = true;

    public View getCustomView() {
        return mCustomView;
    }

    public NiftyAlertDialog(Context context) {
        super(context, R.style.dialog_untran);
        init(context);
    }

    public NiftyAlertDialog(Context context, int theme) {
        super(context, theme);
        init(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes((WindowManager.LayoutParams) params);
    }

    private void init(Context context) {
        mDialogView = View.inflate(context, R.layout.alert_dialog_layout, null);

        mLinearLayoutView = (LinearLayout) mDialogView.findViewById(R.id.parentPanel);
        mRelativeLayoutView = (RelativeLayout) mDialogView.findViewById(R.id.main);
        mLinearLayoutTopView = (LinearLayout) mDialogView.findViewById(R.id.topPanel);
        mLinearLayoutMsgView = (LinearLayout) mDialogView.findViewById(R.id.contentPanel);
        mFrameLayoutCustomView = (FrameLayout) mDialogView.findViewById(R.id.customPanel);

        mBottomHorDivider = mDialogView.findViewById(R.id.bottom_hor_divider);
        mBottomVerDivider = mDialogView.findViewById(R.id.bottom_ver_divider);
        mTitle = (TextView) mDialogView.findViewById(R.id.alertTitle);
        mMessage = (TextView) mDialogView.findViewById(R.id.message);
        mIcon = (ImageView) mDialogView.findViewById(R.id.icon);
        mTopTitleDivider = mDialogView.findViewById(R.id.titleDivider);
        mButton1 = (Button) mDialogView.findViewById(R.id.button1);
        mButton2 = (Button) mDialogView.findViewById(R.id.button2);

        setContentView(mDialogView);

        this.setOnShowListener(new OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                mLinearLayoutView.setVisibility(View.VISIBLE);
                if (type == null) {
                    type = Effectstype.Slidetop;
                }
                start(type);
            }
        });

        mRelativeLayoutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isCancelable) dismiss();
            }
        });
    }

    public NiftyAlertDialog withDividerColor(String colorString) {
        mTopTitleDivider.setBackgroundColor(Color.parseColor(colorString));
        mBottomVerDivider.setBackgroundColor(Color.parseColor(colorString));
        mBottomHorDivider.setBackgroundColor(Color.parseColor(colorString));
        return this;
    }

    public NiftyAlertDialog withDividerColor(int color) {
        mTopTitleDivider.setBackgroundColor(color);
        mBottomVerDivider.setBackgroundColor(color);
        mBottomHorDivider.setBackgroundColor(color);
        return this;
    }

    public NiftyAlertDialog setDividerVisibility(int visibility){
        mTopTitleDivider.setVisibility(visibility);
        return this;
    }

    public NiftyAlertDialog withIcon(int drawableResId) {
        mIcon.setImageResource(drawableResId);
        return this;
    }

    public NiftyAlertDialog withIcon(Drawable icon) {
        mIcon.setImageDrawable(icon);
        return this;
    }

    public NiftyAlertDialog withTitle(CharSequence title) {
        toggleView(mLinearLayoutTopView, title);
        mTitle.setText(title);
        return this;
    }

    public NiftyAlertDialog withTitleColor(String colorString) {
        mTitle.setTextColor(Color.parseColor(colorString));
        return this;
    }

    public NiftyAlertDialog withTitleColor(int color) {
        mTitle.setTextColor(color);
        return this;
    }

    public NiftyAlertDialog withMessage(int textResId) {
        toggleView(mLinearLayoutMsgView, textResId);
        mMessage.setText(textResId);
        return this;
    }

    public NiftyAlertDialog withMessage(CharSequence msg) {
        toggleView(mLinearLayoutMsgView, msg);
        mMessage.setText(msg);
        return this;
    }

    public NiftyAlertDialog withMessageColor(String colorString) {
        mMessage.setTextColor(Color.parseColor(colorString));
        return this;
    }

    public NiftyAlertDialog withMessageColor(int color) {
        mMessage.setTextColor(color);
        return this;
    }

    public NiftyAlertDialog withDialogColor(String colorString) {
        mLinearLayoutView.getBackground().setColorFilter(ColorUtils.getColorFilter(Color.parseColor(colorString)));
        return this;
    }

    public NiftyAlertDialog withDialogColor(int color) {
        mLinearLayoutView.getBackground().setColorFilter(ColorUtils.getColorFilter(color));
        return this;
    }


    public NiftyAlertDialog withDuration(int duration) {
        this.mDuration = duration;
        return this;
    }

    public NiftyAlertDialog withEffect(Effectstype type) {
        this.type = type;
        return this;
    }

    public NiftyAlertDialog withButtonDrawable(int resid) {
        mButton1.setBackgroundResource(resid);
        mButton2.setBackgroundResource(resid);
        return this;
    }

    public NiftyAlertDialog withSingleButtonText(CharSequence text) {
        mBottomHorDivider.setVisibility(View.VISIBLE);
        mBottomVerDivider.setVisibility(View.GONE);
        mButton1.setVisibility(View.VISIBLE);
        mButton1.setText(text);
        mButton1.setBackgroundResource(R.drawable.single_btn_selector);

        return this;
    }

    public NiftyAlertDialog withMultiButtonText(CharSequence text1, CharSequence text2) {
        mBottomHorDivider.setVisibility(View.VISIBLE);
        mBottomVerDivider.setVisibility(View.VISIBLE);
        mButton1.setVisibility(View.VISIBLE);
        mButton1.setText(text1);
        mButton2.setVisibility(View.VISIBLE);
        mButton2.setText(text2);

        return this;
    }

    public NiftyAlertDialog setButton1Click(View.OnClickListener click) {
        mButton1.setOnClickListener(click);
        return this;
    }

    public NiftyAlertDialog setButton2Click(View.OnClickListener click) {
        mButton2.setOnClickListener(click);
        return this;
    }


    public NiftyAlertDialog setCustomView(Context context, int resId) {
        if (mFrameLayoutCustomView.getChildCount() > 0) {
            mFrameLayoutCustomView.removeAllViews();
        }

        mCustomView = LayoutInflater.from(context).inflate(resId, mFrameLayoutCustomView, true);

        return this;
    }

    public NiftyAlertDialog setCustomView(View view) {
        if (mFrameLayoutCustomView.getChildCount() > 0)
        {
            mFrameLayoutCustomView.removeAllViews();
        }

        mCustomView = view;
        mFrameLayoutCustomView.addView(view);

        return this;
    }

    public NiftyAlertDialog isCancelableOnTouchOutside(boolean cancelable) {
        this.isCancelable = cancelable;
        this.setCanceledOnTouchOutside(cancelable);
        return this;
    }

    public NiftyAlertDialog isCancelable(boolean cancelable) {
        this.isCancelable = cancelable;
        this.setCancelable(cancelable);
        return this;
    }

    private void toggleView(View view, Object obj) {
        if (obj == null) {
            view.setVisibility(View.GONE);
        } else {
            view.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void show() {
        super.show();
    }

    private void start(Effectstype type) {
        BaseEffects animator = type.getAnimator();
        if (mDuration != -1) {
            animator.setDuration(Math.abs(mDuration));
        }
        animator.start(mRelativeLayoutView);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        mButton1.setVisibility(View.GONE);
        mButton2.setVisibility(View.GONE);
    }
}
