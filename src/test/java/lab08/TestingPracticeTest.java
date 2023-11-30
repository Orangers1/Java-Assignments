package lab08;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static lab08.TestingPractice.averageInRange;
import static org.junit.jupiter.api.Assertions.*;

class TestingPracticeTest {
    TestingPractice testingPractice;
    @BeforeEach
    void setUp() {
         testingPractice = new TestingPractice();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testAverage(){
        assertEquals(14, averageInRange(new int[] {0, 1, 2}, 1,2), 1.5, "Failed Avg of 1, 2");
        assertEquals(9, averageInRange(new int[] {0, 1, 2}, 1,2), 1.5, "Failed Avg of 1, 2");

    }


}