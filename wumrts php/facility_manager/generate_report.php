<?php
// Get the start and end date parameters from the URL
$startDate = $_GET["start_date"];
$endDate = $_GET["end_date"];
	$result = array();
	$result['data'] = array();
// Create a MySQL connection
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "wumrts";
$conn = mysqli_connect($servername, $username, $password, $dbname);

// Check the connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

// Create a query to select the inserted data for the specified date range
$query = "SELECT * FROM requests WHERE requested_date BETWEEN '$startDate' AND '$endDate'";

// Execute the query and generate the report
$result12 = mysqli_query($conn, $query); 

if (mysqli_num_rows($result12) > 0) {


	$count = mysqli_num_rows($result12);
	echo "Number of Retrieved request from the starting date ".$startDate." to the ending date ".$endDate." is= ". $count . PHP_EOL. PHP_EOL ;
    while($row = mysqli_fetch_array($result12)) {
		
		
	echo"[ Request_id=".$row['0']." Request sender id=".$row['1']. PHP_EOL. " Facility manager id=".$row['8']. " Technician id=".$row['13']." ]" . PHP_EOL . PHP_EOL;
			
		
    }
	 
	
	
} else {
    echo "1";
}

// Close t	mysqli_close($connection);he connection
mysqli_close($conn);
?>