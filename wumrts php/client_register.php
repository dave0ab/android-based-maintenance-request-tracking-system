<?php
 
include 'config.php';
 
// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
 
 if($_SERVER['REQUEST_METHOD'] == 'POST')
 {
 $DefaultId = 0;
 
 
 $n = $_POST['name'];
 $username1 = $_POST['wuid'];
 $mn = $_POST['mobile'];
 $pw = $_POST['password'];
  $g = $_POST['gender'];
   $role = $_POST['role'];
 $ImageData = $_POST['image_data'];
 
 $ImageName = $_POST['image_tag'];
 
 $ImagePath = "upload/$ImageName.jpg";
 
 $ServerURL = "C:/xampp/htdocs/wumrts/upload/$ImagePath";
 
 
 
  $InsertSQL1 = "INSERT INTO account (wuid,password,role) values('$username1','$pw','$role')";
 
 if(mysqli_query($conn, $InsertSQL1)){
 
 
 
 $InsertSQL = "INSERT INTO useraccount (name,wuid,gender,mobilenum,password,imagepath,status,login) values('$n','$username1','$g','$mn','$pw','$ServerURL',"0","client")";
 
 if(mysqli_query($conn, $InsertSQL)){
 
 file_put_contents($ImagePath,base64_decode($ImageData));
 
 echo "Your Image Has Been Uploaded.";
 }
 
 mysqli_close($conn);
 }else{
 echo "Please Try Again";
 }
 }else{
	 
	 
	 
	 
	 
 }
?>