package com.lodz.android.fragmentback.premierleague;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.lodz.android.fragmentback.R;
import com.lodz.android.fragmentback.base.BaseFragment;
import com.lodz.android.fragmentback.premierleague.arsenal.ArsenalFragment;
import com.lodz.android.fragmentback.premierleague.chelsea.ChelseaFragment;
import com.lodz.android.fragmentback.premierleague.liverpool.LiverpoolFragment;
import com.lodz.android.fragmentback.premierleague.manutd.ManchesterUnitedFragment;

/**
 * Created by zhouL on 2016/12/19.
 */

public class PremierLeagueFragment extends BaseFragment{
    private String[] mTabName = {"曼联", "利物浦", "切尔西", "阿森纳"};

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
                    return new ManchesterUnitedFragment();
                case 1:
                    return new LiverpoolFragment();
                case 2:
                    return new ChelseaFragment();
                case 3:
                    return new ArsenalFragment();
                default:
                    return new ManchesterUnitedFragment();
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
