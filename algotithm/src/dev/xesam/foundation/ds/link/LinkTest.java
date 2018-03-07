package dev.xesam.foundation.ds.link;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by xe xesamguo@gmail.com on 15-8-19.
 */
public class LinkTest {

    @Before
    public void setup() {

    }

    @Test
    public void test_1() {
        LinkList linkList = new LinkList();
        linkList.insertFirst(new Node(0));
        linkList.insertFirst(new Node(1));
        linkList.insertFirst(new Node(2));
        linkList.insertFirst(new Node(3));

        linkList.inspect();
    }

    @Test
    public void test_2() {
        LinkList linkList = new LinkList();
        linkList.insertFirst(new Node(0));
        linkList.insertFirst(new Node(1));
        linkList.insertFirst(new Node(2));
        linkList.insertFirst(new Node(3));

        assertEquals(2, linkList.find(2).iData);
        assertEquals(2, linkList.delete(2).iData);

        linkList.inspect();
    }

    @Test
    public void test_3() {
        SortedList list = new SortedList();
        list.insert(new Node(2));
        list.insert(new Node(0));
        list.insert(new Node(3));
        list.insert(new Node(1));

        list.inspect();
    }

    @Test
    public void test_4() {
        LinkList list = new LinkList();
        list.insertLast(new Node(2));
        list.insertLast(new Node(0));
        list.insertLast(new Node(3));
        list.insertLast(new Node(1));

        LinkList.ListIterator iterator = list.getIterator();
        while (!iterator.isAfterLast()) {
            Node node = iterator.getCurrent();
            System.out.println(node);
            iterator.moveToNext();
        }
    }
}
