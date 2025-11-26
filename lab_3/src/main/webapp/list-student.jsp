<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.student.dao.StudentDAO"%>
<%@page import="com.student.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException" %>
<html>
<head>
    <title>List Students</title>
</head>
<body>
    <h2>Student List</h2>
    <table border="1">
        <tr>
            <th>Roll No</th>
            <th>Name</th>
            <th>Email</th>
            <th>Age</th>
            <th>Actions</th>
        </tr>
        <%
            StudentDAO dao = new StudentDAO();
            List<Student> students = new ArrayList<>(); // initialize, not null

            try {
                students = dao.getAllStudents();
            } catch(SQLException e) {
                e.printStackTrace();
            }

            if (students != null && !students.isEmpty()) {
                for (Student student : students) {
        %>
        <tr>
            <td><%= student.getRollNo() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getEmail() %></td>
            <td><%= student.getAge() %></td>
            <td>
                <a href="update-student.jsp?rollNo=<%= student.getRollNo() %>">Update</a>
                <a href="delete-student.jsp?rollNo=<%= student.getRollNo() %>">Delete</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="5">No students found.</td>
        </tr>
        <% } %>
    </table>
    <br>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
