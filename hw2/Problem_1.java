package hw2;
import java.util.Scanner;

public class Problem_1 {
    /**
     * Wenhan Cai
     * CS 5004 homework 2-1
     */
    public static void main(String[] args) {
        Scanner scannerObject = new Scanner(System.in);
        System.out.println("Please enter two integers. First as the dividend, second as the divisor.");
        int num1 = scannerObject.nextInt();
        int num2 = scannerObject.nextInt();
        int quotient = num1 / num2;
        int remainder = num1 % num2;
        System.out.println("Dividend: " + num1);
        System.out.println("Divisor: " + num2);
        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder: " + remainder);
    }
}
