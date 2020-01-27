<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form method="POST" class="register-form" id="log-out-form"
      action="${pageContext.request.contextPath}/user/logout" method="POST">
    <div class="form-group form-button">
        <input type="submit" name="logout" id="logout" class="form-submit"
               value="Log out"/>
    </div>
</form>
</body>
</html>
