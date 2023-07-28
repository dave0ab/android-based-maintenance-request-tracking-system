<?php

    $connection = mysqli_connect("localhost","root","","demo1");    
    
    $address = date('r', time());
//$b = random_str(8, 'abcdefghijklmnopqrstuvwxyz');

$date = date('Y/m/d H:i');

$subject = 'REGISTER 11223344 here' ;
$search = ':' ;
$search1 = '/' ;
$trimmed = str_replace($search, '/', $date) ;
$trimmed2 = str_replace($search1,'0', $trimmed);
$trimmed1 = str_replace(" ",'0', $trimmed2);



  $file_name = "$trimmed1".".docx"; //name of your file
$server_path = "upload_dormitory_files/"; //server path to folder
//$web_path = "http://192.168.43.228:80/"; //web path to folder

$file = $server_path.$file_name;

	//file_put_contents($file,"");
$fp = fopen("php://input", 'r');
while ($buffer =  fread($fp, 8192)) {
file_put_contents($file,$buffer,FILE_APPEND | LOCK_EX);}
$ServerURL11 = "http://192.168.43.228:80//wumrts/request_sender/upl/$trimmed1.docx";
  

?>