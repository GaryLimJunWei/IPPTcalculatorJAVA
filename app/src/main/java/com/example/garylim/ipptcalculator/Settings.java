package com.example.garylim.ipptcalculator;

import android.content.Intent;
import android.net.sip.SipSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;

public class Settings extends AppCompatActivity
{




    Switch switch1,switch2;
    Button settingContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1
        ,getResources().getStringArray(R.array.age));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        settingContinue = (Button)findViewById(R.id.settingContinue);

        settingContinue.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(Settings.this,scorePage.class);
                startActivity(i);
            }
        });


        switch1 = (Switch)findViewById(R.id.switch1);

        switch2 = (Switch)findViewById(R.id.switch2);












    }
}
