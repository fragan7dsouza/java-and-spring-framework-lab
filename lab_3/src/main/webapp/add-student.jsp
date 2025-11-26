<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.student.dao.StudentDAO"%>
<%@page import="com.student.model.Student"%>
<%@page import="java.sql.SQLException"%>
<html>
<head>
    <title>Add Student</title>
</head>
<body>
    <h2>Add Student</h2>
    <form action="add-student.jsp" method="post">
        <table>
            <tr>
                <td>Roll No:</td>
                <td><input type="text" name="rollNo"></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><input type="text" name="age"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:center;">
                    <input type="submit" value="Add Student">
                </td>
            </tr>
        </table>
    </form>
    
    <%
    if (request.getMethod().equals("POST")) {
        int rollNo = Integer.parseInt(request.getParameter("rollNo"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        Student student = new Student(rollNo, name, email, age);
        StudentDAO dao = new StudentDAO();

        try {
            dao.addStudent(student);
            out.println("<p>Student added successfully!</p>");
        } catch (SQLException e) {
            out.println("<p style='color:red;'>Error adding student. Check server logs.</p>");
            e.printStackTrace();
        }
    }
    %>

    <br>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
