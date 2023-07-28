<?php 

	$connection = mysqli_connect("localhost","root","","wumrts");	
	$result = array();
	$result['data'] = array();
	
	$select= "SELECT *from account ORDER BY id desc" ;
	$responce = mysqli_query($connection,$select);

	while($row = mysqli_fetch_array($responce))
		{
			$index['id']      = $row['0'];
			$index['wuid']    = $row['1'];
			$index['role']    = $row['3'];
			$index['email']    = $row['4'];
			
			$index['status']   = $row['7'];
			$index['datecreated']   = $row['8'];
			
			
			
		//	$index['loginstatus']    = $row['7'];
			
			
			array_push($result['data'], $index);
		}
			
			$result["success"]="1";
			echo json_encode($result);
			mysqli_close($connection);
 ?>