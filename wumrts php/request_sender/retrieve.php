<?php 

	$connection = mysqli_connect("localhost","root","","wumrts");	
	$result = array();
	$result['data'] = array();
	$un= $_POST["wuid"];
	$select= "SELECT *from useracccount where wuid = '".$un."'";
	$responce = mysqli_query($connection,$select);

	while($row = mysqli_fetch_array($responce))
		{
			$index['id']      = $row['0'];
			$index['username']    = $row['1'];
			$index['name']    = $row['2'];
			$index['status']   = $row['7'];
			
			
			array_push($result['data'], $index);
		}
			
			$result["success"]="1";
			echo json_encode($result);
			mysqli_close($connection);
 ?>