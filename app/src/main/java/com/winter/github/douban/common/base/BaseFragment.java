package com.winter.github.douban.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.winter.github.douban.R;
import com.winter.github.douban.common.FragmentStackHelper;
import com.winter.github.douban.common.SharedElement;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/**
 * Created by Winter on 2016/6/1.
 * Description
 * email:huang.wqing@qq.com
 */
public abstract class BaseFragment extends Fragment {
    public static final int RESULT_OK = 0x1;
    public static final int RESULT_CANCEL = 0x2;
    private BaseActivity mContainerActivity;
    private int mRequestCode;
    private int mResultCode;
    private Bundle mResultData;


    /**
     * Define the int value for resultCode {@link #onFragmentResult(int, int, Bundle)}
     */
    @IntDef({RESULT_OK, RESULT_CANCEL})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResultCode {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContainerActivity = (BaseActivity) context;
    }

    @Nullable
    public BaseActivity getContainerActivity() {
        return mContainerActivity;
    }

    protected abstract int getContentView();

    protected abstract void initView(View view, Bundle saveInstanceState);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getContentView(), container, false);
        initView(view, savedInstanceState);
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContainerActivity = null;
    }

    /**
     * When user trigger Activity onBackPressed(), this method will be triggered too.
     *
     * @return true if the fragment stack only have one fragment, must invoke {@link BaseActivity#onBackPressed()}
     */
    public boolean onBackPressed() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 1) {
            BaseFragment lastFragment = FragmentStackHelper.getLastFragmentFromStack(fragmentManager);
            if (lastFragment != null) {
//                lastFragment.onBackPressed();
                getFragmentManager().popBackStackImmediate();
                BaseFragment lastFragment2 = FragmentStackHelper.getLastFragmentFromStack(getFragmentManager());
                if (null != lastFragment2 && null != mResultData) {
                    lastFragment2.onFragmentResult(mRequestCode, mResultCode, mResultData);
                }
                return true;
            }
        }
        return false;
    }


    public abstract void onFragmentResume();

    public abstract void onFragmentStop();

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

    }

    public void startFragmentForResult(int requestCode, Bundle bundle) {
        this.mRequestCode = requestCode;

    }

    public void onFragmentResult(int requestCode, int resultCode, Bundle data) {

    }

    public final void setResult(@ResultCode int resultCode, Bundle data) {
        synchronized (this) {
            mResultCode = resultCode;
            mResultData = data;
        }
    }

    /**
     * @param to
     */
    public void startFragment(BaseFragment to) {
        startFragment(to, null);
    }

    /**
     * @param to
     * @param arguments
     */
    public void startFragment(BaseFragment to, Bundle arguments) {
        startFragment(to, true, arguments, null);
    }


    public void startFragment(BaseFragment to, ) {

    }

    public void startFragment(BaseFragment to, Bundle arguments, boolean isBackStack) {
        startFragment(to, isBackStack, arguments, null);

    }



    /**
     * @param to
     * @param isBackStack
     * @param arguments
     */
    public void startFragment(BaseFragment to, boolean isBackStack,
                              Bundle arguments, ) {
        if (to != null) {
            FragmentTransaction trans = getFragmentManager().beginTransaction();

            // 过渡动画
            if (null != sharedElement) {
                trans.addSharedElement(sharedElement.getView(), sharedElement.getName());
            }
            // 添加
            trans.add(R.id.container, to);
            if (isBackStack) {
                trans.addToBackStack(null);
            }

            if (arguments == null) {
                to.setArguments(new Bundle());
            } else {
                to.setArguments(arguments);
            }

            if (to.isHidden()) {
                trans.show(to);
            }

            to.onFragmentResume();
            trans.commitAllowingStateLoss();

        }
    }


    /**
     * 返回上一个Fragment
     */
    public void backFragment() {
        onBackPressed();
    }

    /**
     * 返回到下标为index的Fragment
     *
     * @param index
     */
    public void backFragment(int index) {
        backFragment(index, null);
    }

    /**
     * 将bundle数据带入返回到下标为index的Fragment
     *
     * @param index
     */
    public void backFragment(int index, Bundle bundle) {

        List<Fragment> fragments = getFragmentManager().getFragments();
        if (fragments != null && !fragments.isEmpty()) {
            if (index >= 0 && index < fragments.size()) {
                getFragmentManager().popBackStackImmediate(index, 0);
            }
            BaseFragment lastFragment = FragmentStackHelper.getLastFragmentFromStack(getFragmentManager());
            if (lastFragment != null) {

//                lastFragment.onActivityResult(lastFragment.requestCodeForFragment, lastFragment.resultCodeForFragment,
//                        mBackIntent);
            }
        }

    }

    /**
     * 跳转到当前fragment的前which个fragment
     *
     * @param which
     * @return
     */
    public BaseFragment getLastWhichFragmentFromStack(int which) {
        List<Fragment> fragments = getFragmentManager().getFragments();
        if (fragments != null && !fragments.isEmpty()) {
            int size = fragments.size();

            if (size > which) {
                return (BaseFragment) fragments.get(size - which - 1);
            } else {
                return (BaseFragment) fragments.get(0);
            }
        }
        return null;
    }

    /**
     * 返回到指定class对象的Fragment
     *
     * @param clazz
     */
    public void backFragmentByClass(Class<?> clazz) {
        backFragmentByClass(clazz, null);
    }


    /**
     * 返回到指定class对象的Fragment
     *
     * @param clazz
     */
    public void backFragmentByClass(Class<?> clazz, Bundle bundle) {

        if (clazz != null) {
            List<Fragment> fragments = getFragmentManager().getFragments();
            if (fragments != null && !fragments.isEmpty()) {
                String name1 = clazz.getName();
                int size = fragments.size();
                for (int i = size - 1; i >= 0; i--) {
                    BaseFragment fragment = (BaseFragment) fragments.get(i);
                    if (fragment != null) {

                        Class<?> c = fragment.getClass();
                        String name2 = c.getName();
                        if (!TextUtils.isEmpty(name1)
                                && !TextUtils.isEmpty(name2)) {
                            if (name1.equals(name2)) {
                                break;
                            } else {
                                getFragmentManager().beginTransaction().remove(fragment)
                                        .commit();
                                getFragmentManager().popBackStackImmediate();

                            }
                        }
                    }
                }
                BaseFragment lastFragment = FragmentStackHelper.getLastFragmentFromStack(getFragmentManager());
                if (lastFragment != null) {
                    mResultData = bundle;
                }
            }
        }
    }


}
