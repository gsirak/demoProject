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
		<h1>User login form</h1>

		<form action="<%=request.getContextPath()%>/form" method="post">
			<table>
				<tr>
					<td>User Name:</td>
					<td><input type="text" name="userName"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><input name="button" type="submit" value="ok"> <input
						name="button" type="submit" value="back"></td>


				</tr>
			</table>
		</form>
	</div>
</body>
</html>