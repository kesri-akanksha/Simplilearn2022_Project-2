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
		<h1>Class Management</h1>
		
		
		<form action="addNewClass" method="post">
		<h3>ADD CLASS</h3>
		Class Name:<input type="text" name="className" required>
		
		<input type="submit" value="submit">

		</form>
		
		<form action="DeleteClass" method="post">
		<h3>DELETE CLASS</h3>
         Class Name: <input type="text" name="teacherName" size="45">
         	<br /> <br /> <input type="submit" value="Submit" />	
		</form>
		
	</center>
</body>
</html>