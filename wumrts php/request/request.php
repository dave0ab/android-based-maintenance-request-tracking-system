<?php
 
include 'config.php';
 
// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
 // Create connection
$connection = new mysqli($servername, $username, $password, $dbname);
  $username1 = $_POST['wuid'];
 
 
 
 $currentDate = date("Y-m-d");
$userId = 1; // Replace with the actual user ID of the current user

// Count the number of rows entered today by the current user
$sql = "SELECT COUNT(*) as count FROM requests WHERE sender_wuid = '".$username1."' AND requested_date = '".$currentDate."'";

$result = mysqli_query($conn, $sql);
$row = mysqli_fetch_assoc($result);
$rowsEnteredToday = $row['count'];

// Add a new row if less than 2 rows have been entered today by the current user
if ($rowsEnteredToday < 100) {
	
	
 
 if($_SERVER['REQUEST_METHOD'] == 'POST')
 {
	 
	 
	 
	 
	 
 $DefaultId = 0;
 
 
 $username1 = $_POST['wuid'];
 // $Fullname = $_POST['name'];
 $bn= $_POST['buildingno'];
 $of = $_POST['officeno'];
  $pcmo = $_POST['pcmodel'];
   $phone = $_POST['phone'];
   $quantity = $_POST['quantity'];
   $name =$_POST['name'];
   
 $cb1= $_POST['checkbox1'];

  $cb2= $_POST['checkbox2'];
   $cb3= $_POST['checkbox3'];
    $cb4= $_POST['checkbox4'];
	 $cb5= $_POST['checkbox5'];
	 $cb7= '';
	 
	 
	 
$cb11=$cb1." \n ". $cb2." \n ".$cb3." \n ".$cb4." \n ".$cb5." \n ".$cb7;
 
  $directoret = $_POST['directoret'];
    $am = $_POST['additionalmessage'];
  $device = $_POST['device'];
 $ImageData = $_POST['image_data'];
 
 $ImageName = $_POST['image_tag'];
 
 $ImagePath = "upload/$ImageName.jpg";
 
 $ServerURL = "http://192.168.43.228:80//wumrts/request/$ImagePath";
 $dt = date('Y-m-d');
 
 
 
 
 $sql21 = "SELECT COUNT(*) as count FROM inventory WHERE wuid = '".$username1."' AND serial_no = '".$pcmo."'";
 
 
 
	 
	$responce14 = mysqli_query($conn,$sql21);
	$row22 = mysqli_fetch_assoc($responce14);
$rowsEnteredToday22 = $row22['count'];
	
	if($rowsEnteredToday22 >0)
                
				{
	 

 
 
  $select1= "SELECT *from directorates where dname = '".$directoret."' ";
	$responce1 = mysqli_query($conn,$select1);
	while($row = mysqli_fetch_array($responce1))
                
				{
					$index['did']    = $row['1'];
   $fac=	$index['did'] ;
   
   $current_date = date('Y-m-d');
   
  $InsertSQL = "INSERT INTO requests (sender_wuid,name,buildingno,officeno,phone,quantity,checkboxrequests,facility_manager_id,additionalmessage,imagepath,thing_to_fix,directoret,technician,techname,techphone,task_status,requested_date,report_status,report_status_client)
 values('$username1','$name','$bn','$of','$phone','$quantity','$cb11','Not Assigned','$am','$ServerURL','$device','$fac','Not Assigned','Not Assigned','Not Assigned','Not Assigned','$current_date','not reported','not reported')";
 
 if(mysqli_query($conn,$InsertSQL)){
 
 file_put_contents($ImagePath,base64_decode($ImageData));
 
 
 
  $action= $username1;
		 $logdata="username=".$action." = Requested for ICT maintenances = ".$bn." ".$of." ".$pcmo." ".$phone." ".$name."".$fac." ".$am." ".$device." ".$directoret;
	  $seab = "INSERT INTO log(wuid,logdata) VALUES ('$action','$logdata')";
   $reb = mysqli_query($connection,$seab);
 
 if($reb){
	 
	  $data = $logdata.PHP_EOL;
	  $file = fopen("C:/xampp/htdocs/wumrts/log.txt", "a") or die("Unable to open file!"); // Opens file for writing
fwrite($file,$data);
fclose($file);
 }
 
 echo "Your Request Has Been Uploaded.";
 }
 

else{
 echo "Please Try Again";
 }
 }
 
 }else {
    echo "This device is not woldia university property";
}
 }
	
} else {
    echo "You have already entered 3 Requests for today THANK YOU";
}

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
?>