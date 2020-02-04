package hw3;

import java.io.*;
import java.util.Scanner;

/**
 * Wenhan Cai
 * CS 5004 homework 3-1-Encrypt
 * Encrypt a file given by the first argument of the command line and write the encrypted content to the file given
 * by the second argument of the command line
 */
public class Encrypt {

    public static void main(String[] args) throws IOException {

        File file = new File(args[0]);
        Scanner scan = new Scanner(file);
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter a key: ");
        int k = userInput.nextInt();

        String cypherText = "";
        while(scan.hasNextLine()) {
            String currentLine = "";
            String line = scan.nextLine();
            char alphabet;
            for (int i = 0; i < line.length(); i++) {
                alphabet = line.charAt(i);
                if (Character.isLowerCase(alphabet)) {
                    alphabet = (char) ((alphabet - 'a' + k)%26 + 'a');
                    currentLine = currentLine + alphabet;
                } else if (Character.isUpperCase(alphabet)) {
                    alphabet = (char) ((alphabet - 'A' + k)%26 + 'A');
                    currentLine = currentLine + alphabet;
                } else {
                    currentLine = currentLine + alphabet;
                }
            }
            cypherText = cypherText.concat(currentLine + "\n");
        }

        FileWriter writer = new FileWriter(args[1]);
        writer.write(cypherText);
        writer.close();
    }
}