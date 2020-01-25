<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>User Profile</title>

    <!-- Font Icon -->
    <link rel="stylesheet"
          href="<c:url value="/fonts/material-icon/css/material-design-iconic-font.min.css"/>">

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
                        <table border=1>
                            <tr>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Password</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                            <c:forEach items="${users}" var="user">
                                <tr>
                                    <td>${user.name}</td>
                                    <td>${user.email}</td>
                                    <td>${user.password}</td>
                                    <td>
                                        <div class="form-group form-button">
                                            <button id="updateButton"
                                                    onclick="updateBtn('${user.email}', '${user.name}', '${user.password}')">
                                                Update
                                            </button>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="form-group form-button">
                                            <form id="delete-form">
                                            <button id="deleteButton"
                                                    onclick="deleteBtn('${user.email}')">
                                                Delete
                                            </button>
                                            </form>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                        <div id="updateModal" class="modal">
                            <div class="modal-content">
                                <span class="close">&times;</span>
                                <form id="update-form">
                                    <table border=1>
                                        <tr>
                                            <th>Name</th>
                                            <th>Email</th>
                                            <th>Password</th>
                                        </tr>
                                        <tr>
                                             <th>
                                                <input id="update-name-input" type="text"/>
                                            </th>
                                            <th>
                                                <input id="update-email-input" type="text"/>
                                                <input id="old-email-input" type="hidden" />
                                            </th>
                                            <th>
                                                <input id="update-password-input" type="text"/>
                                            </th>
                                        </tr>
                                </table>
                                    <div id="msg">TEXT</div>
                                <input type="submit" name="updateSubmit" id="updateSubmit"
                                       class="form-submit"
                                       value="Submit"/>
                                </form>
                            </div>
                        </div>
                    </div>
                    <form method="POST" class="register-form" id="log-out-form"
                          action="${pageContext.request.contextPath}/user/logout" method="POST">
                        <div class="form-group form-button">
                            <input type="submit" name="logout" id="logout" class="form-submit"
                                   value="Log out"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</div>
</section>

</div>

<!-- JS -->
<script src="../vendor/jquery/jquery.min.js"></script>
<script>var ctx = "${pageContext.request.contextPath}"</script>
<script src="../js/main.js"></script>
<script src="../js/modal.js"></script>
<script src="../js/update.js"></script>
<script src="../js/delete.js"></script>
</body>
</html>