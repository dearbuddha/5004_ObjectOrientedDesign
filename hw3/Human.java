package hw3;

import java.util.Random;
import java.util.Scanner;

/**
 * Wenhan Cai
 * CS 5004 homework 3-3
 * Human class
 * perform a series of actions when it is the human player's turn and get the score
 */
public class Human {

    int humanTotalScore;
    int humanTurnScore;
    Random rand = new Random();

    void humansTurn(){
        humanTurnScore = 0;
        boolean play = true;
        int firstRoll = roll();
        if(firstRoll != 1){
            humanTurnScore += firstRoll;
            System.out.println("You rolled: "+ humanTurnScore + "  Your score this turn: " + humanTurnScore);
            System.out.println("Enter 'r' to roll again or 'h' to hold: ");
            Scanner scan = new Scanner(System.in);
            while(play){
                String input = scan.nextLine();
                if(input.equals("r")){
                    int newRoll = roll();
                    System.out.println("You rolled: " + newRoll);
                    if(newRoll!= 1){
                        humanTurnScore += newRoll;
                        System.out.println("Your score this turn: " + humanTurnScore);
                        System.out.println("Enter 'r' to roll again or 'h' to hold: ");
                    } else {
                        System.out.println("You didn't score any points this turn and your turn is over " +
                                "because you rolled 1.");
                        humanTurnScore = 0;
                        return;
                    }
                }
                else if(input.equals("h")){
                    System.out.println("Your score this turn: " + humanTurnScore);
                    return;
                }
                else {
                    System.out.println("Please enter a valid input(r or h): ");
                }
            }
        }
        else {
            humanTurnScore = 0;
            System.out.println("You rolled 1 and the turn is over.");
        }
    }

    int roll(){
        int dice = rand.nextInt(6)+1;
        return dice;
    }
}
