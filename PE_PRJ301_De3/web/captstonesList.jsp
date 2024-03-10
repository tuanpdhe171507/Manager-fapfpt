<%-- 
    Document   : captstonesList
    Created on : Mar 10, 2024, 4:19:36 PM
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
        ${text}

        <form action="search" method="POST">
            Search By Name: <input type="text" name="searchname"/></br>
            <input type="submit" value="Search"/>
        </form>
         
        <c:if test="${lists != null && lists.size()>0}">
            <table border="1px">
            <h1>List of Capstones</h1>

            <tr>
                <th>NO</th>
                <th>ID</th>
                <th>DESCRIPTION</th>
                <th>USERID</th>
            </tr>
            <c:forEach items="${requestScope.lists}" var="i" varStatus="loop"> 

                <tr>
                    <td>${loop.index + 1}</td>
                    <td>${i.capid}</td>
                    <td>${i.capdescription}</td>
                    <td>${i.capuserid.userId}</td>
                </tr>

            </c:forEach>
        </table>
        </c:if>
        
    </body>
</html>
