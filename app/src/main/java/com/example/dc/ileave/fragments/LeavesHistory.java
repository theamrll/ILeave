package com.example.dc.ileave.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.dc.ileave.BackgroundTask;
import com.example.dc.ileave.R;
import com.example.dc.ileave.adapter.FiledLeavesAdapter;
import com.example.dc.ileave.objects.Leave;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LeavesHistory#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeavesHistory extends Fragment {

    private ExpandableListView expandableListView;
    private LinkedHashMap<String, Leave> leaveList = new LinkedHashMap<String, Leave>();
    private FiledLeavesAdapter filedLeavesAdapter;
    private ArrayList<String> header = new ArrayList<String>();
    private BackgroundTask backgroundTask = new BackgroundTask(getContext());

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public LeavesHistory() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LeavesHistory.
     */
    // TODO: Rename and change types and number of parameters
    public static LeavesHistory newInstance(String param1, String param2) {
        LeavesHistory fragment = new LeavesHistory();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_filed_leaves, null);

        LoadData();

        expandableListView = (ExpandableListView) view.findViewById(R.id.expandable_listview);
//        filedLeavesAdapter = new FiledLeavesAdapter(LeavesHistory.this.getActivity(), header);
        expandableListView.setAdapter(filedLeavesAdapter);

        return view;
    }

    private void expandAll() {
        int count = filedLeavesAdapter.getGroupCount();
        for (int i =0; i < 0; i++) {
            expandableListView.expandGroup(i);
        }
    }

    private void collapseAll() {
        int count = filedLeavesAdapter.getGroupCount();
        for (int i =0; i < 0; i++) {
            expandableListView.collapseGroup(i);
        }
    }

    private void LoadData() {

    }

}
