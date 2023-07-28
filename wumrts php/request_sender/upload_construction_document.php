<?php

    $connection = mysqli_connect("localhost","root","","wumrts");    
   
 $username1 = $_POST['wuid'];
 $bn= $_POST['buildingno'];
 $of = $_POST['officeno'];
   $phone = $_POST['phone'];
   $name =$_POST['name'];

  $facility = $_POST['facility'];
    $am = $_POST['additionalmessage'];
    $address = date('r', time());
//$b = random_str(8, 'abcdefghijklmnopqrstuvwxyz');

$date = date('Y/m/d H:i');

$subject = 'REGISTER 11223344 here' ;
$search = ':' ;
$search1 = '/' ;
$trimmed = str_replace($search, '/', $date) ;
$trimmed2 = str_replace($search1,'0', $trimmed);
$trimmed1 = str_replace(" ",'0', $trimmed2);
$ServerURL11 = "http://192.168.43.228:80//wumrts/request_sender/upload_construction_files/$trimmed1.docx";
 $dt = date('d-m-Y');
if($name=="")
{
	
}else{
 $select1= "SELECT *from directorates where dname = '".$facility."' ";
	$responce1 = mysqli_query($connection,$select1);
	while($row = mysqli_fetch_array($responce1))
                
				{
					$index['did']    = $row['1'];
   $fac=	$index['did'] ;
	$current_date = date('Y-m-d');
	
$InsertSQL = "INSERT INTO requests (sender_wuid,name,buildingno,officeno,phone,additionalmessage,directoret,technician,techname,techphone,task_status,document_path,thing_to_fix,requested_date,report_status,report_status_client)
 values('$username1','$name','$bn','$of','$phone','$am','$fac','Not Assigned','Not Assigned','Not Assigned','Not Assigned','$ServerURL11','Construction','$current_date','not reported','not reported')";
 
    $result = mysqli_query($connection,$InsertSQL);
	
 if($result){
	 
	 	 $action= $_POST["action"];
		 $logdata="username=".$action." = Requested for Construction maintenances = ".$bn." ".$of." ".$phone." ".$name." ".$am;
	  $seab = "INSERT INTO log(wuid,logdata) VALUES ('$action','$logdata')";
   $reb = mysqli_query($connection,$seab);
 
 if($reb){
	 
	 $data = $logdata.PHP_EOL;
	  $file = fopen("C:/xampp/htdocs/wumrts/log.txt", "a") or die("Unable to open file!"); // Opens file for writing
fwrite($file,$data);
fclose($file);
 }
	 
        echo "Data Inserted";

    }
    else{
        echo "Failed". mysqli_error($connection);
    }
    mysqli_close($connection);	
}
}



   

?>