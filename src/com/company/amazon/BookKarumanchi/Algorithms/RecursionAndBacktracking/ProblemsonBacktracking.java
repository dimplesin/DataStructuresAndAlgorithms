package com.company.amazon.BookKarumanchi.Algorithms.RecursionAndBacktracking;

/**
 * Created by v-dsindhi on 4/3/15.
 */
public class ProblemsonBacktracking {

    /* Generate all the string of n bits. Assume A[0....n-1] is an array of size n
    * Time Complexity O(2^n)
    * */
    int A[] = new int[1024];
    void Binary(int n){
        if(n < 1){
            System.out.println(n);
        }
        else{
            A[n-1] = 0;
            Binary(n-1);
            A[n-1] = 1;
            Binary(n-1);
        }
    }

    /* Generate all the strings of length n drawn from 0.....k-1
    * Time Complexity : O(k^n)
    * */
    void k_string(int n, int k){
        // Process all k-ary strings of length m
        if(n<1){
            System.out.println(A);
        }else{
            for(int j = 0; j<k;j++){
                A[n-1]  = j;
                k_string(n-1,k);
            }
        }
    }



}
