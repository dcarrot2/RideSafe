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
        switch (i) {
            case 0:
                return new ForecastFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 1;
    }
}
