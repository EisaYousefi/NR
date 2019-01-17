package com.broa.nestdapp.tablayout;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends FragmentPagerAdapter{
    private List<String> myPageTitle = new ArrayList <>();
    private List<Fragment> myFragmentList = new ArrayList <>();

    public Adapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int posation) {
        return myFragmentList.get(posation);
    }

    @Override
    public int getCount() {
        return myFragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return null;//myPageTitle.get(position);
    }

    public void addToList(Fragment fragment,String title){
        myFragmentList.add(fragment);
        myPageTitle.add(title);

    }


}
