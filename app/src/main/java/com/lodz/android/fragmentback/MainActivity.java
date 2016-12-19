package com.lodz.android.fragmentback;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.lodz.android.fragmentback.base.BaseActivity;
import com.lodz.android.fragmentback.bundesliga.BundesligaFragment;
import com.lodz.android.fragmentback.laliga.LaLigaFragment;
import com.lodz.android.fragmentback.premierleague.PremierLeagueFragment;

public class MainActivity extends BaseActivity {

    private String[] mTabName = {"英超", "西甲", "德甲"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);

        viewPager.setOffscreenPageLimit(mTabName.length);
        viewPager.setAdapter(new MainAdapter(getSupportFragmentManager()));
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
                    return new PremierLeagueFragment();
                case 1:
                    return new LaLigaFragment();
                case 2:
                    return new BundesligaFragment();
                default:
                    return new PremierLeagueFragment();
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
