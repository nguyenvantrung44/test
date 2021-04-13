<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html >
<html>
<head>

<title>Lop Hoc</title>
</head>
<body>
<h1>Lop Hoc</h1>
<div align="center">
    <form action="save" method="get"  >
        <table border="1" cellpadding="5">
            <caption>
             <h2> 
               Add new/Edit LopHoc
              </h2>
            </caption>
            	
              <input type="hidden" name="id" value="${id}" />
            <tr>
            	
                <th>Name: </th>
                <td>
                 <input type="text" name="tenLop" size="45"
                   value="<c:out value='${lophoc.tenLop}' />"
                  />
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




