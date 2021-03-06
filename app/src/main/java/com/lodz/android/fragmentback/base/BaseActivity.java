package com.lodz.android.fragmentback.base;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

/**
 * Activity基类
 * Created by zhouL on 2016/12/18.
 */
public class BaseActivity extends AppCompatActivity{

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager() != null){
            List<Fragment> list = getSupportFragmentManager().getFragments();// 获取activity下的fragment
            if (list != null && list.size() > 0){
                for (Fragment fragment : list) {
                    if (isFragmentConsumeBackPressed(fragment)){
                        return;
                    }
                }
            }
        }
        if (!onPressBack()){
            super.onBackPressed();
        }
    }

    /**
     * 该fragment是否消耗了返回按钮事件
     * @param fragment fragment
     */
    private boolean isFragmentConsumeBackPressed(Fragment fragment){
        if (fragment == null){
            return false;
        }

        // fragment底下还有子fragment
        if (fragment.getChildFragmentManager() != null && fragment.getChildFragmentManager().getFragments() != null
                && fragment.getChildFragmentManager().getFragments().size() > 0){
            List<Fragment> list = fragment.getChildFragmentManager().getFragments();
            for (Fragment f : list) {
                if (isFragmentConsumeBackPressed(f)){
                    return true;
                }
            }
        }

        // fragment底下没有子fragment或子fragment没有消费事件 则判断自己
        if (fragment.getUserVisibleHint() && fragment.isVisible() && fragment instanceof IFragmentBackPressed){
            if (fragment.getParentFragment() != null){
                // 如果子fragment的父fragment没有显示，则不询问该fragment的返回事件（避免受预先初始化却没有展示到前端的fragment的影响）
                if (!fragment.getParentFragment().getUserVisibleHint()){
                    return false;
                }
            }
            IFragmentBackPressed itf = (IFragmentBackPressed) fragment;
            return itf.onPressBack();// fragment是否消耗返回按钮事件
        }
        return false;
    }

    /** 用户点击返回按钮 */
    protected boolean onPressBack(){
        return false;
    }

}
