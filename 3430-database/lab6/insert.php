<?php
    if($_POST['firstname'] && $_POST['lastname'] && $_POST['age']){
    $con = mysql_connect("localhost","morrowtl","morr.sql"); if (!$con)
    {
        die('Could not connect: ' . mysql_error()); }
    mysql_select_db("my_db", $con);
    $sql="INSERT INTO Persons (FirstName, LastName, Age) VALUES ('$_POST[firstname]','$_POST[lastname]','$_POST[age]')";
    if (!mysql_query($sql,$con)) {
        die('Error: ' . mysql_error());
    }
    echo "1 record added";
    mysql_close($con);
    
    } else {
        ?>
<html> <body>
<form action="insert.php" method="post"> Firstname: <input type="text" name="firstname" /> Lastname: <input type="text" name="lastname" /> Age: <input type="text" name="age" />
<input type="submit" />
</form>
</body> </html>

<?php    } ?>