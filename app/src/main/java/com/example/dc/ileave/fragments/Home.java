package com.example.dc.ileave.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.dc.ileave.BackgroundTask;
import com.example.dc.ileave.FileLeave;
import com.example.dc.ileave.LeaveDetails;
import com.example.dc.ileave.MainActivity;
import com.example.dc.ileave.R;
import com.example.dc.ileave.adapter.PendingLeavesAdapter;
import com.example.dc.ileave.objects.Leave;

import java.util.ArrayList;

/**
 * Created by DC on 24/04/2018.
 */

public class Home extends Fragment {

    private FloatingActionButton fabHome;

    private RecyclerView recyclerViewPending;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private BackgroundTask backgroundTask = new BackgroundTask(getContext());

    private ArrayList<Leave> pendingLeavesList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_home, null);

        recyclerViewPending = (RecyclerView) view.findViewById(R.id.recyclerview_pending);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewPending.setLayoutManager(layoutManager);
        recyclerViewPending.setHasFixedSize(true);

        fabHome = (FloatingActionButton) view.findViewById(R.id.fab_home);

        fabHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), FileLeave.class);
                startActivity(i);
            }
        });

        pendingLeavesList = backgroundTask.getPendingLeaves();
        adapter = new PendingLeavesAdapter(getContext(), pendingLeavesList);
        recyclerViewPending.setAdapter(adapter);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
