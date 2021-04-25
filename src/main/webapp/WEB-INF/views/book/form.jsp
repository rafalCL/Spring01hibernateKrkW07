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
    <form:form method="post" modelAttribute="book">
        <form:hidden path="id"/>
        <div>
            <label for="title">Title</label>
            <form:input id="title" path="title"/>
        </div>
        <div>
            <label for="rating">Rating</label>
            <form:input id="rating" path="rating" type="number" min="1" max="10"/>
        </div>
        <div>
            <label for="description">Description</label>
            <form:textarea id="description" path="description"/>
        </div>
        <div>
            <label for="authors">Authors</label>
            <form:select id="authors" path="authors" items="${authors}" itemLabel="lastName" itemValue="id"/>
        </div>
        <div>
            <label for="publisher">Publisher</label>
            <form:select id="publisher" path="publisher" items="${publishers}" itemLabel="name" itemValue="id"/>
        </div>
        <div>
            <input type="submit">
        </div>
    </form:form>
</body>
</html>
