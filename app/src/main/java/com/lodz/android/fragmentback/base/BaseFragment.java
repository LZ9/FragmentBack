package com.lodz.android.fragmentback.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * fragment基类
 * Created by zhouL on 2016/12/18.
 */
public abstract class BaseFragment extends Fragment implements IFragmentBackPressed{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    @LayoutRes
    protected abstract int getLayoutId();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews(view, savedInstanceState);
    }

    protected abstract void findViews(View view, Bundle savedInstanceState);

    @Override
    public boolean onPressBack() {
        return false;
    }
}
