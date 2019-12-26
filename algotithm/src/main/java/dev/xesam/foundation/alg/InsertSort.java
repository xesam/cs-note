package dev.xesam.foundation.alg;

/**
 * 插入排序
 * <p/>
 * Created by xe on 2014/12/9.
 */
public class InsertSort extends SortProfile implements Sortable {
    public static void main(String[] args) {
        SimpleProfiler.profile(new InsertSort());
    }

    public static void sortOnce(int i) {
        Integer[] input = Generator.ints(1000);
        InsertSort sorter = new InsertSort();
        sorter.sort(input);
    }

    @Override
    public void sort(Integer[] src) {
        int size = src.length;
        for (int outer = 1; outer < size; outer++) {
            int tmp = src[outer];
            for (int inner = outer; inner > 0; inner--) {
                if (tmp < src[inner - 1]) {
                    src[inner] = src[inner - 1];
                } else {
                    src[inner] = tmp;
                    break;
                }
            }
        }
        SortUtils.checkSort(src);
    }

    @Override
    public void run() {
        SortUtils.runSort(1000, InsertSort::sortOnce);
    }
}
