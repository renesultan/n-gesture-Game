/**
 * UNI: rs4240
 * Name: Rene Sultan
 */

package assignment1;

/**
 * Represents a strategy that chooses a move based on weighted random values.
 */
public class WeightedRandomStrategy implements Strategy {

    private final String[] moves;
    private final double[] cumulativeWeights;

    /**
     * Initializes a new WeightedRandomStrategy with the provided moves and outcome matrix.
     * 
     * @param moves An array of moves.
     * @param outcomeMatrix A matrix representing the outcomes for each move combination.
     */
    public WeightedRandomStrategy(String[] moves, int[][] outcomeMatrix) {
        this.moves = moves;
        this.cumulativeWeights = computeWeights(outcomeMatrix);
    }

    /**
     * Computes the cumulative weights based on the outcome matrix.
     * 
     * @param matrix The matrix representing the outcomes.
     * @return An array of cumulative weights.
     */
    private double[] computeWeights(int[][] matrix) {
        int length = matrix.length;
        double[] weights = new double[length];
        
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (matrix[i][j] != 0) {
                    weights[i]++;
                }
            }
        }

        double sum = 0;
        for (double weight : weights) {
            sum += weight;
        }

        for (int i = 0; i < weights.length; i++) {
            weights[i] /= sum;
        }

        double[] cumulativeWeights = new double[length];
        double cumulative = 0.0;
        for (int i = 0; i < weights.length; i++) {
            cumulative += weights[i];
            cumulativeWeights[i] = cumulative;
        }
        return cumulativeWeights;
    }

    /**
     * Chooses a move based on the weighted random strategy.
     * 
     * @return A string representing the chosen move.
     */
    @Override
    public String getMove() {
        double randomValue = Math.random();
        for (int i = 0; i < cumulativeWeights.length; i++) {
            if (randomValue <= cumulativeWeights[i]) {
                return moves[i];
            }
        }
        return moves[moves.length - 1];  // This should never really be reached, but is a fallback.
    }
}
