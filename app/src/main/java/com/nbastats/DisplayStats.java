package com.nbastats;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

/*
 * Created by kevin_maussion on 31/03/2016.
 */
public class DisplayStats extends Activity {



    private DBHelper db;

    TextView match;
    TextView team1;
    TextView team2;
    TextView city;

    Bundle extras = getIntent().getExtras();

    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_display_stats);

        /*match = (TextView) findViewById(R.id.match_Tv);
        team1 = (TextView) findViewById(R.id.team1);
        team2 = (TextView) findViewById(R.id.team2);
        city = (TextView) findViewById(R.id.city);*/

        db = new DBHelper(this);


    }

}
