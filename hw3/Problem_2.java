package hw3;

import java.util.Scanner;

/**
 * Wenhan Cai
 * CS 5004 homework 3-2
 */
public class Problem_2 {

    /**
     * utility method: compute the factorial of input n
     * @param n
     * @return factorial of parameter n
     */
    public static int factorial(int n){
        if(n <= 1){
            return 1;
        }
        else{
            return n*factorial(n-1);
        }
    }

    /**
     * Compute the mathematical constant to the xth power using a approximation method
     * @param x
     * @param n
     * @return mathematical constant to the xth power
     */
    public static double mathConst(double x, int n){
        double result = 0;
        double item;
        double nominator = 1;
        for(int i = 0; i <= n; i++){
            if(i == 0){
                nominator = 1;
            }else {
                nominator = nominator * x;
            }
            item = nominator / factorial(i);
            result = result + item;
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter x and n: ");
        double x = scanner.nextDouble();
        int n = scanner.nextInt();
        double mathConstant = mathConst(x, n);
        System.out.println("The result is: "+mathConstant);
    }
}
