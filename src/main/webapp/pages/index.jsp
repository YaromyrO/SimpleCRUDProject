<%--
  Created by IntelliJ IDEA.
  User: Яромир
  Date: 10.02.2018
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form action="/save" method="post">
    <input type="text" name="name" placeholder="name">
    <input type="text" name="surname" placeholder="surname">
    <input type="text" name="age" placeholder="age">
    <input type="submit" value="save">
</form>

<form action="/delete" method="post">
    <input type="text" name="id" placeholder="id">
    <input type="submit" value="delete">
</form>

<form action="/select" method="get">
    <input type="submit" value="select">
</form>

</body>
</html>
