package com.learn.java.trees.bintree;
/*
 * Create By @author bhegde
 * Create On @date 8/7/2022
 *
 */

public final class BinTreeUtils {
    public static BinTreeUtils INSTANCE = new BinTreeUtils();

    private BinTreeUtils() {
        //Keeping this private to make singleton
    }

    public void testTree() {
        Node root = new Node(new DataImpl(4));

        insert(root, new DataImpl(2));
        insert(root, new DataImpl(6));
        insert(root, new DataImpl(1));
        insert(root, new DataImpl(3));
        insert(root, new DataImpl(5));
        insert(root, new DataImpl(7));

        printInorder(root);
    }

    public Node getSampleBinTree() {
        Node root = getUsualNodeWithData(4);

        root.setLeft(getUsualNodeWithData(2));
        root.setRight(getUsualNodeWithData(6));

        root.getLeft().setLeft(getUsualNodeWithData(1));
        root.getLeft().setRight(getUsualNodeWithData(3));

        root.getRight().setLeft(getUsualNodeWithData(5));
        root.getRight().setRight(getUsualNodeWithData(7));

        return root;
    }

    public Node getUsualNodeWithData(int n) {
        return new Node(new DataImpl(n));
    }

    public Node getUsualNodeWithData(Data data) {
        if (data == null) {
            data = new DataImpl(0);
        }
        return new Node(data);
    }

    public Node insert(Node root, Data data) {
        if (root.compareTo(data) > 0) {
            if (root.getLeft() == null) {
                root.setLeft(new Node(data));
                return root;
            } else {
                return insert(root.getLeft(), data);
            }
        } else if (root.compareTo(data) < 0) {
            if (root.getRight() == null) {
                root.setRight(new Node(data));
                return root;
            } else {
                return insert(root.getRight(), data);
            }
        } else {
            return root;
        }
    }

    public void printInorder(Node root) {
        if (root == null) {
            return;
        }

        if (root.getLeft() != null) {
            printInorder(root.getLeft());
        }

        printValue(root);

        if (root.getRight() != null) {
            printInorder(root.getRight());
        }
    }

    public void printPostorder(Node root) {
        if (root == null) {
            return;
        }

        printValue(root);

        if (root.getLeft() != null) {
            printPostorder(root.getLeft());
        }

        if (root.getRight() != null) {
            printPostorder(root.getRight());
        }
    }

    public void printPreorder(Node root) {
        if (root == null) {
            return;
        }

        if (root.getLeft() != null) {
            printPreorder(root.getLeft());
        }

        if (root.getRight() != null) {
            printPreorder(root.getRight());
        }

        printValue(root);
    }


    public void printValue(Node node) {
        node.getData().printValue();
    }

    public void dfs() {

    }

    public void bfs() {

    }
}
