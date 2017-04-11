<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="uselocale.jsp"%>
<%@ include file="navbar.jsp"%>
<!DOCTYPE html>
<html lang="en">
<script type="text/javascript" src="js/validation.js"></script>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login page</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<style>
body {background: url(images/fon2.jpg);}
</style>
</head>
<body>
	<div class="container" style="color: black;">
		<div class="row">
			<div class="col-md-5">
				<div class="text-center">
					<h3>
						<fmt:message key="title.register" />
					</h3>
				</div>
				<form action="controller" method="POST" class="form-horizontal">
					<input type="hidden" name="command" value="register">
					<div class="form-group">
						<label for="name"><fmt:message key="register.name" /></label> <input
							name="name" id="nameForm" type="text" class="form-control"
							placeholder="<fmt:message key="register.name.placeholder" />"
							onKeyUp="check('name')" maxlength="15"> <b id="name"
							style="color: red; font-size: 10px;"> <fmt:message
								key="reg.info.name" /></b>
					</div>
					<div class="form-group">
						<label for="login"><fmt:message key="register.login" /></label> <input
							name="login" id="regloginForm" type="text" class="form-control"
							placeholder="<fmt:message key="register.login.placeholder" />"
							onKeyUp="check('reglogin')"> <b id="reglogin"
							style="color: red; font-size: 10px;"> <fmt:message
								key="reg.info.login" />
						</b>
					</div>
					<div class="form-group">
						<label for="password"><fmt:message key="register.password" /></label>
						<input name="password" id="regpasswordForm" type="password"
							class="form-control"
							placeholder="<fmt:message key="register.password.placeholder" />"
							onKeyUp="check('regpassword')"> <b id="regpassword"
							style="color: red; font-size: 10px;"> <fmt:message
								key="reg.info.password" />
						</b>
					</div>
					<div class="form-group">
						<label for="email"><fmt:message key="register.email" /></label> <input
							name="email" id="email" type="email" class="form-control"
							placeholder="<fmt:message key="register.email.placeholder" />">
					</div>
					<button type="submit" class="btn btn-primary">
						<fmt:message key="register.button" />
					</button>
					<c:if test="${not empty errorFormDataMessage}">
						<div class="text-center">
							<h4>
								<font color="red">${errorFormDataMessage}</font>
							</h4>
						</div>
					</c:if>
					<c:if test="${not empty errorLoginMessage}">
						<div class="text-center">
							<h4>
								<font color="red">${errorLoginMessage}</font>
							</h4>
						</div>						
					</c:if>
					<c:if test="${not empty errorDBMessage}">
						<div class="text-center">
							<h4>
								<font color="red">${errorDBMessage}</font>
							</h4>
						</div>
					</c:if>
				</form>
			</div>
			<div class="col-md-5 col-md-offset-1">
				<div class="text-center">
					<h3>
						<fmt:message key="title.login" />
					</h3>
				</div>
				<form action="controller" method="POST" class="form-horizontal">
					<input type="hidden" name="command" value="login">
					<div class="form-group">
						<label for="login"><fmt:message key="register.login" /></label> <input
							name="login" id="logloginForm" type="text" class="form-control"
							placeholder="<fmt:message key="register.login.placeholder" />"
							onKeyUp="check('loglogin')"> <b id="loglogin"
							style="color: red; font-size: 10px;"> <fmt:message
								key="reg.info.login" /></b>
					</div>
					<div class="form-group">
						<label for="password"><fmt:message key="register.password" /></label>
						<input name="password" id="logpasswordForm" type="password"
							class="form-control"
							placeholder="<fmt:message key="register.password.placeholder" />"
							onKeyUp="check('logpassword')"> <b id="logpassword"
							style="color: red; font-size: 10px;"> <fmt:message
								key="reg.info.password" />
						</b>
					</div>
					<div class="text-right">

						<button type="submit" class="btn btn-primary">
							<fmt:message key="login.button" />
						</button>
						<c:if test="${not empty errorLoginPassMessage}">
							<div class="text-center">
								<h4>
									<font color="red">${errorLoginPassMessage}</font>
								</h4>
								<c:remove var="errorLoginPassMessage" scope="session" />
							</div>
						</c:if>
						<c:if test="${not empty errorDBMessage}">
							<div class="text-center">
								<h4>
									<font color="red">${errorDBMessage}</font>									
								</h4>
								<c:remove var="errorDBMessage" scope="session" />
							</div>
						</c:if>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>