package hw3;

/**
 * Wenhan Cai
 * CS 5004 homework 3-3
 * Main class
 * Create one instance from Computer and one from Human, and play the Pig Dice Game
 */
public class Problem_3 {

    public static void main(String[] args) {

        System.out.println("**********----------------Game on-------------------**********");

        Human human = new Human();
        Computer computer = new Computer();

        int computerTotalScore = computer.computerTotalScore = 0;
        int humanTotalScore = human.humanTotalScore = 0;
        while(computerTotalScore <100 && humanTotalScore < 100){
            System.out.println("**********----------------Your turn-----------------**********");
            System.out.println("Your total score: " + humanTotalScore + ". Computer total score: " +
                    computerTotalScore);
            human.humansTurn();
            humanTotalScore += human.humanTurnScore;
            if(humanTotalScore >= 100){
                System.out.println("Your total score: " + humanTotalScore);
                break;
            }
            computer.computersTurn();
            computerTotalScore += computer.computerTurnScore;
        }
        System.out.println("\n**********----------------Game over-----------------**********");
        System.out.println(computerTotalScore>humanTotalScore ? "The winner is computer" : "Congratulations! You win!");
    }
}
