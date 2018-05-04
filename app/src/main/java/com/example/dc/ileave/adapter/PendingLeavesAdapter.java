package com.example.dc.ileave.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dc.ileave.LeaveDetails;
import com.example.dc.ileave.R;
import com.example.dc.ileave.objects.Leave;
import com.example.dc.ileave.objects.UsersInfo;

import java.util.ArrayList;

/**
 * Created by DC on 23/04/2018.
 */

public class PendingLeavesAdapter extends RecyclerView.Adapter<PendingLeavesAdapter.PendingLeavesViewHolder> {

    private ArrayList<Leave> pendingLeaves = new ArrayList<>();
    private Context context;

    public PendingLeavesAdapter(Context context, ArrayList<Leave> pendingLeaves) {
        this.pendingLeaves = pendingLeaves;
        this.context = context;
    }

    @Override
    public PendingLeavesViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pending_leaves, parent, false);
        PendingLeavesViewHolder pendingLeavesViewHolder = new PendingLeavesViewHolder(view);
        return pendingLeavesViewHolder;
    }

    @Override
    public void onBindViewHolder(PendingLeavesViewHolder holder, final int position) {
        holder.kindOfLeave.setText(pendingLeaves.get(position).getKind_of_leave() + ": ");
        holder.date.setText(pendingLeaves.get(position).getStart_date());
        holder.status.setText(pendingLeaves.get(position).getStatus());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, LeaveDetails.class);
                Leave l = pendingLeaves.get(position);
                i.putExtra("leaveDetails", l);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pendingLeaves.size();
    }

    public static class PendingLeavesViewHolder extends RecyclerView.ViewHolder{
        TextView kindOfLeave, date, status;
        RelativeLayout parentLayout;

        public PendingLeavesViewHolder(View itemView) {
            super(itemView);
            kindOfLeave = (TextView) itemView.findViewById(R.id.home_type_of_leave);
            date = (TextView) itemView.findViewById(R.id.home_date);
            status = (TextView) itemView.findViewById(R.id.home_status);
            parentLayout = (RelativeLayout) itemView.findViewById(R.id.parent_layout);

        }
    }
}
