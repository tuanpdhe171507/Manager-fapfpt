<%-- 
    Document   : viewCart
    Created on : Mar 8, 2024, 11:48:10 PM
    Author     : G5 5590
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="search" method="GET">
            <table border="1px">
                <tr>
                    <th>No</th>
                    <th>ProductID</th>
                    <th>ProductName</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Status</th>            
                </tr>
                <c:forEach items="${requestScope.list}" var="k"> 
                    <tr>
                        <td>
                        <td>${k.id}</td>
                        <td>${k.name}</td>
                        <td>${k.description}</td>
                        <td>${k.price}</td>
                        <td>${k.status}</td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
