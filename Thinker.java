/**
 * UNI: rs4240
 * Name: Rene Sultan
 */

package assignment1;

/**
 * Represents a thinker that utilizes a specific strategy to make a move.
 */
public class Thinker {
	
    private final Strategy strategy;
    
    /**
     * Initializes a new Thinker with a strategy based on the provided game choice.
     * 
     * @param gameChoice The choice of the game to determine the strategy.
     */
    public Thinker(int gameChoice) {
        this.strategy = StrategyFactory.getStrategy(gameChoice);
    }
    
    /**
     * Retrieves the move chosen by the thinker's strategy.
     * 
     * @return A string representing the move.
     */
    public String getMove() {
        return strategy.getMove();
    }
}
