<%-- 
    Document   : showMarkAllSubject
    Created on : Feb 26, 2024, 1:57:02 AM
    Author     : G5 5590
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <div class="container">
            <table>
                <tr class="row1">
                    <th>NO</th>
                    <th>SUBJECT CODE</th>
                    <th>SUBJECT NAME</th>
                    <th>SEMESTER</th>
                    <th>GROUP</th>
                    <th>STARTDATE</th>
                    <th>ENDDATE</th>
                    <th>AVERAGE MARK</th>
                    <th>STATUS</th>
                </tr>
                <c:forEach items="${requestScope}" var="i"> 
                    <c:set var="id" value="${i.id}"/>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>

                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
