<%--
  Created by IntelliJ IDEA.
  User: Edu
  Date: 25.04.2021
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Person add form binded</title>
</head>
<body>
    <form:form method="post" modelAttribute="person">
        <div>
            <label for="login">Login</label>
            <form:input id="login" path="login"/>
        </div>
        <div>
            <label for="email">Email</label>
            <form:input id="email" path="email" type="email"/>
        </div>
        <div>
            <label for="password">Password</label>
            <form:password id="password" path="password"/>
        </div>
        <div>
            <input type="submit">
        </div>
    </form:form>
</body>
</html>
