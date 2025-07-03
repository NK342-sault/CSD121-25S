package lab4.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void toStringTest() {
        assertEquals("...\n" +
                              "...\n" +
                              "...\n", new Board().toString());
    }

    @Test
    public void isNotOccupiedAtStartup() {
        assertEquals(false, new Board().isOccupiedAt( new Position(Row.Top, Col.Left) ) );
        assertEquals(false, new Board().isOccupiedAt( new Position(Row.Top, Col.Middle) ) );
        assertEquals(false, new Board().isOccupiedAt( new Position(Row.Top, Col.Right) ) );
        assertEquals(false, new Board().isOccupiedAt( new Position(Row.Middle, Col.Left) ) );
        assertEquals(false, new Board().isOccupiedAt( new Position(Row.Middle, Col.Middle) ) );
        assertEquals(false, new Board().isOccupiedAt( new Position(Row.Middle, Col.Right) ) );
        assertEquals(false, new Board().isOccupiedAt( new Position(Row.Bottom, Col.Left) ) );
        assertEquals(false, new Board().isOccupiedAt( new Position(Row.Bottom, Col.Middle) ) );
        assertEquals(false, new Board().isOccupiedAt( new Position(Row.Bottom, Col.Right) ) );
    }



    @Test
    public void horizontalWinX(){
        var board = new Board();
        board.placeX( new Position(Row.Top, Col.Left) );
        board.placeX( new Position(Row.Top, Col.Middle) );
        board.placeX( new Position(Row.Top, Col.Right) );
        board.placeX( new Position(Row.Middle, Col.Left) );
        board.placeX( new Position(Row.Middle, Col.Middle) );
        board.placeX( new Position(Row.Middle, Col.Right) );
        board.placeX( new Position(Row.Bottom, Col.Left) );
        board.placeX( new Position(Row.Bottom, Col.Middle) );
        board.placeX( new Position(Row.Bottom, Col.Right) );
    }

    @Test
    public void horizontalWinO(){
        var board = new Board();
        board.placeO( new Position(Row.Top, Col.Left) );
        board.placeO( new Position(Row.Top, Col.Middle) );
        board.placeO( new Position(Row.Top, Col.Right) );
        board.placeO( new Position(Row.Middle, Col.Left) );
        board.placeO( new Position(Row.Middle, Col.Middle) );
        board.placeO( new Position(Row.Middle, Col.Right) );
        board.placeO( new Position(Row.Bottom, Col.Left) );
        board.placeO( new Position(Row.Bottom, Col.Middle) );
        board.placeO( new Position(Row.Bottom, Col.Right) );
    }

    @Test
    public void verticalWinX(){
        var board = new Board();
        board.placeX( new Position(Row.Top, Col.Left) );
        board.placeX( new Position(Row.Middle, Col.Left) );
        board.placeX( new Position(Row.Bottom, Col.Left) );
        board.placeX( new Position(Row.Top, Col.Middle) );
        board.placeX( new Position(Row.Middle, Col.Middle) );
        board.placeX( new Position(Row.Bottom, Col.Middle) );
        board.placeX( new Position(Row.Top, Col.Right) );
        board.placeX( new Position(Row.Middle, Col.Right) );
        board.placeX( new Position(Row.Bottom, Col.Right) );
    }

    @Test
    public void verticalWinO(){
        var board = new Board();
        board.placeO( new Position(Row.Top, Col.Left) );
        board.placeO( new Position(Row.Middle, Col.Left) );
        board.placeO( new Position(Row.Bottom, Col.Left) );
        board.placeO( new Position(Row.Top, Col.Middle) );
        board.placeO( new Position(Row.Middle, Col.Middle) );
        board.placeO( new Position(Row.Bottom, Col.Middle) );
        board.placeO( new Position(Row.Top, Col.Right) );
        board.placeO( new Position(Row.Middle, Col.Right) );
        board.placeO( new Position(Row.Bottom, Col.Right) );
    }

    @Test
    public void diagonalWinX(){
        var board = new Board();
        board.placeX( new Position(Row.Top, Col.Left) );
        board.placeX( new Position(Row.Middle, Col.Middle) );
        board.placeX( new Position(Row.Bottom, Col.Right) );
        board.placeX( new Position(Row.Top, Col.Right) );
        board.placeX( new Position(Row.Middle, Col.Middle) );
        board.placeX( new Position(Row.Bottom, Col.Left) );
        board.placeX( new Position(Row.Top, Col.Middle) );
    }

    @Test
    public void diagonalWinO(){
        var board = new Board();
        board.placeO( new Position(Row.Top, Col.Left) );
        board.placeO( new Position(Row.Middle, Col.Middle) );
        board.placeO( new Position(Row.Bottom, Col.Right) );
        board.placeO( new Position(Row.Top, Col.Right) );
        board.placeO( new Position(Row.Middle, Col.Middle) );
        board.placeO( new Position(Row.Bottom, Col.Left) );
    }

    @Test
    public void draw(){
        var board = new Board();
        board.placeX( new Position(Row.Top, Col.Left) );
        board.placeO( new Position(Row.Top, Col.Middle) );
        board.placeX( new Position(Row.Top, Col.Right) );
        board.placeO( new Position(Row.Middle, Col.Left) );
        board.placeX( new Position(Row.Middle, Col.Middle) );
        board.placeX( new Position(Row.Middle, Col.Right) );
        board.placeO( new Position(Row.Bottom, Col.Left) );
        board.placeX( new Position(Row.Bottom, Col.Middle) );
        board.placeO( new Position(Row.Bottom, Col.Right) );
        assertTrue(board.isFull());
        assertEquals(Board.Status.Draw, board.getStatus());
    }

    @Test
    public void inProgressAtStartup(){
        assertEquals(Board.Status.InProgress, new Board().getStatus());
    }
}
