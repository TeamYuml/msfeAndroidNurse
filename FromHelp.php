<?php
$user ='root';
$pass = '';
$db = 'project_grupowy_database';

$dp = new mysqli('localhost', $user, $pass, $db) or die("chuj ci w dupe");
echo 'git';

$sql = "SELECT idUser,imieUser,nazwiskoUser,emailUser,PESELUser,adresUser FROM usermsfe";
$result = $dp->query($sql);
if($result->num_rows >0)
{
	while($row[] = $result->fetch_assoc())
	{
		$tem = $row;
		$json = json_encode($tem);
	}
}	
else
{
	echo "Zadnych wynikow";
}
echo $json;
$dp->close();
?>