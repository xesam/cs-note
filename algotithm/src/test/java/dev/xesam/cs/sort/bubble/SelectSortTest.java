package dev.xesam.cs.sort.bubble;

import dev.xesam.foundation.alg.SortUtils;
import dev.xesam.foundation.alg.sort.SelectSort;
import org.junit.Assert;
import org.junit.Test;

public class SelectSortTest {
    @Test
    public void sort() {
        SelectSort sorter = new SelectSort();
        Integer[] test = {2, 1, 4, 3, 6, 5};
        sorter.sort(test);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, test);
    }

    @Test
    public void sort2() {
        SortUtils.run(1000, new SelectSort());
    }

}
