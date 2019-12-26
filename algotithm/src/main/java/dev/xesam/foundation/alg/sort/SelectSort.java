package dev.xesam.foundation.alg.sort;

import dev.xesam.foundation.alg.SortUtils;

/**
 * 选择排序
 * <p/>
 * Created by xe on 14-12-7.
 */
public class SelectSort implements Sorter {
    @Override
    public void sort(Integer[] src) {
        int size = src.length;
        for (int outer = 0; outer < size - 1; outer++) {
            int minIndex = outer;
            for (int inner = outer + 1; inner < size; inner++) {
                if (src[minIndex] > src[inner]) {
                    minIndex = inner;
                }
            }
            SortUtils.swap(src, outer, minIndex);
        }
    }
}
