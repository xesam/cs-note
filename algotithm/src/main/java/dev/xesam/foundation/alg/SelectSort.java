package dev.xesam.foundation.alg;

/**
 * 选择排序
 * <p/>
 * Created by xe on 14-12-7.
 */
public class SelectSort extends SortProfile implements Sortable {
    public static void main(String[] args) {
        SimpleProfiler.profile(new SelectSort());
    }

    public static void sortOnce(int i) {
        Integer[] input = Generator.ints(1000);
        SelectSort sorter = new SelectSort();
        sorter.sort(input);
    }

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
        SortUtils.checkSort(src);
    }

    @Override
    void run() {
        SortUtils.runSort(1000, SelectSort::sortOnce);
    }
}
