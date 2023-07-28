<?php
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;
require 'PHPMailer/Exception.php';
require 'PHPMailer/PHPMailer.php';
require 'PHPMailer/SMTP.php';
require 'PHPMailerAutoload.php';


            $mail = new PHPMailer();

            $mail->isSMTP();                       // telling the class to use SMTP
            $mail->SMTPDebug = 2;                  
            // 0 = no output, 1 = errors and messages, 2 = messages only.

            $mail->SMTPAuth = true;                // enable SMTP authentication
            $mail->SMTPSecure = "tls";              // sets the prefix to the servier
            $mail->Host = "smtp.gmail.com";        // sets Gmail as the SMTP server
            $mail->Port = 587;                     // set the SMTP port for the GMAIL

            $mail->Username = "pradeep001.thakur@gmail.com";  // Gmail username
            $mail->Password = "********";      // Gmail password

            $mail->CharSet = 'windows-1250';
            $mail->SetFrom ('dawitghiwot28@gmail.com'); // send to mail
            $mail->AddBCC ( 'dave0ab@gmail.com'); // send to mail
            $mail->Subject = "abcd";
            $mail->ContentType = 'text/plain';
            $mail->isHTML(false);

            $body_of_your_email ="Hello Pradeep";
            $mail->Body = $body_of_your_email; 
            // you may also use $mail->Body =       file_get_contents('your_mail_template.html');
            $mail->AddAddress ('pradeep001.thakur@gmail.com', 'Recipients Name');     
            // you may also use this format $mail->AddAddress ($recipient);

           if(!$mail->Send())
           {
              echo   $error_message = "Mailer Error: " . $mail->ErrorInfo;
            } else 
           {
           echo   $error_message = "Successfully sent!";
           }
		   ?>