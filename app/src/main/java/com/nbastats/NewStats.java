package com.nbastats;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by kevin_maussion on 12/04/2016.
 */
public class NewStats extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DAOStats daoStats;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_stats);

        TextView tv = (TextView) findViewById(R.id.textMatch);
        tv.setText(getIntent().getStringExtra("str"));


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_other);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_new_stats);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_new_stats);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);

        daoStats = new DAOStats(getApplicationContext());

        Button b = (Button) findViewById(R.id.buttonSave);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText edit3Points = (EditText) findViewById(R.id.edit3Points);
                EditText edit2Points = (EditText) findViewById(R.id.edit2Points);
                EditText editDunks = (EditText) findViewById(R.id.editDunks);
                EditText editFautes = (EditText) findViewById(R.id.editFautes);

                int num3Points = Integer.parseInt(edit3Points.getText().toString());
                int num2Points = Integer.parseInt(edit2Points.getText().toString());
                int numDunks = Integer.parseInt(editDunks.getText().toString());
                int numFautes = Integer.parseInt(editFautes.getText().toString());

                DBStats dbs = new DBStats(num3Points, num2Points, numDunks, numFautes);

                daoStats.open();
                daoStats.ajouter(dbs);
                daoStats.close();
            }
        });
    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_new_stats);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();
        Intent intentStats = new Intent(getApplicationContext(), NewStatsList.class);
        Intent intentMatch = new Intent (getApplicationContext(), Games.class);
        Intent intentTeam = new Intent(getApplicationContext(), Teams.class);
        Intent intentHome = new Intent(getApplicationContext(), MainActivity.class);

        if(id == R.id.nav_home){
            finish();
            startActivity(intentHome);
        }
        else if (id == R.id.nav_stats) {
            finish();
            startActivity(intentStats);

        } else if (id == R.id.nav_match) {
            finish();
            startActivity(intentMatch);

        } else if (id == R.id.nav_team) {
            finish();
            startActivity(intentTeam);

        }


        return true;
    }

}
