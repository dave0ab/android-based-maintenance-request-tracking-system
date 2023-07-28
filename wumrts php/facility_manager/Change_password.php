
<?php

    $connection = mysqli_connect("localhost","root","","wumrts");    
 $un = $_POST['wuid'];
 
$password1 = $_POST['oldpassword'];
	  $pw = md5($password1);
  $password2 = $_POST['newpassword'];
  $newpassword=md5($password2);
	   

	
	
	  $select3= "SELECT *from account where wuid = '".$un."'  AND password = '".$pw."'";

	
    $responce3 = mysqli_query($connection,$select3);
	
	
	
	
		if (mysqli_num_rows ( $responce3 )>=1){
                
  
	  $sql = "UPDATE account SET  password='$newpassword' WHERE wuid = '$un' ";
	
   $result = mysqli_query($connection,$sql);

    if($result){
		
		
		 $action= $un;
		 $logdata="username=".$action." = changed its password ";
	  $seab = "INSERT INTO log(wuid,logdata) VALUES ('$action','$logdata')";
   $reb = mysqli_query($connection,$seab);
 
 if($reb){
	 
	 
	  $data = $logdata.PHP_EOL;
	  $file = fopen("C:/xampp/htdocs/wumrts/log.txt", "a") or die("Unable to open file!"); // Opens file for writing
fwrite($file,$data);
fclose($file);
 }
        echo "password changed";

    }
    else{
        echo "Failed";
    }
    mysqli_close($connection);

                
                }
				
				else{
					echo mysqli_error($connection);
					}
	
	
?>