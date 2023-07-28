<?php

    $connection = mysqli_connect("localhost","root","","backup");    
  		
		$result = array();
	$result['data'] = array();
	$select= "SELECT *from backup ORDER BY id desc";
	$responce = mysqli_query($connection,$select);

	if (mysqli_num_rows ( $responce )>=1){
                
                while($row = mysqli_fetch_array($responce))
                {
                   $index['id']      = $row['0'];
			$index['backupname']    = $row['1'];
			$index['backuppath']    = $row['2'];
			$index['datecreated']    = $row['3'];
			
		   
				  
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