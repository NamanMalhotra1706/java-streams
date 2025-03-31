package com.bridgelabz.javastreams.serializable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Employee class implementing Serializable
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Display employee details
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: Rs. " + salary);
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {
        String filePath = "employees.ser"; // File to store serialized objects

        // Step 1: Serialize Employees
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101, "Alice", "IT", 60000));
        employeeList.add(new Employee(102, "Bob", "HR", 50000));
        employeeList.add(new Employee(103, "Charlie", "Finance", 70000));

        serializeEmployees(employeeList, filePath);

        // Step 2: Deserialize Employees
        List<Employee> retrievedEmployees = deserializeEmployees(filePath);

        // Display retrieved employees
        System.out.println("\n🔍 Retrieved Employee Data:");
        for (Employee emp : retrievedEmployees) {
            emp.display();
        }
    }

    // Method to serialize the list of employees
    public static void serializeEmployees(List<Employee> employees, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(employees); // Write the list of employees to file
            System.out.println("✅ Employees serialized successfully!");
        } catch (IOException e) {
            System.out.println("Serialization Error: " + e.getMessage());
        }
    }

    // Method to deserialize employees from file
    @SuppressWarnings("unchecked")
    public static List<Employee> deserializeEmployees(String filePath) {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            employees = (List<Employee>) ois.readObject(); // Read and cast object
            System.out.println("✅ Employees deserialized successfully!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization Error: " + e.getMessage());
        }
        return employees;
    }
}