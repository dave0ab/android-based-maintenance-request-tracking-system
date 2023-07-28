
<?php

    $connection = mysqli_connect("localhost","root","","wumrts");    



	
	$id= $_POST["id"];
	$select33= "SELECT *from requests where id ='".$id."'";
	$responce333 = mysqli_query($connection,$select33);
	while($row12 = mysqli_fetch_array($responce333))
		{
			
			     $stat = $row12['16'];
			if($stat=="Reassigned"){
			
			echo "You have reassigned this request already";
			
			
			}else{
	$select11= "SELECT *from requests where id ='".$id."'";
	$responce11 = mysqli_query($connection,$select11);

	while($row = mysqli_fetch_array($responce11))
		{
			
	     $wuid = $row['13'];
	
	
	$select22= "SELECT *from technician where wuid ='".$wuid."'";
	$responce22 = mysqli_query($connection,$select22);

	while($row = mysqli_fetch_array($responce22))
		{
			
	
	$index['ongoingjobs']   = $row['8'];
	
	
$a=$index['ongoingjobs'] ;
	
	$a = $a + 1;
	 
	  $sql22 = "UPDATE technician SET  ongoingJobs ='$a' WHERE wuid = '$wuid'";
	//  $dt = date('Y-m-d');
	
	
	  $sql = "UPDATE requests SET  task_status='Reassigned' WHERE id = '$id' ";
	  
	$sql1 = "UPDATE reports SET  reassign_status='Reassigned' WHERE request_id = '$id' ";
	
	
	
   $result = mysqli_query($connection,$sql);

   $result1 = mysqli_query($connection,$sql1);
     $result3 = mysqli_query($connection,$sql22);

    if($result&&$result1){
		
		
		$action= $_POST["action"];
		 $logdata="username=".$action." = Reassigned technician for the request = ".$id. "assigned technician =". $wuid;
	  $seab = "INSERT INTO log(wuid,logdata) VALUES ('$action','$logdata')";
   $reb = mysqli_query($connection,$seab);
 
 if($reb){
	 
	  $data = $logdata.PHP_EOL;
	  $file = fopen("C:/xampp/htdocs/wumrts/log.txt", "a") or die("Unable to open file!"); // Opens file for writing
fwrite($file,$data);
fclose($file);
 }
 
        echo "Re-Assigned";

    }
    else{
        echo "Failed";
    }
	
		}}
		
		}}
    mysqli_close($connection);

   
   
	



?>