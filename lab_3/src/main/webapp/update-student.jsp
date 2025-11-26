<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.student.dao.StudentDAO"%>
<%@page import="com.student.model.Student"%>
<%@page import="java.sql.SQLException"%>
<html>
<head>
    <title>Update Student</title>
</head>
<body>
    <h2>Update Student</h2>

    <%
        int rollNo = Integer.parseInt(request.getParameter("rollNo"));
        StudentDAO dao = new StudentDAO();
        Student student = dao.getAllStudents().stream()
                            .filter(s -> s.getRollNo() == rollNo)
                            .findFirst()
                            .orElse(null);
    %>

    <form action="update-student.jsp" method="post">
        Roll No: <%= student.getRollNo() %> (readonly)<br>
        Name: <input type="text" name="name" value="<%= student.getName() %>"><br>
        Email: <input type="text" name="email" value="<%= student.getEmail() %>"><br>
        Age: <input type="text" name="age" value="<%= student.getAge() %>"><br>
        <input type="hidden" name="rollNo" value="<%= student.getRollNo() %>">
        <input type="submit" value="Update Student">
    </form>

    <%
        if (request.getMethod().equals("POST")) {
            int rollNoUpdate = Integer.parseInt(request.getParameter("rollNo"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            int age = Integer.parseInt(request.getParameter("age"));
            Student updatedStudent = new Student(rollNoUpdate, name, email, age);
            try {
                dao.updateStudent(updatedStudent);
            } catch(SQLException e) { }

            out.println("<p>Student updated successfully!</p>");
        }
    %>

    <a href="list-student.jsp">Back to List</a>
</body>
</html>
