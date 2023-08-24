package com.student.manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {

    public static void main(String[] args) throws IOException {
        System.out.println("WELCOME TO THE STUDENT MANAGEMENT SYSTEM");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("PRESS 1 TO ADD THE STUDENT");
            System.out.println("PRESS 2 TO DELETE THE STUDENT");
            System.out.println("PRESS 3 TO DISPLAY THE STUDENT");
            System.out.println("PRESS 4 TO EXIT");

            int c = Integer.parseInt(br.readLine());

            if (c == 1) {
                // TODO: Implement adding a student
                System.out.println("Enter user Name: ");
                String name = br.readLine();
                System.out.println("Enter user Phone: ");
                String phone = br.readLine();
                System.out.println("Enter user city: ");
                String city = br.readLine();

                // Create student object to store student data
                Student st = new Student(name, phone, city);

                // Insert student into the database
                boolean isAdded = StudentDao.insertStudentToDB(st);
                if (isAdded) {
                    System.out.println("Student is added successfully");
                } else {
                    System.out.println("Something went wrong");
                }
                System.out.println(st);

            } else if (c == 2) {
                // TODO: Implement deleting a student
                System.out.println("Enter student Id to delete: ");
                int userId = Integer.parseInt(br.readLine());
                boolean isDeleted = StudentDao.deleteStudent(userId);
                if (isDeleted) {
                    System.out.println("Student deleted successfully");
                } else {
                    System.out.println("Something went wrong");
                }

            } else if (c == 3) {
                // Display all students
                StudentDao.showAllStudents();

            } else if (c == 4) {
                // Exit
                break;

            } else {
                System.out.println("Invalid choice");
            }
        }

        br.close();
    }
}
