package com.example.dc.ileave;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.dc.ileave.objects.Leave;

public class LeaveDetails extends AppCompatActivity {

    private TextView nameDetails,
                     dateDetails,
                     timeDetails,
                     reasonDetails;

    private Button btnApprove,
                   btnReject;

    private Leave leaveDetails = new Leave();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_leave_details);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nameDetails = (TextView) findViewById(R.id.txt_leave_details_name);
        dateDetails = (TextView) findViewById(R.id.txt_leave_details_date);
        timeDetails = (TextView) findViewById(R.id.txt_leave_details_time);
        reasonDetails = (TextView) findViewById(R.id.txt_leave_details_reason);

        btnApprove = (Button) findViewById(R.id.btn_approve);
        btnReject = (Button) findViewById(R.id.btn_reject);

        Intent intent = getIntent();
        leaveDetails = (Leave) intent.getSerializableExtra("leaveDetails");

        nameDetails.setText(leaveDetails.getUsername());
        dateDetails.setText(leaveDetails.getStart_date());
        timeDetails.setText(leaveDetails.getDuration());
        reasonDetails.setText(leaveDetails.getKind_of_leave());


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
