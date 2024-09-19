import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int MAX_ATTEMPTS = 10; // Limit the number of attempts

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int roundsWon = 0;

        while (playAgain) {
            // Generate a random number within the specified range
            int targetNumber = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("A random number between " + LOWER_BOUND + " and " + UPPER_BOUND + " has been generated.");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");

            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                // Prompt the user to enter their guess
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                // Compare the user's guess with the generated number
                if (userGuess < LOWER_BOUND || userGuess > UPPER_BOUND) {
                    System.out.println("Please enter a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + targetNumber + ".");
            } else {
                roundsWon++;
            }

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            if (response.equals("no")) {
                playAgain = false;
            }
        }

        // Display the user's score
        System.out.println("Game Over! You won " + roundsWon + " rounds.");
        scanner.close();
    }
}
