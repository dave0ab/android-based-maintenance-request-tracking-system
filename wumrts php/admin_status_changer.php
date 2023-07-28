<?php
 
include 'config.php';
 
// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
 
 if($_SERVER['REQUEST_METHOD'] == 'POST')
 {
 $DefaultId = 0;
 
 $id = $_POST['id'];
 
 
 
 $updateSQL = "UPDATE INTO useraccount SET status='1' where id='$id'";
 
 if(mysqli_query($conn, $updateSQL)){
 

 
 echo "Client Status changed.";
 }
 
 mysqli_close($conn);
 }else{
 echo "Please Try Again";
 }
 
?>