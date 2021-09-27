<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="./base.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>


	<script type="text/javascript">
		function amountCal2() {

			var totalAmount = document.getElementById('totalAmount').value;
			var paidAmount = document.getElementById('paidAmount').value;

			var remainAmount = totalAmount - paidAmount;

			document.getElementById('remainAmount').value = remainAmount;
		}
	</script>

	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Student Fees Updation</h1>

				<form action="${pageContext.request.contextPath }/add-fees"
					method="POST">
					<div class="form-group">

						<lebel for="name">Full Name</lebel>
						<input type="text" class="form-control" name="id" id="id"
							value="${fees.id }" readonly="readonly"/>
					</div>

					<div class="form-group">

						<lebel for="name">Full Name</lebel>
						<input type="text" class="form-control" name="name" id="name"
							value="${fees.name }" />
					</div>

					<div class="form-group">

						<lebel for="name">Department</lebel>
						<input type="text" class="form-control" name="department"
							id="department" value="${fees.department }" />
					</div>

					<div class="form-group">

						<lebel for="name">Total Amouont</lebel>
						<input type="text" class="form-control" name="totalAmount"
							id="totalAmount" readonly="readonly" value="${fees.totalAmount }" />
					</div>

					<div class="form-group">

						<lebel for="name">Paid Amount</lebel>
						<input type="text" class="form-control" name="paidAmount"
							id="paidAmount" value="${fees.paidAmount }" />
					</div>

					<div class="form-group">

						<lebel for="name">Remain Amount</lebel>
						<input type="text" class="form-control" name="remainAmount"
							id="remainAmount" value="${fees.remainAmount }"
							onfocus="amountCal2()" readonly="readonly" />
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