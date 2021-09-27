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

	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center mb-3">Fees in Staff</h1>

				<!--  -->
				<!--  -->

				<div class="container text-left">
					<a href="download-pdf" class="btn btn-outline-danger">download Report</a>
				</div>

				<!--  -->
				<!--  -->
				<table class="table">
					<thead>
						<tr>
							<th scope="col">S.NO.</th>
							<th scope="col">Name</th>
							<!-- <th scope="col">Last Name</th> -->
							<th scope="col">Department</th>
							<th scope="col">Total Amount</th>
							<th scope="col">Paid Amount</th>
							<th scope="col">remain Amount</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${fees }" var="p">

							<tr>
								<th scope="row">${p.id }</th>
								<td>${p.name }</td>
								<td>${p.department}</td>
								<td>${p.totalAmount}rs</td>
								<td>${p.paidAmount}rs</td>

								<c:choose>
									<c:when
										test="${p.paidAmount != paidAmount && p.remainAmount!=0 }">
										<td>${p.remainAmount}rs unpaid</td>
									</c:when>
									<c:otherwise>
										<td>${p.status}</td>
									</c:otherwise>
								</c:choose>


								<%-- <c:if test="${ p.paidAmount != paidAmount && p.remainAmount!=0 }">
									<td>${p.remainAmount}</td>
								</c:if> --%>

								<!-- <td>${p.remainAmount}</td> -->
								<td><a href="delete-fees/${p.id }"><i
										class="far fa-trash-alt text-danger"></i></a> <a
									href="update-fees/${p.id }"><i class="fas fa-pen-nib "></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="container text-center">
					<a href="${pageContext.request.contextPath }/dashboard"
						class="btn btn-outline-danger">Back</a>
				</div>

				<div class="container text-center">
					<a href="add-fees" class="btn btn-outline-danger">Add Fees</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
