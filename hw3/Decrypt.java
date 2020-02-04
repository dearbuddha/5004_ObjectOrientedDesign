package hw3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Wenhan Cai
 * CS 5004 homework 3-1-Dncrypt
 * Decrypt a file given by the second argument of the command line and write the decrypted content to the file given
 * by the first argument of the command line
 */
public class Decrypt {

    public static void main(String[] args) throws IOException {
        File file = new File(args[1]);
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
                    if(alphabet-k%26<'a'){
                        alphabet = (char)('z'-(k%26-(alphabet-'a')-1));
                        currentLine = currentLine + alphabet;
                    }else {
                        alphabet = (char)(alphabet-k%26);
                        currentLine = currentLine + alphabet;
                    }
                } else if (Character.isUpperCase(alphabet)) {
                    if(alphabet-k%26<'A'){
                        alphabet = (char)('Z'-(k%26-(alphabet-'A'))+1);
                        currentLine = currentLine + alphabet;
                    }else {
                        alphabet = (char)(alphabet-k%26);
                        currentLine = currentLine + alphabet;
                    }
                } else {
                    currentLine = currentLine + alphabet;
                }
            }
            cypherText = cypherText.concat(currentLine + "\n");
        }

        FileWriter writer = new FileWriter(args[0]);
        writer.write(cypherText);
        writer.close();
    }
}
