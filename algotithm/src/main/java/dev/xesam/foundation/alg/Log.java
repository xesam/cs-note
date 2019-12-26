package dev.xesam.foundation.alg;

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
        for (int i = 0; i < src.length; i++) {
            System.out.print(src[i]);
            System.out.print(",");
            if (i % 10 == 9) {
                System.out.printf("\n");
            }
        }
    }
}
