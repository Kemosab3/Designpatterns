import java.util.Scanner;

public class Ristinolla extends Game {
    private final char[] board = new char[9];
    private final Scanner scanner = new Scanner(System.in);
    private int moveCount = 0;
    private char currentPlayerMark = 'X';
    private char winner = '\0';

    @Override
    protected void initializeGame(int numberOfPlayers) {
        for (int i = 0; i < board.length; i++) {
            board[i] = '-';
        }
        moveCount = 0;
        currentPlayerMark = 'X'; // X always starts
        winner = '\0';
        System.out.println("Ristinolla game initialized.");
    }

    @Override
    protected boolean endOfGame() {
        return moveCount == 9 || winner != '\0';
    }

    @Override
    protected void playSingleTurn(int player) {
        System.out.println("Player " + (player + 1) + "'s turn (" + currentPlayerMark + ")");
        printBoard();
        int move;
        do {
            System.out.println("Enter your move (1-9): ");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number! Enter your move (1-9): ");
                scanner.next(); // consume the invalid input
            }
            move = scanner.nextInt() - 1; // Convert to array index
        } while (move < 0 || move >= 9 || board[move] != '-');

        board[move] = currentPlayerMark;
        moveCount++;
        checkWinner();
        currentPlayerMark = (currentPlayerMark == 'X') ? 'O' : 'X'; // swap turns
    }

    private void checkWinner() {
        // Check rows, columns, and diagonals for a win
        String lines = new String(board);
        String[] winningConditions = {
                "" + lines.charAt(0) + lines.charAt(1) + lines.charAt(2),
                "" + lines.charAt(3) + lines.charAt(4) + lines.charAt(5),
                "" + lines.charAt(6) + lines.charAt(7) + lines.charAt(8),
                "" + lines.charAt(0) + lines.charAt(3) + lines.charAt(6),
                "" + lines.charAt(1) + lines.charAt(4) + lines.charAt(7),
                "" + lines.charAt(2) + lines.charAt(5) + lines.charAt(8),
                "" + lines.charAt(0) + lines.charAt(4) + lines.charAt(8),
                "" + lines.charAt(2) + lines.charAt(4) + lines.charAt(6)
        };

        for (String line : winningConditions) {
            if (line.equals("XXX")) {
                winner = 'X';
                return;
            } else if (line.equals("OOO")) {
                winner = 'O';
                return;
            }
        }
    }

    @Override
    protected void displayWinner() {
        printBoard();
        if (winner == '\0') {
            System.out.println("The game is a draw!");
        } else {
            System.out.println("Player " + (winner == 'X' ? "1" : "2") + " (" + winner + ") wins!");
        }
    }

    private void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i]);
            boolean endOfRow = (i + 1) % 3 == 0;
            if (!endOfRow) {
                System.out.print("|");
            } else if (i != 8) {
                System.out.println("\n-+-+-");
            }
        }
        System.out.println();
    }

    public void closeScanner() {
        scanner.close();
    }
}
