package Lessone10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionTest {
    public static void main(String[] args) {
        Scanner inputFile = null;
        try{
            if(args[0].contains("_")){
                throw new BadFileNameException("The input file must not contain an underscore!");
            }
            inputFile = new Scanner(new FileInputStream(args[0]));
        }
        catch (FileNotFoundException e) {
            System.out.println("Exception handler here: "+e.getMessage());
            System.exit(1);
        }
        catch (BadFileNameException e) {
            e.printStackTrace();
//            System.exit(1);

        }
        System.out.println("After try");
    }
}

class BadFileNameException extends Exception {
    public BadFileNameException(String message) {
        super(message);
    }

    public BadFileNameException(){
        super("Bad File Name");
    }
}
