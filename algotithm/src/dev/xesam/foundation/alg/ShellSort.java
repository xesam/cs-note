package dev.xesam.foundation.alg;

/**
 * Created by xe on 2016/5/6.
 */
public class ShellSort extends SortProfile implements Sortable {
    public static void main(String[] args) {
        SimpleProfiler.profile(new ShellSort());
    }

    public static void sortOnce(int i) {
        Integer[] input = Generator.ints(41);
        ShellSort sorter = new ShellSort();
        sorter.sort(input);
    }

    @Override
    public void sort(Integer[] src) {
        final int size = src.length;

        int h = 1;
        while (h <= size / 3) {//Knuth
            h = 3 * h + 1;
        }

        while (h > 0) {
            System.out.println("h=" + h);
            for (int outer = h; outer < size; outer++) {
                int tmp = src[outer];
                int inner = outer;
                while (inner > h - 1 && src[inner - h] >= tmp) {//inner > h - 1 标志已经有序的部分
                    src[inner] = src[inner - h];
                    inner -= h;
                }
                src[inner] = tmp;
            }
            h = (h - 1) / 3;
        }

        SortUtils.checkSort(src);
    }

    @Override
    public void run() {
        SortUtils.runSort(1, ShellSort::sortOnce);
    }
}
