package com.company.Microsoft;

import java.util.Arrays;

/**
 * Created by v-dsindhi on 8/15/15.
 */
public class CheckIfTwoStringAreSame {

    //Given a set of strings. Check if a new string is equal to any of them. Here equal means the letters are the same, like abbc=bacb

    public static void main(String args[]){
        String str1 = "abbc";
        String str2 = "bacb";
        System.out.println(checkStringSame(str1,str2));
    }

    public static boolean checkStringSame(String str1, String str2){
        char[] str1Char = str1.toCharArray();
        char[] str2Char = str2.toCharArray();
        Arrays.sort(str1Char);
        Arrays.sort(str2Char);
        return Arrays.equals(str1Char, str2Char);
    }
}
