<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="uselocale.jsp"%>
<%@ include file="navbar.jsp"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Show doctor page</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<style>
body {
	background: url(images/fon4.jpg);
}
</style>
</head>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="text-center">
					<h3>
						<fmt:message key="title.show.all.doctors" />
					</h3>
				</div>
				<table class="table table-striped table-condensed table-bordered">
					<tr>
						<td align="center">№</td>
						<td align="center"><fmt:message key="show.doctor.name" /></td>
						<td align="center"><fmt:message
								key="show.doctor.specialization" /></td>
						<td align="center"><fmt:message key="show.doctor.department" /></td>
					</tr>
					<c:forEach items="${doctorsList}" varStatus="сounter">
						<tr>
							<td align="center">${сounter.count}</td>
							<td align="center">${doctorsList[сounter.count-1].name}</td>
							<td align="center">${doctorsList[сounter.count-1].specialization}</td>
							<td align="center"><form name="ShowOneDepartmentsForm"
									method="POST" action="controller">
									<input type="hidden" name="command"
										value="SHOW_ONE_DEPARTMENTS" /> <input type="hidden"
										name="depID" value="${doctorsList[сounter.count-1].depId}" />
									<button type="submit" class="btn btn-link">
										${doctorsList[сounter.count-1].depId}</button>
								</form></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>