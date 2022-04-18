<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Register User form</h1>
		<form action="<%=request.getContextPath()%>/form" method="post">
			<table>
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="firstName"></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input type="text" name="lastName"></td>
				</tr>
				<tr>
					<td>User Name:</td>
					<td><input type="text" name="userName"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<button name="button" type="submit" value="submit">submit</button>
						<button name="button" type="submit" value="login">login</button>
					</td>
					<!--  <td><input type="submit" value="Sign up"></td>-->
				</tr>

			</table>
		</form>
	</div>
</body>
</html>