package com.linkedin.javacodechallenges;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class App {
    public static void redactTextFile(String fileName,
                                      String[] redactedWordsArray) {

        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            StringBuilder redactedText = new StringBuilder();
            while(scanner.hasNext()){
                String line = scanner.nextLine();

                String[] splitwords = line.split(" ");
                for(int i = 0 ; i < splitwords.length; i++)  {
                    String checking = splitwords[i];
                    String valueToWrite = checking;
                    System.out.println("checking: " + checking);
                    for (String value : redactedWordsArray) {
                        if (checking.equals(value)) {
                            valueToWrite = "REDACTED";
                            break;
                        }
                    }
                    redactedText.append(valueToWrite);
                    if(i < splitwords.length -1){
                        redactedText.append(" ");
                    }

                }
                redactedText.append("\n");


            }

            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(redactedText.toString());
            myWriter.close();


        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What file would you like to " +
                "redact information from?");
        String fileName = scanner.nextLine();

        System.out.println("What words would you like to redact? " +
                "Separate each word or phrase with a comma. " +
                "If you phrase includes punctuation, include " +
                "that in your input.");
        String redactedWords = scanner.nextLine();
        String[] redactedWordsList = redactedWords.split(",");

        redactTextFile(fileName, redactedWordsList);

        scanner.close();
    }
}
