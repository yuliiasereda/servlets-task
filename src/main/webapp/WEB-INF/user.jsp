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

    <!-- Font Icon -->
    <link rel="stylesheet" href="<c:url value="/fonts/material-icon/css/material-design-iconic-font.min.css"/>">

    <!-- Main css -->
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
</head>
<body>

<div class="main">
    <!-- Sing in  Form -->
    <section class="sign-in">
        <div class="container">
            <div class="signin-content">

                <div class="signin-form">
                    <h2 class="form-title">User Profile</h2>
                    <div class="form-group">

                    <c:forEach items="${users}" var="user">
                        <table border=1>
                            <tr>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Password</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                        <tr>
                            <td>${user.name}</td>
                            <td>${user.email}</td>
                            <td>${user.password}</td>
                        </tr>
                        </table>
                    </c:forEach>
                    </div>
                    <form method="POST" class="register-form" id="log-out-form" action = "${pageContext.request.contextPath}/user/logout" method = "POST">
                    <div class="form-group form-button">
                        <input type="submit" name="logout" id="logout" class="form-submit" value="Log out"/>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </section>

</div>

<!-- JS -->
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>