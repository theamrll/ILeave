package com.example.dc.ileave.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.dc.ileave.BackgroundTask;
import com.example.dc.ileave.LeaveDetails;
import com.example.dc.ileave.MainActivity;
import com.example.dc.ileave.R;
import com.example.dc.ileave.Singleton;
import com.example.dc.ileave.adapter.FiledLeavesAdapter;
import com.example.dc.ileave.objects.Leave;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DC on 23/04/2018.
 */

public class FiledLeaves extends Fragment {

    private ExpandableListView expandableListView;
    private LinkedHashMap<String, Leave> leaveList = new LinkedHashMap<String, Leave>();
    private FiledLeavesAdapter filedLeavesAdapter;
    private ArrayList<String> header = new ArrayList<String>();
    private BackgroundTask backgroundTask = new BackgroundTask(getContext());

    private ArrayList<Leave> pleaves = new ArrayList<Leave>();
    private ArrayList<Leave> aleaves = new ArrayList<Leave>();
    private ArrayList<Leave> cleaves = new ArrayList<Leave>();
    private ArrayList<Leave> rleaves = new ArrayList<Leave>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.content_filed_leaves, null);

        expandableListView = (ExpandableListView) view.findViewById(R.id.expandable_listview);
        List<String> headings = new ArrayList<String>();

        ArrayList<Leave> pleaves1 = backgroundTask.getPendingLeaves();
        ArrayList<Leave> aleaves1 = backgroundTask.getApprovedLeaves();
        ArrayList<Leave> cleaves1 = backgroundTask.getCancelledLeavesLeaves();
        ArrayList<Leave> rleaves1 = backgroundTask.getRejectedLeaves();

        HashMap<String, ArrayList<Leave>> childList = new HashMap<String, ArrayList<Leave>>();
        String parentItems[] = getResources().getStringArray(R.array.parent_items);

        for (String title : parentItems) {
            headings.add(title);
        }

        childList.put(headings.get(0), pleaves1);
        childList.put(headings.get(1), aleaves1);
        childList.put(headings.get(2), cleaves1);
        childList.put(headings.get(3), rleaves1);

        filedLeavesAdapter = new FiledLeavesAdapter(headings,childList,FiledLeaves.this.getActivity());

        expandableListView.setAdapter(filedLeavesAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {

                Leave cp = (Leave) filedLeavesAdapter.getChild(groupPosition, childPosition);

                Intent i = new Intent(getContext(), LeaveDetails.class);

                i.putExtra("leaveDetails", cp);
                getContext().startActivity(i);

                return false;
            }
        });

        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.menu_filed_leaves, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                    expandableListView.clearTextFilter();
                } else {
                    expandableListView.setFilterText(newText);
                }
//                filedLeavesAdapter.getFilter().filter(newText);
                return true;
            }
        });

    }
}
