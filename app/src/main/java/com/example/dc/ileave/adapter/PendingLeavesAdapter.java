package com.example.dc.ileave.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dc.ileave.R;
import com.example.dc.ileave.objects.Leave;
import com.example.dc.ileave.objects.UsersInfo;

import java.util.ArrayList;

/**
 * Created by DC on 23/04/2018.
 */

public class PendingLeavesAdapter extends RecyclerView.Adapter<PendingLeavesAdapter.PendingLeavesViewHolder> {

    ArrayList<Leave> pendingLeaves = new ArrayList<>();

    public PendingLeavesAdapter(ArrayList<Leave> pendingLeaves) {
        this.pendingLeaves = pendingLeaves;


    }

    @Override
    public PendingLeavesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pending_leaves, parent, false);
        PendingLeavesViewHolder pendingLeavesViewHolder = new PendingLeavesViewHolder(view);
        return pendingLeavesViewHolder;
    }

    @Override
    public void onBindViewHolder(PendingLeavesViewHolder holder, int position) {
        holder.kindOfLeave.setText(pendingLeaves.get(position).getKind_of_leave() + ": ");
        holder.date.setText(pendingLeaves.get(position).getStart_date());
        holder.status.setText(pendingLeaves.get(position).getStatus());

    }

    @Override
    public int getItemCount() {
        return pendingLeaves.size();
    }

    public static class PendingLeavesViewHolder extends RecyclerView.ViewHolder{
        TextView kindOfLeave, date, status;

        public PendingLeavesViewHolder(View itemView) {
            super(itemView);
            kindOfLeave = (TextView) itemView.findViewById(R.id.home_type_of_leave);
            date = (TextView) itemView.findViewById(R.id.home_date);
            status = (TextView) itemView.findViewById(R.id.home_status);
        }
    }
}
