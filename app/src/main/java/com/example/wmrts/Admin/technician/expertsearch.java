package com.example.wmrts.Admin.technician;


public class expertsearch {
    private String id, fname,lname,  wuid, mobilnum,   facility,  loginstatus,   workstatus,  role;

    public expertsearch() {
    }

    public expertsearch(String id, String fname,String lname,String wuid, String mobilnum,  String facility, String loginstatus,  String workstatus,  String role) {
        this.id = id;
        this.fname = fname;
        this.wuid = wuid;
        this.mobilnum = mobilnum;
        this.facility = facility;
        this.loginstatus = loginstatus;
        this.workstatus = workstatus;
        this.role = role;


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



    public String getfacility() {
        return facility;
    }

    public void setfacility(String facility) {
        this.facility = facility;
    }

    public String getloginstatus() {
        return loginstatus;
    }

    public void setloginstatus(String loginstatus) {
        this.loginstatus = loginstatus;
    }

    public String getworkstatus() {
        return workstatus;
    }

    public void setworkstatus(String workstatus) {
        this.workstatus = workstatus;
    }




    public String getrole() {
        return role;
    }

    public void setrole(String role) {
        this.role = role;
    }
}
