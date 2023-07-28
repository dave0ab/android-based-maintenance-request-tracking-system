<?php

    $connection = mysqli_connect("localhost","root","","wumrts");    
  
  
		
		$result = array();
	$result['data'] = array();
	
	
	
	
 $select3= "SELECT *from account where   role ='client'  ORDER BY id DESC";

    $responce3 = mysqli_query($connection,$select3);
	



				
					while($row1 = mysqli_fetch_array($responce3))
		{
				
				$ab=$row1['1'];
				
				//echo $ab;
				$select= "SELECT *from request_sender where wuid='".$ab."' ORDER BY id DESC";
	$responce = mysqli_query($connection,$select);


	while($row = mysqli_fetch_array($responce))
		{
			$index['status']=$row1['7'];
                   $index['id']      = $row['0'];
			$index['fname']    = $row['1'];
			$index['lname']    = $row['2'];
			$index['wuid']    = $row['3'];
			
			$index['mobilenum']   = $row['4'];
			$index['gender']    = $row['5'];
			$index['imagepath']    = $row['6'];
	      //  $index['status']    =  $status;
			$index['job_title']    = $row['8'];
                

				   
				  
                array_push($result['data'], $index);
                }
                	
                  
            
                    
                }$result["success"]="1";
			echo json_encode($result);
			mysqli_close($connection);
	
 //   mysqli_close($connection);

?>