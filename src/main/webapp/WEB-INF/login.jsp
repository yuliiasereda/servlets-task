<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign In</title>

    <link rel="stylesheet"
          href="<c:url value="/fonts/material-icon/css/material-design-iconic-font.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
</head>

<body>
<div class="main">
    <jsp:include page="loginform.jsp"/>
</div>
<script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
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
        window.location.href = "${pageContext.request.contextPath}"
            + data.homeUrl;
      },
      error: function (xhr, status, error) {
        $('#msg').html('<span style=\'color:red;\'>' + error + '</span>')
      }
    });
  });
</script>
</body>
</html>