package unsigned.atthacks.com.weride;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.graphics.Typeface;
import android.widget.TextView;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.TextView;

import com.facebook.*;
import com.facebook.model.*;
import android.util.Log;

import org.w3c.dom.Text;


public class login extends Activity {

    private ImageButton login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Session.openActiveSession(this, true, new Session.StatusCallback() {
            @Override
            public void call(Session session, SessionState state, Exception exception) {

                if(session.isOpened()){

                    Request.newMeRequest(session, new Request.GraphUserCallback() {
                        @Override
                        public void onCompleted(GraphUser user, Response response) {
                            if(user != null){
                                Log.i("SUCESSS", "Success" + user.getName());
                            }
                        }
                    }).executeAsync();
                }

            }
        });

        // start Facebook login

        /*
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //callinf textView by id
        TextView titleTxt = (TextView) findViewById(R.id.ridr);

        // Loading Font Face
        Typeface riderTitle = Typeface.createFromAsset(getAssets(), "fonts/PlayfairDisplay-Black.otf");

        titleTxt.setTypeface(riderTitle);

        login = (ImageButton) findViewById(R.id.fbLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launch = new Intent(login.getContext(), MainActivity.class);
                startActivity(launch);

            }
        });
        */
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
