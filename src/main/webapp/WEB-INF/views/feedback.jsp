<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=submit] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
</head>
<body>

<script type="text/javascript">

function updateInputs() {
	var firstname = document.getElementById('teachers.firstname');
	
	var name = firstname;
	document.getElementById('name') = name;

}
</script>

<h3>Contact Form</h3>

<div class="container">
  <form action="${pageContext.request.contextPath }/add-feedback"
   method="POST">
    
    		 <label class="col-md-3 control-label">Teacher Name</label>
				<div class="col-md-9">
					<form:select class="form-control" path="teachers">
						<c:forEach items="${teachers}" var="teachers">
							<form:option value="${teachers.firstname}">${teachers.firstname} ${teachers.lastname }</form:option>
						</c:forEach>
					</form:select>
				</div> 
  <br>
  	<!--  <label for="name">Name</label> 
     <input type="text" id="name" name="name"
      onfocus="updateInputs()"
     readonly="readonly"> -->
  <hr>
  
   <label for="name">Enter Name</label>
    <input type="text" id="name" name="name" placeholder="Teacher Name">

    <label for="email">Enter Email</label>
    <input type="text" id="email" name="email" placeholder="Teacher Email">
  
  
    <label for="answer1">What advice would you give to improve level ?</label>
    <input type="text" id="answer1" name="answer1" placeholder="Your Answer">

    <label for="answer2">What do you want to learn next? </label>
    <input type="text" id="answer2" name="answer2" placeholder="Your Answer..">
    
    <label for="answer3">Rate your teacher. How could she/he do better? </label>
    <input type="text" id="answer3" name="answer3" placeholder="Your Answer..">

    

    <label for="answer4">Subject</label>
    <textarea id="answer4" name="answer4" placeholder="Write something.." style="height:200px"></textarea>

    <input type="submit" value="Submit">
  </form>
</div>

</body>
</html>
