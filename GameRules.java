/**
 * UNI: rs4240
 * Name: Rene Sultan
 */

package assignment1;

/**
 * This class encapsulates the game rules for determining the winner between the computer and the player.
 */
public class GameRules {

	/**
     * Determines the winner between the computer and the player based on their moves.
     * 
     * @param computerMove The move made by the computer.
     * @param playerMove The move made by the player.
     * @param gameChoice The type of game being played.
     * @return 0 if it's a tie, 1 if the computer wins, and -1 if the player wins.
     * @throws IllegalArgumentException If the provided moves don't correspond to the game type.
     */
    public int checkWinner(String computerMove, String playerMove, int gameChoice) {
        int computerMoveIndex = GameDefinitions.getMoveIndex(computerMove);
        int playerMoveIndex = GameDefinitions.getMoveIndex(playerMove);

        int[][] outcomeMatrix = GameDefinitions.getOutcomeMatrixForGame(gameChoice);
        if (computerMoveIndex >= outcomeMatrix.length || playerMoveIndex >= outcomeMatrix[0].length) {
            throw new IllegalArgumentException("Invalid move indices: " + computerMove + " or " + playerMove);
        }

        int outcome = outcomeMatrix[computerMoveIndex][playerMoveIndex];
        return outcome;
    }
}
