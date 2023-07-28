<?php

$connection = mysqli_connect("localhost","root","","wumrts");	  
    $id = $_POST["id"];
    $wuid = $_POST["wuid"];
	
	$name = $_POST["name"];
    $phone = $_POST["phone"];
	$faphone = $_POST["faphone"];
	$assd = $_POST["assdate"];
	$action= $_POST["action"];
	
	$select= "SELECT *from technician where wuid ='".$wuid."'";
	$responce = mysqli_query($connection,$select);

	while($row = mysqli_fetch_array($responce))
		{
			
	
	$index['ongoingjobs']   = $row['8'];
	
	
$a=$index['ongoingjobs'] ;
	
	$a = $a + 1;
	 
	  $sql1 = "UPDATE technician SET  ongoingJobs ='$a' WHERE wuid = '$wuid'";
	//  $dt = date('Y-m-d');
	 
    $sql = "UPDATE requests SET   technician= '$wuid' ,facility_manager_id='$action',fa_phone='$faphone',techname='$name', techphone ='$phone' ,	assigned_date='$assd' , task_status ='Assigned' WHERE id = '$id' ";

    $result = mysqli_query($connection,$sql);
 $result1 = mysqli_query($connection,$sql1);
 
    if($result&&$result1){
		
		$action= $_POST["action"];
		 $logdata="username=".$action." = Assigned technician for the request = ".$id. "  assigned technician =". $wuid;
	  $seab = "INSERT INTO log(wuid,logdata) VALUES ('$action','$logdata')";
   $reb = mysqli_query($connection,$seab);
 
 if($reb){}
 
  $data = $logdata.PHP_EOL;
	  $file = fopen("C:/xampp/htdocs/wumrts/log.txt", "a") or die("Unable to open file!"); // Opens file for writing
fwrite($file,$data);
fclose($file);
        echo "Data Updated";
		
	

    }
    else{
        echo "Failed";
		}}
    mysqli_close($connection);    
?>