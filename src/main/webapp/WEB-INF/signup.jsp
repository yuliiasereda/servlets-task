<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up</title>

    <link rel="stylesheet" href="<c:url value="/fonts/material-icon/css/material-design-iconic-font.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
</head>

<body>
    <div class="main">
        <jsp:include page="signupform.jsp"/>
    </div>
</body>
</html>