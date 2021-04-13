<%-- 
    Document   : person
    Created on : Mar 13, 2021, 7:43:39 PM
    Author     : TriPham
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Records</h1>

	<table style="border: 1px solid; width: 100%; text-align: center">
		<thead style="background: #d3dce3">
			<tr>
				<th>Id</th>
				<th>TenLop</th>
				<th colspan="4">Action</th>

			</tr>
		</thead>
		<tbody style="background: #ccc">

			<c:forEach items="${lophoc}" var="lophoc">
				<tr>
					<td><c:out value="${lophoc.id}" /></td>
					<td><c:out value="${lophoc.tenLop}" /></td>
					<td><a href="/Class/viewStudentClass?id=${lophoc.id}" style="text-decoration: none">Xem</a></td>
					<td><a href="">Xoa</a></td>
					<td><a href="">Sua</a></td>
					<td><a href="/Class/addStudent?id=${lophoc.id}">Them Student</a></td>
				</tr>
				    
			</c:forEach>

		</tbody>
	</table>

	<c:if test="${empty lophoc}">
 No records found. 
</c:if>

	<p>
		<a href="/Class/add">Create new record</a>
	</p>

</body>
</html>
