package com.lodz.android.fragmentback.bundesliga;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.lodz.android.fragmentback.R;
import com.lodz.android.fragmentback.base.BaseFragment;

/**
 * 德甲
 * Created by zhouL on 2016/12/19.
 */
public class BundesligaFragment extends BaseFragment{

    private String[] mTabName = {"拜仁", "多特蒙德"};

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tab_layout;
    }

    @Override
    protected void findViews(View view, Bundle savedInstanceState) {
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);

        viewPager.setOffscreenPageLimit(mTabName.length);
        viewPager.setAdapter(new MainAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }


    private class MainAdapter extends FragmentPagerAdapter {

        public MainAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new BayernMunichFragment();
                case 1:
                    return new DortmundFragment();
                default:
                    return new BayernMunichFragment();
            }
        }

        @Override
        public int getCount() {
            return mTabName.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabName[position];
        }
    }
}
