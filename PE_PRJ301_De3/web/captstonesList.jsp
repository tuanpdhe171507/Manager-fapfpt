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
         <script>
            function  chonXoa(id) {
                var cf = confirm('are you sure?');
                if (cf)
                {
                    document.getElementById('deleteId' + id).submit();
                }
            }
        </script>
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
                <th>ACTION</th>
            </tr>
            <c:forEach items="${requestScope.lists}" var="i" varStatus="loop"> 
                 <c:set var="id" value="${i.capid}"/>
                <tr>
                    <td>${loop.index + 1}</td>
                    <td>${i.capid}
                        <form id="deleteId${i.capid}" action="delete">
                            <input type="hidden" name="id" value="${i.capid}"/> 
                        </form>
                    </td>
                    <td>${i.capdescription}</td>
                    <td>${i.capuserid.userId}</td>
                    <td>
                        <a href="update?id=${id}">Update</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                        <a href="#" onclick="chonXoa('${id}')">Delete</a>
                    </td>
                </tr>

            </c:forEach>
        </table>
        </c:if>
        
    </body>
</html>
