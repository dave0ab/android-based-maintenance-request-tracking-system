package com.example.wmrts.facility_manager;

public class reportmodal {
    private String id;String  request_id;String tech_wuid ;String  message; String directoret;String  documentPath;String  reported_date;String  status;

    public reportmodal() {
    }

    public reportmodal(String id,String  request_id,String tech_wuid ,String  message, String directoret,String  documentPath,String  reported_date,String  status) {
        this.id = id;
        this.tech_wuid = tech_wuid;
        this.request_id = request_id;
        this.message = message;
        this.directoret = directoret;
        this.documentPath = documentPath;
        this.reported_date= reported_date;
        this.status= status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String gettech_wuid() {
        return tech_wuid;
    }

    public void settech_wuid(String tech_wuid) {
        this.tech_wuid = tech_wuid;
    }

    public String getrequest_id() {
        return request_id;
    }

    public void setrequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getmessage() {
        return message;
    }

    public void setmessage(String message) {
        this.message = message;
    }

    public String getdirectoret() {
        return directoret;
    }

    public void setdirectoret(String directoret) {
        this.directoret = directoret;
    }

    public String getdocumentPath() {
        return documentPath;
    }

    public void setdocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }


    public String getreported_date() {
        return reported_date;
    }

    public void setreported_date(String reported_date) {
        this.reported_date = reported_date;
    }



    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }

}
