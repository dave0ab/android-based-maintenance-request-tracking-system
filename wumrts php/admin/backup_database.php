<?php
 $connection = mysqli_connect("localhost","dave","1234","backup");
$dest_folder = 'C:/xampp/htdocs/wumrts/admin/backup/';
$dest_folder1 = 'C:/xampp/htdocs/wumrts/admin/backup/';
$backup_file = $dest_folder . "wumrts" . '-' . date('Y-m-d-H-i-s') . '.sql';
$backup_file1 = $dest_folder1 . "wumrts" . '-' . date('Y-m-d-H-i-s') . '.sql';
chdir("C:/xampp/mysql/bin");
shell_exec("mysqldump --host=localhost --user=dave --password=1234 wumrts >$backup_file");

    
$f="wumrts" . '-' . date('Y-m-d-H-i-s') ;

 $InsertSQL1 = "INSERT INTO backup (backupname,backuppath) values('$f','$backup_file1')";
 
 if(mysqli_query($connection, $InsertSQL1))
 {
	 
	 
	 
	 $action= $_POST["action"];
		 $logdata="username=".$action." backedup the database";
	  $seab = "INSERT INTO log(wuid,logdata) VALUES ('$action','$logdata')";
   $reb = mysqli_query($connection,$seab);

	  $data = $logdata.PHP_EOL;
	  $file = fopen("C:/xampp/htdocs/wumrts/log.txt", "a") or die("Unable to open file!"); // Opens file for writing
fwrite($file,$data);
fclose($file);
	 
	 echo "succesfully backedup"; 
 }
 else
 {
 echo "failed";
 }
	 
?>