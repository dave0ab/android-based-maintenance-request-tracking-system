package com.example.wmrts.Admin.Admin;


public class logmodal {
    private String id,wuid,logdata,logdate;

    public logmodal() {
    }

    public logmodal(String id, String wuid, String logdata  , String logdate ) {
        this.id = id;
        this.wuid = wuid;
        this.logdata = logdata;
        this.logdate = logdate;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getwuid() {
        return wuid;
    }

    public void setwuid(String wuid) {
        this.wuid = wuid;
    }

    public String getlogdata() {
        return logdata;
    }

    public void setlogdata(String logdata) {
        this.logdata = logdata;
    }

    public String getlogdate() {
        return logdate;
    }

    public void setlogdate(String logdate) {
        this.logdate = logdate;
    }

}
