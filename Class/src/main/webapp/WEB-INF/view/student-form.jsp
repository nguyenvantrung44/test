<%-- 
    Document   : credit-form
    Created on : Mar 14, 2021, 10:48:21 AM
    Author     : TriPham
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Student Form</h1>

<div align="center">
    <form action="student/save" method="get" >
        <table border="1" cellpadding="5">
            <caption>
             <h2>
                Add New/Edit Student
             </h2>
            </caption>     
             <input type="hidden" name="id" value="${id}"/>        
            <tr>
                <th>First Name: </th>
                <td>
                 <input type="text" name="firstname" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Last Name: </th>
                <td>
                 <input type="text" name="lastname" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Age: </th>
                <td>
                 <input type="text" name="age" size="45"/>
                </td>
            </tr>
            <tr>
             <td colspan="2" align="center">
              <input type="submit" value="Save" />
             </td>
            </tr>
        </table>
        </form>
    </div> 
</body>
</html>
