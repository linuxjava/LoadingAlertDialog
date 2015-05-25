package com.gitonway.lee.niftymodaldialogeffects.lib.effects;

import android.view.View;

import com.nineoldandroids.animation.ObjectAnimator;

/**
 * Created by guochang on 2015/5/21.
 */
public class ModalIn extends BaseEffects{
    @Override
    protected void setupAnimation(View view) {

        ObjectAnimator animatorX1 = ObjectAnimator.ofFloat(view, "scaleX", 1.05f, 0.95f);
        animatorX1.setStartDelay(135);
        animatorX1.setDuration(105);
        ObjectAnimator animatorY1 = ObjectAnimator.ofFloat(view, "scaleY", 1.05f, 0.95f);
        animatorY1.setStartDelay(135);
        animatorY1.setDuration(105);

        ObjectAnimator animatorX2 = ObjectAnimator.ofFloat(view, "scaleX", 0.95f, 1.0f);
        animatorX2.setStartDelay(240);
        animatorX2.setDuration(60);
        ObjectAnimator animatorY2 = ObjectAnimator.ofFloat(view, "scaleY", 0.95f, 1.0f);
        animatorY2.setStartDelay(240);
        animatorY2.setDuration(60);

        getAnimatorSet().playTogether(ObjectAnimator.ofFloat(view, "alpha", 0.2f, 1.0f).setDuration(90),
                ObjectAnimator.ofFloat(view, "scaleX", 0.7f, 1.05f).setDuration(135),
                ObjectAnimator.ofFloat(view, "scaleY", 0.7f, 1.05f).setDuration(135),
                animatorX1, animatorY1, animatorX2, animatorY2);
    }
}
