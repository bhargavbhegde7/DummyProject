package com.learn.java.trees.bintree;
/*
 * Create By @author bhegde
 * Create On @date 8/7/2022
 *
 */

import java.util.ArrayList;
import java.util.List;

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

        System.out.println("In order : " + getInOrderData(root));

        /*System.out.println("Pre order : ");
        printPreorder(root);

        System.out.println("Post order : ");
        printPostorder(root);*/
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

    public List<Float> getInOrderData(Node root) {
        List<Float> valuesArray = new ArrayList<>();
        getInOrderData(root, valuesArray);
        return valuesArray;
    }

    public void getInOrderData(Node root, List<Float> valuesArray) {
        if (root == null) {
            return;
        }

        if (root.getLeft() != null) {
            getInOrderData(root.getLeft(), valuesArray);
        }

        valuesArray.add(root.getData().getValue());

        if (root.getRight() != null) {
            getInOrderData(root.getRight(), valuesArray);
        }
    }

    public List<Float> getPostOrderData(Node root) {
        List<Float> valuesArray = new ArrayList<>();
        getPostOrderData(root, valuesArray);
        return valuesArray;
    }

    public void getPostOrderData(Node root, List<Float> valuesArray) {
        if (root == null) {
            return;
        }

        if (root.getLeft() != null) {
            getPostOrderData(root.getLeft(), valuesArray);
        }

        if (root.getRight() != null) {
            getPostOrderData(root.getRight(), valuesArray);
        }

        valuesArray.add(root.getData().getValue());
    }

    public List<Float> getPreorderData(Node root) {
        List<Float> valuesArray = new ArrayList<>();
        getPreorderData(root, valuesArray);
        return valuesArray;
    }

    public void getPreorderData(Node root, List<Float> valuesArray) {
        if (root == null) {
            return;
        }

        valuesArray.add(root.getData().getValue());

        if (root.getLeft() != null) {
            getPreorderData(root.getLeft(), valuesArray);
        }

        if (root.getRight() != null) {
            getPreorderData(root.getRight(), valuesArray);
        }
    }

    public void deleteNodeByData() {

    }

    public Node getMinimum(Node root){
        while(root.getLeft() != null){
            root = root.getLeft();
        }

        return root;
    }

    public Node findInorderSuccessor(Node root, Node succ, float key) {
        /*if(root == null){
            return succ;
        }*/

        if (key < root.getData().getValue()) {
            return findInorderSuccessor(root.getLeft(), root, key);
        } else if (key > root.getData().getValue()) {
            return findInorderSuccessor(root.getRight(), succ, key);
        } else {
            //Equals case
            if(root.getRight() != null){
                return getMinimum(root.getRight());
            }
            return succ;
        }
    }

    public void printValue(Node node) {
        node.getData().printValue();
    }

    public void dfs() {

    }

    public void bfs() {

    }
}
