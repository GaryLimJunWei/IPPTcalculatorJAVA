package com.example.garylim.ipptcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class scorePage extends AppCompatActivity
{

    Button home,save;
    TextView scoreChange;
    EditText pushupvalue,situpvalue,runvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_page);

        pushupvalue = findViewById(R.id.pushupvalue);
        situpvalue = findViewById(R.id.situpvalue);
        runvalue = findViewById(R.id.runvalue);
        scoreChange = findViewById(R.id.scoreChange);

        home = (Button)findViewById(R.id.home);


        updateValue();
        setupUiEvent();

        home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(scorePage.this,MainActivity.class);
                startActivity(i);

            }
        });


        save = (Button)findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(scorePage.this, "Saved!", Toast.LENGTH_SHORT).show();
                DbHelper db = new DbHelper(scorePage.this);
                db.insertData("Hello","09022019",85);
            }
        });




    }

    public void setupUiEvent ()
    {
        //pushup

        pushupvalue.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                updateValue();
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });

        situpvalue.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                updateValue();
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });

        runvalue.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                updateValue();
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });

        final SeekBar seekbarpushup = findViewById(R.id.seekBarPushup);
        seekbarpushup.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                pushupvalue.setText(String.valueOf(seekbarpushup.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

        final SeekBar seekbarsitup = findViewById(R.id.seekBarSitup);
        seekbarsitup.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                situpvalue.setText(String.valueOf(seekbarsitup.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

        final SeekBar seekbarrun = findViewById(R.id.seekBarRun);
        seekbarrun.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                runvalue.setText(String.valueOf(seekbarrun.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

    }

    private void updateValue()
    {


            int pushup = Integer.parseInt( pushupvalue.getText().toString());
            int situp = Integer.parseInt( situpvalue.getText().toString());
            int run = Integer.parseInt( runvalue.getText().toString());



    }





}
