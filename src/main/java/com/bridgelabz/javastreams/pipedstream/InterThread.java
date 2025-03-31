package com.bridgelabz.javastreams.pipedstream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class InterThread {
    public static void main(String[] args) {
        try {
            // Step 1: Create Piped Streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            // Step 2: Create a writer thread
            Thread writerThread = new Thread(() -> {
                try {
                    String message = "Hello from Writer Thread!";
                    pos.write(message.getBytes());
                    pos.close(); // Close after writing
                } catch (IOException e) {
                    System.out.println("Writer Error: " + e.getMessage());
                }
            });

            // Step 3: Create a reader thread
            Thread readerThread = new Thread(() -> {
                try {
                    int data;
                    System.out.print("Reader Received: ");
                    while ((data = pis.read()) != -1) { // Read from pipe
                        System.out.print((char) data);
                    }
                    pis.close(); // Close after reading
                } catch (IOException e) {
                    System.out.println("Reader Error: " + e.getMessage());
                }
            });

            // Step 4: Start both threads
            writerThread.start();
            readerThread.start();

            // Step 5: Ensure both threads complete execution
            writerThread.join();
            readerThread.join();

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
