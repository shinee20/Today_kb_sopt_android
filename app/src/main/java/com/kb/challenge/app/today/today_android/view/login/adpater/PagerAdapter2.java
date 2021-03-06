package com.kb.challenge.app.today.today_android.view.login.adpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.kb.challenge.app.today.today_android.view.login.PickTimeFragment;
import com.kb.challenge.app.today.today_android.view.login.SetTitleFragment;

public class PagerAdapter2 extends FragmentStatePagerAdapter {
    public PagerAdapter2(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PickTimeFragment();
            case 1:
                return new SetTitleFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }
}
