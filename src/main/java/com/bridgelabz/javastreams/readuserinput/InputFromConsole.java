package com.bridgelabz.javastreams.readuserinput;

import java.io.*;

public class InputFromConsole {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writeToFile = new BufferedWriter(new FileWriter("C:\\Users\\naman\\IdeaProjects\\java-streams\\src\\main\\java\\com\\bridgelabz\\javastreams\\readuserinput\\OutputFromConsole.txt"))) {

            System.out.print("Enter the name: ");
            String name = bufferedReader.readLine();

            System.out.print("Enter the age: ");
            int age = Integer.parseInt(bufferedReader.readLine());

            System.out.print("Enter your favorite programming language: ");
            String favoriteProgrammingLanguage = bufferedReader.readLine();

            writeToFile.write("Name: " + name);
            writeToFile.newLine();
            writeToFile.write("Age: " + age);
            writeToFile.newLine();
            writeToFile.write("Favorite Programming Language: " + favoriteProgrammingLanguage);
            writeToFile.newLine();

            System.out.println("✅ Data successfully saved to 'OutputFromConsole.txt'!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Age must be a number.");
        }
    }
}
