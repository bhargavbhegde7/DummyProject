package com.learn.java.arrays;

import java.util.Arrays;

public class Basic {
    public static int factorial(int n){
        if(n == 1 || n == 0){
            return 1;
        }else{
            return n * factorial(n-1);
        }
    }

    public static int fibOfNthNum(int n){
        if(n == 0){
            return 0;
        }

        else if(n == 1 | n == 2){
            return 1;
        }

        else{
            return fibOfNthNum(n-1) + fibOfNthNum(n-2);
        }
    }

    public static int sumOfNume(int[] arr){
        if(arr.length == 1){
            return arr[0];
        }else{
            return arr[0] + sumOfNume(Arrays.copyOfRange(arr, 1, arr.length));
        }
    }
}
