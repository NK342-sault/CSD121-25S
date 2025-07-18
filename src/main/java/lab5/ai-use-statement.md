I used IntelliJ AI chat to complete this lab
## Me
Can you help me modify the Console.promptForPlayer function to allow users to select Randy

## AI Assistant
Based on the Console.java code shown, I'll help you modify the promptForPlayer method to include Randy as a computer player option. Here's how to update it:
``` java

public static Player promptForPlayer(PlayerToken whichPlayer) {
    while (true) {
        var input = prompt(fPrompt.format("Who will play " + whichPlayer + "? "));

        if (input.startsWith("@")) {
            input = input.substring(1).toLowerCase(); // remove the '@' prefix

            switch (input) {
                case "randy" -> {
                    return new Randy(input);
                }
                default -> printAlert("Unknown computer player type. Available types: randy");
            }
        } else {
            return new HumanPlayer(input);
        }
    }
}
```
## Me
Can you help me write a few tests for the palyer Omola

## AI Assistant
I'll help you create some test cases for the Omola player. Let's create tests that verify Omola's three main behaviors: winning when possible, blocking opponent wins, and making valid moves when neither is possible.
Here's a test class:
``` java
package lab5.players;

import lab5.game.Board;
import lab5.game.Position;
import lab5.game.Row;
import lab5.game.Col;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OmolaTest {

    @Test
    void shouldTakeWinningMove() {
        // Setup board where Omola (O) can win
        Board board = new Board("""
                OO.
                XX.
                ...
                """);
        Omola omola = new Omola("test");
        
        Position move = omola.pickNextMove(board);
        
        // Omola should take the winning move at (0,2)
        assertEquals(new Position(Row.Top, Col.Right), move);
    }

    @Test
    void shouldBlockOpponentWin() {
        // Setup board where opponent (X) could win
        Board board = new Board("""
                XX.
                O..
                ...
                """);
        Omola omola = new Omola("test");
        
        Position move = omola.pickNextMove(board);
        
        // Omola should block at (0,2)
        assertEquals(new Position(Row.Top, Col.Right), move);
    }

    @Test
    void shouldMakeValidMoveWhenNoWinOrBlock() {
        // Setup board with no immediate wins or blocks needed
        Board board = new Board("""
                X..
                .O.
                ...
                """);
        Omola omola = new Omola("test");
        
        Position move = omola.pickNextMove(board);
        
        // Verify the move is to an empty position
        assertTrue(board.isEmptyAt(move));
    }

    @Test
    void shouldPreferWinningOverBlocking() {
        // Setup board where both winning and blocking are possible
        Board board = new Board("""
                OO.
                XX.
                ...
                """);
        Omola omola = new Omola("test");
        
        Position move = omola.pickNextMove(board);
        
        // Should choose winning move (0,2) over blocking move (1,2)
        assertEquals(new Position(Row.Top, Col.Right), move);
    }

    @Test
    void shouldHandleEmptyBoard() {
        Board board = new Board();
        Omola omola = new Omola("test");
        
        Position move = omola.pickNextMove(board);
        
        // Verify the move is valid on an empty board
        assertTrue(board.isEmptyAt(move));
    }
}
```



