package com.company.amazon.BookKarumanchi.Algorithms.DynamicProgramming;

/**
 * Created by v-dsindhi on 4/3/15.
 */
public class Factorial {

    int fact(int n){
        if(n == 1) return 1;
        else if(n == 0) return 1;
        else return n * fact(n-1);
    }

    int facto[];
    int factor(int n){
        if(n == 1 || n==0) return 1;
        else if(facto[n] != 0) return facto[n];
        else return facto[n] = n * factor(n-1);
    }
}
