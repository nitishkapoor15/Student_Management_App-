package Database;

import java.sql.*;
import java.util.*;

public class StudentDAO { 
// add method to add student
    public void addStudent(Student student) {
        try {
            Connection con = DBConnection.createConnection();
            String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getGrade());
            ps.executeUpdate();
            System.out.println("✅ Student Added Successfully!");
        } catch (Exception e) {
            System.out.println("❌ Error Adding Student: " + e.getMessage());
        }
    }
 //view method to view all the student
    public void getAllStudents() {
    	try {
    	Connection con = DBConnection.createConnection();
        String query = "SELECT * FROM students";
        PreparedStatement pstmt = con.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();

            System.out.println("\n📋 Student List:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Name: " + rs.getString("name") +
                                   ", Age: " + rs.getInt("age") +
                                   ", Grade: " + rs.getString("grade"));
            }
    	}
         catch (Exception e) {
            System.out.println("❌ Error Fetching Students: " + e.getMessage());
        }
    }
 // update method to update the student
    public void updateStudent(Student student) {
        try {
            Connection con = DBConnection.createConnection();
            String sql = "UPDATE students SET name=?, age=?, grade=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getGrade());
            ps.setInt(4, student.getId());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Student Updated Successfully!");
            } else {
                System.out.println("⚠️ No Student Found With ID " + student.getId());
            }
        } catch (Exception e) {
            System.out.println("❌ Error Updating Student: " + e.getMessage());
        }
    }
 // Delete method to delete student
    public void deleteStudent(int id) {
        try {
            Connection con = DBConnection.createConnection();
            String sql = "DELETE FROM students WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("🗑️ Student Deleted Successfully!");
            } else {
                System.out.println("⚠️ No Student Found With ID " + id);
            }
        } catch (Exception e) {
            System.out.println("❌ Error Deleting Student: " + e.getMessage());
        }
    }
}
