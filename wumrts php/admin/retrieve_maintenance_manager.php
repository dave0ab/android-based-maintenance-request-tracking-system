<?php 

	$connection = mysqli_connect("localhost","root","","wumrts");	
	$result = array();
	$result['data'] = array();
	 $id= "mm"
	$select= "SELECT *from admin  where wuid='$id' ORDER BY id desc";
	
	$responce = mysqli_query($connection,$select);

	while($row = mysqli_fetch_array($responce))
		{
			$index['id']      = $row['0'];
			$index['fname']    = $row['1'];
			$index['lname']    = $row['2'];
			$index['wuid']    = $row['3'];
			$index['phone']    = $row['5'];
		
			
			
			array_push($result['data'], $index);
		}
			
			$result["success"]="1";
			echo json_encode($result);
			mysqli_close($connection);
 ?>