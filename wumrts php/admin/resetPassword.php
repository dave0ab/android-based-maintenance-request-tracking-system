<?php
	require_once "functions.php";

	if (isset($_GET['email']) && isset($_GET['token'])) {
		$conn = new mysqli('localhost', 'root', '', 'wumrts');

		$email = $conn->real_escape_string($_GET['email']);
		$token = $conn->real_escape_string($_GET['token']);

		$sql = $conn->query("SELECT *from account WHERE
			email='$email' AND token='$token' AND token<>'' AND tokenExpire > NOW()
		");

		if ($sql->num_rows > 0) {
			$newPassword = generateNewString();
			$str = md5($newPassword);
			//$newPasswordEncrypted = password_hash($str, PASSWORD_BCRYPT);
			$conn->query("UPDATE account SET token='', password = '$str'
				WHERE email='$email'
			");

		
		
 $select3= "SELECT *from account WHERE
			email='$email' ";

    $responce3 = mysqli_query($conn,$select3);
	

while($row1 = mysqli_fetch_array($responce3))
		{
				$ab=$row1['1'];
			
		           echo "Your university id is  Is $ab";
		}
		   
		   
		   
		   
			echo "<br>Your New Password Is $newPassword";
		} else
			echo "Your New Passwor";
	} else {
		redirectToLoginPage();
	}
?>
