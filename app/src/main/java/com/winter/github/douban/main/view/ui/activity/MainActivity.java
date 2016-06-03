package com.winter.github.douban.main.view.ui.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;
import com.winter.github.douban.R;
import com.winter.github.douban.common.base.BaseActivity;
import com.winter.github.douban.common.base.BaseFragment;
import com.winter.github.douban.databinding.MainBinding;
import com.winter.github.douban.main.view.ui.fragment.MainFragment;

public class MainActivity extends BaseActivity {
    private MainBinding mBinding;
    private BaseFragment mCurrentFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void initView(Bundle savedInstanceState) {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        BottomBar bottomNavigation = BottomBar.attachShy(mBinding.coordinatorLayout, mBinding.getRoot(), savedInstanceState);
        bottomNavigation.setItemsFromMenu(R.menu.main_tab_menu, new MainMenuChangeListener());
        bottomNavigation.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorBottomNavigationBlueGrey));
        bottomNavigation.mapColorForTab(1, ContextCompat.getColor(this, R.color.colorBottomNavigationTeal));
        bottomNavigation.mapColorForTab(2, ContextCompat.getColor(this, R.color.colorBottomNavigationBrown));
        bottomNavigation.mapColorForTab(3, ContextCompat.getColor(this, R.color.colorBottomNavigationGrey));
    }

    class MainMenuChangeListener implements OnMenuTabClickListener {

        @Override
        public void onMenuTabSelected(@IdRes int menuItemId) {
            switch (menuItemId) {
                case R.id.bottomBarMovie:

                    break;
                case R.id.bottomBarMusic:

                    break;
                case R.id.bottomBarBook:

                    break;
                case R.id.bottomBarMine:

                    break;
            }
        }

        @Override
        public void onMenuTabReSelected(@IdRes int menuItemId) {
            if (mCurrentFragment instanceof MainFragment) {
                ((MainFragment)mCurrentFragment).scrollToTop();
            }
        }
    }
}
