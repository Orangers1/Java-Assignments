package assign09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains tests for the TileButton class.
 *
 * @author Prof. Heisler and Josh Eggett
 * @version 1.0
 */
public class TileButtonTest {
    private TileButton button1;
    private TileButton button2;


    // This code executes before each test.
    // You can reference button1 and button2 in your tests without having to create them.
    @BeforeEach
    public void setup() {
        button1 = new TileButton("src/assign09/tile_1_2.png", 1, 2, 6);
        button2 = new TileButton("src/assign09/tile_2_2.png", 2, 2, 10);
    }

    @Test
    public void testGetRow() {
        assertEquals(1, button1.getRow());
    }

    @Test
    public void testGetImageID() {
        assertEquals(6, button1.getImageID());
    }

    @Test
    public void testSwap() {
        button1.swap(button2);
        assertEquals(10, button1.getImageID());
    }

    @Test
    public void testGetColumn() {
        assertEquals(2, button1.getColumn());
    }

    @Test
    public void testSwapSameButton() {
        button1.swap(button1);
        assertEquals(6, button1.getImageID());
    }


}