package dev.xesam.foundation.alg.sort;

import dev.xesam.foundation.alg.SortUtils;

/**
 * 冒泡排序
 * <p/>
 * Created by xe on 2014/12/5.
 * xesamguo@gmail.com
 */
public class BubbleSort implements Sorter {
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
    }
}
