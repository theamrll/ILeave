package com.example.dc.ileave.objects;

/**
 * Created by DC on 23/04/2018.
 */

public class UsersInfo {

    private int id;
    private String username;
    private String fname;
    private String mname;
    private String lname;
    private String company_email;
    private String roles;
    private String position;
    private String project;
    private String department;
    private String employee_stat;

    public UsersInfo() {
    }

    public UsersInfo(int id, String username, String fname, String mname, String lname, String company_email, String roles, String position, String project, String department, String employee_stat) {
        this.id = id;
        this.username = username;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.company_email = company_email;
        this.roles = roles;
        this.position = position;
        this.project = project;
        this.department = department;
        this.employee_stat = employee_stat;
    }

    public UsersInfo(String username, String fname) {
        this.username = username;
        this.fname = fname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCompany_email() {
        return company_email;
    }

    public void setCompany_email(String company_email) {
        this.company_email = company_email;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployee_stat() {
        return employee_stat;
    }

    public void setEmployee_stat(String employee_stat) {
        this.employee_stat = employee_stat;
    }
}
