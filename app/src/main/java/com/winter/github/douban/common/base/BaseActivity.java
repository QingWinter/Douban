package com.winter.github.douban.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.winter.github.douban.common.FragmentStackHelper;

/**
 * Created by Winter on 2016/5/30.
 * Description
 * email:huang.wqing@qq.com
 */
public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentStackHelper.onSaveInstance(savedInstanceState, getSupportFragmentManager());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        FragmentStackHelper.onRestoreInstanceState(savedInstanceState, getSupportFragmentManager());
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        BaseFragment lastFragment = FragmentStackHelper.getLastFragmentFromStack(fragmentManager);
        if (lastFragment != null) {
            if (!lastFragment.onBackPressed()) {
                super.onBackPressed();
            } else {
                lastFragment.onBackPressed();
            }
        }
    }
}
