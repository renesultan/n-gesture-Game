/**
 * UNI: rs4240
 * Name: Rene Sultan
 */

package assignment1;

/**
 * This class maintains the statistics for the game, including the outcome of individual rounds and overall results.
 */
public class GameStatistics {
    private int[][] resultsMatrix; 
    private int totalRounds;
    private int computerWins;
    private int playerWins;
    private int ties;

    /**
     * Constructs a GameStatistics object with a results matrix of the given size.
     * 
     * @param numOfMoves The number of possible moves in the game.
     */
    public GameStatistics(int numOfMoves) {
        resultsMatrix = new int[numOfMoves][numOfMoves];
    }

    /**
     * Records the outcome of a round.
     * 
     * @param computerMoveIndex The move made by the computer, represented by its index.
     * @param friendMoveIndex The move made by the friend, represented by its index.
     */
    public void recordOutcome(int computerMoveIndex, int friendMoveIndex) {
        resultsMatrix[computerMoveIndex][friendMoveIndex]++;
        totalRounds++;
    }

    /**
     * Retrieves the count of a specific outcome.
     * 
     * @param computerMoveIndex The index of the computer's move.
     * @param friendMoveIndex The index of the friend's move.
     * @return The count of the outcome.
     */
    public int getOutcomeCount(int computerMoveIndex, int friendMoveIndex) {
        return resultsMatrix[computerMoveIndex][friendMoveIndex];
    }

    /**
     * Retrieves the total number of rounds played.
     * 
     * @return The total number of rounds.
     */
    public int getTotalRounds() {
        return totalRounds;
    }
    
    public void incrementComputerWins() {
        this.computerWins++;
    }

    public void incrementPlayerWins() {
        this.playerWins++;
    }

    public void incrementTies() {
        this.ties++;
    }

    public int getComputerWins() {
        return computerWins;
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public int getTies() {
        return ties;
    }

    public int getRowTotal(int rowIndex) {
        int total = 0;
        for (int i = 0; i < resultsMatrix[rowIndex].length; i++) {
            total += resultsMatrix[rowIndex][i];
        }
        return total;
    }

    public int getColumnTotal(int colIndex) {
        int total = 0;
        for (int i = 0; i < resultsMatrix.length; i++) {
            total += resultsMatrix[i][colIndex];
        }
        return total;
    }
    
    /**
     * Computes and returns the win percentage of the player.
     * 
     * @return The win percentage of the player.
     */
    public double computePlayerWinPercentage() {
        if (totalRounds == 0) return 0.0;  // Prevent division by zero
        return (double) playerWins / totalRounds * 100;
    }
    
    /**
     * Computes and returns the win percentage of the computer.
     * 
     * @return The win percentage of the computer.
     */
    public double computeComputerWinPercentage() {
        if (totalRounds == 0) return 0.0;  // Prevent division by zero
        return (double) computerWins / totalRounds * 100;
    }
}
