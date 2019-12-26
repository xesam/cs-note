package dev.xesam.foundation.ds.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xe on 2014/12/4.
 * xesamguo@gmail.com
 */
public class BinaryTreeTest {

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void test_1() {
        BinaryTree tree = BinaryTreeRun.getTree();
        assertNull(tree.find(1000));
        BinaryTreeNode node = tree.find(22);
        assertNotNull(node);
        assertEquals(10022, node.value);
    }

    @Test
    public void test_2() {
        BinaryTree tree = BinaryTreeRun.getTree();
        BinaryTreeNode min = tree.minNode();
        assertEquals(1000, min.value);
        BinaryTreeNode max = tree.maxNode();
        assertEquals(10028, max.value);
    }

    @Test
    public void test_3() {
        BinaryTree tree = BinaryTreeRun.getTree();
        BinaryTreeNode before = tree.find(17);
        assertEquals(10017, before.value);
        tree.delete(17);
        BinaryTreeNode after = tree.find(17);
        assertNull(after);
    }
}
