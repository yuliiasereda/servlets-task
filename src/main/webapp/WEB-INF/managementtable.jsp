<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
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
</body>
</html>
