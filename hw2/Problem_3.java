package hw2;
import java.util.Scanner;

public class Problem_3 {
    /**
     * Wenhan Cai
     * CS 5004 homework 2-3
     */
    public static void main(String[] args) {

        Scanner scannerObject = new Scanner(System.in);

        System.out.println("Input name of item 1:");
        String nameItem1 = scannerObject.next();
        scannerObject.nextLine();
        System.out.println("Input quantity of item 1:");
        int quantityItem1 = scannerObject.nextInt();
        scannerObject.nextLine();
        System.out.println("Input price of item 1:");
        double priceItem1 = scannerObject.nextDouble();
        scannerObject.nextLine();

        System.out.println("Input name of item 2:");
        String nameItem2 = scannerObject.next();
        scannerObject.nextLine();
        System.out.println("Input quantity of item 2:");
        int quantityItem2 = scannerObject.nextInt();
        scannerObject.nextLine();
        System.out.println("Input price of item 2:");
        double priceItem2 = scannerObject.nextDouble();
        scannerObject.nextLine();

        System.out.println("Input name of item 3:");
        String nameItem3 = scannerObject.next();
        scannerObject.nextLine();
        System.out.println("Input quantity of item 3:");
        int quantityItem3 = scannerObject.nextInt();
        scannerObject.nextLine();
        System.out.println("Input price of item 3:");
        double priceItem3 = scannerObject.nextDouble();
        scannerObject.nextLine();

        double totalItem1 = priceItem1 * quantityItem1;
        double totalItem2 = priceItem2 * quantityItem2;
        double totalItem3 = priceItem3 * quantityItem3;

        double subtotal = quantityItem1 * priceItem1 + quantityItem2 * priceItem2 + quantityItem3 * priceItem3;
        double saleseTax = subtotal * 0.0625;
        double total = subtotal + saleseTax;
        System.out.printf("%-30s %-10s %-10s %-10s %n", "Item", "Quantity", "Price", "Total");
        System.out.printf("%-30s %-10d %-10.2f %-10.2f%n", nameItem1, quantityItem1, priceItem1, totalItem1);
        System.out.printf("%-30s %-10d %-10.2f %-10.2f%n", nameItem2, quantityItem2, priceItem2, totalItem2);
        System.out.printf("%-30s %-10d %-10.2f %-10.2f%n", nameItem3, quantityItem3, priceItem3, totalItem3);
        System.out.printf("Subtotal %49.2f%n", subtotal);
        System.out.printf("6.25 percent sales tax %34.2f%n", saleseTax);
        System.out.printf("Total %52.2f", total);
    }
}
