package com.example.dc.ileave.objects;

import java.io.Serializable;

/**
 * Created by DC on 24/04/2018.
 */

public class Leave implements Serializable{

    private int id_pending;
    private String status;
    private String assignor;
    private String username;
    private String approver;
    private String kind_of_leave;
    private String start_date;
    private String end_date;
    private String duration;

    public Leave() {
    }

    public Leave(int id_pending, String status, String assignor, String username, String approver, String kind_of_leave, String start_date, String end_date, String duration) {
        this.id_pending = id_pending;
        this.status = status;
        this.assignor = assignor;
        this.username = username;
        this.approver = approver;
        this.kind_of_leave = kind_of_leave;
        this.start_date = start_date;
        this.end_date = end_date;
        this.duration = duration;
    }

    public int getId_pending() {
        return id_pending;
    }

    public void setId_pending(int id_pending) {
        this.id_pending = id_pending;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignor() {
        return assignor;
    }

    public void setAssignor(String assignor) {
        this.assignor = assignor;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getKind_of_leave() {
        return kind_of_leave;
    }

    public void setKind_of_leave(String kind_of_leave) {
        this.kind_of_leave = kind_of_leave;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
