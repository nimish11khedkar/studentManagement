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
				<h1 class="text-center mb-3">Subject Details</h1>

				<form action="${pageContext.request.contextPath }/add-subject-post" method="POST">
					<div class="form-group">
							
							<lebel for="name">Subject Name</lebel>	
								<input type="text" 
								class="form-control"
								name="subjectname" 
								id="subjectname"
								 />
							</div>
							
						
							<div class="form-group">
							<lebel for="name">Department</lebel>	
								<input type="text" 
								class="form-control"
								name="department" 
								id="department" 
								/>
							</div>
							
							<div class="form-group">
							<lebel for="name">Year</lebel>	
								<input type="text" 
								class="form-control"
								name="year" 
								id="year" 
								/>
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