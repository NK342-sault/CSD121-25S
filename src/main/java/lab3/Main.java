package lab3;

import lab3.game.Board;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        do {
            // Initialize game
            Board board = new Board();
            char player = 'X';

            while (true) {
                board.printBoard();
                makeMove(board.getBoard(), player, sc);

                if (checkState(board.getBoard(), player)) {
                    board.printBoard();
                    System.out.println("Player " + player + " won!");
                    break;
                } else if (Draw(board.getBoard())) {
                    board.printBoard();
                    System.out.println("DRAW");
                    break;
                }
                player = (player == 'X') ? 'O' : 'X';
            }

            System.out.println("Do you want to play again? (Y/N): ");
            String playAgain = sc.next().toUpperCase();
            if (!playAgain.equals("Y")) {
                break;
            }
            
        } while (true);
        
        sc.close();
    }

    /**
     * Checks if the state of the board is a win for the given player
     * The state of the board is a win if the player has three in a row in any direction on the board
     * (vertical, horizontal, or diagonal)
     * @param board the board to check
     * @param player the player to check for a win
     * @return true if the player has won, false otherwise
     */
    public static boolean checkState(char[][] board, char player) {
        for (int i = 0; i < 3; i++){
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        else return false;
    }

    public static boolean Draw(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Makes a move on the board for the given player
     * @param board the board to make a move on
     * @param player the player to make a move for
     * @param sc the scanner to read user input from
     */
    public static void makeMove(char[][] board, char player, Scanner sc) {
        int row, col;
        while (true) {
            System.out.println("Player " + player + ", your turn!");
            try {
                System.out.print("Enter row (1-3) ");
                row = sc.nextInt() - 1;
                System.out.print("Enter column (1-3) ");
                col = sc.nextInt() - 1;
                if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                    if (board[row][col] == ' ') {
                        board[row][col] = player;
                        break;
                    } else {
                        System.out.println("Position taken. Try again");
                    }
                } else {
                    System.out.println("Not a position on the board");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Please enter only numbers");
                sc.nextLine();
            }
        }
    }
}