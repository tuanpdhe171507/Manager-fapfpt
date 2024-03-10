<%-- 
    Document   : update
    Created on : Jan 28, 2024, 11:29:56 PM
    Author     : G5 5590
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update TblCapstones</h1>

        <form action="update" method="POST">
            <input type="hidden" name="did" value="${requestScope.cap.capid}"/> <br/>
            Name: <input type="text" name="name" value="${requestScope.cap.capname}" /> <br/>
            Description:<input type="text" name="des" value="${requestScope.cap.capdescription}"/> <br/>

            UserID:<select name="userid">
                <c:forEach items="${requestScope.listU}" var="d">
                    <option
                        <c:if test="${d.userId eq requestScope.cap.capuserid.userId}">
                            selected="selected"
                        </c:if>
                        value="${d.userId}">${d.userId}</option>
                </c:forEach>
            </select>
            <br/>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
