package com.example.dc.ileave;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileLeave extends AppCompatActivity {

    private DateFormat dateFormat;
    private DatePickerDialog startDatePicker,
                             endDatePicker;
    private TimePickerDialog startTimePicker,
                             endTimePicker;
    private EditText fileStartDate,
                     fileEndDate,
                     fileStartTime,
                     fileEndTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_leave);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_file_leave);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dateFormat = new SimpleDateFormat("yyyy-dd-MM");
        fileStartDate = (EditText) findViewById(R.id.file_start_date);
        fileEndDate = (EditText) findViewById(R.id.file_end_date);
        fileStartTime = (EditText) findViewById(R.id.file_start_time);
        fileEndTime = (EditText) findViewById(R.id.file_end_time);

        setDateField();
        setTimeField();

    }

    public void showTimePickerDialog() {
        fileStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog();
            }
        });
    }

    private void setTimeField(){
        Calendar time = Calendar.getInstance();
        int hour = time.get(Calendar.HOUR_OF_DAY);
        int minute = time.get(Calendar.MINUTE);
        fileStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTimePicker.show();

            }
        });

        fileEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endTimePicker.show();
            }
        });

        startTimePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                fileStartTime.setText(i + " : " + i1);
            }
        }, time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE), false);

        endTimePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                fileEndTime.setText(i + " : " + i1);
            }
        }, hour, minute, false);

    }

    private void setDateField() {
        fileStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDatePicker.show();
            }
        });

        fileEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endDatePicker.show();
            }
        });

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        startDatePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                Calendar date = Calendar.getInstance();
                date.set(year, month, day);
                fileStartDate.setText(dateFormat.format(date.getTime()));
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        endDatePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                Calendar date = Calendar.getInstance();
                date.set(year, month, day);
                fileEndDate.setText(dateFormat.format(date.getTime()));
            }
        }, year, month, day);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_leave_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
