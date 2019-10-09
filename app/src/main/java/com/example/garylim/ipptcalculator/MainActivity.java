package com.example.garylim.ipptcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity

{
    Button newtablebutton;
    ListView listTable;

    //myRecords - store an array of all the records from the SQLite
    // used to display onto the screen


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         newtablebutton = (Button)findViewById(R.id.newtablebutton);

         newtablebutton.setOnClickListener(new View.OnClickListener()
         {
             @Override
             public void onClick(View v)
             {
                 Intent i = new Intent(MainActivity.this,NewTable.class);
                 startActivity(i);
             }
         });

         Button btnSummarise = (Button)findViewById(R.id.btnSummarise);
         btnSummarise.setOnClickListener(new View.OnClickListener()
         {
             @Override
             public void onClick(View v) {

                 Intent i = new Intent(MainActivity.this, summarise.class);
                 startActivity(i);
             }
         });

    }

}
