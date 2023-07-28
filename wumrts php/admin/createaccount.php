<?php


use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;
require 'PHPMailer/Exception.php';
require 'PHPMailer/PHPMailer.php';
require 'PHPMailer/SMTP.php';
    require_once "functions.php";

function generateRandomString($length) {
    $characters = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    $randomString = '';
    for ($i = 0; $i < $length; $i++) {
        $randomString .= $characters[rand(0, strlen($characters) - 1)];
    }
    return $randomString;
}

// Usage: generate a random string of length 10
 $passwordstr=generateRandomString(8);



    $connection = mysqli_connect("localhost","root","","wumrts");    
    $usertype = $_POST['usertype'];
 $email = $_POST['email'];
if($usertype=='Admin'){
	
	
	  $fname = $_POST["fname"];
	    $lname = $_POST["lname"];
	   $wuid = $_POST["wuid"];
    $email = $_POST["email"];
    $contact = $_POST["contact"];
	   $gender = $_POST["gender"];
	   $facility = $_POST["facility"];  
	   
   
	   
 $password = md5($passwordstr);
 
	 $ImageData = $_POST['image_data'];
 
 $ImageName = $_POST['image_tag'];
 
 $ImagePath = "profilepicture/$ImageName.jpg";
 
 
	$select= "SELECT *from account where wuid = '".$wuid."'";
    $select1= "SELECT *from account where email = '".$email."'";

	$responce = mysqli_query($connection,$select);
	$responce1 = mysqli_query($connection,$select1);
   
   if (mysqli_num_rows ( $responce )>=1){
 
  echo "University id already exists"; 
	}else{
   
    if (mysqli_num_rows ( $responce1 )>=1){
 
  echo "Email address already exists"; 
	}else{
 
   $InsertSQL1 = "INSERT INTO account (wuid,password,role,email,status) values('$wuid','$password','$usertype','$email','Allowed')";
 
 if(mysqli_query($connection, $InsertSQL1))
 {
	 
	 
 
 $ServerURL = "http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg";
    $sql = "INSERT INTO admin(fname,lname,wuid,sex,phone,imagepath) VALUES ('$fname','$lname','$wuid','$gender','$contact','$ServerURL')";
   $result = mysqli_query($connection,$sql);

 if($result){
 
 file_put_contents($ImagePath,base64_decode($ImageData));
 
 


	
	
	    $connection = mysqli_connect("localhost","root","","wumrts");    
 //$un = $_POST['wuid'];

 $email = $_POST['email'];
 


	
	
	  $select3= "SELECT *from account where  email = '".$email."'";

	
    $responce3 = mysqli_query($connection,$select3);
	
	
	 //$n = $_POST['name'];
	
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
$fname = $_POST["fname"];
	   
	   $wuid = $_POST["wuid"];

$mail->setFrom('dawitghiwot28@gmail.com');
$mail->addAddress($email, 'dave');
$mail->addReplyTo($email, $name); /* Reply to the user who submitted the form from the bookings email. */

 $conn = new mysqli('localhost', 'root', '', 'wumrts');

$mail->Subject = "Account created";
	        $mail->isHTML(true);
	        $mail->Body = "
	            Dear $fname,<br><br>
	            
				Thank you for creating an account with Woldia university maintenance request tracking system. We are excited to have you join our community and look forward to providing you with a seamless and enjoyable experience.

With your new account <br>

<br>
	            In order to login use your university id=($wuid) and  password=($passwordstr)<br>
				<br> Then please change your password for security purposes.
	           <br><br>
	            
	            Kind Regards,<br>
	            Woldia university maintenance request tracking system
	        ";

	        if ($mail->send()){
				
				
				
				
				

			echo('Please Check Your Email Inbox!');}
    	  






		  
		}


 
 
 
 
 
 
 	 
	 $action= $_POST["action"];
		 $logdata="username=".$action." created account for ". $wuid;
	  $seab = "INSERT INTO log(wuid,logdata) VALUES ('$action','$logdata')";
   $reb = mysqli_query($connection,$seab);

	 
	 
  $data = $logdata.PHP_EOL;
	  $file = fopen("C:/xampp/htdocs/wumrts/log.txt", "a") or die("Unable to open file!"); // Opens file for writing
fwrite($file,$data);
fclose($file);
 
 
 
 echo "Account created"; 
 }
 else{
 echo "Please Try Again";

 
 mysqli_close($connection);
 }

}}}}


    
    

   
   
	

if($usertype=='Facility Manager'){
	  $connection = mysqli_connect("localhost","root","","wumrts");    
	
	   $fname = $_POST["fname"];
	    $lname = $_POST["lname"];
	   $wuid = $_POST["wuid"];
    $email = $_POST["email"];
    $contact = $_POST["contact"];
	   $gender = $_POST["gender"];
	   $facility = $_POST["facility"];  
	  
	    
	   
   $password = md5($passwordstr);
   
   
   $ImageData = $_POST['image_data'];
 
 $ImageName = $_POST['image_tag'];
 
 $ImagePath = "profilepicture/$ImageName.jpg";
 
 
 
 $ServerURL = "http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg";
 
 
 
 $select= "SELECT *from account where wuid = '".$wuid."'";
    $select1= "SELECT *from account where email = '".$email."'";

	$responce = mysqli_query($connection,$select);
	$responce1 = mysqli_query($connection,$select1);
   
   if (mysqli_num_rows ( $responce )>=1){
 
  echo "University id already exists"; 
	}else{
   
    if (mysqli_num_rows ( $responce1 )>=1){
 
  echo "Email address already exists"; 
	}else{
   
       $InsertSQL1 = "INSERT INTO account (wuid,password,role,email,status) values('$wuid','$password','$usertype','$email','Allowed')";
 
if(mysqli_query($connection, $InsertSQL1))
 {
	$select1= "SELECT *from directorates where dname = '".$facility."' ";
	$responce1 = mysqli_query($connection,$select1);
	while($row = mysqli_fetch_array($responce1))
	{
				
					$index['did']    = $row['1'];
 
   $fac=	$index['did'] ;
   
   
   
    $sql = "INSERT INTO facility_manager(fname,lname,wuid,sex,phone,imagepath,directoret) VALUES ('$fname','$lname','$wuid','$gender','$contact','$ServerURL','$fac')";
   $result = mysqli_query($connection,$sql);

      if($result){
 
 file_put_contents($ImagePath,base64_decode($ImageData));
 
 
 
 
 

	    $connection = mysqli_connect("localhost","root","","wumrts");    
 //$un = $_POST['wuid'];

 $email = $_POST['email'];
 


	
	
	  $select3= "SELECT *from account where  email = '".$email."'";

	
    $responce3 = mysqli_query($connection,$select3);
	
	
	 //$n = $_POST['name'];
	
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
$fname = $_POST["fname"];
	   
	   $wuid = $_POST["wuid"];

$mail->setFrom('dawitghiwot28@gmail.com');
$mail->addAddress($email, 'dave');
$mail->addReplyTo($email, $name); /* Reply to the user who submitted the form from the bookings email. */

 $conn = new mysqli('localhost', 'root', '', 'wumrts');

$mail->Subject = "Account created";
	        $mail->isHTML(true);
	        $mail->Body = "
	            Dear $fname,<br><br>
	            
				Thank you for creating an account with Woldia university maintenance request tracking system. We are excited to have you join our community and look forward to providing you with a seamless and enjoyable experience.

With your new account <br>

<br>
	            In order to login use your university id=($wuid) and  password=($passwordstr)<br>
				<br> Then please change your password for security purposes.
	           <br><br>
	            
	            Kind Regards,<br>
	            Woldia university maintenance request tracking system
	        ";

	        if ($mail->send()){
			echo('Please Check Your Email Inbox!');}
    	   
		}


 
 
 
 
 
 
 
	 $action= $_POST["action"];
		 $logdata="username=".$action." created account for ". $wuid;
	  $seab = "INSERT INTO log(wuid,logdata) VALUES ('$action','$logdata')";
   $reb = mysqli_query($connection,$seab);
 
 
 
 
 
 
 
 
 
 
 
 
 
 echo "Account created"; mysqli_close($connection);
 }
 else{
 echo "Please Try Again";
 mysqli_close($connection);
 
 }}
}
}}}
if($usertype=='Technician'){
	
	   $fname = $_POST["fname"];
	    $lname = $_POST["lname"];
	   $wuid = $_POST["wuid"];
    $email = $_POST["email"];
    $contact = $_POST["contact"];
	   $gender = $_POST["gender"];
	   $facility = $_POST["facility"];  
	  
	 
	   
   $password = md5($passwordstr);
   
      $ImageData = $_POST['image_data'];
 
 $ImageName = $_POST['image_tag'];
 
 $ImagePath = "profilepicture/$ImageName.jpg";
 
 $select= "SELECT *from account where wuid = '".$wuid."'";
    $select1= "SELECT *from account where email = '".$email."'";

	$responce = mysqli_query($connection,$select);
	$responce1 = mysqli_query($connection,$select1);
   
   if (mysqli_num_rows ( $responce )>=1){
 
  echo "University id already exists"; 
	}else{
   
    if (mysqli_num_rows ( $responce1 )>=1){
 
  echo "Email address already exists"; 
	}else{
 
 
 
     $InsertSQL1 = "INSERT INTO account (wuid,password,role,email,status) values('$wuid','$password','$usertype','$email','Allowed')";
 
if(mysqli_query($connection, $InsertSQL1))
 {
	
 
$ServerURL = "http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg";
 
 $select1= "SELECT *from directorates where dname = '".$facility."' ";
	$responce1 = mysqli_query($connection,$select1);
	while($row = mysqli_fetch_array($responce1))
                
				{
					$index['did']    = $row['1'];
 
  $fac=	$index['did'] ;
 
   
   
    $sql = "INSERT INTO technician(fname,lname,wuid,sex,phone,imagepath,directoret,ongoingjobs) VALUES ('$fname','$lname','$wuid','$gender','$contact','$ServerURL','$fac',0)";
   $result = mysqli_query($connection,$sql);

     if($result){
 
 file_put_contents($ImagePath,base64_decode($ImageData));
 
 

	
	    $connection = mysqli_connect("localhost","root","","wumrts");    
 //$un = $_POST['wuid'];

 $email = $_POST['email'];
 


	
	
	  $select3= "SELECT *from account where  email = '".$email."'";

	
    $responce3 = mysqli_query($connection,$select3);
	
	
	 //$n = $_POST['name'];
	
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
$fname = $_POST["fname"];
	   
	   $wuid = $_POST["wuid"];

$mail->setFrom('dawitghiwot28@gmail.com');
$mail->addAddress($email, 'dave');
$mail->addReplyTo($email, $name); /* Reply to the user who submitted the form from the bookings email. */

 $conn = new mysqli('localhost', 'root', '', 'wumrts');

$mail->Subject = "Account created";
	        $mail->isHTML(true);
	        $mail->Body = "
	            Dear $fname,<br><br>
	            
				Thank you for creating an account with Woldia university maintenance request tracking system. We are excited to have you join our community and look forward to providing you with a seamless and enjoyable experience.

With your new account <br>

<br>
	            In order to login use your university id=($wuid) and  password=($passwordstr)<br>
				<br> Then please change your password for security purposes.
	           <br><br>
	            
	            Kind Regards,<br>
	            Woldia university maintenance request tracking system
	        ";

	        if ($mail->send()){
			echo('Please Check Your Email Inbox!');}
    	   
		}


 
 
 
 
 
	 $action= $_POST["action"];
		 $logdata="username=".$action." created account for ". $wuid;
	  $seab = "INSERT INTO log(wuid,logdata) VALUES ('$action','$logdata')";
   $reb = mysqli_query($connection,$seab);
 
 
 
 
 
 
 
 
 
 
 
 echo "Account created"; mysqli_close($connection);
 }
 else{
 echo "Please Try Again";
 mysqli_close($connection);
 }
 }
	
}else{
 echo "Please Try Again".mysqli_error($connection);
 
 }

}}}

























?>