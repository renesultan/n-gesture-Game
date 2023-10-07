/**
 * UNI: rs4240
 * Name: Rene Sultan
 */

package assignment1;

import java.util.Scanner;

/**
 * The Talker class handles interactions with the user, collecting input and displaying relevant prompts.
 */
public class Talker {

    private int gameChoice;
    private Scanner scanner;

    /**
     * Constructs a Talker object for user interactions.
     */
    public Talker() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the welcome text for the game and lists the available game modes.
     */
    public void displayWelcomeText() {
        System.out.println("Welcome to the Rock-Paper-Scissors Game!");
        System.out.println("What game mode would you like to play?");
        System.out.println("1: RPS (Rock, Paper, Scissors)");
        System.out.println("2: RPSKL (Rock, Paper, Scissors, Lizard, Spock)");
        System.out.println("3: RPSFW (Rock, Paper, Scissors, Fire, Water)");
        System.out.println("4: RPMFW (Rock, Paper, Monkey, Fire, Water)");
    }

    /**
     * Collects the user's choice of game mode.
     * 
     * @return The chosen game mode as an integer.
     */
    public int getGameChoice() {
        int choice = 0;
        do {
            System.out.println("Enter your choice (1/2/3/4): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();  // Consume the leftover newline
                if (choice < 1 || choice > 4) {
                    System.out.println("Invalid choice. Please select 1, 2, 3, or 4.");
                } else {
                    gameChoice = choice;  // Store the game choice for later use
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        } while (choice < 1 || choice > 4);
        return choice;
    }
    
    /**
     * Retrieves the number of rounds the player wishes to play.
     * 
     * @return The number of rounds as an integer.
     */
    public int getNumberOfRounds() {
        System.out.print("Enter the number of rounds you want to play (or 0 to quit): ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return getNumberOfRounds();  // Ask again if invalid input
        }
    }

    /**
     * Retrieves the player's move choice.
     * 
     * @return A string representing the chosen move.
     */
    public String getPlayerMove() {
        String[] moves = GameDefinitions.getMovesForGame(gameChoice);
        System.out.println(generatePrompt(moves));
        
        String choice = scanner.next().toLowerCase();
        String[] inputChoices = generateInputChoices(moves);
        for (int i = 0; i < inputChoices.length; i++) {
            if (inputChoices[i].equals(choice)) {
                return moves[i];
            }
        }

        System.out.println("Invalid move! Please try again.");
        return getPlayerMove();
    }

    /**
     * Asks the user if they want to play another round of the game.
     * 
     * @return true if the user wants to play again, otherwise false.
     */
    public boolean askPlayAgain() {
        System.out.println("Would you like to play again? (y/n)");
        char response = scanner.next().toLowerCase().charAt(0);
        return response == 'y';
    }

    private String generatePrompt(String[] moves) {
        StringBuilder prompt = new StringBuilder("Enter your move (");
        String[] inputChoices = generateInputChoices(moves);

        for (int i = 0; i < moves.length; i++) {
            prompt.append(inputChoices[i]).append(" for ").append(moves[i]).append(", ");
        }
        prompt.setLength(prompt.length() - 2);  // Remove trailing comma and space
        prompt.append("): ");

        return prompt.toString();
    }

    private String[] generateInputChoices(String[] moves) {
        String[] inputChoices = new String[moves.length];
        for (int i = 0; i < moves.length; i++) {
            if (moves[i].equalsIgnoreCase("Spock")) {
                inputChoices[i] = "k";
            } else {
                inputChoices[i] = moves[i].toLowerCase().substring(0, 1);
            }
        }
        return inputChoices;
    }
}
