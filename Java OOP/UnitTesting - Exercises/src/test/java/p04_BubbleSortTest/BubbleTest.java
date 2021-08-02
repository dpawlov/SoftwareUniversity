package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void testSort() {
        int [] numbers = {3, 44, 15, 66, 23, 51};
        Bubble.sort(numbers);

        int [] expectedSortedArray = {3, 15, 23, 44, 51, 66};
        Assert.assertEquals(numbers.length, expectedSortedArray.length);
        Assert.assertArrayEquals(numbers, expectedSortedArray);
    }

}