
<?php

    $connection = mysqli_connect("localhost","root","","wumrts");    



	
	$id= $_POST["id"];
	  $sql = "UPDATE requests SET  task_status='Rejected' WHERE id = '$id' ";
	
   $result = mysqli_query($connection,$sql);

    if($result){
		
		
		$action= $_POST["action"];
		 $logdata="username=".$action." = changed request status of =".$id."to rejected ";
	  $seab = "INSERT INTO log(wuid,logdata) VALUES ('$action','$logdata')";
   $reb = mysqli_query($connection,$seab);
 
 if($reb){
	 
	  $data = $logdata.PHP_EOL;
	  $file = fopen("C:/xampp/htdocs/wumrts/log.txt", "a") or die("Unable to open file!"); // Opens file for writing
fwrite($file,$data);
fclose($file);
	 
 }
        echo "Rejected";

    }
    else{
        echo "Failed";
    }
    mysqli_close($connection);

   
   
	



?>