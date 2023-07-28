<?php 

	$connection = mysqli_connect("localhost","root","","wumrts");	
	$result = array();
	$result['data'] = array();
	 $wuid = $_POST["wuid"];
	$select= "SELECT *from technician WHERE wuid='$wuid'";
	$responce = mysqli_query($connection,$select);

	while($row = mysqli_fetch_array($responce))
		{
			$index['id']      = $row['0'];
			$index['fname']    = $row['1'];
			$index['lname']    = $row['2'];
			$index['wuid']    = $row['3'];
			
			$index['mobilenum']   = $row['5'];
			$index['imagepath']   = $row['6'];
				$index['facility']    = $row['7'];
			
			$index['workingstatus']    = $row['8'];
			
			
			
			array_push($result['data'], $index);
		}
			
			$result["success"]="1";
			echo json_encode($result);
			mysqli_close($connection);
 ?>