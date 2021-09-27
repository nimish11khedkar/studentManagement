<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<style>
a:link, a:visited {
	background-color: #f44336;
	color: white;
	padding: 44px 25px;
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

	<h2>Link Button</h2>
	<p>A link styled as a button:</p>
	<!-- <a href="default.asp" target="">1st Year Students</a>
	
	<a href="default.asp" target="">2nd Year Students</a>
	
	<a href="default.asp" target="">3rd Year Students</a>
	
	<a href="default.asp" target="">4th Year Students</a> -->

	<!-- <form action="/semesters">
		<label for="year">Choose a car:</label> <input type="text"
			placeholder="Search.." name="search">
		<button type="submit">
			<i class="fa fa-search"></i>
		</button>
		<select id="year" name="year">
			<option value=""></option>
			<option value="1st">1st year Students</option>
			<option value="2nd">2nd year Students</option>
			<option value="3rd">3rd year Students</option>
			<option value="4th">4th year Students</option>
		</select> <input type="submit" value="Submit">
	</form> -->

	<hr>
	<a href="add-student" target="">New Admission</a>
	<a href="all-students" target="">All Student Details</a>

</body>
</html>