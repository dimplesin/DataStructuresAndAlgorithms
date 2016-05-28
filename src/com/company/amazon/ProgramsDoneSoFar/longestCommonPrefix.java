package com.company.amazon.ProgramsDoneSoFar;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by v-dsindhi on 6/23/15.
 */
public class longestCommonPrefix {
    // returns the length of the longest common prefix of all strings in the given array
    public static char longestCommonPrefix(String[] strings) {
        // Null or no contents, return 0
        if (strings == null || strings.length == 0) {
            return 0;
            // only 1 element? return it's length
        } else if (strings.length == 1 && strings[0] != null) {
            return 0;
            // more than 1
        } else {
            // copy the array and sort it on the lengths of the strings,
            // shortest one first.
            // this will raise a NullPointerException if an array element is null
            String[] copy = Arrays.copyOf(strings, strings.length);
            Arrays.sort(copy, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o2.length() - o1.length();
                }
            });
            char result = 0; // init result
            // iterate through every letter of the shortest string
            for (int i = 0; i < copy[0].length(); i++) {
                // compare the corresponding char of all other strings
                char currenChar = copy[0].charAt(i);
                for (int j = 1; j < strings.length; j++) {
                    if (currenChar != copy[j].charAt(i)) { // mismatch
                        return result;
                    }
                }
                // all match
                result = currenChar;
            }
            // done iterating through shortest string, all matched.
            return result;
        }
    }

    public static void main(String args[]){
        String[] strings = { "cd", "cf","cg","ch","ckk","dll"};
        System.out.print(longestCommonPrefix(strings));
    }
}
