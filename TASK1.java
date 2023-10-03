import java.util.Scanner;
import java.util.Random;

public class TASK1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;

        do {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nWelcome to the Number Guessing Game!");
            System.out.println("I've chosen a number between " + minRange + " and " + maxRange + ". Can you guess it?");
            
            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + " - Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Please enter a valid number within the specified range.");
                    continue;
                }

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    guessedCorrectly = true;
                    score++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                attempts++;
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + targetNumber);
            }

            System.out.println("Your current score is: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        } while (true);

        System.out.println("\nThanks for playing! Your final score is: " + score);
        scanner.close();
    }
}
