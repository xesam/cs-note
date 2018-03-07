package dev.xesam.foundation.ds;

import java.util.Iterator;

/**
 * Created by xe on 2014/12/1.
 * xesamguo@gmail.com
 */
public class ListTest<T> implements Iterable<T> {


    public static void main(String[] args) {

    }

    private static class Node {
        public Node prev;
        public Node content;
        public Node next;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

}
