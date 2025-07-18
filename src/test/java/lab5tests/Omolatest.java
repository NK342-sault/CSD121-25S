package lab5tests;

import lab5.game.Board;
import lab5.game.Col;
import lab5.game.Position;
import lab5.game.Row;
import lab5.players.Omola;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Omolatest {
    @Test
    public  void handleEmptyBoard(){
        Board board = new Board();
        Omola omola = new Omola("test");
        Position move = omola.pickNextMove(board);
        assertTrue(board.isEmptyAt(move));
    }
    @Test
    public void handleFullBoard(){
        Board board = new Board();
        for (Row row : Row.values()) {
            for (Col col : Col.values()) {
                board.placeNextToken(new Position(row, col));
            }
        }
    }

}
