package com.example.wmrts.Admin.Admin;


public class headsearch {
    private String id,fname,lname,wuid,mobilnum,gender,loginstatus,role;

    public headsearch() {
    }

    public headsearch(String id, String fname, String lname  , String wuid, String mobilnum,  String loginstatus,  String role) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.wuid = wuid;
        this.mobilnum = mobilnum;

        this.loginstatus = loginstatus;
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



    public String getloginstatus() {
        return loginstatus;
    }

    public void setloginstatus(String loginstatus) {
        this.loginstatus = loginstatus;
    }


    public String getrole() {
        return role;
    }

    public void setrole(String role) {
        this.role = role;
    }
}
