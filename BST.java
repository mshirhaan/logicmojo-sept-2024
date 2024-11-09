import java.util.*;

class Solution {

    public static void main(String[] args) {
        BST tree = new BST();
        tree.add(4);
        tree.add(6);
        tree.add(3);
        tree.add(9);
        tree.add(2);
        tree.add(1);
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }

}

class BST {
    public Node root;

    public void add1(int val) {
        if (root == null) {
            root = new Node(val);
            return;
        }
        Node node = root;
        while (true) {
            if (val < node.val) {
                if (node.left == null) {
                    node.left = new Node(val);
                    break;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new Node(val);
                    break;
                }
                node = node.right;
            }
        }
    }

    public void add2(int val, Node current) {
        if (val < current.val) {
            if (current.left == null) {
                current.left = new Node(val);
            } else {
                add2(val, current.left);
            }
        } else {
            if (current.right == null) {
                current.right = new Node(val);
            } else {
                add2(val, current.right);
            }
        }
    }

    public void add3(int val) {

        helper(val, root);

    }

    private void helper(int val, Node current) {
        if (val < current.val) {
            if (current.left == null) {
                current.left = new Node(val);
            } else {
                helper(val, current.left);
            }
        } else {
            if (current.right == null) {
                current.right = new Node(val);
            } else {
                helper(val, current.right);
            }
        }
    }
}
