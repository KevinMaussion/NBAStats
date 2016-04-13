package com.nbastats;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

/*
 * Created by kevin_maussion on 31/03/2016.
 */
public class DisplayStats extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    private DAOStats daoStats;
    private Cursor daoCursor;

    private DrawerLayout drawer;
    private TextView match;
    private TextView _2points ;
    private TextView _3points ;
    private TextView dunks ;
    private TextView fautes;

    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_display_stats);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_other);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout_display_stats);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_display_stats);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);

        daoStats = new DAOStats(getApplicationContext());

        match = (TextView) findViewById(R.id.textMatchD);
        match.setText(getIntent().getStringExtra("str"));

        Cursor c = null;

         _2points = (TextView) findViewById(R.id.text2PointsD2);
         _3points = (TextView) findViewById(R.id.text3PointsD2);
         dunks = (TextView) findViewById(R.id.textDunksD2);
         fautes = (TextView) findViewById(R.id.textFautesD2);

       // try{
             daoStats.open();
            daoCursor = daoStats.selectionner((getIntent().getIntExtra("gameId", -1)));

            Toast.makeText(DisplayStats.this, getIntent().getIntExtra("gameId",-1)+"", Toast.LENGTH_SHORT).show();

            if(String.valueOf(daoCursor.getString(daoCursor.getColumnIndex(DBHelper.Stats_Column_3_POINTS )))!= "null"){
                _3points.setText(String.valueOf(daoCursor.getString(daoCursor.getColumnIndex(DBHelper.Stats_Column_3_POINTS))));
            }else{
                _3points.setText("NA");
            }

            if(String.valueOf(daoCursor.getString(daoCursor.getColumnIndex(DBHelper.Stats_Column_2_POINTS )))!= "null"){
                _2points.setText(String.valueOf(daoCursor.getString(daoCursor.getColumnIndex(DBHelper.Stats_Column_2_POINTS))));
            }else{
                _2points.setText("NA");
            }

            if(String.valueOf(daoCursor.getString(daoCursor.getColumnIndex(DBHelper.Stats_Column_DUNKS )))!= "null"){
                dunks.setText(String.valueOf(daoCursor.getString(daoCursor.getColumnIndex(DBHelper.Stats_Column_DUNKS))));
            }else{
                dunks.setText("NA");
            }

            if(String.valueOf(daoCursor.getString(daoCursor.getColumnIndex(DBHelper.Stats_Column_FAUTES )))!= "null"){
                fautes.setText(String.valueOf(daoCursor.getString(daoCursor.getColumnIndex(DBHelper.Stats_Column_FAUTES))));
            }else{
                fautes.setText("NA");
            }

        /*}catch (Exception e){
            Toast.makeText(DisplayStats.this, "Database Error"+getIntent().getIntExtra("gameId", -1), Toast.LENGTH_SHORT).show();
        }*/

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_display_stats);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

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

        drawer.closeDrawers();

        return true;
    }

}
