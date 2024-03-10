<%-- 
    Document   : login
    Created on : Mar 10, 2024, 3:57:29 PM
    Author     : G5 5590
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST">
            Enter UserName:<input type="text" name="username"/><br></br>
            Enter PassWrod:<input type="text" name="password"/></br></br>
            <input type="submit" value="Login"/></br></br>
            ${text1}
        </form>
    </body>
</html>
