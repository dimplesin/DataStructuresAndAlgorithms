package com.company.amazon.BookKarumanchi.Algorithms.StringAlgorithms;

/**
 * Created by v-dsindhi on 4/2/15.
 */
public class Combinations {
    //Print all subsets of the characters in str
    public static void CombinationsOne(String str){
        CombinationsOne("", str);
    }

    //print all subsets of the remaining elements, with given prefix
    private static void CombinationsOne(String prefix, String str){
        if(str.length() > 0){
            System.out.println(prefix + str.charAt(0));
            CombinationsOne(prefix+str.charAt(0), str.substring(1));
            CombinationsOne(prefix, str.substring(1));
        }
    }
    //alternate implementation
    public static void CombinationsTwo(String str){
        CombinationsTwo("", str);
    }
    private static void CombinationsTwo(String prefix, String str){
        System.out.println(prefix);
        for(int i =0;i < str.length();i++){
            CombinationsTwo(prefix+str.charAt(i), str.substring(i+1));
        }
    }
}
