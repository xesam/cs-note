package dev.xesam.foundation.ds.tree;

import java.util.stream.IntStream;

/**
 * Created by xe on 16-6-1.
 */
class BinaryTree {
    BinaryTreeNode root;

    public void inspect() {
        inspect0(root, 0, "root");
    }

    private void indent(int depth) {
        IntStream.range(0, depth).forEach(i -> System.out.print("   "));
        System.out.print("|--");
    }

    private void inspect0(BinaryTreeNode root0, int depth, String pos) {
        System.out.print(String.format("[%s]", pos));
        System.out.println(root0.toString());
        if (root0.left != null) {
            indent(depth);
            inspect0(root0.left, depth + 1, "left");
        }

        if (root0.right != null) {
            indent(depth);
            inspect0(root0.right, depth + 1, "right");
        }
    }

    public BinaryTreeNode find(int key) {
        BinaryTreeNode current = root;
        while (current != null) {
            if (current.key == key) {
                return current;
            } else if (current.key < key) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return null;
    }

    public void insert(int key, int value) {

        BinaryTreeNode node = new BinaryTreeNode();
        node.key = key;
        node.value = value;

        if (root == null) {
            root = node;
            return;
        }

        BinaryTreeNode current = root;

        while (true) {
            if (current.key < key) {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = node;
                    break;
                }
            } else {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = node;
                    break;
                }
            }
        }

    }

    public boolean delete(int key) {
        BinaryTreeNode parent = root;
        BinaryTreeNode current = parent;

        boolean isLeftLeaf = false;

        while (current != null) {
            if (current.key == key) {
                break;
            } else if (current.key > key) {
                parent = current;
                current = current.left;
                isLeftLeaf = true;
            } else {
                parent = current;
                current = current.right;
                isLeftLeaf = false;
            }
        }

        if (current == null) {
            return false;
        }

        if (current.left == null && current.right == null) {
            System.out.println("leaf");
            System.out.println("parent:" + parent);
            System.out.println("current:" + current);

            if (current == root) {
                root = null;
            } else if (isLeftLeaf) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.left != null && current.right == null) {
            System.out.println("current.left != null");
            System.out.println("parent:" + parent);
            System.out.println("current:" + current);

            if (current == root) {
                root = root.left;
            } else if (isLeftLeaf) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }

        } else if (current.left == null && current.right != null) {
            System.out.println("current.right != null");
            System.out.println("parent:" + parent);
            System.out.println("current:" + current);

            if (current == root) {
                root = root.right;
            } else if (isLeftLeaf) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else {

            BinaryTreeNode firstRight = current.right;

            if (firstRight.left == null) {
                firstRight.left = current.left;
                if (current == root) {
                    root = firstRight;
                } else if (isLeftLeaf) {
                    parent.left = firstRight;
                } else {
                    parent.right = firstRight;
                }
            } else {
                BinaryTreeNode parent2 = firstRight;
                BinaryTreeNode left2 = firstRight.left;
                while (left2.left != null) {
                    parent2 = left2;
                    left2 = left2.left;
                }

                System.out.println("parent2:" + parent2);
                System.out.println("left2:" + left2);

                parent2.left = left2.right;
                left2.left = current.left;
                left2.right = current.right;
                if (current == root) {
                    root = left2;
                } else if (isLeftLeaf) {
                    parent.left = left2;
                } else {
                    parent.right = left2;
                }

            }
        }

        return true;
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历
     */
    public void inOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.key);
        inOrder(node.right);
    }

    /**
     * 先序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 先序遍历
     */
    public void preOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.key);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历
     */
    public void postOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.key);
    }

    public BinaryTreeNode minNode() {
        if (root == null) {
            return null;
        }

        BinaryTreeNode target = root;
        while (target.left != null) {
            target = target.left;
        }

        return target;
    }

    public BinaryTreeNode maxNode() {
        if (root == null) {
            return null;
        }

        BinaryTreeNode target = root;
        while (target.right != null) {
            target = target.right;
        }

        return target;
    }
}
