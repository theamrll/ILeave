package com.example.dc.ileave.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dc.ileave.R;
import com.example.dc.ileave.objects.UsersInfo;

import java.util.ArrayList;

/**
 * Created by DC on 23/04/2018.
 */

public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.UserInfoViewHolder> {

    ArrayList<UsersInfo> usersInfo = new ArrayList<>();

    public UserInfoAdapter(ArrayList<UsersInfo> usersInfo) {
        this.usersInfo = usersInfo;


    }

    @Override
    public UserInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pending_leaves, parent, false);
        UserInfoViewHolder userInfoViewHolder = new UserInfoViewHolder(view);
        return userInfoViewHolder;
    }

    @Override
    public void onBindViewHolder(UserInfoViewHolder holder, int position) {
        holder.username.setText(usersInfo.get(position).getUsername());
        holder.fname.setText(usersInfo.get(position).getFname());

    }

    @Override
    public int getItemCount() {
        return usersInfo.size();
    }

    public static class UserInfoViewHolder extends RecyclerView.ViewHolder{
        TextView username, fname;

        public UserInfoViewHolder(View itemView) {
            super(itemView);
            username = (TextView) itemView.findViewById(R.id.user_username);
            fname = (TextView) itemView.findViewById(R.id.user_fname);
        }
    }
}
