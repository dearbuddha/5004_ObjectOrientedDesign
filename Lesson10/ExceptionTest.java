package Lesson10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.naming.InvalidNameException;

// test for exception handling

public class ExceptionTest {
    public static void main(String[] args) {
        // Scanner inputFile = null;
        // System.out.println("The number of command-line arguments is " + args.length);

        // System.out.println("Before try");

        // try {
        //     System.out.println("Start");
        //     if (args[0].contains("_")) {
        //         throw new BadNameException("The input file must not contain an underscore!", 66);
        //     }
        //     inputFile = new Scanner(new FileInputStream(args[0]));
        //     System.out.println("End");
        // }
        // catch (FileNotFoundException eee) {
        //     System.out.println("Exception handler 1 here! " + eee.getMessage());
        //     System.exit(1);
        // }
        // catch (BadNameException e) {
        //     System.out.println("Exception handler 2 here! " + e.getMessage());
        //     //System.exit(1);
        // }

        // System.out.println("After try");

        Person p = new Person("John", 28);
        try {
            p.changeAge(-30);
        }
        catch (BadNameException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.out.println(p);

        //System.out.println(args[11]);

    }
}

class BadNameException extends Exception {
    public BadNameException(String message) {
        super(message);
    }
    public BadNameException() {
        super("Bad File Name");
    }
    public BadNameException(String message, int code) {
        super(message);
        this.code = code;
    }
    public String getMessage() {
        return super.getMessage() + " -- the code is " + code;
    }
    private int code;
}

class BadNameException2 extends Exception {
    public BadNameException2(String message) {
        super(message);
    }
    public BadNameException2() {
        super("Bad File Name");
    }
    public BadNameException2(String message, int code) {
        super(message);
        this.code = code;
    }
    public String getMessage() {
        return super.getMessage() + " -- the code is " + code;
    }
    private int code;
}

class Person {
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private String name;
    private int age;
    public void changeAge(int age) throws BadNameException {
        try {
            if (age < 0) {
                throw new BadNameException("Age must be positive.");
            }
            if (age > 100) {
                throw new BadNameException2("Too old!");
            }
            this.age = age;
        }
        catch (BadNameException2 e) {
            System.err.println(e.getMessage());
        }
        finally {
            System.out.println("Finally here!");
        }
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String toString() {
        return getName() + ", " + getAge();
    }
}