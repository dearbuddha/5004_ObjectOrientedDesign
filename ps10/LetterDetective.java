package ps10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LetterDetective {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream(args[0]));
        } catch (FileNotFoundException e) {
            System.out.println("File not found. " + e.getMessage());
            System.exit(1);
        }

        StringBuilder letterString = new StringBuilder();
        while(scanner.hasNextLine()){
            letterString.append(scanner.nextLine());
        }

        TreeMap<Character, Integer> letter = new TreeMap<>();
        for(int i = 0; i < letterString.length(); i++){
            char c = letterString.charAt(i);
            if(c != ' '){
                if(letter.containsKey(c)){
                    letter.put(c, letter.get(c)+1);
                } else {
                    letter.put(c, 1);
                }
            }
        }
//        System.out.println(letter);

        Scanner scanner2 = null;
        try {
            scanner2 = new Scanner(new FileInputStream(args[1]));
        } catch (FileNotFoundException e) {
            System.out.println("File not found. " + e.getMessage());
            System.exit(1);
        }

        StringBuilder magazineString = new StringBuilder();
        while(scanner2.hasNextLine()){
            magazineString.append(scanner2.nextLine());
        }

        TreeMap<Character, Integer> magazine = new TreeMap<>();
        for(int i = 0; i < magazineString.length(); i++){
            char c = magazineString.charAt(i);
            if(c != ' '){
                if(magazine.containsKey(c)){
                    magazine.put(c, magazine.get(c)+1);
                } else {
                    magazine.put(c, 1);
                }
            }
        }
//        System.out.println(magazine);

        int count = 0;
        for(Map.Entry<Character, Integer> entry : letter.entrySet()){
            if(magazine.containsKey(entry.getKey()) && (magazine.get(entry.getKey()) >= entry.getValue())){
                count += 1;
            } else{
                System.out.println("Not possible to write an anonymous letter with the given magazine");
                break;
            }
        }
        if(count == letter.size()){
            System.out.println("Yes! It's possible to write an anonymous letter with the given magazine");
        }
    }
}
