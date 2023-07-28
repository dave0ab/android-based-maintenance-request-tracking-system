<?php
 
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;
require 'PHPMailer/Exception.php';
require 'PHPMailer/PHPMailer.php';
require 'PHPMailer/SMTP.php';
    require_once "functions.php";
include 'config.php';
 
// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
 $wuid= $_POST['wuid'];
  $email = $_POST['email'];
 
 
    if($_SERVER['REQUEST_METHOD'] == 'POST')
 {
	 
	 $select= "SELECT *from account where wuid = '".$wuid."'";
    $select1= "SELECT *from account where email = '".$email."'";

	$responce = mysqli_query($conn,$select);
	$responce1 = mysqli_query($conn,$select1);
   
   if (mysqli_num_rows ( $responce )>=1){
 
  echo "University id already exists"; 
	}else{
   
    if (mysqli_num_rows ( $responce1 )>=1){
 
  echo "Email address already exists"; 
	}else{
 
	 
	 
	 
 $DefaultId = 0;
 
 $n = $_POST['name'];
  $l = $_POST['lname'];
 $username1 = $_POST['wuid'];
 $mn = $_POST['mobile'];
$password1 = $_POST["password"];
	   
   $pw = md5($password1);
  $g = $_POST['gender'];
  $email = $_POST['email'];
//$d = $_POST['role'];
  $job= $_POST['job_title'];
 $ImageData = $_POST['image_data'];
  $ImageData1 = $_POST['image_data1'];
 
 $ImageName = $_POST['image_tag'];
 $ImageName1 = $_POST['image_tag1'];
 $ImagePath = "upload/$ImageName.jpg";
  $ImagePath1 = "upload1/$ImageName1.jpg";
 
 $ServerURL = "http://192.168.43.228:80//wumrts/request_sender/$ImagePath";
 $ServerURL1 = "http://192.168.43.228:80//wumrts/request_sender/$ImagePath1";
 
 
 
 
 
   $InsertSQL1 = "INSERT INTO account (wuid,password,role,email,status) values('$username1','$pw','client','$email','Not Allowed')";
 
 if(mysqli_query($conn, $InsertSQL1)){
 
 
 
 $InsertSQL = "INSERT INTO request_sender (fname,lname,wuid,phone,sex,imagepath,wuidimage,job_title) values('$n','$l','$username1','$mn','$g','$ServerURL','$ServerURL1','$job')";
  
 if(mysqli_query($conn, $InsertSQL)){
 
 file_put_contents($ImagePath,base64_decode($ImageData));

 file_put_contents($ImagePath1,base64_decode($ImageData1));
 
 echo "Your Have Registered Succesfully Wait For Approval.";
  echo "\r\n";
 }
 else{
	 echo mysqli_error($conn);
 }}
 else{
	 echo mysqli_error($conn);
	 
 }
	
	
	
	    $connection = mysqli_connect("localhost","root","","wumrts");    
 //$un = $_POST['wuid'];

 $email = $_POST['email'];
 


	
	
	  $select3= "SELECT *from account where  email = '".$email."'";

	
    $responce3 = mysqli_query($connection,$select3);
	
	
	 $n = $_POST['name'];
	
		if (mysqli_num_rows ( $responce3 )>=1){

$name = "Dave";
$mail = new PHPMailer;
$mail->isSMTP();
//$mail->SMTPDebug = 2;
$mail->Host = 'smtp.gmail.com';
$mail->Port = 587;
$mail->SMTPAuth = true;
$mail->Username = 'woldiauniversity.wumrts@gmail.com'; /* This is the sender of the bookings. */
$mail->Password = 'ijjvsqorjeuqcywi';


$mail->setFrom('dawitghiwot28@gmail.com');
$mail->addAddress($email, 'dave');
$mail->addReplyTo($email, $name); /* Reply to the user who submitted the form from the bookings email. */

 $conn = new mysqli('localhost', 'root', '', 'wumrts');

$mail->Subject = "Account created";
	        $mail->isHTML(true);
	        $mail->Body = "
	            Dear $n,<br><br>
	            
				Thank you for creating an account with Woldia university maintenance request tracking system. We are excited to have you join our community and look forward to providing you with a seamless and enjoyable experience.

With your new account. <br>
	            In order to login use your university id and  password<br>
	           <br><br>
	            
	            Kind Regards,<br>
	            Woldia university maintenance request tracking system
	        ";

	        if ($mail->send()){
			echo('Please Check Your Email Inbox!');}
    	   
 }}}}
?>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
