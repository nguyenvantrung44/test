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
	<h1>${lopHoc.tenLop}</h1>
	<h2>List Student of LopHoc</h2>

	<table style="border: 1px solid; width: 50%; text-align: center">
		<thead style="background: #d3dce3">
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody style="background: #ccc">
			<c:if test="${!empty lophoc.students}">
				<c:forEach items="${lophoc.students}" var="creditCard">
					<tr>
						<td><c:out value="${creditCard.id}" /></td>
						<td><c:out value="${creditCard.firstname}" /></td>
						<td><c:out value="${creditCard.lastname}" /></td>
						<td><c:out value="${creditCard.age}" /></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>



	<p>
		<a href="${addUrl}">Create new record</a>
	</p>
	<p>
		<a href="${personUrl}"}">Person List</a>
	</p>

</body>
</html>
