<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="./base.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Student Admission</h1>

				<form action="${pageContext.request.contextPath }/add-student" method="POST">
				<input type="hidden" name="id" value="${student.id }"/>
					<div class="form-group">
							
							<lebel for="name">First Name</lebel>	
								<input type="text" 
								class="form-control"
								name="firstname" 
								id="firstname"
								value="${student.firstname }"
								 />
							</div>
							
							<div class="form-group">
							
							<lebel for="name">last Name</lebel>	
								<input type="text" 
								class="form-control"
								name="lastname" 
								id="lastname" 
								value="${student.lastname }"
								/>
							</div>
							
							<div class="form-group">
							
							<lebel for="name">College Name</lebel>	
								<input type="text" 
								class="form-control"
								name="collegeName" 
								id="collegeName" 
								value="${student.collegeName }"
								/>
							</div>
							
							<div class="form-group">
							
							<lebel for="name">Email</lebel>	
								<input type="text" 
								class="form-control"
								name="email" 
								id="email" 
								value="${student.email }"
								/>
							</div>
							
							<div class="form-group">
							
							<lebel for="name">Address</lebel>	
								<input type="text" 
								class="form-control"
								name="address" 
								id="address" 
								value="${student.address }"
								/>
							</div>
							
							<div class="form-group">
							
							<lebel for="name">Year</lebel>	
								<input type="text" 
								class="form-control"
								name="year" 
								id="year" 
								value="${student.year }"
								/>
							</div>
							
							<div class="form-group">
							
							<lebel for="name">Department</lebel>	
								<input type="text" 
								class="form-control"
								name="dept" 
								id="dept" 
								value="${student.dept }"
								/>
							</div>
							
							
							<div class="form-group">
							
							<lebel for="name">Mobile No</lebel>	
								<input type="text" 
								class="form-control"
								name="mobileNo" 
								id="mobileNo" 
								value="${student.mobileNo }"
								/>
							</div>
						
						
					<div class="container text-center">
						<a href="${pageContext.request.contextPath }"
							class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn-btn-primary">Update</button>
					</div>

				</form>
			</div>
		</div>
	</div>
</body>
</html>