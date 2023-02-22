/**
 * 
 */
package randomnumberguesser;

/**
 * This is the utility class to accompany RandomNumberGuesser
 * It contains static methods to generate a random number,
 * validate the guesses as being between the previous low and high guesses,
 * and maintain the number of guesses.
 * @author Romaric
 */


import java.util.Scanner;
import java.util.Random;

public class RandomNumberGuesser {
    private static int count;
    private static int guess;
    private static int rand;
    private static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        rand = new Random().nextInt(100) + 1;
        boolean playAgain = true;

        while (playAgain) {
            int low = 1;
            int high = 100;
            count = 0;

            System.out.println("This application generates a random integer between 0 and 100 and asks the user to guess repeatedly until they guess correctly."
            		+ "Enter your guess:");
            guess = inputValidation(input.nextInt(), low, high);
            count++;

            while (rand != guess && count < 7) {
                if (guess < rand) {
                    System.out.println("Your guess is too low. Guess again:");
                    low = guess + 1;
                } else {
                    System.out.println("Your guess is too high. Guess again:");
                    high = guess - 1;
                }

                guess = inputValidation(input.nextInt(), low, high);
                count++;
            }

            if (rand == guess) {
                System.out.println("You got it in " + count + " tries.");
                System.out.println("programmer name: romaric nkola");
            } else {
                System.out.println("You didn't guess it in 7 tries. The correct number was " + rand + "." );
                System.out.println("programmer name: romaric nkola");
            }

            System.out.println("Do you want to try again? (yes/no)");
            String userInput = input.next().toLowerCase();
            if (userInput.equals("no")) {
                playAgain = false;
            } else if (userInput.equals("yes")) {
                rand = new Random().nextInt(100) + 1;
            } else {
                System.out.println("wrong input,Exit game");
                System.out.println("programmer name : romaric nkola");
                playAgain = false;
            }
        }
    }

    private static int inputValidation(int guess, int low, int high) {
        while (guess < low || guess > high) {
            System.out.println("Invalid guess. Enter a number between " + low + " and " + high + ":");
            guess = input.nextInt();
        }
        return guess;
    }
}
