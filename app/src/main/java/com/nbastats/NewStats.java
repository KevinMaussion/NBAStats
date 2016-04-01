package com.nbastats;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
 * Created by kevin_maussion on 01/04/2016.
 */
public class NewStats extends AppCompatActivity {

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

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_new_stats);


    }

    public void saveStats(View view){

        if(editMatch.getText().length() == 0 || editTeamA.getText().length() == 0 || editTeamB.getText().length() == 0 || editCity.getText().length()==0){
            Toast.makeText(NewStats.this, "Please fulfill all the field",Toast.LENGTH_SHORT).show();
        }



    }

    public void erase(View view){
        if(editMatch.getText().length() != 0 || editTeamA.getText().length() != 0 || editTeamB.getText().length() != 0 || editCity.getText().length()!=0){
            editMatch.setText(null);
            editTeamA.setText(null);
            editTeamB.setText(null);
            editCity.setText(null);
        }
    }
}
