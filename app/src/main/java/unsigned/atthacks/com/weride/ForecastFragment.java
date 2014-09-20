package unsigned.atthacks.com.weride;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.app.LoaderManager;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by Algernon on 9/19/14.
 */
public class ForecastFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        return rootView;
    }
}
