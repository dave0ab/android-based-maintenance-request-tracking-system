<?php 

	$connection = mysqli_connect("localhost","root","","wumrts");	
	
	$result = array();
	$result['data'] = array();
	$department = "INFORMATION TECHNOLOGY";
    $status = "Not Allowed";
  
    
	$select1= "SELECT *from request_sender where department = '".$department."'  AND status = '".$status."'";
	$responce = mysqli_query($connection,$select1);

	while($row = mysqli_fetch_array($responce))
		{     $index['id']      = $row['0'];
                $index['fname']    = $row['1'];
				$index['lname']    = $row['1'];
                $index['wuid']    = $row['2'];
              
                $index['mobilenum']   = $row['4'];
                $index['gender']    = $row['5'];
                $index['imagepath']    = $row['6'];
                $index['department']    = $row['7'];
			  $index['status']    = $row['8'];
			array_push($result['data'], $index);
		}
			
			$result["success"]="1";
			echo json_encode($result);
			mysqli_close($connection);
 ?>