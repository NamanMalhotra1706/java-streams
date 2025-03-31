package com.bridgelabz.javastreams.countwordsinafile;

import java.io.BufferedReader;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;

public class WordsInAFile {
    public static void main(String[] args) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\naman\\IdeaProjects\\java-streams\\src\\main\\java\\com\\bridgelabz\\javastreams\\countwordsinafile\\Input.txt"))){
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+"); 
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
            return ;
        }

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCountMap.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Display the top 5 most frequent words
        System.out.println("Top 5 most frequently occurring words:");
        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
            if (++count == 5) break;
        }
    }
}
