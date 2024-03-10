<%-- 
    Document   : list
    Created on : Mar 11, 2024, 1:51:06 AM
    Author     : G5 5590
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>List of Students:</h2>
        <form action="list" method="">
            <table border="1px">
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Date of birth</th>
                    <th>Gender</th>
                    <th>Select</th>
                </tr>
                <c:forEach items="${requestScope.lists}" var="i">
                     <c:set var="id" value="${i.studentID}"/>
                    <tr>
                        <td>${i.studentID}</td>
                        <td>${i.studentName}</td>
                        <td>${i.bithDay}</td>
                        <td>
                            <c:if test="${i.gender}">
                                Male
                            </c:if>
                            <c:if test="${!i.gender}">
                                Female
                            </c:if>
                        </td>
                        <td>
                           <a href="update?id=${id}">Select</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
        
        <h2>Detail information:</h2>
        <form action="update" method="POST">
            Code:<input type="text" name="code" value="${requestScope.liststu.studentID}" readonly/>
            Name:<input type="text" name="name" value="${requestScope.liststu.studentName}"/></br>
            Date of birth:<input type="text" name="date" value="${requestScope.liststu.bithDay}"/>
            Gender: <input type="radio" name="gender"
                           <c:if test="${requestScope.liststu.gender}"> 
                           checked="checked"
                           </c:if>
                           value="male"/> Male
            <input type="radio" name="gender"
                           <c:if test="${!requestScope.liststu.gender}"> 
                           checked="checked"
                           </c:if>
                    value="female"/> Female
            <br/>
            Class:<select name="did">
                <c:forEach items="${requestScope.listClass}" var="d">
                    <option
                        <c:if test="${d.classid eq requestScope.liststu.classID.classid}">
                            selected="selected"
                        </c:if>
                        value="${d.classid}">${d.className}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Update"/>
        </form>
    </body>
</html>
