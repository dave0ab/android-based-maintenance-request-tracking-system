<?php

	$connection = mysqli_connect("localhost","root","","wumrts");	
	
	$result = array();
	$result['data'] = array();
	$department = "INFORMATION TECHNOLOGY";
    $status = "Not Allowed";
  
    	$id= "Not Assigned";
	$select= "SELECT *from request_sender";
	$responce = mysqli_query($connection,$select);

	while($row = mysqli_fetch_array($responce))
		{     
	            $index['id']= $row['0'];
                $index['fname']    = $row['1'];
                $index['lname']    = $row['2'];
				$index['wuid']    = $row['3'];
                $index['phone']      = $row['4'];
				
			 
			array_push($result['data'], $index);
		}
			
			$result["success"]="1";
			echo json_encode($result);
			mysqli_close($connection);
 ?>