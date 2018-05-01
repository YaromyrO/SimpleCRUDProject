<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Яромир
  Date: 11.02.2018
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <!--ми отримуємо лист юзерів з атрибуту котрий ми передали в SelectServlet та вивовдимо кожного юзера та його поля-->

    <c:forEach items="${users}" var="user">
        ${user.id}<br>
        ${user.name}<br>
        ${user.surname}<br>
        ${user.age}<br>
    </c:forEach>

    <a href="pages/index.jsp">Back</a>

</body>
</html>
