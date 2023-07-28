<?php
 
include 'config.php';
 
// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
 
 if($_SERVER['REQUEST_METHOD'] == 'POST')
 {
 $DefaultId = 0;
 
 $n = $_POST['name'];
 $username = $_POST['username'];
 $mn = $_POST['mobile'];
 $pw = $_POST['password'];
  $g = $_POST['gender'];
 $ImageData = $_POST['image_data'];
 
 $ImageName = $_POST['image_tag'];
 
 $ImagePath = "upload/$ImageName.jpg";
 
 $ServerURL = "C:/xampp/htdocs/im/$ImagePath";
 
 $InsertSQL = "INSERT INTO useraccount (name,username,gender,mobilenum,password,imagepath,status) values('$n','$username','$g','$mn','$pw','$ServerURL','0')";
 
 if(mysqli_query($conn, $InsertSQL)){
 
 file_put_contents($ImagePath,base64_decode($ImageData));
 
 echo "Your Image Has Been Uploaded.";
 }
 
 mysqli_close($conn);
 }else{
 echo "Please Try Again";
 }
 
?>