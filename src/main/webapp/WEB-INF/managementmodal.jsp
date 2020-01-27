<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
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
</body>
</html>
