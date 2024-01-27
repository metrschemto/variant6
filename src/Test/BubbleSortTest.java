package Test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BubbleSortTest {
    private static BubbleSort bubbleSort;
    private static int[] unsortedArray;
    private static int[] sortedArray;

    @BeforeClass
    public static void setUp() {
        bubbleSort = new BubbleSort();
        unsortedArray = new int[]{52, 5, 74, 25, 17, 77, 31};
        sortedArray = new int[]{5, 17, 25, 31, 52, 74, 77};
    }

    @AfterClass
    public static void tearDown() {
        bubbleSort = null;
        unsortedArray = null;
        sortedArray = null;
    }

    @Test
    public void testBubbleSort() {
        bubbleSort.bubbleSort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }
}