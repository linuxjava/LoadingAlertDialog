package com.example.guochang.niftydialogeffects;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyAlertDialog;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyLoadingDialog;


public class MainActivity extends Activity {
    private Effectstype effect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onLoadingDialog(View v){
        switch (v.getId()) {
            case R.id.normal_loading_btn:
                new NiftyLoadingDialog(this).setMsg("加载中").isCancelable(true).show();
                break;
            case R.id.material_loading_btn:
                new NiftyLoadingDialog(this).isMaterial(true).setMsg("加载中").isCancelable(true).show();
                break;

        }
    }

    public void dialogShow(View v) {
        switch (v.getId()) {
            case R.id.modalin:
                effect = Effectstype.ModalIn;
                break;
            case R.id.fadein:
                effect = Effectstype.Fadein;
                break;
            case R.id.slideright:
                effect = Effectstype.Slideright;
                break;
            case R.id.slideleft:
                effect = Effectstype.Slideleft;
                break;
            case R.id.slidetop:
                effect = Effectstype.Slidetop;
                break;
            case R.id.slideBottom:
                effect = Effectstype.SlideBottom;
                break;
            case R.id.newspager:
                effect = Effectstype.Newspager;
                break;
            case R.id.fall:
                effect = Effectstype.Fall;
                break;
            case R.id.sidefall:
                effect = Effectstype.Sidefill;
                break;
            case R.id.fliph:
                effect = Effectstype.Fliph;
                break;
            case R.id.flipv:
                effect = Effectstype.Flipv;
                break;
            case R.id.rotatebottom:
                effect = Effectstype.RotateBottom;
                break;
            case R.id.rotateleft:
                effect = Effectstype.RotateLeft;
                break;
            case R.id.slit:
                effect = Effectstype.Slit;
                break;
            case R.id.shake:
                effect = Effectstype.Shake;
                break;


        }

        final NiftyAlertDialog dialogBuilder = new NiftyAlertDialog(this);

        dialogBuilder
                .withTitle("测试")
                .withMessage("确定退出吗")
                .withIcon(getResources().getDrawable(R.drawable.ic_launcher))
                .isCancelable(false)
                .isCancelableOnTouchOutside(true)
                .withDuration(300)
                .withEffect(effect)
                .withMultiButtonText("取消", "确定")
                .setButton1Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogBuilder.dismiss();
                    }
                })
                .setButton2Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .show();
    }
}
