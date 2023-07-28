package com.example.wmrts.facility_manager;

public class requestmodal {
    private String id,wuid,name,buildingno,officeno,phone,department;
    String quantity,document_path; String checkboxrequests;
    String priority;String requested_date; String 	additionalmessage; String facility; String 	imagepath ; String assigned_date; String 	thing_to_fix;String technician;String techphone;String techname;
String fa_phone;
    public requestmodal() {
    }

    public requestmodal(String id, String wuid,String name, String buildingno, String officeno, String phone, String quantity, String checkboxrequests,
                       String priority, String 	additionalmessage, String 	imagepath , String 	thing_to_fix
   ,  String facility,String technician ,String techname,String techphone ,String 	task_status, String 	assigned_time , String 	assigned_date, String 	requested_date,String document_path,String fa_phone) {
        this.id = id;
        this.wuid = wuid;
        this.name = name;
        this.buildingno = buildingno;
        this.officeno = officeno;
        this.department = department;
        this.phone= phone;
        this.quantity= quantity;
        this.facility= facility;
        this.checkboxrequests = checkboxrequests;
        this.technician = technician;
        this.techname = techname;
        this.techphone = techphone;
        this.priority = priority;
        this.additionalmessage = additionalmessage;
        this.imagepath= imagepath;
        this.thing_to_fix = thing_to_fix;
        this.document_path = document_path;
        this.requested_date = requested_date;

        this.assigned_date = assigned_date;
        this.fa_phone = fa_phone;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getbuildingno() {
        return buildingno;
    }

    public void setbuildingno(String buildingno) {
        this.buildingno = buildingno;
    }

    public String getWuid() {
        return wuid;
    }

    public void setWuid(String Wuid) {
        this.wuid = Wuid;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.wuid = name;
    }

    public String getofficeno() {
        return officeno;
    }

    public void setofficeno(String officeno) {
        this.officeno = officeno;
    }

    public String getquantity() {
        return quantity;
    }

    public void setquantity(String quantity) {
        this.quantity = quantity;
    }


    public String gettechnician() {
        return technician;
    }

    public void settechnician(String technician) {
        this.technician = technician;
    }


    public String gettechphone() {
        return techphone;
    }


    public void settechphone(String techphone) {
        this.techphone = techphone;
    }


    public String getfacility() {
        return facility;
    }

    public void setfacility(String technician) {
        this.facility = facility;
    }




    public String gettechname() {
        return techname;
    }


    public void settechname(String techphone) {
        this.techname = techname;
    }

    public String getdocument_path() {
        return document_path;
    }


    public void setdocument_path(String document_path) {
        this.document_path = document_path;
    }




    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }




    public String getdepartment() {
        return department;
    }

    public void setdepartment(String department) {
        this.department = department;
    }



    public String getcheckboxrequests() {
        return checkboxrequests;
    }

    public void setcheckboxrequests(String checkboxrequests) {
        this.checkboxrequests = checkboxrequests;
    }

    public String getpriority() {
        return priority;
    }

    public void setpriority(String priority) {
        this.priority = priority;
    }

    public String getadditionalmessage() {
        return additionalmessage;
    }

    public void setadditionalmessage(String additionalmessage) {
        this.additionalmessage = additionalmessage;
    }

    public String getthing_to_fix() {
        return thing_to_fix;
    }

    public void setthing_to_fix(String thing_to_fix) {
        this.thing_to_fix = thing_to_fix;
    }

    public String getimagepath() {
        return imagepath;
    }

    public void setimagepath(String imagepath) {
        this.imagepath = imagepath;
    }


    public String getrequested_date() {
        return requested_date;
    }

    public void setrequested_date(String requested_date) {
        this.requested_date = requested_date;
    }


    public String getassigned_date() {
        return assigned_date;
    }

    public void setassigned_date(String assigned_date) {
        this.assigned_date = assigned_date;
    }


    public String getfa_phone() {
        return fa_phone;
    }

    public void setfa_phone(String fa_phone) {
        this.fa_phone = fa_phone;
    }

}
