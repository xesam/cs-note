package dev.xesam.foundation.alg;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by xe on 2014/12/5.
 * xesamguo@gmail.com
 */
public class Generator {
    public static Integer[] ints(int length) {
        Random random = new Random();
        Integer[] ret = new Integer[length];
        IntStream.range(0, length).forEach((i) -> {
            ret[i] = random.nextInt(length * 10);
        });
        return ret;
    }
}
