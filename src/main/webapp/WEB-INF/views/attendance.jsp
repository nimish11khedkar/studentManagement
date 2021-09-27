<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="./base.jsp"%>
<%@ include file="header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Insert title here</title>
</head>
<body>
<!--  -->

<!--  -->

	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center mb-3">Student Attendance</h1>

				<!-- <form class="mg-b-20" action="AttendanceSearch" method="GET">
					<div class="row-gutters-8">
						<label for="cast">Choose a Cast :</label> 
						<select id="cast"
							name="cast">
							<option value="">Select cast</option>
							<option value="OPEN">Open</option>
							<option value="OBC">Obc</option>
							<option value="SC">Sc</option>
							<option value="GENERAL">Generals</option>
						</select>
						
						<div class="col-1-xxxl col-xl-2 col-lg-4 col-12 form-group">
							<button type="submit" class="btn btn-primary">Search</button>
						</div>
					</div>

				</form> -->
			

				<table class="table">
					<thead>
						<tr>
							<th scope="col">S.NO.</th>
							<th scope="col">Name</th>
							<th scope="col">Department</th>
							<th scope="col">Attandance</th>
							<th scope="col">Status</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${students }" var="p">
							<tr>
								<th scope="row">${p.id }</th>
								<td>${p.firstname }${p.lastname }</td>
								<td>${p.dept }</td>
								<td>${p.attendance }</td>
								<td><input type="checkbox" name="attendance" 
								 id="attendance" value="Present">
								
								
								  <i class="fas fa-pen-nib "> Mark Present</i>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="container text-center">
					<a href="${pageContext.request.contextPath }/dashboard"
						class="btn btn-outline-danger">Back</a>
						<a href="update-Attendance">
								<i class="fas fa-pen-nib "></i>Update</a>
				</div>

			</div>
		</div>
	</div>

</body>
</html>