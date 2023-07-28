
<?php


    $connection = mysqli_connect("localhost","root","","wumrts");    
	
	
 $a1=$_POST["a1"];
  $b1=$_POST["b1"];
 $c1=$_POST["c1"];
 $d1=$_POST["d1"];
  
	  $sql = "INSERT INTO inventory(wuid,device,serial_no,qr_data) VALUES ('$a1','$b1','$c1','$d1')";
	
   $result = mysqli_query($connection,$sql);

    if($result){
		
		
		  
   $action=$_POST["action"];
   $logdata="username=".$action. " inserted inventory data ";
	  $seab = "INSERT INTO log(wuid,logdata) VALUES ('$action','$logdata')";
   $reb = mysqli_query($connection,$seab);

 if($reb){}
		
		 $data = $logdata.PHP_EOL;
	  $file = fopen("C:/xampp/htdocs/wumrts/log.txt", "a") or die("Unable to open file!"); // Opens file for writing
fwrite($file,$data);
fclose($file);
        echo "inventory data add";

    }
    else{
        echo "Failed";
    }
    mysqli_close($connection);

   
   
            
                    

	
	
	
	
	
	
	
	



?>