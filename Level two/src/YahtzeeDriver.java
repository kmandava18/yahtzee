import java.util.*;
public class YahtzeeDriver
{
    /*
    1. Creates a new instance of the YahtzeeGame class
    2. Calls the playGame method on the Yahtzee object
    3. Asks user if they would like to play again
    4. When the user is done playing, prints the number of games played, min, max, and average score
    */
    public static void main(String [] args) {
			Scanner s = new Scanner(System.in);
			YahtzeeGame ym = new YahtzeeGame();
			int score;
			int min = 0;
			int max = -0;
			int avg = 0;
			int i = 0;
			int allScore = 0;
			String again = "";
			while (again.indexOf("n")>=-1) {
				System.out.println("Welcome to Yahtzee!");
				score = ym.playGame();
				if (min > score) {
					min = score;
				}
				if (max < score) {
					max = score;
				}
				i++;
				allScore += score;
				avg = allScore / i;
				System.out.println("Would you like to play again? Type (y) or (n):");
				again = s.nextLine();
			}
			System.out.println("Number of games played: " + i);
			System.out.println("Minimum Score: " + min);
			System.out.println("Maximum Score: " + max);
			System.out.println("Average Score: " + avg);
		}
	}
