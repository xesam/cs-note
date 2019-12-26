package dev.xesam.cs.sort.bubble;

import dev.xesam.foundation.alg.SortUtils;
import dev.xesam.foundation.alg.sort.InsertSort;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class InsertSortTest {
    @Test
    public void sort() {
        InsertSort sorter = new InsertSort();
        Integer[] test = {2, 1, 4, 3, 6, 5};
        sorter.sort(test);
        Arrays.asList(test).forEach(System.out::println);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, test);
    }

    @Test
    public void sort2() {
        SortUtils.run(1000, new InsertSort());
    }

}
