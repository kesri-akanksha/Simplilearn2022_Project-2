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
		<h1>Subject Management</h1>
		
		<form action="addNewSubject" method="post">
		<h3>ADD SUBJECT</h3>
			Subject Name: <input type="text" name="subjectName" size="45">
			<br /> <br /> <input type="submit" value="Submit" />
		</form>
		
		<form action="DeleteSubject" method="post">
		<h3>DELETE SUBJECT</h3>
         Subject Name: <input type="text" name="teacherName" size="45">
         	<br /> <br /> <input type="submit" value="Submit" />	
		</form>
		
		
		

	</center>

</body>
</html>