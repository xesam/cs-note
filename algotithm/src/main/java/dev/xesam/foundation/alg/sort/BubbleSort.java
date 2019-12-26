package dev.xesam.foundation.alg.sort;

import dev.xesam.foundation.alg.*;

/**
 * 冒泡排序
 * <p/>
 * Created by xe on 2014/12/5.
 * xesamguo@gmail.com
 */
public class BubbleSort extends SortProfile implements Sortable {
    public static void main(String[] args) {
        SimpleProfiler.profile(new BubbleSort());
    }

    public static void sortOnce(int i) {
        Integer[] input = Generator.ints(1000);
        BubbleSort sorter = new BubbleSort();
        sorter.sort(input);
    }

    @Override
    public void sort(Integer[] src) {
        int size = src.length;
        for (int outer = size - 1; outer > 0; outer--) {
            for (int inner = 0; inner < outer; inner++) {
                if (src[inner] > src[inner + 1]) {
                    SortUtils.swap(src, inner, inner + 1);
                }
            }
        }
        SortUtils.checkSort(src);
    }

    @Override
    public void run() {
        SortUtils.runSort(1000, BubbleSort::sortOnce);
    }
}
