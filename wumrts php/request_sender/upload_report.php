<?php

    $connection = mysqli_connect("localhost","root","","wumrts");    
    $request_id= $_POST['request_id'];
    $wuid= $_POST['sender_wuid'];
    $message = $_POST['message'];
    //$directorate = $_POST['directorate'];
	$facility = $_POST['facility'];
    $status ="not seen";
    $address = date('r', time());
//$b = random_str(8, 'abcdefghijklmnopqrstuvwxyz');
   $name =$_POST['name'];
$date = date('Y/m/d H:i');

$subject = 'REGISTER 11223344 here' ;
$search = ':' ;
$search1 = '/' ;
$trimmed = str_replace($search, '/', $date) ;
$trimmed2 = str_replace($search1,'0', $trimmed);
$trimmed1 = str_replace(" ",'0', $trimmed2);
$ServerURL11 = "http://192.168.43.228:80//wumrts/technician/upload/$trimmed1.docx";
 $dt = date('d-m-Y');
 
 
 
 
$sql77= "SELECT *from reports WHERE request_id = '".$request_id."' AND sendeR_wuid ='".$wuid."' AND 	reassign_status ='Not Reassigned' ORDER BY id desc";
 
 //$sql77 = "SELECT *from reports  WHERE requested_id = '226'  AND  tech_wuid = 'tech1'";

$result21 = mysqli_query($connection, $sql77);

// Add a new row if less than 2 rows have been entered today by the current user
if (mysqli_num_rows ($result21)>=1){
	
     echo "You have already reported";
}
 

 
 else{
 
 

if($name=="")
{
	
}else{
 
	  $sql2 = "UPDATE requests SET  task_status ='Completed' , report_status_client ='reported' WHERE id = '$request_id'";
	  
$InsertSQL = "INSERT INTO reports (request_id,sender_wuid,message,directorate,document_path,status,reassign_status)
 values('$request_id','$wuid','$message','$facility','$ServerURL11','$status','Not Reassigned')";
 $result2 = mysqli_query($connection,$sql2);

    $result = mysqli_query($connection,$InsertSQL);
	
 if($result&&$result2){
	 
	 
	 
	 $action= $wuid;
		 $logdata="username=".$action." = Reported for the request = ".$request_id."detailes= ".$message." ".$facility." ".$request_id." ".$wuid." ";
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