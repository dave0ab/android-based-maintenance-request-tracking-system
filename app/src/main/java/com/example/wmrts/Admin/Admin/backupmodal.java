package com.example.wmrts.Admin.Admin;


public class backupmodal {
    private String id,backupname,backuppath,backupdate;

    public backupmodal() {
    }

    public backupmodal(String id, String backupname, String backuppath  , String backupdate ) {
        this.id = id;
        this.backupname = backupname;
        this.backuppath = backuppath;
        this.backupdate = backupdate;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getbackupname() {
        return backupname;
    }

    public void setbackupname(String backupname) {
        this.backupname = backupname;
    }

    public String getbackuppath() {
        return backuppath;
    }

    public void backuppath(String backuppath) {
        this.backuppath = backuppath;
    }

    public String getbackupdate() {
        return backupdate;
    }

    public void setbackupdate(String backupdate) {
        this.backupdate = backupdate;
    }

}
