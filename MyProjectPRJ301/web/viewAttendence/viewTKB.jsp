<%-- 
    Document   : viewTKB
    Created on : Feb 20, 2024, 9:31:22 PM
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
            .text1{
                text-align: center;
            }
            .container5{
                width: 130px;
                height: 20px;

            }
            .text2{
                display: inline-block;
                display: flex;
                justify-content: center;
                margin: 15px;
                font-weight: bold;
            }
            .text5{
                background: blue;
            }
            .cod{
                width: 250px;
            }
            .text6{
                background-color: orange;
                color: white;
                border: none;
                border-radius: 5px;
            }

            .text7{
                width: 95px;
                height: 20px;
                border: 1px solid black;
                font-size: 14px;
                background-color: green;
                color: white;
                border: none;
                border-radius: 5px;
            }
            .text8{
                margin-top: -4px;
                margin-bottom: 0px;
            }
        </style>


    </head>
    <body>
        <div class="container">
            <form id="cc"  action="timetable">
                <div  class="text2">
                    <div class="text3">
                        Campus:
                    </div>
                    <div class="text4">
                        <select name="did" class="container5" id="campusSelect" onchange="document.getElementById('cc')">
                            <option value="0">Select Campus</option>
                            <c:forEach items="${requestScope.campus}" var="d">
                                <option>${d.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div style="display: flex; align-items: center; justify-content: center; margin-top: -20px">
                    <h3 style="margin-right: 10px;">Lecturer:</h3>
                    <input type="text" name="text1"/>
                    <button type="submit">View</button>
                </div>



                <table>
                    <tr>
                        <th rowspan="2" class="text5">

                            YEAR:
                            <select name="year">
                                <c:forEach items="${requestScope.years}" var="year">

                                    <option value="${year}"  <c:if test="${year == curentYear}">
                                            selected="selected"
                                        </c:if>>
                                        ${year}
                                    </option>
                                </c:forEach>
                            </select><br>


                            WEEK:<select name="weekday" onchange="this.form.submit()">
                                <c:forEach items="${requestScope.dayAndMonth}" var="week">
                                    <option value="${week.weekTimeTableID}" 
                                            <c:if test="${week.weekTimeTableID eq dayMonth}">
                                                selected="selected"
                                            </c:if>>
                                        ${week.getWeekRange()} 
                                    </option>
                                </c:forEach>
                            </select>
                            <br>

                        </th>
                        <th class="text5">MON</th>
                        <th class="text5">TUE</th>
                        <th class="text5">WED</th>
                        <th class="text5">THU</th>
                        <th class="text5">FRI</th>
                        <th class="text5">SAT</th>
                        <th class="text5">SUN</th>
                    </tr>
                    <tr class="text5">

                        <c:forEach items="${requestScope.listday}" var="week1">
                            <td>
                                ${week1}
                            </td>
                        </c:forEach>
                    </tr>
                    <c:forEach items="${requestScope.slots}" var="slot">
                        <tr>
                            <td  class="cod"> ${slot.name}</td> 

                            <c:forEach items="${requestScope.dates}" var="date">
                                <td>
                                    <c:set var="hasSession" value="false" />
                                    <c:forEach items="${requestScope.sessions}" var="session">
                                        <c:if test="${session.date eq date and session.timeslot.id eq slot.id}">
                                            <div name="nameclass">${session.group.groupName}</div>
                                            ${session.group.subject.code}-<input class="text6" type="submit" value="view Materials"/><br/>
                                            at ${session.room.name}<br/>

                                            <h4 class="text8"><a href="attendence?sesid=${session.sessionID}">Take</a></h4>
                                            <c:if test="${session.isPresent}">Edit</c:if>
                                            <c:if test="${!session.isPresent}">Take</c:if>
                                                <div class="text7">                                           
                                                    (${session.timeslot.timeStart}-${session.timeslot.timeEnd})
                                            </div>
                                            <c:set var="hasSession" value="true" />
                                        </c:if>
                                    </c:forEach>
                                    <c:if test="${not hasSession}">
                                        -
                                    </c:if>
                                </td>
                            </c:forEach>

                        </tr>
                    </c:forEach>
                </table>
            </form>
        </div>
    </body>
</html>