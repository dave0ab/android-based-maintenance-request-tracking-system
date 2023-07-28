package com.example.wmrts.Admin.request_sender;

public class client {
    private String id,fname,lname,wuid,mobilnum,gender,job_title,status,impath;

    public client() {
    }

    public client(String id, String fname, String lname,String wuid, String mobilnum, String gender,String job_title,String status,String impath) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.wuid = wuid;
        this.mobilnum = mobilnum;
        this.gender = gender;
        this.job_title = job_title;
        this.status = status;
        this.impath = impath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getfname() {
        return fname;
    }

    public void setfname(String fname) {
        this.fname = fname;
    }

    public String getlname() {
        return lname;
    }

    public void setlname(String lname) {
        this.lname = lname;
    }

    public String getWuid() {
        return wuid;
    }

    public void setWuid(String Wuid) {
        this.wuid = Wuid;
    }



    public String getmobilnum() {
        return mobilnum;
    }

    public void setmobilnum(String mobilnum) {
        this.mobilnum = mobilnum;
    }

    public String getgender() {
        return gender;
    }

    public void setgender(String gender) {
        this.gender = gender;
    }



    public String getjob_title() {
        return job_title;
    }

    public void setjob_title(String job_title) {
        this.job_title = job_title;
    }



    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }

    public String getimpath() {
        return impath;
    }

    public void setimpath(String impath) {
        this.impath = impath;
    }

}
