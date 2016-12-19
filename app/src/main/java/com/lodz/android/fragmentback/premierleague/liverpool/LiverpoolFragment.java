package com.lodz.android.fragmentback.premierleague.liverpool;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import com.lodz.android.fragmentback.R;
import com.lodz.android.fragmentback.base.BaseFragment;

/**
 * 利物浦
 * Created by zhouL on 2016/12/18.
 */

public class LiverpoolFragment extends BaseFragment {
    private String[] mTabName = {"克洛普", "库蒂尼奥", "亨德森"};

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
                    return new KloppFragment();
                case 1:
                    return new CoutinhoFragment();
                case 2:
                    return new HendersonFragment();
                default:
                    return new KloppFragment();
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

    @Override
    public boolean onPressBack() {
        Toast.makeText(getContext(), "利物浦", Toast.LENGTH_SHORT).show();
        return true;
    }
}
