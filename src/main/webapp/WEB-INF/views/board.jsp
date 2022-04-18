<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Issue Management Application</title>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	%>
	<div align="center">
		<h1>Issue Management</h1>
		<h2>
			<a href="in?button=new">Add New Issue</a> &nbsp;&nbsp;&nbsp; <a
				href="in?button=list">List All Issues</a>
		</h2>
	</div>
	<div align="center">
		<table border="1">
			<caption>List of Issues</caption>
			<tr>

				<th>Title</th>
				<th>Description</th>
				<th>Type</th>
				<th>Employee</th>
				<th>Date of Birth</th>
				<th>Last Modified</th>
				<th>Last Employee Modified</th>
				<th>Creator</th>
				<th>Status</th>
			</tr>
			<c:forEach var="issue" items="${listIssue}">
				<tr>
					<td><c:out value="${issue.title}" /></td>
					<td><c:out value="${issue.description}" /></td>
					<td><c:out value="${issue.type}" /></td>
					<td><c:out value="${issue.employee}" /></td>
					<td><c:out value="${issue.dateOfBirth}" /></td>
					<td><c:out value="${issue.lastModified}" /></td>
					<td><c:out value="${issue.lastEmployeeModified}" /></td>
					<td><c:out value="${issue.userCreator}" /></td>
					<td><c:out value="${issue.status}" /></td>
					<td><a href="in?id=<c:out value='${issue.id}' />&button=edit">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="in?id=<c:out value='${issue.id}' />&button=delete">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>