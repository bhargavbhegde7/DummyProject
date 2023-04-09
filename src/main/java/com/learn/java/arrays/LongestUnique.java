package com.learn.java.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestUnique {
    public static void main(String[] args) {
        System.out.println(longestUnique("PINEAPPLE"));
        System.out.println(longestUnique("BHARGAV"));
        System.out.println(longestUnique("CHITKALA"));
        System.out.println(longestUnique("BHALACHANDRA"));
    }

    public static String longestUnique(String str) {

        char[] arr = str.toCharArray();
        int size = arr.length;

        int finalStart = 0;
        int finalEnd = 0;

        int start = 0;
        int end = 0;

        Map<Character, Integer> unique = new HashMap<>();
        for (int i = 0; i < size; i++) {
            char c = arr[i];
            if (unique.containsKey(c)) {
                start = unique.get(c) + 1;
                i = start - 1;
                end = start;
                unique = new HashMap<>();
            } else {
                unique.put(c, i);
                end = i;
            }
            if (finalEnd - finalStart < end - start) {
                finalStart = start;
                finalEnd = end;
            }
        }

        System.out.println("Start : " + finalStart + ", End : " + finalEnd);
        return str.substring(finalStart, finalEnd + 1);
    }
}
