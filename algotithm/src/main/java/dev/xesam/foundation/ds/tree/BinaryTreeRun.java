package dev.xesam.foundation.ds.tree;

/**
 * Created by xe on 2014/12/4.
 * xesamguo@gmail.com
 */
public class BinaryTreeRun {

    public static BinaryTree getTree() {
        BinaryTree tree = new BinaryTree();
        tree.insert(23, 1001);
        tree.insert(0, 1000);
        tree.insert(13, 10012);
        tree.insert(15, 10015);
        tree.insert(22, 10022);
        tree.insert(5, 11);
        tree.insert(17, 10017);
        tree.insert(26, 10026);
        tree.insert(2, 1002);
        tree.insert(24, 10024);
        tree.insert(25, 10025);
        tree.insert(27, 10027);
        tree.insert(28, 10028);
        return tree;
    }

    public static void main(String[] args) {
        BinaryTree tree = getTree();
        tree.inspect();
    }
}
