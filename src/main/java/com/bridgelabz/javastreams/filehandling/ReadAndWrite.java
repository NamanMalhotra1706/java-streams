package com.bridgelabz.javastreams.filehandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadAndWrite {
    public static void main(String[] args) throws Exception
    {
        try{
            String inputFile  =  "C:\\Users\\naman\\IdeaProjects\\java-streams\\src\\main\\java\\com\\bridgelabz\\javastreams\\filehandling\\Intro.txt";
            String outFile = "C:\\Users\\naman\\IdeaProjects\\java-streams\\src\\main\\java\\com\\bridgelabz\\javastreams\\filehandling\\OutputFile.txt";

            FileInputStream fileInputStream = new FileInputStream(inputFile);
            FileOutputStream fileOutputStream = new FileOutputStream(outFile);

            int byteCode;

            while((byteCode=fileInputStream.read())!=-1){
                fileOutputStream.write(byteCode);
            }

            System.out.println("Successfully, reads the contents of a text file and writes it into a new file");
        } catch (FileNotFoundException e) {
            System.out.println("File not milli: " + e.getMessage());
        }
        catch (IOException err){
            System.out.println("Error reading/writing file: " + err.getMessage());
        }
    }
}
