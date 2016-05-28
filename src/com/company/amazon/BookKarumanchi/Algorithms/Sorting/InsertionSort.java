package com.company.amazon.BookKarumanchi.Algorithms.Sorting;

/**
 * Created by v-dsindhi on 3/29/15.
 */
public class InsertionSort {
    public void InsertionSort(int A[], int n){
        int i,j,v;
        for(i=2;i<=n-1;i++){
            v=A[i];
            j=i;
            while(A[j-1] > v && j >= 1){
                A[j] = A[j-1];
                j--;
            }
            A[j] = v;
        }
    }
}
