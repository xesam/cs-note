package dev.xesam.foundation.ds.link;

/**
 * Created by xe xesamguo@gmail.com on 15-8-19.
 */
public class LinkList {

    /**
     * Created by xe xesamguo@gmail.com on 15-8-20.
     */
    public class ListIterator {

        LinkList linkList;
        Node current;

        ListIterator(LinkList linkList) {
            this.linkList = linkList;
            current = linkList.first;
        }

        public boolean isAfterLast() {
            return current == null;
        }

        public void moveToNext() {
            current = current.next;
        }

        public Node getCurrent() {
            return current;
        }
    }

    private Node first;
    private Node last;

    public LinkList() {
        this.last = null;
        this.first = last;
    }

    boolean isEmpty() {
        return first == null;
    }

    void insertFirst(Node node) {
        if (isEmpty()) {
            last = node;
        }
        node.next = first;
        first = node;
    }

    void insertLast(Node node) {
        if (isEmpty()) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
    }

    Node deleteFirst() {
        Node tmp = first.next;
        first.next = tmp.next;
        return tmp;
    }

    Node find(int key) {
        Node current = first;
        while (current != null) {
            if (current.iData == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    Node delete(int key) {
        Node current = first;
        Node previous = null;
        while (current != null) {
            if (current.iData == key) {
                previous.next = current.next;
                return current;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    void inspect() {
        Node current = first;
        while (current != null) {
            System.out.println(current.toString());
            current = current.next;
        }
    }

    public ListIterator getIterator() {
        return new ListIterator(this);
    }

}
