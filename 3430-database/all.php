<html>
<head>
<title>Database Structure</title>
</head>
<body>
<p>
<?php
$mysql_access = mysql_connect("student.cs.appstate.edu", "morrowtl", "musical0");
$query = "SHOW TABLES FROM morrowtl;";
$result = mysql_query($query) or die('Query failed: ' . mysql_error());

while ($row = mysql_fetch_row($result)) {
    echo "Table: {$row[0]}\n";
}
mysql_close($mysql_access);
?>
</p>
</body>
</html>