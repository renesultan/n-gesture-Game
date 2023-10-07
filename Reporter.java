/**
 * UNI: rs4240
 * Name: Rene Sultan
 */

package assignment1;

/**
 * This class is responsible for displaying game results and detailed statistics to the user.
 */
public class Reporter {

    /**
     * Displays the result of a single round of the game.
     * 
     * @param playerMove The move made by the player.
     * @param computerMove The move made by the computer.
     * @param result The result of the round: 0 for a tie, 1 if the computer wins, and -1 if the player wins.
     */
    public void displayRoundResult(String playerMove, String computerMove, int result) {
        System.out.println("You chose: " + playerMove);
        System.out.println("Computer chose: " + computerMove);
        if (result == 0) {
            System.out.println("It's a tie!");
        } else if (result == 1) {
            System.out.println("Computer wins this round!");
        } else {
            System.out.println("You win this round!");
        }
    }
    
    /**
     * Displays the gathered statistics including player wins, computer wins, ties, and win percentages.
     * 
     * @param stats The GameStatistics object containing the game's statistics.
     */
    public void displayStatistics(GameStatistics stats) {
        System.out.println("==== Game Statistics ====");
        System.out.println("Total Rounds Played: " + stats.getTotalRounds());
        System.out.println("Player Wins: " + stats.getPlayerWins());
        System.out.println("Computer Wins: " + stats.getComputerWins());
        System.out.println("Ties: " + stats.getTies());
        System.out.printf("Player Win Percentage: %.2f%%\n", stats.computePlayerWinPercentage());
        System.out.printf("Computer Win Percentage: %.2f%%\n", stats.computeComputerWinPercentage());
        System.out.println("==========================");
    }

    /**
     * Displays detailed statistics about the game's rounds.
     * 
     * @param stats The GameStatistics object containing the game's statistics.
     * @param moves The list of possible moves in the game.
     */
    public void displayDetailedStatistics(GameStatistics stats, String[] moves) {
        // Print header
        System.out.print("Friend\t");
        for (String move : moves) {
            if (move.equals("Spock")) {
                System.out.print("\t K");
            } else if(move.equals("Scissors")) {
                System.out.print("\t S");
            } else {
                System.out.print("\t " + move.charAt(0));
            }
        }
        System.out.println("\t Tot");
        System.out.print("\t\t");
        for (int i = 0; i < moves.length; i++) {
            System.out.print("--------");
        }
        System.out.println();

        // Print outcomes for each move
        for (int i = 0; i < moves.length; i++) {
        	if (moves[i].equals("Spock")) {
                System.out.printf("Computer K |"); // Corrected this line
            } else {
                System.out.printf("Computer %c |", moves[i].charAt(0));
            }
            for (int j = 0; j < moves.length; j++) {
                if (i == j) {
                    System.out.print("\t 0");
                    continue;
                }
                int outcome = stats.getOutcomeCount(i, j) - stats.getOutcomeCount(j, i);
                System.out.printf("\t %d", outcome);
            }
            System.out.printf("\t %d%n", stats.getRowTotal(i));
        }

        // Print the totals
        System.out.print("Tot\t   |");
        for (int j = 0; j < moves.length; j++) {
            System.out.printf("\t %d", stats.getColumnTotal(j));
        }
        int playerPercentageInt = (int) Math.round(stats.computePlayerWinPercentage());
        System.out.printf("\t %d/%d%n", playerPercentageInt, 100);
    }
}
