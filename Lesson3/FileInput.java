package Lesson3;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileInput {

    public static void main(String[] args) {
        Scanner file = null;
        try {
            FileInputStream inputStream = new FileInputStream("/Users/arthurcai/IdeaProjects/5004_OOD/src/Lesson3/test.txt");
            file = new Scanner(inputStream);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        };
        //if the program gets here
        //then the file was opened successfully
        int highScore;
        String name;

        System.out.println("Text left to read? " + file.hasNextLine());
        highScore = file.nextInt();
        file.nextLine();
        name = file.nextLine();

        System.out.println(highScore);
        System.out.println(name);
        file.close();
    }
}
