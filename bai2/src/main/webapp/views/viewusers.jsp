<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Sex</th>
                <th>Country</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <% List<User> users = (List<User>) request.getAttribute("users"); %>
            <%-- Lặp qua danh sách người dùng và tạo hàng trong bảng --%>
            <% for (User user : users) { %>
                <tr>
                    <td><%= user.getId() %></td>
                    <td><%= user.getName() %></td>
                    <td><%= user.getEmail() %></td>
                    <td><%= user.getSex() %></td>
                    <td><%= user.getCountry() %></td>
                    <td>
                        <a href="editUser.jsp?id=<%= user.getId() %>">Edit</a>
                        <a href="deleteUser.jsp?id=<%= user.getId() %>">Delete</a>
                    </td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
