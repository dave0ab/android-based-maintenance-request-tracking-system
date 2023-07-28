<?php 

	$connection = mysqli_connect("localhost","root","","wumrts");	
	
	$result = array();
	$result['data'] = array();
	$department = "INFORMATION TECHNOLOGY";
    $status = "Not Allowed";
  $wuid = $_POST['wuid']; 
    	$id= "Not Assigned";
	$select1= "SELECT *from requests WHERE technician = '$wuid' ";
	$responce = mysqli_query($connection,$select1);

	while($row = mysqli_fetch_array($responce))
		{     $index['id']      = $row['0'];
                $index['wuid']    = $row['1'];
				  $index['name']    = $row['2'];
                $index['buildingno']    = $row['3'];
                $index['officeno']      = $row['4'];
				 $index['phone']   = $row['5'];
				  $index['quantity']   = $row['6'];
				 $index['checkboxrequests']    = $row['7'];
                $index['priority']   = $row['8'];
				$index['additionalmessage']    = $row['9'];
				   $index['imagepath']    = $row['10'];
                $index['thing_to_fix']    = $row['11'];
                $index['facility']    = $row['12'];
				 $index['technician']    = $row['13'];
                $index['techname']    = $row['14'];
				 $index['techphone']    = $row['15'];
			  $index['task_status']    = $row['16'];
			  $index['assigned_time']    = $row['17'];
			  $index['assigned_date']    = $row['18'];
			   $index['requested_date']    = $row['19'];
			    $index['document_path']    = $row['20'];
				$index['fa_phone']    = $row['23'];
			 
			array_push($result['data'], $index);
		}
			
			$result["success"]="1";
			echo json_encode($result);
			mysqli_close($connection);
 ?>
 
 
 
 
 
 
 
 
 