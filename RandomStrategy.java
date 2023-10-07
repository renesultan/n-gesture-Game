/**
 * UNI: rs4240
 * Name: Rene Sultan
 */

package assignment1;

import java.util.Random;

/**
 * This class implements the Strategy interface and represents a strategy where moves are chosen randomly.
 */
public class RandomStrategy implements Strategy{
	private String[] moves;
	private Random random = new Random();
	
    /**
     * Constructs a RandomStrategy object with the provided moves.
     * 
     * @param moves An array of possible moves in the game.
     */

	public RandomStrategy(String[] moves) {
		this.moves = moves;
	}
	
    /**
     * Gets a move chosen randomly from the available moves.
     * 
     * @return A randomly chosen move.
     */
    @Override
	public String getMove() {
		int index = random.nextInt(moves.length);
		return moves[index];
	}
}
