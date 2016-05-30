package com.winter.github.douban.main.view.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.winter.github.douban.R;
import com.winter.github.douban.common.base.BaseActivity;
import com.winter.github.douban.databinding.MainBinding;

public class MainActivity extends BaseActivity {
    private MainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }
}
