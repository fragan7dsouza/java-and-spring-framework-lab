package com.student.dao;

import com.student.model.Student;
import com.student.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Insert student
    public void addStudent(Student student) throws SQLException {
        Connection con = DBUtil.getConnection();
        String query = "INSERT INTO students(roll_no, name, email, age) VALUES(?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, student.getRollNo());
        ps.setString(2, student.getName());
        ps.setString(3, student.getEmail());
        ps.setInt(4, student.getAge());
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    // Retrieve all students
    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        Connection con = DBUtil.getConnection();
        Statement stmt = con.createStatement();
        String query = "SELECT * FROM students";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            Student student = new Student();
            student.setRollNo(rs.getInt("roll_no"));
            student.setName(rs.getString("name"));
            student.setEmail(rs.getString("email"));
            student.setAge(rs.getInt("age"));
            students.add(student);
        }
        rs.close();
        stmt.close();
        con.close();
        return students;
    }

    // Update student
    public void updateStudent(Student student) throws SQLException {
        Connection con = DBUtil.getConnection();
        String query = "UPDATE students SET name = ?, email = ?, age = ? WHERE roll_no = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, student.getName());
        ps.setString(2, student.getEmail());
        ps.setInt(3, student.getAge());
        ps.setInt(4, student.getRollNo());
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    // Delete student
    public void deleteStudent(int rollNo) throws SQLException {
        Connection con = DBUtil.getConnection();
        String query = "DELETE FROM students WHERE roll_no = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, rollNo);
        ps.executeUpdate();
        ps.close();
        con.close();
    }
}
