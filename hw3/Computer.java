package hw3;

import java.util.Random;

/**
 * Wenhan Cai
 * CS 5004 homework 3-3
 * Computer class
 * perform a series of actions when it is the computer's turn and get the score
 */
public class Computer {
    int computerTotalScore;
    int computerTurnScore;
    Random rand = new Random();

    void computersTurn(){
        computerTurnScore = 0;
        while(computerTurnScore <20){
            if(roll() != 1){
                computerTurnScore += roll();
            }
            else {
                computerTurnScore = 0;
                break;
            }
        }
        computerTotalScore += computerTurnScore;
        System.out.println("**********------------The computer's turn-----------**********");
        System.out.println("This turn the computer scored: "+ computerTurnScore);
        System.out.println("Computer total score: " + computerTotalScore);
    }

    int roll(){
        int dice = rand.nextInt(6)+1;
        return dice;
    }

}
