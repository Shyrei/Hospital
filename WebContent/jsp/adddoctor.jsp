<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="uselocale.jsp"%>
<%@ include file="navbar.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Add doctor page</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<style>
body {
	background: url(images/fon2.jpg);
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-7 col-md-offset-2">
				<div class="text-center">
					<h3>
						<fmt:message key="title.add.doctor" />
					</h3>
				</div>
				<form action="controller" method="POST" class="form-horizontal">
					<div class="form-group">
						<label for="name" class="col-sm-3 control-label"><fmt:message
								key="add.doctor.name" /></label>
						<div class="col-sm-9">
							<input name="name" id="name" type="text" class="form-control"
								placeholder="<fmt:message key="add.doctor.name.placeholder" />">
						</div>
					</div>
					<div class="form-group">
						<label for="specialization" class="col-sm-3 control-label"><fmt:message
								key="add.doctor.specialization" /></label>
						<div class="col-sm-9">
							<input name="specialization" id="specialization" type="text"
								class="form-control"
								placeholder="<fmt:message key="add.doctor.specialization.placeholder" />">
						</div>
					</div>

					<div class="form-group">
						<label for="Departments_id" class="col-sm-3 control-label"><fmt:message
								key="add.doctor.department" /></label>
						<div class="col-sm-9">
							<select class="form-control">
								<c:forEach items="${list}" var="dept">
									<option value="${dept.depId}">${dept.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					

					<!--<div class="form-group">
						<label for="Departments_id" class="col-sm-3 control-label"><fmt:message
								key="add.doctor.department" /></label>
						<div class="col-sm-9">
							<input name="Departments_id" id="Departments_id" type="text"
								class="form-control"
								placeholder="<fmt:message key="add.doctor.department.placeholder" />">
						</div>
					</div>-->
					<div class="text-right">
						<input type="hidden" name="command" value="add_doctor">
						<button type="submit" class="btn btn-primary">
							<fmt:message key="button.add.doctor" />
						</button>
					</div>
					<br>
				</form>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="text-center">
				<c:if test="${not empty errorAddDoctorPassMessage}">
					<div class="text-center">
						<h4>
							<font color="red">${errorAddDoctorPassMessage}</font>
						</h4>
					</div>
				</c:if>
				<c:if test="${not empty successAddDoctorPassMessage}">
					<div class="text-center">
						<h4>
							<font color="green">${successAddDoctorPassMessage}</font>
						</h4>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>