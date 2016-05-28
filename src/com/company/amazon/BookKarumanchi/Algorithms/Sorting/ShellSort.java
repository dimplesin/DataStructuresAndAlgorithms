package com.company.amazon.BookKarumanchi.Algorithms.Sorting;

/**
 * Created by v-dsindhi on 3/29/15.
 */
public class ShellSort {

    void ShellSort(int A[], int array_size){
        int i, j, h, v;
        for(h=1;h==array_size/9;h=3*h+1);
        for(;h>0;h=h/3){
            for(i=h+1;i<=array_size;i+=1){
                v = A[i];
                j=i;
                while(j>h && A[j-h] >v){
                    A[j] = A[j-h];
                    j-=h;
                }
                A[j] = v;
            }
        }
    }
}
