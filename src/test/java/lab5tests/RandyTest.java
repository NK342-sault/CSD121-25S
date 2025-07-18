package lab5tests;

import lab5.game.Board;
import lab5.game.Position;
import lab5.players.Randy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RandyTest {
    @Test
    public void testRandyName() {
        Randy randy = new Randy("Randy");
        assertEquals("Randy", randy.getName());
    }

    @Test
    public void testPickMoveOnEmptyBoard(){
        Randy randy = new Randy("Randy");
        Board board = new Board();
        Position move = randy.pickNextMove(board);
        assertTrue(board.isEmptyAt(move));
    }

}
