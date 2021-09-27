<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="./base.jsp"%>
<%@ include file ="header.jsp"  %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<style>
a:link, a:visited {
	background-color: #f44336;
	color: white;
	padding: 14px 25px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
}

a:hover, a:active {
	background-color: red;
}
</style>
</head>
<body>

	<h2> dashboard </h2>
	<p></p>
	<a href="all-students" target="">Students</a>
	
	<!-- 
	<a href="student-years" target="">Students</a> -->
	
	<a href="all-subjects" target="" >Subjects</a>
	
	<a href="default.asp" target="">Exam / Marks</a>
	
	<a href="Attendance" target="">Attendance</a>
	<hr>
	<a href="showAllTeachers" target="">Teacher</a>
	
	<a href="teacher-subject-map" target="">Mapping</a>
	
	<a href="all-fees-structure" target="">Fees Structure</a>
	
	<a href="feedback" target="">FeedBack</a>
	

</body>
</html>

