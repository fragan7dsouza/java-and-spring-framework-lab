<%@page import="com.student.dao.StudentDAO"%>
<%@page import="java.sql.SQLException"%>
<html>
<head>
    <title>Delete Student</title>
</head>
<body>

    <h2>Delete Student</h2>
    <!-- Form to input the USN (roll number) of the student to delete -->
    <form action="delete-student.jsp" method="post">
        Enter Roll No (USN) of the student to delete:
        <input type="text" name="rollNo"><br><br>
        <input type="submit" value="Delete Student">
    </form>

    <%
        // Handle form submission
        if (request.getMethod().equals("POST")) {
            String rollNoStr = request.getParameter("rollNo");
            if (rollNoStr != null && !rollNoStr.trim().isEmpty()) {
                int rollNo = Integer.parseInt(rollNoStr);
                StudentDAO dao = new StudentDAO();

                try {
                    dao.deleteStudent(rollNo);
                    out.println("<p>Student with Roll No " + rollNo + " has been deleted successfully!</p>");
                } catch (SQLException e) {
                    out.println("<p>Error occurred while deleting the student. Please try again.</p>");
                    e.printStackTrace();
                }
            } else {
                out.println("<p>Please enter a valid Roll No.</p>");
            }
        }
    %>

    <br>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
