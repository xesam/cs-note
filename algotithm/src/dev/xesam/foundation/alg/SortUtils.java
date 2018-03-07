package dev.xesam.foundation.alg;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 * Created by xe on 2014/12/5.
 * xesamguo@gmail.com
 */
public class SortUtils {
    public static <T> void swap(T[] src, int a, int b) {
        T tmp = src[a];
        src[a] = src[b];
        src[b] = tmp;
    }

    public static <T extends Comparable<T>> void checkSort(T[] src) {
        for (int i = 0; i < src.length - 1; i++) {
            if (src[i].compareTo(src[i + 1]) > 0) {
                Log.println(src);
                throw new RuntimeException("fatal");
            }
        }
    }

    public static void runSort(int count, IntConsumer intConsumer) {
        IntStream.range(0, count).forEach(intConsumer);
    }
}
