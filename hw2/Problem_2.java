package hw2;
import java.util.Scanner;

public class Problem_2 {
    /**
     * Wenhan Cai
     * CS 5004 homework 2-2
     */
    public static void main(String[] args) {
        System.out.println("Please enter price of item (in cents, from 25 cents to a dollar, in 5-cent increments):");
        Scanner scannerObject = new Scanner(System.in);
        int price = scannerObject.nextInt();
        int change = 100 - price;
        int quarter = change / 25;
        int dime = (change - quarter * 25) / 10;
        int nickel = (change - quarter * 25 - dime * 10) / 5;
        System.out.println("You bought an item for " + price + " cents and game me a dollar");
        System.out.println("so your change is");
        System.out.println(quarter + " quarters");
        System.out.println(dime + " dimes, and");
        System.out.println(nickel + " nickels");
    }
}
