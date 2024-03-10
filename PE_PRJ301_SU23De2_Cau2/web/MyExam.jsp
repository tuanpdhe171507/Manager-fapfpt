<%-- 
    Document   : MyExam
    Created on : Mar 11, 2024, 12:50:50 AM
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
            .text{
                width: 169px;
                height: 20px;
                border: 1px solid black;
                margin-left: 73px;
            }
            .text2{
                margin-top: 5px;
                display: flex;
                
            }
        </style>
    </head>
    <body>
        <form action="execute" method="POST">
            Enter an integer n:<input type="number" name="number"/></br>
            <div class="text2">
                <div>Result:</div>
                <div class="text">${result}</div>
            </div><br>
            <input type="submit" value="Execute"/>
        </form>
    </body>
</html>
