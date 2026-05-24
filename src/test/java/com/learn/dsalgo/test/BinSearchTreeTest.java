package com.learn.dsalgo.test;

import com.learn.java.trees.bintree.BinTreeUtils;
import com.learn.java.trees.bintree.DataImpl;
import com.learn.java.trees.bintree.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BinSearchTreeTest {

    private static Node root;

    @BeforeAll
    public static void createTree() {
        List<Float> valuesArray = Arrays.asList(5.0F, 6.0F, 7.0F, 1.0F, 2.0F, 3.0F, 4.0F, -2.0F, 1.5F, 1.25F, 1.75F);

        root = new Node(new DataImpl(valuesArray.get(0)));

        int size = valuesArray.size();
        for (int i = 1; i < size; i++) {
            BinTreeUtils.INSTANCE.insert(root, new DataImpl(valuesArray.get(i)));
        }
    }

    @Test
    public void testInOrder() {
        Assertions.assertEquals(String.valueOf(Arrays.asList(-2.0, 1.0, 1.25, 1.5, 1.75, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0)), String.valueOf(BinTreeUtils.INSTANCE.getInOrderData(root)));
    }

    @Test
    public void testPostOrder() {
        Assertions.assertEquals(String.valueOf(Arrays.asList(-2.0, 1.25, 1.75, 1.5, 4.0, 3.0, 2.0, 1.0, 7.0, 6.0, 5.0)), String.valueOf(BinTreeUtils.INSTANCE.getPostOrderData(root)));
    }

    @Test
    public void testPreOrder() {
        Assertions.assertEquals(String.valueOf(Arrays.asList(5.0, 1.0, -2.0, 2.0, 1.5, 1.25, 1.75, 3.0, 4.0, 6.0, 7.0)), String.valueOf(BinTreeUtils.INSTANCE.getPreorderData(root)));
    }

    @Test
    public void testInorderSuccessor() {
        float inOrderSuccessor = BinTreeUtils.INSTANCE.findInorderSuccessor(root, null, 1F).getData().getValue();
        Assertions.assertEquals(1.25, inOrderSuccessor);
    }
}
