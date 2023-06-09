<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User Form</title>
</head>
<body>

    <%@page import="model.User,repository.UserDao" %>

    <%
        String id=request.getParameter("id");
        User u=UserDao.getRecordById(Integer.parseInt(id));
    %>
    <h1>Edit Form</h1>
    <a href="/users">View all</a>
    <p>${message}</p>
    <form action="/users?action=update" method="post">
    <input type="hidden" name="id" value="<%=u.getId() %>"/>
    <table>
    <tr><td>Name:</td><td>
    <input type="text" name="name" value="<%= u.getName()%>"/></td></tr>
    <tr><td>Password:</td><td>
    <input type="password" name="password" value="<%= u.getPassword()%>"/></td></tr>
    <tr><td>Email:</td><td>
    <input type="email" name="email" value="<%= u.getEmail()%>"/></td></tr>
    <tr><td>Sex:</td><td>
    <input type="radio" name="sex" value="Male" <%= ("Male".equals(u.getSex())) ? "checked" : "" %> />Male
    <input type="radio" name="sex" value="Female" <%= ("Female".equals(u.getSex())) ? "checked" : "" %> />Female
    </td></tr>
    <tr><td>Country:</td><td>
    <select name="country">
        <option <%= ("USA".equals(u.getCountry())) ? "selected" : "" %>>USA</option>
        <option <%= ("Canada".equals(u.getCountry())) ? "selected" : "" %>>Canada</option>
        <option <%= ("UK".equals(u.getCountry())) ? "selected" : "" %>>UK</option>
        <option <%= ("Australia".equals(u.getCountry())) ? "selected" : "" %>>Australia</option>
        <option <%= ("Germany".equals(u.getCountry())) ? "selected" : "" %>>Germany</option>
        <option <%= ("Other".equals(u.getCountry())) ? "selected" : "" %>>Other</option>
    </select>
    </td></tr>
    <tr><td colspan="2"><input type="submit" value="Edit User"/></td></tr>
    </table>
    </form>

</body>
</html>