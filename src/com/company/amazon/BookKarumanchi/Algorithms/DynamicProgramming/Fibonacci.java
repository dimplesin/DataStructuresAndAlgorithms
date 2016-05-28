package com.company.amazon.BookKarumanchi.Algorithms.DynamicProgramming;

/**
 * Created by v-dsindhi on 4/3/15.
 */
public class Fibonacci {

    int fib(int n){
        if(n ==0 || n==1){
            return 1;
        }
        int[] fib = new int[0];
        fib[0] = 1;
        fib[1] = 1;
        for(int i=2; i<n;i++){
            fib[i] = fib(i-1) + fib(i-2);
        }
        return fib(n-1);
    }

    int fib[] =  new int[10];
    int fibonacci(int n){
        if(n == 1) return 1;
        if(n == 2) return 1;
        if(fib[n] != 0){
            return fib[n];
        }
        return fib[n] = fibonacci(n-1) + fibonacci(n-2);
    }

    int fibonacciSum(int n){
        int a=0,b=1,sum = 0, i;
        for(i=0;i<n;i++){
            sum = a+b;
            a = b;
            b = sum;
        }
        return sum;
    }

}
