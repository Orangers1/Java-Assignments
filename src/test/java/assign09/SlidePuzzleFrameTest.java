package assign09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class contains tests for the SlidePuzzleFrame class.
 *
 * @author Prof. Heisler and Josh Eggett
 * @version 1.0
 */
public class SlidePuzzleFrameTest {

    @Test
    public void testStartInUnsolvedState() {
        SlidePuzzleFrame frame = new SlidePuzzleFrame();
        assertFalse(frame.isSolved());
    }

    /**
     * Test method to ensure that the solve method will set the puzzle to solved.
     */
    @Test
    public void testSolveMethodSolves() {
        SlidePuzzleFrame frame = new SlidePuzzleFrame();
        assertFalse(frame.isSolved());
        frame.solve();
        assertTrue(frame.isSolved());
    }

    /**
     * Test method to ensure that a solved puzzle will end up shuffled after the shuffle method is called
     */
    @Test
    public void testShuffleShuffles() {
        SlidePuzzleFrame frame = new SlidePuzzleFrame();
        frame.solve();
        assertTrue(frame.isSolved());
        frame.shuffle();
        assertFalse(frame.isSolved());
    }

}