<%-- 
    Document   : viewAttendance
    Created on : Feb 20, 2024, 8:49:15 PM
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
                background: blue;
            }
            .img{
                width: 100px;
                height: 100px;
            }
            .gg{
                width: 100px;
                height: 30px;
                background-color: orange;
                border: none;
                border-radius: 5px;
                color: white;

            }
            .button-container {
                text-align: center;
                margin-top: 20px;

            }

        </style>
    </head>
    <body>
        <form action="attendence">

            <div class="container">
                <h1>Take attendance</h1>
                <h4>Attendance for AnhNN59 at slot 4 on Tuesday 20/02/2024 at room BE-101. This is session number 11 of the course.</h4>
                <table>
                    <tr class="row1">
                        <th></th>
                        <th>GROUP</th>
                        <th>ROLLNUMBER</th>
                        <th>FULL NAME</th>
                        <th>ABSENT</th>
                        <th>PRESENT</th>
                        <th>...</th>
                        <th>COMMENT</th>
                        <th>SHOW IMAGE</th>
                    </tr>

                    <c:forEach items="${requestScope.listStudents}" var="i" varStatus="loop">



                        <tr>
                            <td>${loop.index + 1}</td>
                            <td name="class">${i.session.group.groupName}</td>
                            <td name="code">${i.student.rollNumber}</td>
                            <td name="name">${i.student.lastName}${i.student.fristName}</td>
                            <td>
                                <input type="radio" 
                                       ${!i.isPresent?"checked=\"checked\"":""}
                                       name="present${i.student.id}" value="no"/> Absent
                            </td>
                            <td>
                                <input type="radio" 
                                       ${i.isPresent?"checked=\"checked\"":""}
                                       name="present${i.student.id}" value="yes"/> Present
                            </td>
                            <td></td>
                            <td>
                                <input type="text" name="description${i.student.id}" value="${i.comment}"/>
                            </td>
                            <td>                            
                                <img name="img" class="img" src="${i.student.image}" alt=""/>
                            </td>
                        </tr>

                    </c:forEach>
                </table>
                <div class="button-container">
                    <input class="gg" type="submit" value="Save"/>
                </div>
            </div>
        </form>
    </body>
</html>
