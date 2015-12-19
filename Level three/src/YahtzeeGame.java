import java.util.Scanner;

public class YahtzeeGame
{
    /* instance data should include the five yahtzee dice, a scoreboard, and a CONSTANT (static final) variable NUM_SIDES
    which should be set to six (the number of sides on a yahtzee die) */
    private YahtzeeDie die1=new YahtzeeDie(6);
    private YahtzeeDie die2=new YahtzeeDie(6);
    private YahtzeeDie die3=new YahtzeeDie(6);
    private YahtzeeDie die4=new YahtzeeDie(6);
    private YahtzeeDie die5=new YahtzeeDie(6);
    private static final int NUM_SIDES=6;
    private YahtzeeScorecard scoreboard=new YahtzeeScorecard();




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
        System.out.print("Would you like to roll again(n or y):");
        String ans = s.nextLine();
        if(ans.equals("n")){
            markScore();}
        if(ans.equals("y")){
            chooseFrozen();
            rollDice();
            printDice();
            System.out.print("Would you like to roll again(n or y):");
            String ans2 = s.nextLine();
            if(ans2.equals("n")){
                markScore();}
            if(ans2.equals("y")){
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
        System.out.println("die1:" + die1.getValue() + " die2: " + die2.getValue() + " die3: " + die3.getValue() + " die4: " + die4.getValue() +  " die5: " + die5.getValue());
    }

    /* 1. Print a scoreboard
       2. Ask the user where they would like to mark their score.
       3. Call appropriate function
       4. If false is returned the user entered an invalid number, so ask the user to try again	*/
    private void markScore()
    {
        boolean b = false;

        Scanner s = new Scanner(System.in);
        while(!b){
            System.out.print("Where would you like to place your score?");
            int var  = s.nextInt();
            switch(var) {
                case 1:
                    b = scoreboard.markOnes(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                    break;
                case 2:
                    b = scoreboard.markTwos(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                    break;
                case 3:
                    b = scoreboard.markThrees(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                    break;
                case 4:
                    b = scoreboard.markFours(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                    break;
                case 5:
                    b = scoreboard.markFives(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                    break;
                case 6:
                    b = scoreboard.markSixes(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                    break;
                case 7:
                    b = scoreboard.markThreeOfAKind(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                    break;
                case 8:
                    b = scoreboard.markFourOfAKind(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                    break;
                case 9:
                    b = scoreboard.markFullHouse(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                    break;
                case 10:
                    b = scoreboard.markSmallStraight(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                    break;
                case 11:
                    b = scoreboard.markLargeStraight(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                    break;
                case 12:
                    b = scoreboard.markYahtzee(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                    break;
                case 13:
                    b = scoreboard.markChance(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                    break;
                default:markScore();break;
            }
        }
        scoreboard.printScoreCard();
    }
}