package in.nitjsr.ojass.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import in.nitjsr.ojass.Fragments.EventsFragment;
import in.nitjsr.ojass.Fragments.HomeFragment;
import in.nitjsr.ojass.Fragments.ItinaryFragment;
import in.nitjsr.ojass.Fragments.ProfileFragment;

/**
 * Created by Abhishek on 28-Jan-18.
 */

public class MainActivityAdapter extends FragmentStatePagerAdapter {

    public MainActivityAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new HomeFragment();
            case 1: return new EventsFragment();
            case 2: return new ItinaryFragment();
            case 3: return new ProfileFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
