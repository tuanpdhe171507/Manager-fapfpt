<%-- 
    Document   : showSVAttendance
    Created on : Feb 20, 2024, 11:38:06 PM
    Author     : G5 5590
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <style>
            body {
                margin: 0;
                padding: 0;
                font-family: Arial, sans-serif;
            }
            .container {
                width: 95%;
                margin: 0 auto;
                padding: 20px;
            }
            table {
                width: 100%;
                border-collapse: collapse;
            }
            table, th, td {
                border: 1px solid black;
            }
            th, td {
                padding: 10px;
                text-align: left;
            }

            .row1{
               background-color: rgba(0, 0, 255, 0.7);
            }
            .img{
                width: 100px;
                height: 100px;
            }
            .text100{
                color: red;
            }
            .text99{
                color: green;
            }
        </style>
    </head>
    <body>
        <form action="attendence" method="POST"> 
            <div class="container">
                <h1>Single activity Attendance</h1>
                <c:choose>
                    <c:when test="${not empty requestScope.listStudentAddtendence}">
                        <c:set var="studentAttendance" value="${requestScope.listStudentAddtendence[0]}" />
                        <h4>Attendance for  at <a>${studentAttendance.session.timeslot.name}</a> on Day ${studentAttendance.datetime} at room ${studentAttendance.session.group.groupName}. This is session number ${studentAttendance.session.sessionID} of the course.</h4>
                    </c:when>
                    <c:otherwise>
                        <p>No attendance data available.</p>
                    </c:otherwise>
                </c:choose>

                <table>
                    <tr class="row1">
                        <th>NO</th>
                        <th>GROUP</th>
                        <th>CODE</th>
                        <th>NAME</th>
                        <th>IMAGE</th>
                        <th>STATUS</th>
                        <th>COMMENT</th>
                        <th>TEACHER</th>
                        <th>RECORD TIME</th>
                        <th>View Mark</th>
                    </tr>
                    <c:forEach items="${requestScope.listStudentAddtendence}" var="i" varStatus="loop">
                        <tr>
                            <td>${loop.index + 1}</td>
                            <td name="class">${i.session.group.groupName}</td>
                            <td name="code">${i.student.rollNumber}</td>
                            <td name="name">${i.student.lastName}${i.student.fristName}</td>
                            <td>                            
                                <img name="img" class="img" src="${i.student.image}" alt=""/>
                            </td>

                            <td>                           
                                <div class="text99"> <c:if test="${i.isPresent}">Present</c:if></div>

                                    <div class="text100"><c:if test="${!i.isPresent}">Absent</c:if></div>
                                </td>

                                <td>
                                    <input type="text" name="description${i.student.id}" value="${i.comment}"/>
                            </td>
                            <td>${i.session.teacher.code}</td>
                            <td>${i.datetime}</td>
                            <td><a href="mark?studentid=${i.student.id}">Mark</a></td>
                        </tr>

                    </c:forEach>
                </table>
            </div>
        </form>
    </body>
</html>

