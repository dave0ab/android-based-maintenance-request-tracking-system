<?php 

	$connection = mysqli_connect("localhost","root","","wumrts");	
	
	$result = array();
	$result['data'] = array();
	$department = "INFORMATION TECHNOLOGY";
    $status = "Not Allowed";
   $department = $_POST["wuid"];
    
	$select1= "SELECT *from reports WHERE tech_wuid = '".$department."' ORDER BY id asc";
	$responce = mysqli_query($connection,$select1);

	while($row = mysqli_fetch_array($responce))
		{     $index['id']      = $row['0'];
                $index['request_id']    = $row['1'];
				  $index['tech_wuid']    = $row['2'];
				   $index['sender_wuid']    = $row['3'];
                $index['message']    = $row['4'];
                $index['directorate']      = $row['5'];
				 $index['document_path']   = $row['6'];
				  $index['reported_date']   = $row['7'];
				 $index['status']    = $row['8'];
                
			array_push($result['data'], $index);
		}
			
			$result["success"]="1";
			echo json_encode($result);
			mysqli_close($connection);
 ?>