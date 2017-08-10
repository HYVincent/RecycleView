package com.example.recycleview.one;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * @name ShowHintTopAndButtomRecycleView
 * @class name：com.example.recycleview
 * @class describe
 * @anthor Vincent QQ:1032006226
 * @time 2017/8/10 10:10
 * @change
 * @chang time
 * @class describe
 */

public class FooterBehaviorDependAppBar extends CoordinatorLayout.Behavior<View> {


    public FooterBehaviorDependAppBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }


    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
//        float translationY = Math.abs(dependency.getTranslationY());
//        child.setTranslationY(translationY);
        float translationY = Math.abs(dependency.getTop());
        child.setTranslationY(translationY);
        return true;
    }
}
