
<?php

    $connection = mysqli_connect("localhost","root","","wumrts");    



	
	$id= $_POST["id"];
	  $sql = "UPDATE account SET  status='Not Allowed' WHERE wuid = '$id' ";
	
   $result = mysqli_query($connection,$sql);

    if($result){
       	$action=$_POST["action"];
  $logdata="username=".$action."  deactivated account of=".$id;
	  $seab = "INSERT INTO log(wuid,logdata) VALUES ('$action','$logdata')";
   $reb = mysqli_query($connection,$seab);

 if($reb){
	 
 $data = $logdata.PHP_EOL;
	  $file = fopen("C:/xampp/htdocs/wumrts/log.txt", "a") or die("Unable to open file!"); // Opens file for writing
fwrite($file,$data);
fclose($file);
	 
 } 
 
 echo "deleted";

    }
    else{
        echo "Failed";
    }
    mysqli_close($connection);

   
   



?>