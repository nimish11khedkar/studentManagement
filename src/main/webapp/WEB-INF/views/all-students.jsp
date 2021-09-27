<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="./base.jsp"%>
<%@ include file ="header.jsp"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Insert title here</title>
</head>
<body>

	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center mb-3">Student in College</h1>

				<form class="mg-b-20" action="studentSearch" method="GET">
					<div class="row-gutters-8">
						<div class="col-3-xxxl col-xl-4 col-lg-4 col-12 form-group">
							<input type="text" placeholder="Search by department.."
								name="dept"
								id="dept" class="form-control" />
						</div>

						<div class="col-4-xxxl col-xl-4 col-lg-4 col-12 form-group">
							<input type="text" placeholder="Search by firstname"
								name="firstname" class="form-control" />
						</div>

						<div class="col-4-xxxl col-xl-3 col-lg-5 col-12 form-group">
							<input type="text" placeholder="Search by year" name="year"
								class="form-control" />
						</div>

						<div class="col-1-xxxl col-xl-2 col-lg-4 col-12 form-group">
							<button type="submit" class="btn btn-primary">Search</button>
						</div>
					</div>

				</form>


				<table class="table">
					<thead>
						<tr>
							<th scope="col">S.NO.</th>
							<th scope="col">Name</th>
							<!-- <th scope="col">Last Name</th> -->
							<th scope="col">Department</th>
							<th scope="col">year</th>
							<th scope="col">Mobile No</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${students }" var="p">
							<tr>
								<th scope="row">${p.id }</th>
								<td>${p.firstname }${p.lastname }</td>
								<td>${p.dept}</td>
								<td>${p.year}</td>
								<td>${p.mobileNo}</td>
								<td><a href="delete-student/${p.id }"><i
										class="far fa-trash-alt text-danger"></i></a> <a
									href="update-student/${p.id }"><i class="fas fa-pen-nib "></i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="container text-center">
					<a href="${pageContext.request.contextPath }/dashboard"
						class="btn btn-outline-danger">Back</a>
				</div>

				<div class="container text-center">
					<a href="add-student" class="btn btn-outline-danger">Add
						Student</a>
				</div>

			</div>
		</div>
	</div>

</body>
</html>