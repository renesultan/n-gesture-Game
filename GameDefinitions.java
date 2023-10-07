/**
 * UNI: rs4240
 * Name: Rene Sultan
 */

package assignment1;

/**
 * This class defines the constants and game rules for various versions of the Rock-Paper-Scissors game.
 * It provides methods to fetch moves for a game, get the index of a move, fetch the number of moves for
 * a game, and get the outcome matrix for a particular game type.
 */
public class GameDefinitions {

	// Move constants
    public static final String ROCK = "Rock";
    public static final String PAPER = "Paper";
    public static final String SCISSORS = "Scissors";
    public static final String LIZARD = "Lizard";
    public static final String SPOCK = "Spock";
    public static final String FIRE = "Fire";
    public static final String WATER = "Water";
    public static final String MONKEY = "Monkey";

    // Game mode move sets
    public static final String[] RPS = {ROCK, PAPER, SCISSORS};
    public static final String[] RPSKL = {ROCK, PAPER, SCISSORS, LIZARD, SPOCK};
    public static final String[] RPSFW = {ROCK, PAPER, SCISSORS, FIRE, WATER};
    public static final String[] RPMFW = {ROCK, PAPER, MONKEY, FIRE, WATER};

    // Outcome matrices for game modes
    public static final int[][] RPS_OUTCOMES = {
        { 0, -1,  1},
        { 1,  0, -1},
        {-1,  1,  0}
    };

    public static final int[][] RPSKL_OUTCOMES = {
        { 0, -1,  1, -1,  1},
        { 1,  0, -1,  1, -1},
        {-1,  1,  0, -1,  1},
        { 1, -1,  1,  0, -1},
        {-1,  1, -1,  1,  0}
    };

    public static final int[][] RPSFW_OUTCOMES = {
        { 0, -1,  1, -1,  1},
        { 1,  0, -1,  1, -1},
        {-1,  1,  0, -1,  1},
        { 1,  1,  1,  0, -1},
        {-1,  1, -1,  1,  0}
    };
    
    public static final int[][] RPMFW_OUTCOMES = {
    	{ 0, -1,  1, -1,  1},
    	{ 1,  0, -1,  1, -1},
    	{-1,  1,  0,  0,  0},
    	{ 1,  1,  0,  0, -1},
    	{-1, -1,  0,  1,  0}
    };
    
    /**
     * Fetches the array of moves for a given game type.
     * 
     * @param gameChoice The type of game.
     * @return An array of possible moves for the game.
     * @throws IllegalArgumentException If an invalid game choice is provided.
     */
    public static String[] getMovesForGame(int gameChoice) {
        switch (gameChoice) {
            case 1: return RPS;
            case 2: return RPSKL;
            case 3: return RPSFW;
            case 4: return RPMFW;
            default: throw new IllegalArgumentException("Invalid game choice");
        }
    }
    
    /**
     * Returns the index of a given move.
     * 
     * @param move The move whose index is to be fetched.
     * @return The index of the move.
     * @throws IllegalArgumentException If an invalid move is provided.
     */
    public static int getMoveIndex(String move) {
        if (move.equals(ROCK)) return 0;
        else if (move.equals(PAPER)) return 1;
        else if (move.equals(SCISSORS)) return 2;
        else if (move.equals(LIZARD)) return 3;
        else if (move.equals(SPOCK)) return 4;
        else if (move.equals(FIRE)) return 3;
        else if (move.equals(WATER)) return 4;
        else if (move.equals(MONKEY)) return 2;
        else throw new IllegalArgumentException("Invalid move");
    }

    /**
     * Fetches the outcome matrix for a given game type.
     * 
     * @param gameChoice The type of game.
     * @return The outcome matrix for the game.
     * @throws IllegalArgumentException If an invalid game choice is provided.
     */
    public static int[][] getOutcomeMatrixForGame(int gameChoice) {
        switch (gameChoice) {
            case 1: return RPS_OUTCOMES;
            case 2: return RPSKL_OUTCOMES;
            case 3: return RPSFW_OUTCOMES;
            case 4: return RPMFW_OUTCOMES;
            default: throw new IllegalArgumentException("Invalid game choice");
        }
    }
}
