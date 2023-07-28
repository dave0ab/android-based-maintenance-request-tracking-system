
<?php

    $connection = mysqli_connect("localhost","root","","wumrts");    



	
	$id= $_POST["id"];
	
	
	$select1= "SELECT *from requests where id = '".$id."' AND task_status='Rejected'";
    

	$responce1 = mysqli_query($connection,$select1);
   
    if (mysqli_num_rows ( $responce1 )>=1){
		
		
		
	  $sql = "UPDATE requests SET  task_status='Not Assigned' WHERE id = '$id' ";
	
   $result = mysqli_query($connection,$sql);

    if($result){
		
		
		$action= $_POST["action"];
		 $logdata="username=".$action." = changed request status of =".$id."to unrejected ";
	  $seab = "INSERT INTO log(wuid,logdata) VALUES ('$action','$logdata')";
   $reb = mysqli_query($connection,$seab);
 
 if($reb){
	 
	  $data = $logdata.PHP_EOL;
	  $file = fopen("C:/xampp/htdocs/wumrts/log.txt", "a") or die("Unable to open file!"); // Opens file for writing
fwrite($file,$data);
fclose($file);
	 
 }
		
		
        echo "Request Accepted(Unrejected)";

    }
    else{
        echo "Failed";
    }
	}
	else{
		
		echo "This request can not be Accepted(Unrejected)";
		
	}
    mysqli_close($connection);

   
   
	



?>