package com.example.garylim.ipptcalculator;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.icu.text.AlphabeticIndex;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


class ListTable
{
    int id,score;
    String name,date;

    public ListTable(int id, String date, String name, int score)
    {
        this.id = id;
        this.score = score;
        this.name = name;
        this.date = date;
    }

}
public class NewTable extends AppCompatActivity
{
    public static String TAG = "MYDEV";

    EditText etName,etDate;
    Button btContinue;
    ListView lstTable;
    static ArrayList<ListTable> myRecords = new ArrayList<>();
    RecordAdapter myRecordAdapter;

    private Context context;
    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
    {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
        {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR,year);
            cal.set(Calendar.MONTH,month);
            cal.set(Calendar.DAY_OF_MONTH,dayOfMonth);
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MMM-dd,EEE");
            String str = f.format(cal.getTime());
        }
    };

    private View.OnClickListener DateListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            DialogFragment datePickerDialog = new DialogFragment();
            datePickerDialog.show(getSupportFragmentManager(),"date picker");


            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int mon = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog d = new DatePickerDialog(context,dateSetListener,year,mon,day);
            d.show();


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_table);

//        String namestored = etName.getText().toString();
//        String datestored = etDate.getText().toString();



        setupUi();



        Log.i(TAG, "onCreate: " + myRecords.size());
//        myRecordAdapter = new RecordAdapter(this, myRecords);
 //       lstTable.setAdapter(myRecordAdapter);

        //loadData();

    }

    public void setupUi()
    {
        context = NewTable.this;
        etName = (EditText)findViewById(R.id.etName);
        etDate = (EditText)findViewById(R.id.etDate);
        btContinue = (Button)findViewById(R.id.btContinue);

        btContinue.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(NewTable.this,Settings.class);
                startActivity(i);

//                loadData();

            }
        });

        etDate.setOnClickListener(DateListener);
    }




    public void addRecord(String date,String name,int score)
    {
        DbHelper db = new DbHelper(NewTable.this);
        db.insertData(date,name,score);
    }



    public double getTotal()
    {
        return 0;
    }





    // Change to static due to error on ViewHolder class
    static class RecordAdapter extends BaseAdapter
    {
        Context mContext;

        ArrayList<ListTable> listTables;
        LayoutInflater inflater;

        static class ViewHolder
        {
            TextView lblDate,lblName,lblScore;
        }

        public RecordAdapter(Context mContext, ArrayList<ListTable> listTables)
        {
            this.mContext = mContext;
            this.listTables = listTables;
            this.inflater = (LayoutInflater.from(mContext));
        }

        @Override
        public int getCount()
        {
            return listTables.size();
        }

        @Override
        public Object getItem(int position)
        {
            return listTables.get(position);
        }

        @Override
        public long getItemId(int position)
        {
            return listTables.get(position).id;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            final ListTable model = (ListTable) getItem(position);
            final ViewHolder viewHolder;
            final View rowView;

            if(convertView == null)
            {
                viewHolder = new ViewHolder();
                convertView = inflater.inflate(R.layout.listtable,parent,false);
                viewHolder.lblDate = convertView.findViewById(R.id.lblDate);
                viewHolder.lblName = convertView.findViewById(R.id.lblName);
                viewHolder.lblScore = convertView.findViewById(R.id.lblScore);

                rowView = convertView;
                convertView.setTag(viewHolder);
            }
            else
            {
                viewHolder = (ViewHolder) convertView.getTag();
                rowView = convertView;
            }

            if (model != null)
            {
                viewHolder.lblDate.setText(model.date);
                viewHolder.lblName.setText(model.name);
                viewHolder.lblScore.setText( String.valueOf(model.score));
            }

            return rowView;
        }




    }
}
