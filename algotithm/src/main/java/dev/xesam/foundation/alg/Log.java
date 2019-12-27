package dev.xesam.foundation.alg;

import java.util.Arrays;

/**
 * Created by xe on 2014/12/5.
 * xesamguo@gmail.com
 */
public class Log {
    public static <T> void println(T[] src) {
        print(src);
        System.out.println("\n");
    }

    public static <T> void print(T[] src) {
        Arrays.asList(src).forEach(value -> {
            System.out.print(value);
            System.out.print(",");
        });
    }
}
