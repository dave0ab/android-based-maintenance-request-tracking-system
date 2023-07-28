<?php

$conn = mysqli_connect("localhost","root","","wumrts");	  
     $id = $id = $_POST["wuid"];
	 $serial= $_POST["serial"];
	 $qrdata= $_POST["qrdata"];
     
    

        
		$sql21 = "SELECT COUNT(*) as count FROM inventory WHERE wuid = '".$id."' AND serial_no='".$serial."'And qr_data='".$qrdata."'";
 
 
 
	 
	$responce14 = mysqli_query($conn,$sql21);
	$row22 = mysqli_fetch_assoc($responce14);
$rowsEnteredToday22 = $row22['count'];
	
	if($rowsEnteredToday22 >0)
                
				{
	 
	 echo "This pc is woldia university property you can maintain it";
 }
 else{
	 echo "This pc is not woldia university property you can not maintain it";
 }
 
     //   echo "Data Updated";

   
    mysqli_close($conn);   

	
?>