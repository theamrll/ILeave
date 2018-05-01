package com.example.dc.ileave;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.dc.ileave.objects.Leave;
import com.example.dc.ileave.objects.UsersInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by DC on 23/04/2018.
 */

public class BackgroundTask {

    private Context context;
    private ArrayList<UsersInfo> usersInfoList = new ArrayList<>();
    private ArrayList<Leave> pendingLeaves = new ArrayList<Leave>();
    private ArrayList<Leave> approvedLeaves = new ArrayList<Leave>();
    private ArrayList<Leave> cancelledLeaves = new ArrayList<Leave>();
    private ArrayList<Leave> rejectedLeaves = new ArrayList<Leave>();

    String BASE_URL = "http://192.168.0.15/iLeave/";

    public BackgroundTask(Context context) {
        this.context = context;
    }

    public ArrayList<UsersInfo> getList() {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, BASE_URL + "users_info/get_users_info.php", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i=0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                UsersInfo usersInfo = new UsersInfo(jsonObject.getString("username"),
                                        jsonObject.getString("fname"));

                                usersInfoList.add(usersInfo);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
                error.printStackTrace();


            }
        });

        Singleton.getInstance(context).addToRequestQueue(jsonArrayRequest);


        return usersInfoList;
    }

    public ArrayList<Leave> getPendingLeaves() {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, BASE_URL + "leaves/get_leaves_search.php?status=Pending", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i=0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                Leave leave = new Leave(jsonObject.getInt("id_pending"),
                                        jsonObject.getString("status"),
                                        jsonObject.getString("assignor"),
                                        jsonObject.getString("username"),
                                        jsonObject.getString("approver"),
                                        jsonObject.getString("kind_of_leave"),
                                        jsonObject.getString("start_date"),
                                        jsonObject.getString("end_date"),
                                        jsonObject.getString("duration"));

                                pendingLeaves.add(leave);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
                error.printStackTrace();


            }
        });

        Singleton.getInstance(context).addToRequestQueue(jsonArrayRequest);


        return pendingLeaves;
    }

    public ArrayList<Leave> getApprovedLeaves() {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, BASE_URL + "leaves/get_leaves_search.php?status=Approved", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i=0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                Leave leave = new Leave(jsonObject.getInt("id_pending"),
                                        jsonObject.getString("status"),
                                        jsonObject.getString("assignor"),
                                        jsonObject.getString("username"),
                                        jsonObject.getString("approver"),
                                        jsonObject.getString("kind_of_leave"),
                                        jsonObject.getString("start_date"),
                                        jsonObject.getString("end_date"),
                                        jsonObject.getString("duration"));

                                approvedLeaves.add(leave);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
                error.printStackTrace();


            }
        });

        Singleton.getInstance(context).addToRequestQueue(jsonArrayRequest);


        return approvedLeaves;
    }

    public ArrayList<Leave> getCancelledLeavesLeaves() {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, BASE_URL + "leaves/get_leaves_search.php?status=Cancelled", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i=0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                Leave leave = new Leave(jsonObject.getInt("id_pending"),
                                        jsonObject.getString("status"),
                                        jsonObject.getString("assignor"),
                                        jsonObject.getString("username"),
                                        jsonObject.getString("approver"),
                                        jsonObject.getString("kind_of_leave"),
                                        jsonObject.getString("start_date"),
                                        jsonObject.getString("end_date"),
                                        jsonObject.getString("duration"));

                                cancelledLeaves.add(leave);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
                error.printStackTrace();

            }
        });

        Singleton.getInstance(context).addToRequestQueue(jsonArrayRequest);


        return cancelledLeaves;
    }

    public ArrayList<Leave> getRejectedLeaves() {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, BASE_URL + "leaves/get_leaves_search.php?status=Rejected", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i=0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                Leave leave = new Leave(jsonObject.getInt("id_pending"),
                                        jsonObject.getString("status"),
                                        jsonObject.getString("assignor"),
                                        jsonObject.getString("username"),
                                        jsonObject.getString("approver"),
                                        jsonObject.getString("kind_of_leave"),
                                        jsonObject.getString("start_date"),
                                        jsonObject.getString("end_date"),
                                        jsonObject.getString("duration"));

                                rejectedLeaves.add(leave);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
                error.printStackTrace();
            }
        });

        Singleton.getInstance(context).addToRequestQueue(jsonArrayRequest);

        return rejectedLeaves;
    }
}
