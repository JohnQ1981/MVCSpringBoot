<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result of Adding Integer 1 and Integer 2</title>
</head>
<body>
<h1> Results:</h1>
<br>
Result of Addition operation is: ${sumOfTwoIntegers} <br><br>
Result of Multiplication operation is: ${productOfTwoIntegers}
<hr>
<br>
Result of Addition operation is: ${sumOfNumbers} <br><br>
Result of Multiplication operation is: ${productOfNumbers}
<hr>

<h1>Students Added</h1>
<p>
Student 1 Added is: ${studentObject}
<br>
Student 2 added is : 
<hr>
<h1>Greetings:</h1>
Welcome Back : ${GreetStudent}<br>
Your Id is : ${StudentID}
<hr>


<h1>Student List:</h1>
All Students : ${studentList}<br>
<h1>Student List1:</h1>
All Students : ${studentList1}<br>
<hr>
<h1>Get Specific Student with Id</h1>
The Student that you wanted to see is : ${specificStudent}
<hr>
<h1>Get student with id:</h1>
	The student is ${specificStudent}
</body>
</html>