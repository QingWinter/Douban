package com.winter.github.douban.common;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Transition;
import android.view.View;

import com.winter.github.douban.common.base.BaseFragment;

/**
 * Created by Winter on 2016/6/3.
 * Description
 * email:huang.wqing@qq.com
 */
public class FragmentOptions {

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static TransitionOptions getDefaultTransitionOptions() {
        TransitionOptions transitionOptions = new TransitionOptions();
        transitionOptions.setDuration(TransitionOptions.DEFAULT);
        transitionOptions.setEnterTransition(new Fade(Fade.IN));
        transitionOptions.setExitTransition(new Fade(Fade.OUT));
        transitionOptions.setReenterTransition(new Fade(Fade.OUT));
        transitionOptions.setSharedElementEnterTransition(new ChangeBounds());
        return transitionOptions;
    }


    public static void makeSceneTransitionAnimation(BaseFragment fragment, Pair<View, String>... shareElements) {
        makeSceneTransitionAnimation(fragment, getDefaultTransitionOptions(), shareElements);
    }

    public static void makeSceneTransitionAnimation(BaseFragment fragment, TransitionOptions options, Pair<View, String>... shareElements) {
        if (Build.VERSION.SDK_INT >= 21) {
            fragment.setAllowReturnTransitionOverlap(options.isAllowReturnTransitionOverlap());
            fragment.setAllowEnterTransitionOverlap(options.isAllowEnterTransitionOverlap());
            Transition exitTransition = options.getExitTransition();
            if (null != exitTransition) {
                exitTransition.setDuration(options.getDuration());
                fragment.setReturnTransition(exitTransition);
                fragment.setExitTransition(exitTransition);
            }
            Transition enterTransition = options.getEnterTransition();
            if (null != enterTransition) {
                enterTransition.setDuration(options.getDuration());
                fragment.setEnterTransition(enterTransition);
            }
            Transition shareElementTransition = options.getSharedElementEnterTransition();
            if (null != shareElementTransition) {
                shareElementTransition.setDuration(options.getDuration());
                fragment.setSharedElementEnterTransition(shareElementTransition);
            }
        }
    }
}
