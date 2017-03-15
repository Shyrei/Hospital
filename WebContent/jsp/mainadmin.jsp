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
<title>Admin page</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<style>
body {background: url(images/fon2.jpg);}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="text-center">
					<h3>${user},
						<fmt:message key="messages.login.admin.success" />
					</h3>
				</div>
				<div class="col-md-6 col-md-offset-3">
					<div class="text-center">
						<form name="ShowAllDoctorsForm" method="POST" action="controller">
							<input type="hidden" name="command" value="SHOW_DOCTORS" />
							<button type="submit" class="btn btn-primary">
								<fmt:message key="button.show.doctors" />
							</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="text-center">
					<form name="AddDoctorForm" method="POST" action="controller">
						<input type="hidden" name="command" value="GO" />
						<button type="submit" class="btn btn-primary">
							<fmt:message key="button.add.doctor" />
						</button>
					</form>
				</div>
			</div>
		</div>
		<br>
	</div>
</body>
</html>