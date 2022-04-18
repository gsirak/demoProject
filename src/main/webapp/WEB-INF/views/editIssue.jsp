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
		<h1>Edit Issue</h1>
		<!--request.getContextPath()h() %>/in?action=save -->
		<form action="<%=request.getContextPath()%>/in" method="post">

			<table>
				<caption>Fill the features you want to update</caption>

				<tr>
					<td><input type="hidden" name="id" value="${issue.id}">
					</td>
				</tr>
				<tr>
					<td>Title:</td>
					<td><input type="text" name="title" placeholder="title"
						value="${issue.title }"></td>
				</tr>
				<tr>
					<td>Description :</td>
					<td><input type="text" name="description"
						placeholder="description" value="${issue.description }"></td>
				</tr>
				<tr>
					<td>Type:</td>
					<td><input type="text" name="type" value="${issue.type }"></td>
				</tr>
				<tr>
					<td>Employee:</td>
					<td><input type="text" name="employee"
						value="${issue.employee }"></td>
				</tr>
				<tr>
					<td>Date:</td>
					<td><input type="text" name="dateOfBirth"
						value="${issue.dateOfBirth }"></td>
				</tr>
				<tr>
					<td>Last Modified:</td>
					<td><input type="text" name="lastModified"
						value="${issue.lastModified }"></td>
				</tr>
				<tr>
					<td>Last employee modified:</td>
					<td><input type="text" name="lastEmployeeModified"
						value="${issue.lastEmployeeModified }"></td>
				</tr>
				<tr>
					<td>Creator:</td>
					<td><input type="text" name="userCreator"
						value="${issue.userCreator }"></td>
				</tr>
				<tr>
					<td>Status:</td>
					<td><input type="text" name="status" value="${issue.status }"></td>
				</tr>
				<tr>
					<td></td>
					<td><input name="button" type="submit" value="update">
						<input name="button" type="submit" value="back"> <!--<a href="in?action=save">save</a>-->
					</td>
					<!--  
 
 
 <td><input type="submit" value="Sign up"></td>-->
				</tr>
			</table>
		</form>
	</div>
</body>
</html>