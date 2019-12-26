package dev.xesam.foundation.book.algorithms.section1_1;

import junit.framework.TestCase;

/**
 * Created by xe on 12/2/15.
 */
public class Ex1_1_24 extends TestCase {
    public static int gcd1(int a, int b) {
        if (b == 0) {
            return a;
        }
        if (a < b) {
            return gcd1(b, a);
        } else {
            return gcd1(b, a % b);
        }
    }

    public void testGcd1() {
        assertEquals(3, gcd1(6, 3));
        assertEquals(3, gcd1(15, 24));
    }
}
