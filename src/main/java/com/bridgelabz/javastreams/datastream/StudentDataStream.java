package com.bridgelabz.javastreams.datastream;

import java.io.*;

public class StudentDataStream {
    public static void main(String[] args) {
        String filePath = "student_data.bin";

        // Step 1: Store Student Data
        storeStudentData(filePath);

        // Step 2: Retrieve Student Data
        retrieveStudentData(filePath);
    }

    // Method to store student details in a binary file
    public static void storeStudentData(String filePath) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            // Writing sample student data
            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(3.85);

            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(3.67);

            System.out.println("Student data stored successfully!");
        } catch (IOException e) {
            System.out.println("Error storing data: " + e.getMessage());
        }
    }

    // Method to retrieve student details from the binary file
    public static void retrieveStudentData(String filePath) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            System.out.println("\n🔍 Retrieving Student Data:");
            while (dis.available() > 0) {
                int rollNo = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll No: " + rollNo + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error retrieving data: " + e.getMessage());
        }
    }
}
