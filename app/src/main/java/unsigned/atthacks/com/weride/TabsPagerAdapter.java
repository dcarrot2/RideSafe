package unsigned.atthacks.com.weride;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * Created by Algernon on 9/20/14.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager m){
        super(m);
    }
    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        if(i == 0)
        {
            fragment = new ForecastFragment();
        }
        if(i == 1){
            fragment = new ChallengesFragment();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = new String();
        if(position == 0)
        {
            return "Track Route";
        }
        if(position == 1)
        {
            return "Recently Posted Challenges";
        }
        return null;
    }
}
