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
				<h1 class="text-center mb-3">Teachers in Staff</h1>

				<table class="table">
					<thead>
						<tr>
							<th scope="col">S.NO.</th>
							<th scope="col">Name</th>
							<!-- <th scope="col">Last Name</th> -->
							<th scope="col">Department</th>
							<th scope="col">Subject</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${teachers }" var="p">
							<tr>
								<th scope="row">${p.id }</th>
								<td>${p.firstname }${p.lastname }</td>
								<td>${p.department}</td>
								<td>${p.subject}</td>
								<td>
									<a href="delete/${p.id }"><i class="far fa-trash-alt text-danger"></i></a>
									<a href="update/${p.id }"><i class="fas fa-pen-nib "></i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="container text-center">
					<a href="${pageContext.request.contextPath }/dashboard"
						class="btn btn-outline-danger">Back</a>
				</div>

			</div>
		</div>
	</div>

</body>
</html>