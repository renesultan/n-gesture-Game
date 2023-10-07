/**
 * UNI: rs4240
 * Name: Rene Sultan
 */

package assignment1;

/**
 * The Strategy interface defines the contract for strategy classes that determine the move to be made in the game.
 */
public interface Strategy {
	
    /**
     * Gets the move according to the implemented strategy.
     * 
     * @return A move based on the strategy.
     */
	String getMove();
}
