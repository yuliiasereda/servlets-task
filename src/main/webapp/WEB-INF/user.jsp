<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>User Profile</title>

    <link rel="stylesheet" href="<c:url value="/fonts/material-icon/css/material-design-iconic-font.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
</head>

<body>
<div class="main">
    <section class="sign-in">
        <div class="container">
            <div class="signin-content">
                <div class="signin-form">
                    <h2 class="form-title">User Profile</h2>
                    <div class="form-group">
                        <jsp:include page="usertable.jsp"/>
                    </div>
                    <jsp:include page="logout.jsp"/>
                </div>
            </div>
        </div>
    </section>
</div>

<script src="../vendor/jquery/jquery.min.js"></script>
</body>
</html>