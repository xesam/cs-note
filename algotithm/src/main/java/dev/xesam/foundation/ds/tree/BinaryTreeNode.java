package dev.xesam.foundation.ds.tree;

/**
* Created by xe on 16-6-1.
*/
class BinaryTreeNode {
    public int key;
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    public void display() {

    }
}
