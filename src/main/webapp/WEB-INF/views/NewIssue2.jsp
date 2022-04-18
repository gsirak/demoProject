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
		<h1>New Issue</h1>
		<form action="<%=request.getContextPath()%>/in" method="post">
			<table>
				<tr>
					<td>Title *:</td>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>Description :</td>
					<td><input type="text" name="description"></td>
				</tr>
				<tr>
					<td>Type *:</td>
					<td><input type="text" name="type"></td>
				</tr>
				<tr>
					<td>Employee:</td>
					<td><input type="text" name="employee"></td>
				</tr>
				<tr>
					<td>Date *:</td>
					<td><input type="text" placeholder="dd/mm/yy"
						name="dateOfBirth"></td>
				</tr>
				<tr>
					<td>Last Modified:</td>
					<td><input type="text" placeholder="dd/mm/yy"
						name="lastModified"></td>
				</tr>
				<tr>
					<td>Last employee modified:</td>
					<td><input type="text" name="lastEmployeeModified"></td>
				</tr>
				<tr>
					<td>Creator *:</td>
					<td><input type="text" name="userCreator"></td>
				</tr>
				<tr>
					<td>Status:</td>
					<td><input type="text" name="status"></td>
				</tr>
				<tr>
					<td></td>
					<td><input name="button" type="submit" value="save"> <input
						name="button" type="submit" value="back"> <!--<a href="in?action=save">save</a>-->
					</td>
					<!--  <td><input type="submit" value="Sign up"></td>-->
				</tr>
			</table>
		</form>
	</div>
</body>
</html>