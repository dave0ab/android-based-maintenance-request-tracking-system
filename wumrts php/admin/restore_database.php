<?php

 $path = $_POST['path'];
$host = "localhost";
$user = "dave";
$pass = "1234";

$dbname = "wumrts";
 $connection = mysqli_connect("localhost","dave","1234","wumrts");
$dest_folder = 'C:/xampp/htdocs/wumrts/admin/backup/';
$dest_folder1 = 'http://192.168.43.228:80//wumrts/admin/backup/';
$backup_file = $dest_folder . "wumrts" . '-' . date('Y-m-d-H-i-s') . '.sql';
$backup_file1 = $dest_folder1 . "wumrts" . '-' . date('Y-m-d-H-i-s') . '.sql';
chdir("C:/xampp/mysql/bin");

shell_exec("mysql -h $host -u $user -p$pass $dbname < $path");


	 $action= $_POST["action"];
		 $logdata="username=".$action." restored the database";
	  $seab = "INSERT INTO log(wuid,logdata) VALUES ('$action','$logdata')";
   $reb = mysqli_query($connection,$seab);
$data = $logdata.PHP_EOL;
	  $file = fopen("C:/xampp/htdocs/wumrts/log.txt", "a") or die("Unable to open file!"); // Opens file for writing
fwrite($file,$data);
fwrite($file,"\n"); // Writes the text to the file
fclose($file);
	 
	 



echo "succefully restored";
	 
?>