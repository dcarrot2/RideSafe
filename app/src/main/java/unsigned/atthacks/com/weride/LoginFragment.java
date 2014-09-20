package unsigned.atthacks.com.weride;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.View;
import android.util.Log;

import com.facebook.*;
import com.facebook.Session;
import com.facebook.widget.LoginButton;

/**
 * Created by Algernon on 9/20/14.
 */
public class LoginFragment extends Fragment {

    private static final String TAG = "LoginFragment";
    private UiLifecycleHelper uiLifecycleHelper;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.login_fragment, container, false);
        LoginButton authButton = (LoginButton) rootView.findViewById(R.id.facebook_login_button);
        authButton.setFragment(this);



        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uiLifecycleHelper = new UiLifecycleHelper(getActivity(), callback);
        uiLifecycleHelper.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();


        Session session = Session.getActiveSession();
        if(session != null &&
                (session.isOpened()|| session.isClosed())){
            onSessionStateChange(session, session,null);
        }

        uiLifecycleHelper.onResume();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uiLifecycleHelper.onActivityResult(requestCode, resultCode, data);
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onPause() {
        super.onPause();
        uiLifecycleHelper.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        uiLifecycleHelper.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        uiLifecycleHelper.onSaveInstanceState(outState);
    }

    private void onSessionStateChange(Session session, Session state, Exception exception) {
        if(state.isOpened()) {
            Log.i(TAG, "Logged in..");

        } else if(state.isClosed()) {
            Log.i(TAG, "Logged out");
        }
    }

    private Session.StatusCallback callback = new Session.StatusCallback() {

        @Override
        public void call(Session session, SessionState state, Exception exception) {
            onSessionStateChange(session, session, exception);
        }
    };



}
