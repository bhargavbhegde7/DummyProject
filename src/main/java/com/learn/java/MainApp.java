package com.learn.java;

/*
 * Create By @author bhegde
 * Create On @date 6/26/2022
 *
 */

import com.learn.java.mouse.KeepAlive;
import com.learn.java.trees.bintree.BinTreeUtils;
import java.awt.AWTException;

public class MainApp {
    public static void main(String[] args) throws AWTException {
        //BinTreeUtils.INSTANCE.testTree();
        KeepAlive.mouseWiggle();
    }
}