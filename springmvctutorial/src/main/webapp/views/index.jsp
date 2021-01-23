<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Model View Controller-MVC Tutorial</title>
</head>
<body>
	<h1>Welcome to Spring MVC Course!</h1>
	<p>
       Spring Boot makes project creation easy!<br>
       Spring Boot is the most common Framework in the market.	
	</p><hr>
	<p>
	  <h1>Get two integers from user</h1>
	  <form action ="add">
	  	Enter First Integer: <input type="text" name ="n1">
	  	<br><br>
	  	Enter Second Integer: <input type="text" name ="n2">
	  	<br><br>
	  	<input type="submit">
	  </form>
	  
	  
	 <h1>Add a student...</h1>
	<form action = "addStudent", method = "post">
		Enter student id: <input type="text" name="id">
		<br><br>
		Enter student name: <input type="text" name="name">
		<br><br>
		<input type="submit">
	</form>  
	
	<h1>Get All Students</h1>
	<form action = "getStudent", method = "get">
	
	<h1>Get All Students</h1>
	<form action = "getStudent1", method = "get">
		
		<h1>Get a student by using id...</h1>
	<form action = "getStudentWithId", method = "get">
		Enter student id: <input type="text" name="id">
		<input type="submit">
	</form> 
	<a href ="/about">About Us</a>
	<hr>
	<a href ="/index1">Index-1</a>
	
</body>
</html>