<?php

    $connection = mysqli_connect("localhost","root","","wumrts");    
  		 $department = $_POST['wuid'];
    
  
  
		
		$result = array();
	$result['data'] = array();
	$select= "SELECT *from facility_manager where wuid = '".$department."' ";
	$responce = mysqli_query($connection,$select);

	if (mysqli_num_rows ( $responce )>=1){
                
                while($row = mysqli_fetch_array($responce))
                {
                   $index['id']      = $row['0'];
			$index['fname']    = $row['1'];
			$index['lname']    = $row['2'];
			$index['wuid']    = $row['3'];
			
			$index['phone']   = $row['5'];
			
			$index['imagepath']    = $row['6'];
			$index['directoret']    = $row['7'];

				   
				  
                array_push($result['data'], $index);
                }
                	$result["success"]="1";
			echo json_encode($result);
			mysqli_close($connection);
                  
            
                    
                }
			

    else{
        echo "Failed";
    }
 //   mysqli_close($connection);

?>