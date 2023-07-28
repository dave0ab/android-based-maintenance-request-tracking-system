<?php

    $connection = mysqli_connect("localhost","root","","wumrts");    
    $request_id= $_POST['request_id'];
    $wuid= $_POST['tech_wuid'];
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
 
 
 
  
$sql77= "SELECT *from reports WHERE request_id = '".$request_id."' AND tech_wuid ='".$wuid."' AND reassign_status ='Not Reassigned' ORDER BY id desc";
 
 //$sql77 = "SELECT *from reports  WHERE requested_id = '226'  AND  tech_wuid = 'tech1'";

$result21 = mysqli_query($connection, $sql77);

// Add a new row if less than 2 rows have been entered today by the current user
if (mysqli_num_rows ($result21)>=1){
	
     echo "You have already reported";
}
 

 
 else{
 
 
 
 
 
 	$sql77= "SELECT *from reports WHERE request_id = '".$request_id."' AND tech_wuid ='".$wuid."'  ORDER BY id desc";
 
 //$sql77 = "SELECT *from reports  WHERE requested_id = '226'  AND  tech_wuid = 'tech1'";

$result21 = mysqli_query($connection, $sql77);

// Add a new row if less than 2 rows have been entered today by the current user
if (mysqli_num_rows ($result21)>1){
	
     echo "You have already reported";
}
 
 else{
 
 
if($name=="")
{
	
}else{
 /*$select1= "SELECT *from directorates where dname = '".$facility."' ";
	$responce1 = mysqli_query($connection,$select1);
	while($row = mysqli_fetch_array($responce1))
        {
				$index['did']    = $row['1'];
   $fac=	$index['did'] ;
		}	
		*/		
	
	$select= "SELECT *from technician where wuid ='".$wuid."'";
	$responce = mysqli_query($connection,$select);

	while($row = mysqli_fetch_array($responce))
		{
			
	
	$index['ongoingjobs']   = $row['8'];
	
	
$a=$index['ongoingjobs'] ;
	
	$a = $a - 1;
	 
	  $sql1 = "UPDATE technician SET  ongoingJobs ='$a' WHERE wuid = '$wuid'";
	  
	 
	  $sql2 = "UPDATE requests SET   task_status ='Completed'  ,report_status ='reported' WHERE id = '$request_id'";
	  
$InsertSQL = "INSERT INTO reports (request_id,tech_wuid,message,directorate,document_path,status,reassign_status)
 values('$request_id','$wuid','$message','$facility','$ServerURL11','$status','Not Reassigned')";
 $result2 = mysqli_query($connection,$sql2);
 $result1 = mysqli_query($connection,$sql1);
    $result = mysqli_query($connection,$InsertSQL);
	 if($result2){
		if($result1){ 
 if($result){
	 
	 
	  
	 
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
    }
    else{
        echo "Failed". mysqli_error($connection);
	 }}else{
		 
		 echo "Failed". mysqli_error($connection);
	 }
	 
		
    mysqli_close($connection);	


		}
}		}}




   

?>