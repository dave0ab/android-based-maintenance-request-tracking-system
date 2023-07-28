 <?php 

	$connection = mysqli_connect("localhost","root","","wumrts");	
	
		 
 $un = $_POST['wuid'];



    $select3= "SELECT *from account where wuid = '".$un."'AND role ='client'";

    $responce3 = mysqli_query($connection,$select3);
	


			if (mysqli_num_rows ( $responce3 )>=1){
                
                while($row = mysqli_fetch_array($responce3))
                {
              
                $index['status']    = $row['7'];
                $bg=$row['7'];
if($bg=="Not Allowed"){
				     echo "failed"; 
}else {
	echo "ok";
}
                  //  array_push($result['data'], $index);
                }
                
                    mysqli_close($connection);
            
                    
                }

?>