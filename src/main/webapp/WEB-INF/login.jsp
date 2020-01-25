<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign In</title>

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
                    <div class="signin-image">
                        <figure><img src="<c:url value="/images/signin-image.jpg"/>" alt="sing up image"></figure>
                        <a href="<c:url value="/user/signup"/>" class="signup-image-link">Create an account</a>
                    </div>

                    <div class="signin-form">
                        <h2 class="form-title">Sign in</h2>
                        <form id="form">
                            <div class="form-group">
                                <label for="your_email"><i class="zmdi zmdi-email"></i></label>
                                <input type="text" name="your_email" id="your_email" placeholder="Email"/>
                            </div>
                            <div class="form-group">
                                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="your_pass" id="your_pass" placeholder="Password"/>
                            </div>
                            <div class="form-group">
                                <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" />
                                <label for="remember-me" class="label-agree-term"><span><span></span></span>Remember me</label>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signin" id="signin" class="form-submit" value="Log in"/>
                            </div>
                        </form>
                        <div id="msg"></div>
                    </div>
                </div>
            </div>
        </section>

    </div>

    <!-- JS -->
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js">
    </script>
    <script>
        $("#form").closest('form').on('submit', function (event) {
            event.preventDefault();
            var $form = $(this);
            var url = "${pageContext.request.contextPath}/user/login";
            var email = $form.find('input[name="your_email"]').val();
            var password = $form.find('input[name="your_pass"]').val();

            $.ajax({
                type: 'PUT',
                url: url,
                contentType: 'application/json',
                data: JSON.stringify({email: email, password: password}),
                success: function (data) {
                    console.log('Redirecting...');
                    window.location.href = "${pageContext.request.contextPath}/management/users";
                },
                error: function (xhr, status, error) {
                    $('#msg').html('<span style=\'color:red;\'>' + error + '</span>')
                }
            });
        });
    </script>
</body>
</html>