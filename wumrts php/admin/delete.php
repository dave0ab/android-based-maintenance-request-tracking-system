
<?php

    $connection = mysqli_connect("localhost","root","","wumrts");    
    $usertype = $_POST["usertype"];
	$id= $_POST["id"];

if($usertype=='Admin'){
	
	$id= $_POST["id"];
	 
	 $sql =  $sql = "UPDATE account SET  tatus='Not allowed' WHERE id = '$id' ";
	 

    
   $result = mysqli_query($connection,$sql);

    if($result){
        echo "deleted";

    }
    else{
        echo "Failed";
    }
    mysqli_close($connection);

   
   
	
}
if($usertype=='Maintenance Head'){
	
	
	 $id= $_POST["id"];
	$sql =  $sql = "UPDATE account SET  tatus='Not allowed' WHERE id = '$id' ";
   
   $result = mysqli_query($connection,$sql);

    if($result){
        echo "deleted";

    }
    else{
        echo "Failed";
    }
    mysqli_close($connection);

	
}

if($usertype=='Maintenance Expert'){
	
	
	
	

	  $id= $_POST["id"];
	  
	  
	$sql =  $sql = "UPDATE account SET  tatus='Not allowed' WHERE id = '$id' ";
    
   $result = mysqli_query($connection,$sql);

    if($result){
        echo "deleted";

    }
    else{
        echo "Failed";
    }
    mysqli_close($connection);


	
}



?>