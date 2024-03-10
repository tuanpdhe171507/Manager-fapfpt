<%-- 
    Document   : shopping
    Created on : Mar 8, 2024, 8:11:00 PM
    Author     : G5 5590
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>

        </style>
    </head>
    <body>
        <form action="search" method="GET">
            Search All Information Product<input  type="submit" name="search"  value="Search all"/></br>


        </form>
        <h2>List Product</h2><br></br>


        <table border="1px">
            <tr>
                <th>ProductID</th>
                <th>ProductName</th>
                <th>Description</th>
                <th>Price</th>
                <th>Action</th>
            </tr>

            <c:forEach items="${requestScope.list111}" var="i">
                <c:if test="${i.status}">
                    <tr>
                        <td>${i.id}</td>
                        <td>${i.name}</td>
                        <td>${i.description}</td>
                        <td>${i.price}</td>
                        <td>
                            <form action="search" method="POST">
                                <input type="hidden" name="id" value="${i.id}">
                                <input type="hidden" name="name" value="${i.name}">
                                <input type="hidden" name="description" value="${i.description}">
                                <input type="hidden" name="price" value="${i.price}">
                                <input type="hidden" name="status" value="${i.status}">
                                <input type="submit"  value="Add">
                            </form>

                        </td>
                    </tr>
                </c:if>
            </c:forEach>

        </table>


        <h2>List Cart Add</h2>

        <form action="search" method="GET">
            <table border="1px">
                <tr>
                    <th>ProductID</th>
                    <th>ProductName</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Status</th>            
                </tr>
                <c:forEach items="${requestScope.list}" var="k"> 
                    <tr>
                        <td>${k.id}</td>
                        <td>${k.name}</td>
                        <td>${k.description}</td>
                        <td>${k.price}</td>
                        <td>${k.status}</td>
                    <input type="hidden" name="id1" value="${k.id}">
                    <input type="hidden" name="name1" value="${k.name}">
                    <input type="hidden" name="description1" value="${k.description}">
                    <input type="hidden" name="price1" value="${k.price}">
                    <input type="hidden" name="status1" value="${k.status}">
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" name="submit12" value="Submit">
        </form>




    </body>
</html>
