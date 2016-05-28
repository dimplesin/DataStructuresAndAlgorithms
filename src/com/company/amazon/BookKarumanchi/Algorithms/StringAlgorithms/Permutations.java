package com.company.amazon.BookKarumanchi.Algorithms.StringAlgorithms;

/**
 * Created by v-dsindhi on 4/2/15.
 */
public class Permutations {
    public static void permutationInOrder(String s){
        permutationsInOrder("",s);
    }

    private static void permutationsInOrder(String prefix, String s){
        int len = s.length();
        if(len == 0){
            System.out.println(prefix);
        }else{
            for(int i=0;i<len;i++){
                permutationsInOrder(prefix+s.charAt(i), s.substring(0, i) + s.substring( i+1, len));
            }
        }
    }

    public static void permutationsNotInOrder(String s){
        int len = s.length();
        char[] a = new char[len];
        for(int i=0;i<len;i++){
            a[i] = s.charAt(i);
        }
        permutationsNotInOrder(a, len);
    }

    private static void permutationsNotInOrder(char[] a, int n){
        if(n==1){
            System.out.println(a);
            return;
        }
        for(int i=0;i<n;i++){
            swap(a, i, n-1);
            permutationsNotInOrder(a, n - 1);
            swap(a, i, n-1);
        }
    }

    //swap the characters at indices i and j
    private static void swap(char[] a, int i, int j){
        char c;
        c = a[i]; a[i] = a[j]; a[j] = c;
    }
}
