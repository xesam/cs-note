package dev.xesam.cs.sort.bubble;

import dev.xesam.foundation.alg.SortUtils;
import dev.xesam.foundation.alg.sort.BubbleSort;
import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {
    @Test
    public void sort() {
        BubbleSort sorter = new BubbleSort();
        Integer[] test = {2, 1, 4, 3, 6, 5};
        sorter.sort(test);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, test);
    }

    @Test
    public void sort2() {
        SortUtils.run(1000, new BubbleSort());
    }

}
