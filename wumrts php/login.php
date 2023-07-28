 <?php 
$connection = mysqli_connect("localhost","root","","wumrts");	
	
		 
 $un = $_POST['wuid'];

 $pw = $_POST['password'];
	
	$result = array();
	$result['data'] = array();
	
	   $encoded=  md5($pw);
	
	$select= "SELECT *from account where wuid = '".$un."'";
    

	$responce = mysqli_query($connection,$select);
   
    if (mysqli_num_rows ( $responce )>=1){
		
		
		
	
	while($row = mysqli_fetch_array($responce))
            {
			$er=$row['2'];
			if($er==$encoded){
				
            $index['id']      = $row['0'];
			$index['wuid']    = $row['1'];
			$index['password']      = $row['2'];
		    $index['role']      = $row['3'];
			$ss=$row['7'];
               if($ss=="Allowed"){ 
			if($encoded==$index['password']) {
              //  array_push($result['data'], $index);
            if($index['role'] =='Maintenance Manager')
			{
		echo "maintenance_manager";
		
		   } else if($index['role'] =='Technician'){
			    echo "mcexpert";
		   }
		   else if($index['role'] =='Facility Manager'){
			   
			   echo "mchead";
		   }
		   else if($index['role'] =='client'){
			    echo "client"; 
		   }
			}
                
				   $action=$un;
   $logdata="username=".$action. " logged in to the system ";
	  $seab = "INSERT INTO log(wuid,logdata) VALUES ('$action','$logdata')";
   $reb = mysqli_query($connection,$seab);

 if($reb){
	 
	 
	  

	  $data = $logdata.PHP_EOL;
	  $file = fopen("C:/xampp/htdocs/wumrts/log.txt", "a") or die("Unable to open file!"); // Opens file for writing
fwrite($file,$data);
fclose($file);
 }
				
				
			}else
			{
				
				echo "Sorry you are not allowed to login \n Please contact the system admin";
			}
				
				
                	$result["success"]="1";
                    mysqli_close($connection);
	}
                    
		else{
				
				echo "Incorrect password";
				
			}	} }else 
				{
					echo "Incorrect username";
				}

?>