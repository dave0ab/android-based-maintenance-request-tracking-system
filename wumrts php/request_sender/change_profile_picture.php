<?php
 
include 'config.php';
 
// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
 
 
 
    if($_SERVER['REQUEST_METHOD'] == 'POST')
 {
 $wuid = $_POST['wuid'];
 $ImageData = $_POST['image_data'];
  $ImageData1 = $_POST['image_data1'];
 
 $ImageName = $_POST['image_tag'];
 $ImageName1 = $_POST['image_tag1'];
 $ImagePath = "upload/$ImageName.jpg";
  $ImagePath1 = "upload1/$ImageName1.jpg";
 
 $ServerURL = "http://192.168.43.228:80//wumrts/request_sender/$ImagePath";
 $ServerURL1 = "http://192.168.43.228:80//wumrts/request_sender/$ImagePath1";
 
 
 
 
 
   $InsertSQL1 = "UPDATE request_sender SET imagepath='$ServerURL1' WHERE wuid='".$wuid."'";
 
 if(mysqli_query($conn, $InsertSQL1)){
 
 
 file_put_contents($ImagePath,base64_decode($ImageData));

 file_put_contents($ImagePath1,base64_decode($ImageData1));
 
  $action= $wuid;
		 $logdata="username=".$action."  changed its profile picture";
	  $seab = "INSERT INTO log(wuid,logdata) VALUES ('$action','$logdata')";
   $reb = mysqli_query($conn,$seab);

 if($reb){
	 
	  $data = $logdata.PHP_EOL;
	  $file = fopen("C:/xampp/htdocs/wumrts/log.txt", "a") or die("Unable to open file!"); // Opens file for writing
fwrite($file,$data);
fclose($file);
 }
 
 
 echo "Your Have Succesfully changed your profile picture.";
}
 else{
	 echo mysqli_error($conn);
	 
 }}
	
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

?>