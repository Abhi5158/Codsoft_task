package Task1;

import java.util.Random;
import java.util.Scanner;

public class GuessGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		boolean playAgain = true;
		int roundsWon = 0;

		System.out.println("===== Welcome to the Number Guessing Game! =====");

		while (playAgain) {
			int randomNumber = random.nextInt(100) + 1; // 
			int attempts = 5; // 
			boolean guessedCorrectly = false;

			System.out.println("\nI have picked a number between 1 and 100. Can you guess it?");
			System.out.println("You have " + attempts + " attempts.");

			while (attempts > 0) {
				System.out.print("\nEnter your guess: ");
				int userGuess = scanner.nextInt();

				if (userGuess < 1 || userGuess > 100) {
					System.out.println("Invalid input! Please guess a number between 1 and 100.");
					continue;
				}

				if (userGuess == randomNumber) {
					System.out.println("🎉 Congratulations! You guessed the correct number: " + randomNumber);
					guessedCorrectly = true;
					roundsWon++;
					break;
				} else if (userGuess < randomNumber) {
					System.out.println("Too low! Try again.");
				} else {
					System.out.println("Too high! Try again.");
				}

				attempts--;
				if (attempts > 0) {
					System.out.println("Remaining attempts: " + attempts);
				} else {
					System.out.println("❌ Out of attempts! The correct number was: " + randomNumber);
				}
			}

			System.out.println("\nRounds Won: " + roundsWon);

			System.out.print("\nDo you want to play again? (yes/no): ");
			String response = scanner.next().toLowerCase();
			playAgain = response.equals("yes");
		}

		System.out.println("\n===== Thank you for playing! Your final score: " + roundsWon + " rounds won. =====");
		scanner.close();
	}
}
