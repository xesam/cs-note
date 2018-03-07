package dev.xesam.foundation.ds.link;

/**
 * Created by xe xesamguo@gmail.com on 15-8-20.
 */
public class SortedList {
    private Node first;

    public SortedList() {
        this.first = null;
    }

    boolean isEmpty() {
        return first == null;
    }

    void insert(Node node) {
        Node previous = null;
        Node current = first;

        while (current != null && node.iData > current.iData) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            first = node;
        } else {
            previous.next = node;
        }
        node.next = current;
    }

    void inspect() {
        Node current = first;
        while (current != null) {
            System.out.println(current.toString());
            current = current.next;
        }
    }
}
