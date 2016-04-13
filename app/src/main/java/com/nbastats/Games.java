package com.nbastats;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin_maussion on 02/04/2016.
 */
public class Games extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
     public  DrawerLayout drawer;
    ListView listView;
    String[] match = new String[]{ "match1", "match2"};

    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_other);
        setSupportActionBar(toolbar);
         drawer = (DrawerLayout) findViewById(R.id.drawer_layout_games);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_games);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);

        listView = (ListView) findViewById(R.id.listView);
        List<Row> row = genererRow();
        final RowAdapter adapter = new RowAdapter(Games.this, row);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Row row1 = (Row) adapter.getItem(position);
                if(position==0){
                    Intent intent0 = new Intent(Games.this, DisplayStats.class);
                    Intent intent01 = new Intent(Games.this, DisplayStats.class);
                    String str0 = "Lakers VS Bulls";
                    intent0.putExtra("str", str0);
                    intent01.putExtra("gameId", 0);
                    Games.this.startActivity(intent0);
                }else if(position ==1 ){
                    Intent intent1 = new Intent(Games.this, DisplayStats.class);
                    Intent intent11 = new Intent(Games.this, DisplayStats.class);
                    String str1 = "Celtics VS Grizzlies";
                    intent1.putExtra("str", str1);
                    intent11.putExtra("gameId", 1);
                    Games.this.startActivity(intent1);
                }
            }
        });
    }

    private List<Row> genererRow(){
        Drawable matchA = getResources().getDrawable(R.drawable.lal);
        Drawable matchB = getResources().getDrawable(R.drawable.bos);

        List<Row> row = new ArrayList<Row>();
        row.add(new Row( matchA ,"Match A", "Lakers VS Bulls"));
        row.add(new Row( matchB, "Match B", "Celtics VS Grizzlies"));

        return row;
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_games);
        
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
