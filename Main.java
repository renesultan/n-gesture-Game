/**
 * UNI: rs4240
 * Name: Rene Sultan
 */

package assignment1;

/**
 * The main class responsible for running the game.
 */
public class Main {

    /**
     * The main method to start and control the game flow.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Talker talker = new Talker();
        GameRules gameRules = new GameRules();
        Reporter reporter = new Reporter();

        talker.displayWelcomeText();
        
        int gameChoice;
        int numberOfRounds;

        do {
            gameChoice = talker.getGameChoice();
            numberOfRounds = talker.getNumberOfRounds();
            
            playRounds(gameChoice, numberOfRounds, talker, gameRules, reporter);

        } while (talker.askPlayAgain());

        System.out.println("Thanks for playing!");
    }

    /**
     * Plays the game for the specified number of rounds.
     * 
     * @param gameChoice The chosen game mode.
     * @param numberOfRounds The number of rounds to be played.
     * @param talker The Talker object for user interaction.
     * @param gameRules The GameRules object to determine round outcomes.
     * @param reporter The Reporter object to display results.
     */
    private static void playRounds(int gameChoice, int numberOfRounds, Talker talker, GameRules gameRules, Reporter reporter) {
        String[] movesForCurrentGame = GameDefinitions.getMovesForGame(gameChoice);
        GameStatistics gameStats = new GameStatistics(movesForCurrentGame.length);

        for (int i = 0; i < numberOfRounds; i++) {
            Thinker thinker = new Thinker(gameChoice);
            
            String playerMove = talker.getPlayerMove();
            String computerMove = thinker.getMove();
            
            int result = gameRules.checkWinner(computerMove, playerMove, gameChoice);
            gameStats.recordOutcome(GameDefinitions.getMoveIndex(computerMove), GameDefinitions.getMoveIndex(playerMove));

            updateGameStatistics(result, gameStats);

            reporter.displayRoundResult(playerMove, computerMove, result);
        }

        reporter.displayStatistics(gameStats);
        reporter.displayDetailedStatistics(gameStats, movesForCurrentGame);
    }

    /**
     * Updates the game statistics based on the round result.
     * 
     * @param result The outcome of the round.
     * @param gameStats The GameStatistics object to be updated.
     */
    private static void updateGameStatistics(int result, GameStatistics gameStats) {
        if (result == 0) {
            gameStats.incrementTies();
        } else if (result == 1) {
            gameStats.incrementComputerWins();
        } else {
            gameStats.incrementPlayerWins();
        }
    }
}
