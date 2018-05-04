package com.example.dc.ileave.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.dc.ileave.BackgroundTask;
import com.example.dc.ileave.R;
import com.example.dc.ileave.objects.Leave;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by DC on 24/04/2018.
 */

public class FiledLeavesAdapter extends BaseExpandableListAdapter implements Filterable{

    private List<String> headerTitles;
    private List<String> originalList;
    private HashMap<String, ArrayList<Leave>> childTitles;
    private Context context;
    private BackgroundTask backgroundTask = new BackgroundTask(context);
    private ArrayList<Leave> leavesList;

    private TextView child_type_of_leave,
                     child_date_leave,
                     child_name,
                     child_status,
                     parent_item;

    public FiledLeavesAdapter(List<String> headerTitles, HashMap<String, ArrayList<Leave>> childTitles, Context context) {
        this.headerTitles = headerTitles;
        this.childTitles = childTitles;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return headerTitles.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return childTitles.get(headerTitles.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return headerTitles.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return childTitles.get(headerTitles.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String title = (String)this.getGroup(i);
        if (view==null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.parent_layout, null);

        }
        parent_item = (TextView) view.findViewById(R.id.parent_item);
        parent_item.setTypeface(null, Typeface.BOLD);
        parent_item.setText(title);

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {

        Leave title = (Leave)getChild(i, i1);
        if (view==null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.child_layout, null);

        }

        child_type_of_leave = (TextView) view.findViewById(R.id.child_type_of_leave);
        child_type_of_leave.setText(title.getKind_of_leave());
        child_date_leave = (TextView) view.findViewById(R.id.child_date_leave);
        child_date_leave.setText(title.getStart_date());
        child_name = (TextView) view.findViewById(R.id.child_name);
        child_name.setText(title.getUsername());
        child_status = (TextView) view.findViewById(R.id.child_status);
        child_status.setText(title.getStatus());


        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults result = new FilterResults();
                leavesList = backgroundTask.getLeaves();
                ArrayList<Leave> newList = new ArrayList<Leave>();

                if(charSequence != null && charSequence.toString().length() > 0) {
                    headerTitles.addAll(originalList);

                } else {
                   for (Object header : originalList) {
//                       ArrayList<Leave> l = header;

                       leavesList.add((Leave)header);

                       for (Leave leave : leavesList) {
                           if (leave.getUsername().toLowerCase().contains(charSequence) ||
                                   leave.getApprover().toLowerCase().contains(charSequence) ||
                                   leave.getKind_of_leave().toLowerCase().contains(charSequence) ||
                                   leave.getStatus().toLowerCase().contains(charSequence)) {
                               newList.add(leave);
                           }
                       }
                   }
                   result.values = newList;
                }
                return result;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                leavesList = (ArrayList<Leave>) filterResults.values;
                notifyDataSetChanged();


            }
        };
    }
}
