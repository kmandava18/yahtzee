import java.util.Scanner;

public class YahtzeeGame
{
	/* instance data should include the five yahtzee dice, a scoreboard, and a CONSTANT (static final) variable NUM_SIDES
	which should be set to six (the number of sides on a yahtzee die) */
	private YahtzeeDie die1;
	private YahtzeeDie die2;
	private YahtzeeDie die3;
	private YahtzeeDie die4;
	private YahtzeeDie die5;
	private static final int NUM_SIDES=6;
	private YahtzeeScorecard scoreboard;




	/* initializes the dice and scoreboard */
	public YahtzeeGame()
	{}

	/* check to see if the game is over, and while the game is not over call the method takeTurn()
	once the game ends (hint: there are 13 turns in a game of Yahtzee), the method should print a
	final scorecard and return the grand total */
	public int playGame()
	{
		for(int i = 0; i < 13; i++) {
			this.takeTurn();
		}
		scoreboard.printScoreCard();
		return scoreboard.getGrandTotal();
	}

	/* 	1. call rollDice()
		2. call printDice()
		3. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		4. call chooseFrozen()
		5. call rollDice()
		6. call printDice()
		7. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		8. call chooseFrozen()
		9. call rollDice()
		10. call printDice()
		11. call markScore()
	*/
	private void takeTurn()
	{
		Scanner s = new Scanner(System.in);
		rollDice();
		printDice();
		System.out.print("Are you (s)atisfied or would you like to (r)oll again:");
		String ans = s.nextLine();
		if(ans.equals("s")){
			markScore();
		} if (ans.equals("r")){
		chooseFrozen();
		rollDice();
		printDice();
		System.out.print("Are you (s)atisfied or would you like to (r)oll again:");
		String ans2 = s.nextLine();
		if(ans2.equals("s")){
			markScore();
		} if (ans2.equals("r")){
			chooseFrozen();
			rollDice();
			printDice();
			markScore();
		}
	}
	}

	/* Rolls all unfrozen dice.  Also resets all dice to the unfrozen state after the roll */
	private void rollDice()
	{
		if(die1.isFrozen() == false){
			die1.rollDie();
		}
		if(die2.isFrozen() == false){
			die2.rollDie();
		}
		if(die3.isFrozen() == false){
			die3.rollDie();
		}
		if(die4.isFrozen() == false){
			die4.rollDie();
		}
		if(die5.isFrozen() == false){
			die5.rollDie();
		}
		die1.unfreezeDie();
		die2.unfreezeDie();
		die3.unfreezeDie();
		die4.unfreezeDie();
		die5.unfreezeDie();
	}

	/* Asks the user which dice should be frozen 1-5 (should be read in in one line) */
	private void chooseFrozen()
	{
		System.out.print("Which dice would you like to freeze(1-5):");
		Scanner s = new Scanner(System.in);
		String ans = s.nextLine();
		if(ans.indexOf("1") >= 0){
			die1.freezeDie();
		}if (ans.indexOf("2") >= 0){
		die2.freezeDie();
	}if (ans.indexOf("3") >= 0){
		die3.freezeDie();
	}if (ans.indexOf("4") >= 0){
		die4.freezeDie();
	}if (ans.indexOf("5") >= 0){
		die5.freezeDie();
	}
	}

	/* Should print the value of all five dice separated by a tab (\t) to the console */
	private void printDice()
	{
		System.out.println(die1.getValue() + "\t" + die2.getValue() + "\t" + die3.getValue() + "\t" + die4.getValue() +  "\t" + die5.getValue());
	}

	/* 1. Print a scoreboard
	   2. Ask the user where they would like to mark their score.
	   3. Call appropriate function
	   4. If false is returned the user entered an invalid number, so ask the user to try again	*/
	private void markScore()
	{
		boolean b = false;

		Scanner r = new Scanner(System.in);
		while(b != true){
			System.out.print("Where would you like to place your score? \n"
					+ "1. Ones 	7.  3 of Kind \n"
					+ "2. Twos 	8.  4 of Kind \n"
					+ "3. Threes 	9.  Full House \n"
					+ "4. Fours 	10. Sm Straight \n"
					+ "5. Fives 	11. Lg Straight \n"
					+ "6. Sixes 	12. Yahtzee\n"
					+ "13. Chance \n"
					+ "Enter 1-13:" );
			String again  = r.nextLine();
			switch(again){
				case "1":
					b = scoreboard.markOnes(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
					break;
				case "2":
					b = scoreboard.markTwos(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
					break;
				case "3":
					b = scoreboard.markThrees(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
					break;
				case "4":
					b = scoreboard.markFours(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
					break;
				case "5":
					b = scoreboard.markFives(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
					break;
				case "6":
					b = scoreboard.markSixes(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
					break;
				case "7":
					b = scoreboard.markThreeOfAKind(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
					break;
				case "8":
					b = scoreboard.markFourOfAKind(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
					break;
				case "9":
					b = scoreboard.markFullHouse(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
					break;
				case "10":
					b = scoreboard.markSmallStraight(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
					break;
				case "11":
					b = scoreboard.markLargeStraight(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
					break;
				case "12":
					b = scoreboard.markYahtzee(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
					break;
				case "13":
					b = scoreboard.markChance(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
					break;
			}
		}
		scoreboard.printScoreCard();
	}
}