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
                background-color: blue;
            }
        </style>
    </head>
    <body>
        <form action="attendence"> 
            <div class="container">
                <h1>Single activity Attendance</h1>
                <h4>Attendance for AnhNN59 at slot 4 on Tuesday 20/02/2024 at room BE-101. This is session number 11 of the course.</h4>
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
                    </tr>
                    <c:forEach items="${requestScope.listStudents}" var="i" varStatus="loop">
                        <tr>
                            <td>${loop.index + 1}</td>
                            <td>${i.group.groupName}</td>
                            <td>${i.student.rollNumber}</td>
                            <td>${i.student.lastName}${i.student.fristName}</td>
                            <td> 
                                
                            </td>
                            
                            <td></td>
                            <td>
                                <form>
                                    <input type="text" name="name"/>
                                </form>
                            </td>
                            <td>                            
                                <img class="img" src="${i.student.image}" alt=""/>
                            </td>
                        </tr>

                    </c:forEach>
                </table>
            </div>
        </form>
    </body>
</html>

