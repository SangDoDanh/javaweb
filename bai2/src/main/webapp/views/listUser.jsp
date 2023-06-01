<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %>

<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<body>
<h1>User List</h1>
<p>${message}</p>
<a class="btn btn-primary" href="/views/addUser.jsp">Add user</a>
<table class="table table-hover table-striped">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Sex</th>
        <th>Country</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<User> userList = (List<User>) request.getAttribute("users");
        for (User user : userList) {
    %>
    <tr>
        <td><%= user.getId() %></td>
        <td><%= user.getName() %></td>
        <td><%= user.getEmail() %></td>
        <td><%= user.getPassword() %></td>
        <td><%= user.getSex() %></td>
        <td><%= user.getCountry() %></td>
        <td>
            <a class="btn btn-sm btn-warning" href="./views/editUser.jsp?id=<%= user.getId() %>">Edit</a>
            <a class="btn btn-sm btn-danger" href="/users?action=delete&id=<%= user.getId() %>">Delete</a>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
