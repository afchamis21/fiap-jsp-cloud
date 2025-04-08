<%@ page import="com.fiap.on.esoa.domain.Wine" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: afcha
  Date: 07/04/2025
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Vinheria Agnello</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>

<jsp:useBean id="wines" scope="request" type="java.util.List<com.fiap.on.esoa.domain.Wine>"/>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<ul>
    <c:forEach var="wine" items="${wines}">
        <li>
            <p>${wine.name}</p>
            <p>${wine.year}</p>
            <p>R$ ${wine.price}</p>

            <img src="${contextPath}/img?id=${wine.image}" alt="${wine.alt}" title="${wine.alt}"/>
        </li>
    </c:forEach>
</ul>
</body>
</html>
