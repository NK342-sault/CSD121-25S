package lab4.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ColTest {
    @Test
    void validString(){
        assertEquals(Col.from("1"), Col.Left);
        assertEquals(Col.from("l"), Col.Left);
        assertEquals(Col.from("2"), Col.Middle);
        assertEquals(Col.from("m"), Col.Middle);
        assertEquals(Col.from("c"), Col.Middle);
        assertEquals(Col.from("3"), Col.Right);
        assertEquals(Col.from("r"), Col.Right);
    }

    @Test
    void caseSensitive(){
        assertEquals(Col.from("L"), Col.Left);
        assertEquals(Col.from("M"), Col.Middle);
        assertEquals(Col.from("C"), Col.Middle);
        assertEquals(Col.from("R"), Col.Right);
    }

    @Test
    void invalidString(){
        assertThrows(IllegalArgumentException.class, () -> Col.from(""));
        assertThrows(IllegalArgumentException.class, () -> Col.from("a"));
        assertThrows(IllegalArgumentException.class, () -> Col.from("4"));
        assertThrows(IllegalArgumentException.class, () -> Col.from("x"));
        assertThrows(IllegalArgumentException.class, () -> Col.from("0"));
    }
}
