<?php 

	$connection = mysqli_connect("localhost","root","","wumrts");	
	$department ="INFORMATION TECHNOLOGY";
    $status = "Not Allowed";
	$result = array();
	$result['data'] = array();
		$select= "SELECT *from request_sender ORDER BY id desc";
	$responce = mysqli_query($connection,$select);

	while($row = mysqli_fetch_array($responce))
		{
			$index['id']      = $row['0'];
			$index['fname']    = $row['1'];
			$index['lname']    = $row['2'];
			$index['wuid']    = $row['3'];
			
			$index['mobilenum']   = $row['4'];
			$index['gender']    = $row['5'];
			$index['imagepath']    = $row['6'];
			$index['status']    = $row['8'];
			$index['job_title']    = $row['9'];
			
			array_push($result['data'], $index);
		}
			
			$result["success"]="1";
			echo json_encode($result);
			mysqli_close($connection);
 ?>