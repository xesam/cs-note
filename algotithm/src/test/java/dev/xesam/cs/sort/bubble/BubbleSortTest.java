package dev.xesam.cs.sort.bubble;

import dev.xesam.foundation.alg.Generator;
import dev.xesam.foundation.alg.SortUtils;
import dev.xesam.foundation.alg.sort.BubbleSort;
import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {
    @Test
    public void sort() {
        BubbleSort bubbleSort = new BubbleSort();
        Integer[] test = {2, 1, 4, 3, 6, 5};
        bubbleSort.sort(test);
        Assert.assertArrayEquals(test, new Integer[]{1, 2, 3, 4, 5, 6});
    }

    @Test
    public void sort2() {
        Integer[] input = Generator.ints(1000);
        BubbleSort sorter = new BubbleSort();
        sorter.sort(input);
        SortUtils.run(1000, sorter);
    }

}
