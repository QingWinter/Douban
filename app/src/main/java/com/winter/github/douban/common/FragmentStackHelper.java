package com.winter.github.douban.common;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;

import com.winter.github.douban.common.base.BaseFragment;

import java.util.List;

/**
 * Created by Winter on 2016/6/2.
 * Description
 * email:huang.wqing@qq.com
 */
public class FragmentStackHelper {
    private static final String TAG_KEY = "tagKey";

    public static void onSaveInstance(Bundle savedInstanceState, FragmentManager fragmentManager) {
        Fragment topFragment = getLastFragmentFromStack(fragmentManager);
        String tag = topFragment.getTag();
        savedInstanceState.putString(TAG_KEY, tag);
    }

    public static void onRestoreInstanceState(Bundle savedInstanceState, FragmentManager fragmentManager) {
        if (null != savedInstanceState) {
            String tag = savedInstanceState.getString(TAG_KEY);
            if (!TextUtils.isEmpty(tag)) {
                Fragment topFragment = fragmentManager.findFragmentByTag(tag);
                List<Fragment> fragments = fragmentManager.getFragments();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                if (null != fragments && fragments.size() > 0 ){
                    for (Fragment fragment : fragments) {
                        if (fragment == topFragment) {
                            transaction.show(fragment);
                        } else {
                            transaction.hide(fragment);
                        }
                    }
                }
                transaction.commitAllowingStateLoss();
            }
        }
    }

    /**
     * 得到回退栈中最后一个fragment
     *
     * @return
     */
    public static BaseFragment getLastFragmentFromStack(FragmentManager fragmentManager) {
        BaseFragment fragment = null;
        List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments != null && !fragments.isEmpty()) {
            int size = fragments.size();

            for (int i = size - 1; i >= 0; i--) {
                fragment = (BaseFragment) fragments.get(i);
                if (fragment != null) {
                    break;
                }
            }

        }
        return fragment;
    }

    /**
     * 得到一个Activity栈中所有的Fragment
     *
     * @return
     */
    public int getFragmentCount(FragmentManager fragmentManager) {
        List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments != null) {
            return fragments.size();
        } else {
            return 0;
        }
    }
}
