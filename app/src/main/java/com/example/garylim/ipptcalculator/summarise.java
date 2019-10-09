package com.example.garylim.ipptcalculator;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class summarise extends AppCompatActivity {

    ListView lstTable;
    ArrayList<ListTable> myRecords = new ArrayList<>();
    NewTable.RecordAdapter myRecordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summarise);

        lstTable = findViewById(R.id.lstTable);

        loadData();

        myRecordAdapter = new NewTable.RecordAdapter(this, myRecords);
        lstTable.setAdapter(myRecordAdapter);


    }

    public void loadData() {
        myRecords.clear();

        DbHelper db = new DbHelper(this);
        Cursor cursor = db.getAllData();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String date = cursor.getString(1);
            String name = cursor.getString(2);
            int score = cursor.getInt(3);

            ListTable listTable = new ListTable(id, date, name, score);

            myRecords.add(listTable);
        }

        if (myRecordAdapter != null) {
            myRecordAdapter.notifyDataSetChanged();
        }

    }
}
