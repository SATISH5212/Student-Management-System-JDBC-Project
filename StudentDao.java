package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
    public static boolean insertStudentToDB(Student st) {
        boolean isInserted = false;
        try {
            Connection con = CP.CreateC();
            String query = "INSERT INTO student(sname, sphone, scity) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, st.getStudentName());
            pstmt.setString(2, st.getStudentPhone());
            pstmt.setString(3, st.getStudentCity());
            int rowsAffected = pstmt.executeUpdate();
            isInserted = rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isInserted;
    }

    public static boolean deleteStudent(int userId) {
        boolean isDeleted = false;
        try {
            Connection con = CP.CreateC();
            String query = "DELETE FROM student WHERE sid=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, userId);
            
            int rowsAffected = pstmt.executeUpdate();
            isDeleted = rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted;	
    }

    public static void showAllStudents() {
        try {
            Connection con = CP.CreateC();
            String query = "SELECT * FROM student";
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("sid");
                String name = resultSet.getString("sname");
                String phone = resultSet.getString("sphone");
                String city = resultSet.getString("scity");

                System.out.println("ID : " + id);
                System.out.println("NAME : " + name);
                System.out.println("PHONE : " + phone);
                System.out.println("CITY : " + city);
                System.out.println("++++++++++++++++++++++++++++");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
