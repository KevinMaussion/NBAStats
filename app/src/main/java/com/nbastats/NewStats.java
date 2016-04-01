package com.nbastats;

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
import android.widget.Toast;

/*
 * Created by kevin_maussion on 01/04/2016.
 */
public class NewStats extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{



    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_new_stats);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    public void saveStats(View view){
        EditText editMatch = (EditText) findViewById(R.id.editMatch);
        EditText editTeamA = (EditText) findViewById(R.id.editTeamA);
        EditText editTeamB = (EditText) findViewById(R.id.editTeamB);
        EditText editCity = (EditText) findViewById(R.id.editCity);

        TextView textMatch = (TextView) findViewById(R.id.textMatch);
        TextView textTeamA = (TextView) findViewById(R.id.textTeamA);
        TextView textTeamB = (TextView) findViewById(R.id.textTeamB);
        TextView textCity = (TextView) findViewById(R.id.textCity);

        Button buttonSave = (Button) findViewById(R.id.buttonSave);
        Button buttonErase = (Button) findViewById(R.id.buttonErase);

        if(editMatch.getText().length() == 0 || editTeamA.getText().length() == 0 || editTeamB.getText().length() == 0 || editCity.getText().length()==0){
            Toast.makeText(NewStats.this, "Please fulfill all the field",Toast.LENGTH_SHORT).show();

        }



    }

    public void erase(View view){

        EditText editMatch = (EditText) findViewById(R.id.editMatch);
        EditText editTeamA = (EditText) findViewById(R.id.editTeamA);
        EditText editTeamB = (EditText) findViewById(R.id.editTeamB);
        EditText editCity = (EditText) findViewById(R.id.editCity);

        TextView textMatch = (TextView) findViewById(R.id.textMatch);
        TextView textTeamA = (TextView) findViewById(R.id.textTeamA);
        TextView textTeamB = (TextView) findViewById(R.id.textTeamB);
        TextView textCity = (TextView) findViewById(R.id.textCity);

        Button buttonSave = (Button) findViewById(R.id.buttonSave);
        Button buttonErase = (Button) findViewById(R.id.buttonErase);

        if(editMatch.getText().length() != 0 || editTeamA.getText().length() != 0 || editTeamB.getText().length() != 0 || editCity.getText().length()!=0){
            editMatch.setText(null);
            editTeamA.setText(null);
            editTeamB.setText(null);
            editCity.setText(null);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();
        Intent intentStats = new Intent(getApplicationContext(), NewStats.class);
        Intent intentMatch = new Intent (getApplicationContext(), Match.class);
        Intent intentTeam = new Intent(getApplicationContext(), Team.class);

        if (id == R.id.nav_stats) {
            // Handle the camera action
            startActivity(intentStats);

        } else if (id == R.id.nav_match) {
            startActivity(intentMatch);

        } else if (id == R.id.nav_team) {
            startActivity(intentTeam);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
