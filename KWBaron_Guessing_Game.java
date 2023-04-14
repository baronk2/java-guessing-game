/*
Kevin Baron
12/6/12
Guessing Game
*/

import java.util.*; //for Scanner and Rand

public class KWBaron_Guessing_Game {
	
	public static final int maxNumber = 1024;
	
	public static void main(String[] args) {
		giveIntro();
		manyGames();
	}//eo main
	
	//Haiku
	public static void giveIntro() {
		System.out.println("I'll pick a number.");
		System.out.println("You'll try to guess my number.");
		System.out.println("I'll give you a hint.");
	}//eo giveIntro
	
	//Count games, guesses, and the lowest number
	//of guesses in one game.
	public static void manyGames() {
		int totalGames = 1;
		int guesses = oneGame();
		int totalGuesses = guesses;
		int best = guesses;
		boolean playAgain = anotherGame();
		while (playAgain) {	//Because playAgain is a boolean, it alone will enter or exit the loop.
			totalGames++;
			guesses = oneGame();
			totalGuesses += guesses;
			best = determineBest(best, guesses);
			playAgain = anotherGame();
		}//eo while
		report(totalGames, totalGuesses, best);
	}//eo manyGames
	
	public static int oneGame() {
		Random rand = new Random();
		Scanner console = new Scanner(System.in);
		int number = rand.nextInt(maxNumber) + 1;		//rand.nextInt gives an integer less than its parameter.
		System.out.println("\nI'm thinking of a number between 1 and " + maxNumber + "...");
		int playerGuess = 0;		//int number is always at least 1.
		int guesses = 0;
		while (playerGuess != number) {
			System.out.print("Your guess? ");
			playerGuess = console.nextInt();
			guesses++;
			if (number < playerGuess) {
				System.out.println("It's lower.");
			}//eo if
			if (number > playerGuess) {
				System.out.println("It's higher.");
			}//eo if
		}//eo while
		System.out.println("You got it right in " + guesses + " guesses");
		return guesses;
	}//eo oneGame
	
	public static int determineBest(int best, int guesses) {
		int newBest = best;
		if (guesses < best) {
			newBest = guesses;
		}//eo if
		return newBest;
	}//eo determineBest
	
	public static boolean anotherGame() {
		Scanner console = new Scanner(System.in);
		String yes = "Yy";
		System.out.print("Do you want to play again? ");
		String response = console.next();
		boolean playAgain = false;
		if (yes.contains(response.substring(0,1))) {
			playAgain = true;
		}//eo if
		return playAgain;
	}//eo anotherGame
	
	//Report the results from all games played using these three integers.
	public static void report(int totalGames, int totalGuesses, int best) {
		System.out.println("\nOverall results:");
		System.out.println("  total games   = " + totalGames);
		System.out.println("  total guesses = " + totalGuesses);
		double average = ((double) totalGuesses) / totalGames;
		System.out.printf("  guesses/game  = %.2f\n", average);
		System.out.println("  best game   = " + best);
	}//eo report
	
}//eo class