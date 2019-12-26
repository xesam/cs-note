package dev.xesam.foundation.alg.sort;

/**
 * 插入排序
 * <p/>
 * Created by xe on 2014/12/9.
 */
public class InsertSort implements Sorter {

    @Override
    public void sort(Integer[] src) {
        this.sort_2(src);
    }

    private void sort_2(Integer[] src) {
        for (int outer = 1; outer < src.length; outer++) {
            Integer target = src[outer];
            int inner = outer - 1;
            while (inner >= 0 && src[inner] > target) {
                src[inner + 1] = src[inner];
                inner--;
            }
            src[inner + 1] = target;
        }
    }
}
