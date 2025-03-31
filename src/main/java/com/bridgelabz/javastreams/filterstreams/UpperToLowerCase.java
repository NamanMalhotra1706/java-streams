package com.bridgelabz.javastreams.filterstreams;

import java.io.*;

public class UpperToLowerCase {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\naman\\IdeaProjects\\java-streams\\src\\main\\java\\com\\bridgelabz\\javastreams\\filterstreams\\InputFile.txt"));

            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\\\Users\\\\naman\\\\IdeaProjects\\\\java-streams\\\\src\\\\main\\\\java\\\\com\\\\bridgelabz\\\\javastreams\\\\filterstreams\\\\OutputFile.txt"));

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }
            br.close();
            bw.close();

        } catch (FileNotFoundException e) {
            System.out.println("File Not Exist: " + e.getMessage());
        } catch (IOException e){
            System.out.println("File Error: " + e.getMessage());
        }

    }
}
