import java.util.Scanner;

public class YahtzeeDriver
{
	/*
    1. Creates a new instance of the YahtzeeGame class
    2. Calls the playGame method on the Yahtzee object
    3. Asks user if they would like to play again
    4. When the user is done playing, prints the number of games played, min, max, and average score
    */
	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		YahtzeeGame myGame = new YahtzeeGame();
		int score;
		int minScore = 999;
		int maxScore = -999;
		int avgScore = 0;
		int i = 0;
		int allScore = 0;
		String again = "";
		while (again != "n") {
			System.out.println("Welcome to <your name here>'s APCSA Yahtzee Game!");
			score = myGame.playGame();
			if (minScore > score) {
				minScore = score;
			}
			if (maxScore < score) {
				maxScore = score;
			}
			i++;
			allScore += score;
			avgScore = allScore / i;
			System.out.println("Would you like to play again? Type \'y\' or \'n\':");
			again = s.nextLine();
		}
		System.out.println("Number of games played: " + i);
		System.out.println("Minimum Score: " + minScore);
		System.out.println("Maximum Score: " + maxScore);
		System.out.println("Average Score: " + avgScore);
	}
}
