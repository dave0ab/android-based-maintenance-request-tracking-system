package com.example.wmrts.Admin.subadmin;



public class adminsearch {


    private String id,email,status,wuid,phone,role,datecreated;

    public  adminsearch() {

    }

    public  adminsearch(String id,String wuid,String role, String email ,String status,String datecreated) {
        this.id = id;
        this.email = email;
        this.status = status;
        this.wuid = wuid;
        this.phone = phone;
        this.role = role;
        this.datecreated = datecreated;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }


    public String getWuid() {
        return wuid;
    }

    public void setWuid(String Wuid) {
        this.wuid = Wuid;
    }



    public String getdatecreated() {
        return datecreated;
    }

    public void setdatecreated(String datecreated) {
        this.datecreated = datecreated;
    }




    public String getrole() {
        return role;
    }

    public void setrole(String role) {
        this.role = role;
    }
}
