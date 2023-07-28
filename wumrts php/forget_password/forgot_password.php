<?php
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;
require 'PHPMailer/Exception.php';
require 'PHPMailer/PHPMailer.php';
require 'PHPMailer/SMTP.php';
    require_once "functions.php";
	
	
	    $connection = mysqli_connect("localhost","root","","wumrts");    
 //$un = $_POST['wuid'];

 $email = $_POST['email'];
 


	
	
	  $select3= "SELECT *from account where  email = '".$email."'";

	
    $responce3 = mysqli_query($connection,$select3);
	
	
	
	
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

        $email = $conn->real_escape_string($email);

        $sql = $conn->query("SELECT email FROM account WHERE email='$email'");
        if ($sql->num_rows > 0) {

            $token = generateNewString();

	        $conn->query("UPDATE account SET token='$token', 
                      tokenExpire=DATE_ADD(NOW(), INTERVAL 5 MINUTE)
                      WHERE email='$email'
            ");

		}







$mail->Subject = "Reset Password";
	        $mail->isHTML(true);
	        $mail->Body = "
	            Hi,<br><br>
	            
	            In order to reset your password, please click on the link below:<br>
	            <a href='http://192.168.43.228:80/wumrts/forget_password/resetPassword.php?email=$email&token=$token'>http://192.168.43.228:80/wumrts/forget_password/resetPassword.php?email=$email&token=$token</a>
				<br><br>
	            
	            Kind Regards,<br>
	            Woldia university maintenance request tracking system
	        ";

	        if ($mail->send()){
			echo('Please Check Your Email Inbox!');}
    	   
		}else{
			echo "Your ID or EMAIL is invalid".mysqli_error($connection);
		}
?>