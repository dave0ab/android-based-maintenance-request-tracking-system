package com.example.wmrts.facility_manager;

public class clientapprove {
    private String id,name,wuid,mobilnum,gender,department,status;

    public clientapprove () {
    }

    public clientapprove (String id, String name, String wuid, String mobilnum, String gender,String department,String status) {
        this.id = id;
        this.name = name;
        this.wuid = wuid;
        this.mobilnum = mobilnum;
        this.gender = gender;
        this.department = department;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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



    public String getdepartment() {
        return department;
    }

    public void setdepartment(String department) {
        this.department = department;
    }



    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }



}
