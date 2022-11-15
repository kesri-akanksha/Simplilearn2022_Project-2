<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet"  href="style.css"/>
<center>
		<h1>Teacher Management</h1>
		
		<form action="addNewTeacher" method="post">
		<h3>ADD TEACHER</h3>
			Teacher Name: <input type="text" name="teacherName" size="45">
			<br /> <br /> <input type="submit" value="Submit" />
		</form>
		
		<form action="DeleteTeacher" method="post">
		<h3>DELETE TEACHER</h3>
         Teacher Name: <input type="text" name="teacherName" size="45">
         	<br /> <br /> <input type="submit" value="Submit" />	
		</form>


        
        

	</center>

</body>
</html>