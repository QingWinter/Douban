package com.winter.github.douban.common;

import android.support.annotation.IntDef;
import android.transition.Transition;

import com.winter.github.douban.common.base.BaseFragment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Winter on 2016/6/3.
 * Description
 * email:huang.wqing@qq.com
 */
public class TransitionOptions {
    public static final int SHORT = 200;
    public static final int DEFAULT = 300;
    public static final int LONG = 500;

    private Transition enterTransition;
    private Transition exitTransition;
    private Transition reenterTransition;
    private Transition sharedElementEnterTransition;
    private int duration;
    private boolean allowReturnTransitionOverlap;
    private boolean allowEnterTransitionOverlap;


    @IntDef({SHORT, DEFAULT, LONG})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TransitionDuration {
    }

    public boolean isAllowEnterTransitionOverlap() {
        return allowEnterTransitionOverlap;
    }

    public void setAllowEnterTransitionOverlap(boolean allowEnterTransitionOverlap) {
        this.allowEnterTransitionOverlap = allowEnterTransitionOverlap;
    }

    public boolean isAllowReturnTransitionOverlap() {
        return allowReturnTransitionOverlap;
    }

    public void setAllowReturnTransitionOverlap(boolean allowReturnTransitionOverlap) {
        this.allowReturnTransitionOverlap = allowReturnTransitionOverlap;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(@TransitionDuration int duration) {
        this.duration = duration;
    }

    public Transition getEnterTransition() {
        return enterTransition;
    }

    public void setEnterTransition(Transition enterTransition) {
        this.enterTransition = enterTransition;
    }

    public Transition getExitTransition() {
        return exitTransition;
    }

    public void setExitTransition(Transition exitTransition) {
        this.exitTransition = exitTransition;
    }

    public Transition getReenterTransition() {
        return reenterTransition;
    }

    public void setReenterTransition(Transition reenterTransition) {
        this.reenterTransition = reenterTransition;
    }

    public Transition getSharedElementEnterTransition() {
        return sharedElementEnterTransition;
    }

    public void setSharedElementEnterTransition(Transition sharedElementEnterTransition) {
        this.sharedElementEnterTransition = sharedElementEnterTransition;
    }
}
