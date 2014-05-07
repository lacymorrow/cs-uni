<html>
<head>
<title>Database Structure</title>
</head>
<body>
<p>
<?php
$mysql_access = mysql_connect("localhost", "lacymorr_admin", "musical0");
$query = "SHOW TABLES FROM lacymorr_wp";
$result = mysql_query($query) or die('Query failed: ' . mysql_error());
mysql_query("use lacymorr_wp");
while ($row = mysql_fetch_row($result)) {
    echo "Table: {$row[0]}<br />\n";
    $query = "SELECT * FROM {$row[0]}";
    $results = mysql_query($query) or die('Query failed: ' . mysql_error());
    while ($res = mysql_fetch_array($results)) {
	          echo "$res[0]  ";
	}
	echo "<br />\n";
}
mysql_close($mysql_access);
?>
</p>
</body>
</html>