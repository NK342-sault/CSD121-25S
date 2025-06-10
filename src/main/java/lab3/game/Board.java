package lab3.game;

import java.util.Scanner;

public class Board {

    private char[][] board;
    public char[][] getBoard() {
        return board;
    }


    public Board() {
        this.board = new char[][] {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
    }

    /**
     * Prints the array with bars to give it the appearance of a board.
     */
    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.printf("%1c", board[i][j]);
                System.out.print(" | ");
            }
            System.out.println();
            if (i < board.length - 1) {
                System.out.println("------------");
            }
        }
    }
}

    // TODO: encapsulate the representation of the tictactoe board and provide instance methods to access and update it





