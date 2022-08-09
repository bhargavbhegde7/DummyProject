package com.learn.java.trees.bintree;

/*
 * Create By @author bhegde
 * Create On @date 8/7/2022
 *
 */

public class Node implements Comparable<Data>{
    private Data data;
    private Node left;
    private Node right;

    public Node(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public int compareTo(Data o) {
        return this.data.compareTo(o);
    }
}
