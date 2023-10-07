/**
 * UNI: rs4240
 * Name: Rene Sultan
 */

package assignment1;

/**
 * The StrategyFactory class provides a mechanism to obtain a strategy instance based on the game choice.
 */
public class StrategyFactory {
	
    /**
     * Gets a Strategy instance based on the game choice. The strategy determines how moves are chosen.
     * 
     * @param gameChoice The type of game for which a strategy is required.
     * @return A Strategy instance corresponding to the game choice.
     * @throws IllegalArgumentException If an invalid game choice is provided.
     */
    public static Strategy getStrategy(int gameChoice) {
        String[] moves = GameDefinitions.getMovesForGame(gameChoice);
        int[][] outcomeMatrix = GameDefinitions.getOutcomeMatrixForGame(gameChoice);
        
        switch(gameChoice) {
            case 1:
            case 2:
                return new RandomStrategy(moves);
            case 3:
            case 4:
                return new WeightedRandomStrategy(moves, outcomeMatrix);
            default:
                throw new IllegalArgumentException("Invalid game choice");
        }
    }
}
