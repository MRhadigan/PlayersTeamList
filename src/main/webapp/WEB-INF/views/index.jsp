<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Player List</title>
</head>
<body>

<h1>List of Players</h1>
	<table border="1">
		<c:forEach var="a" items="${list}">
			<tr>
				<td>${p.n}</td>
				<td>${p.pos}</td>
				<td>${p.team}</td>
				<td>${p.bench}</td>
				<td>${p.points}</td>
				<td><a href="delete?id=${p.id}">Delete</a></td>
				<td><a href="update?id=${p.id}">Update</a></td>

			</tr>
		</c:forEach>
	</table>

</body>
</html>