package com.winter.github.douban.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;

import com.winter.github.douban.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/**
 * Created by Winter on 2016/6/1.
 * Description
 * email:huang.wqing@qq.com
 */
public class FragmentNavigationHelper {
    private FragmentManager mFragmentManager;
    private static final int STANDARD = 0x1;
    private static final int SINGLETOP = 0x2;
    private static final int SINGLETASK = 0x3;
    private static final int SINGLEINSTANCE = 0x4;
    private int mResultCode;
    private int mRequestCode;
    private Bundle mResultData;

    @IntDef({STANDARD, SINGLETOP, SINGLETASK, SINGLEINSTANCE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LaunchMode {
    }

    public FragmentNavigationHelper(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }












}
