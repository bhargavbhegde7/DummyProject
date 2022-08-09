package com.learn.java.arrays;
/*
 * Create By @author bhegde
 * Create On @date 8/8/2022
 *
 */

/**
 * Replace every array element with the product of every other element without using a division operator
 * <p>
 * Given an integer array, replace each element with the product of every other element without using the division operator.
 * <p>
 * For example,
 * Input:  { 1, 2, 3, 4, 5 }
 * Output: { 120, 60, 40, 30, 24 }
 * <p>
 * <p>
 * Input:  { 5, 3, 4, 2, 6, 8 }
 * Output: { 1152, 1920, 1440, 2880, 960, 720 }
 */
public class Prob1 {

    public static void testProb1() {
        int[] arr = {1, 2, 3, 4, 5};
        printProds(arr);
    }

    private static void printProds(int[] arr) {
        printProds(arr, 5);
    }

    private static void printProds(int[] arr, int start) {
        int len = arr.length;
        int safeKeep = arr[start];
        for (int i = 0; i < len; i++) {

        }
    }
}
