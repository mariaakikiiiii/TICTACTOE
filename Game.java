
import java.util.Scanner;
public class Game {
    private Player player1, player2;
    private GameGrid gameGrid;
    private Scanner scanner;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startGame() {
        System.out.print("Choose game mode (1: Human vs Human, 2: Human vs Computer): ");
        int gameMode = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (gameMode == 1) {
            setupHumanVsHuman();
        } else {
            setupHumanVsComputer();
        }

        playGame();
    }

    private void setupHumanVsHuman() {
        System.out.print("Enter username for Player 1: ");
        String username1 = scanner.nextLine();
        player1 = new Human(username1, 'X');
        System.out.println(username1 + " is X");

        System.out.print("Enter username for Player 2: ");
        String username2 = scanner.nextLine();
        player2 = new Human(username2, 'O');
        System.out.println(username2 + " is O");
    }

    private void setupHumanVsComputer() {
        System.out.print("Enter username for Human Player: ");
        String humanUsername = scanner.nextLine();
        player1 = new Human(humanUsername, 'X');
        player2 = new Computer("Computer", 'O');
        System.out.println("Computer is O");
    }

    private void playGame() {
        gameGrid = new GameGrid();
        boolean gameWon = false;

        for (int turn = 0; turn < 9 && !gameWon; turn++) {
            gameGrid.printGrid();

            Player currentPlayer = (turn % 2 == 0) ? player1 : player2;
            System.out.println(currentPlayer.getUsername() + "'s turn:");

            char row, col;
            while (true) {
                if (currentPlayer instanceof Computer) {
                    row = (char) ('A' + (int) (Math.random() * 3));  // Randomly choose 'A', 'B', 'C'
                    col = (char) ('0' + (int) (Math.random() * 3));  // Randomly choose '0', '1', '2'
                } else {
                    System.out.print("Enter row (A, B, C) and column (0, 1, 2)separated by a space: ");
                    row = scanner.next().charAt(0);
                    col = scanner.next().charAt(0);
                }

                if (gameGrid.isEmpty(row, col)) {
                    gameGrid.setMove(row, col, currentPlayer.getSymbol());
                    System.out.println(currentPlayer.getUsername() + " placed " + currentPlayer.getSymbol() + " at (" + row + ", " + col + ")");
                    break;
                } else if (!(currentPlayer instanceof Computer)) {
                    System.out.println("Invalid move. Try again.");
                }
            }

            if (gameGrid.checkWin()) {
                gameWon = true;
                System.out.println(currentPlayer.getUsername() + " wins!");
            } else if (gameGrid.isDraw()) {
                System.out.println("The game is a draw!");
                break;
            }
        }
        gameGrid.printGrid();
    }
}

