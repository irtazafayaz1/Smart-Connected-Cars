package com.example.wasalahore.RainGauges;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class RainPagerAdapterClass extends FragmentPagerAdapter {

    private int noOfTabs;
    private Fragment fragment;

    public RainPagerAdapterClass(@NonNull FragmentManager fm, int i) {

        super(fm);
        noOfTabs = i;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new DashboardRainFragment();
            case 1:
                return new GraphRainFragment();

            default:
                return new DashboardRainFragment();
        }
    }

    @Override
    public int getCount() {
        return noOfTabs;
    }

}

