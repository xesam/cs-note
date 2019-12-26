package dev.xesam.foundation.alg;

/**
 * Created by xe on 15-4-4.
 */
public class MergeSort extends SortProfile implements Sortable {

    public static void main(String[] args) {
        SimpleProfiler.profile(new MergeSort());
    }

    public static void sortOnce(int i) {
        Integer[] input = Generator.ints(1000);
        MergeSort sorter = new MergeSort();
        sorter.sort(input);
    }

    @Override
    public void sort(Integer[] src) {
        Integer[] workspace = new Integer[src.length];
        recSort(src, workspace, 0, src.length - 1);
        SortUtils.checkSort(src);
    }

    private void recSort(Integer[] src, Integer[] workspace, int lowerIndex, int upperIndex) {
        if (lowerIndex == upperIndex) {
            return;
        } else {
            int mid = (lowerIndex + upperIndex) / 2;
            recSort(src, workspace, lowerIndex, mid);
            recSort(src, workspace, mid + 1, upperIndex);
            merge(src, workspace, lowerIndex, mid, mid + 1, upperIndex);
        }
    }

    private void merge(Integer[] src, Integer[] workspace, int leftIndex, int leftBound, int rightIndex, int rightBound) {
        int len = rightBound - leftIndex + 1;
        int lowBound = leftIndex;
        int highBound = rightIndex;
        int i = 0;
        while (lowBound <= leftBound && highBound <= rightBound) {
            if (src[lowBound] < src[highBound]) {
                workspace[i++] = src[lowBound++];
            } else {
                workspace[i++] = src[highBound++];
            }
        }

        while (lowBound <= leftBound) {
            workspace[i++] = src[lowBound++];
        }

        while (highBound <= rightBound) {
            workspace[i++] = src[highBound++];
        }

        int j = 0;
        while (j < len) {
            src[leftIndex + j] = workspace[j];
            j++;
        }
    }

    @Override
    public void run() {
        SortUtils.runSort(1000, MergeSort::sortOnce);
    }
}
