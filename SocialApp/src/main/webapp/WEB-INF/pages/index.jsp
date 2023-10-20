<%-- 
    Document   : index
    Created on : Sep 3, 2023, 8:19:24 PM
    Author     : tadai
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
        <h1>Hello World!</h1>
        <ul>
            <c:forEach items="${users}" var="p">
                <li>${p.userID}. ${p.username} - ${p.role}</li>
            </c:forEach>
        </ul>
    </body>
</html>
