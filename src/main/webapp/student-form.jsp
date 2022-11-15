<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
 
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet"  href="style.css"/>
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"  
     url="jdbc:mysql://localhost/learnersacademy"  
     user="root"  password="12345"/>  
     
     <sql:query dataSource="${db}" var="ListClasses">  
select * from schoolclass;  
</sql:query>  

<center>
	<form action="addNewStudent" method="post">
	    	<h3>ADD STUDENT</h3>
		Student Name: <input type="text" name="studentName" required>
		&nbsp; 
		Select a Class:<select name="classes">
		
			<c:forEach items="${ListClasses.rows}" var="classes">
				<option value="${classes.class_id}">${classes.class_name}</option>
			</c:forEach>
			
		</select> <br />
		<br /> 
		
		<input type="submit" value="Submit" />
	</form>
	
	<form action="DeleteStudent" method="post">
		<h3>DELETE STUDENT</h3>
         Teacher Name: <input type="text" name="teacherName" size="45">
         	<br /> <br /> <input type="submit" value="Submit" />	
		</form>
	
</center>

</body>
</html>