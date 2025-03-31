package com.bridgelabz.javastreams.bytearraystream;

import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) {
        try{
            FileInputStream fis = new FileInputStream("C:\\Users\\naman\\IdeaProjects\\java-streams\\src\\main\\java\\com\\bridgelabz\\javastreams\\bytearraystream\\cartoon.png");
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            byte[] buffer = new byte[4096];
            int bytes;

            while((bytes=fis.read(buffer))!=-1){
                bos.write(buffer,0,bytes);
            }

            fis.close();
            byte[] imageBytes = bos.toByteArray();

            ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream("C:\\Users\\naman\\IdeaProjects\\java-streams\\src\\main\\java\\com\\bridgelabz\\javastreams\\bytearraystream\\cartoonCopy.png");

            while((bytes=bis.read(buffer))!=-1){
              fos.write(buffer,0,bytes);
            }
            fos.close();

            System.out.println("Image Copy Successfully");
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
