package com.bridgelabz.javastreams.bufferedstreams;

import java.io.*;

public class EfficientFileCopy {
    public static void main(String[] args) {
        String inputFile  =  "C:\\Users\\naman\\IdeaProjects\\java-streams\\src\\main\\java\\com\\bridgelabz\\javastreams\\bufferedstreams\\InputFile.txt";
        String outputFile = "C:\\Users\\naman\\IdeaProjects\\java-streams\\src\\main\\java\\com\\bridgelabz\\javastreams\\bufferedstreams\\OutputFile.txt";

        long bufferedTime = copyFileUsingBufferedStreams(inputFile, outputFile);
        long unbufferedTime = copyFileUsingUnbufferedStreams(inputFile, outputFile);

        long performacneTime = unbufferedTime/bufferedTime;
        System.out.println("Performance of BufferReader is " + performacneTime + " x faster");
    }

    public static long copyFileUsingBufferedStreams(String inputFile, String outputFile){
        long startTime = System.nanoTime();

        try{
            BufferedInputStream bufferInput = new BufferedInputStream(new FileInputStream(inputFile));
            BufferedOutputStream bufferOutput = new BufferedOutputStream(new FileOutputStream(outputFile));

            byte[] buffer = new byte[4096]; // 4 KB chunk size
            int bytesRead;
            while ((bytesRead = bufferInput.read(buffer)) != -1) {
                bufferOutput.write(buffer, 0, bytesRead);
            }

        }
        catch (IOException e){
            System.out.println("Error copying file (Buffered): " + e.getMessage());
        }
        return System.nanoTime()-startTime;
    }

    private static long copyFileUsingUnbufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            int byteCode;
            while ((byteCode = fis.read()) != -1) {
                fos.write(byteCode); // Writing byte-by-byte (Slow!)
            }

        } catch (IOException e) {
            System.out.println("Error copying file (Unbuffered): " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }





}
