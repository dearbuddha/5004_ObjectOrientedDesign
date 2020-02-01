package hw1;

public class Problem_2 {
    /**
     * Wenhan Cai
     * CS 5004 homework 1-2
     *
     */
    public static void main(String[] args) {
        int gearSize = 100;
        int cadence = 90;
        double speed = gearSize * 3.14 * 1 / 12 * 1 / 5280 * cadence * 60 / 1;
        System.out.println(speed);
    }
}
