package dev.xesam.foundation.book.algorithms.section1_1;

import junit.framework.TestCase;

/**
 * Created by xe on 12/2/15.
 */
public class Ex1_1_6 extends TestCase {
    public void test1() {
        int f = 0;
        int g = 1;
        for (int i = 0; i < 15; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
    }
}
