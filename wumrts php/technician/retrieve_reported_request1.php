<?php 

	$connection = mysqli_connect("localhost","root","","wumrts");	
	
	$result = array();
	$result['data'] = array();
	$department = "INFORMATION TECHNOLOGY";
    $status = "Not Allowed";
     $department = $_POST["rid"];
    $wuid = $_POST["wuid"];
	$select1= "SELECT *from reports Where request_id = '".$department."' AND tech_wuid='".$wuid."' ORDER BY id asc";
	$responce = mysqli_query($connection,$select1);

    if (mysqli_num_rows ( $responce )>=1){
	while($row = mysqli_fetch_array($responce))
		
	
		{     
		
		$result["stat"]= "0011";
		$index['id']      = $row['0'];
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
	}else{
		
		$result["stat"]= "00";
		
		
	}
	
			$result["success"]="1";
			echo json_encode($result);
	mysqli_close($connection);
 ?>