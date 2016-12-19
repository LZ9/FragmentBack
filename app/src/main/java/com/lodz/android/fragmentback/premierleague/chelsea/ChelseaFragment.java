package com.lodz.android.fragmentback.premierleague.chelsea;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.lodz.android.fragmentback.R;
import com.lodz.android.fragmentback.base.BaseFragment;
import com.lodz.android.fragmentback.premierleague.arsenal.AlexisSanchezFragment;
import com.lodz.android.fragmentback.premierleague.arsenal.CechFragment;
import com.lodz.android.fragmentback.premierleague.arsenal.WengerFragment;

/**
 * 切尔西
 * Created by zhouL on 2016/12/18.
 */

public class ChelseaFragment extends BaseFragment {
    private String[] mTabName = {"孔蒂", "阿扎尔", "特里"};

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
                    return new ConteFragment();
                case 1:
                    return new HazardFragment();
                case 2:
                    return new TerryFragment();
                default:
                    return new ConteFragment();
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
