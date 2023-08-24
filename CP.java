package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
    static Connection con;

    public static Connection CreateC() {
        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Create connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_manage", "root", "Satish@nb4mnu");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
