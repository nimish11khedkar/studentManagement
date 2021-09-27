<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="./base.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Student New Admission</h1>

				<form action="${pageContext.request.contextPath }/add-student"
					method="POST">
					<div class="form-group">

						<lebel for="name">First Name</lebel>
						<input type="text" class="form-control" name="firstname"
							id="firstname" />
					</div>

					<div class="form-group">

						<lebel for="name">last Name</lebel>
						<input type="text" class="form-control" name="lastname"
							id="lastname" />
					</div>

					<div class="form-group">

						<label for="cast">Choose a CAST:</label> 
						<select name="cast"
							id="cast">
							<option value="OPEN">Open</option>
							<option value="OBC">Obc</option>
							<option value="SC">Sc</option>
							<option value="GENERAL">General</option>
						</select>
					</div>

					<div class="form-group">

						<lebel for="name">College Name</lebel>
						<input type="text" class="form-control" name="collegeName"
							id="collegeName" />
					</div>

					<div class="form-group">

						<lebel for="name">Email</lebel>
						<input type="text" class="form-control" name="email" id="email" />
					</div>

					<div class="form-group">

						<lebel for="name">Address</lebel>
						<input type="text" class="form-control" name="address"
							id="address" />
					</div>

					<div class="form-group">

						<lebel for="name">Year</lebel>
						<input type="text" class="form-control" name="year" id="year" />
					</div>

					<div class="form-group">

						<lebel for="name">Department</lebel>
						<input type="text" class="form-control" name="dept" id="dept" />
					</div>


					<div class="form-group">

						<lebel for="name">Mobile No</lebel>
						<input type="text" class="form-control" name="mobileNo"
							id="mobileNo" />
					</div>



					<div class="container text-center">
						<a href="${pageContext.request.contextPath }"
							class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn-btn-primary">Submit</button>
					</div>

				</form>
			</div>
		</div>
	</div>
</body>
</html>