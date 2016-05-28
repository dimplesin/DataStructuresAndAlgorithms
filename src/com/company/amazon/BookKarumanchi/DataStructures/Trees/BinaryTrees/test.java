package com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees;

/**
 * Created by v-dsindhi on 8/26/15.
 */
public class test {
    public static void main(String args[]){
        permutations("abc");
    }

    static void permutations(String word){
        permutations(word, "");
    }
    static void permutations(String word, String prefix){
        if(word.length()==0){
            System.out.println(prefix);
        }
        for(int i=0; i<word.length();i++){
            char c = word.charAt(i);
            String left = word.substring(0,i);
            String right = word.substring(i+1);
            permutations(left+right, c+prefix);
        }
    }
}
