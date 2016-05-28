package com.company.amazon.BookKarumanchi.Algorithms.Sorting;

/**
 * Created by v-dsindhi on 3/29/15.
 */
public class SelectionSort {

    void Selection(int A[], int n){
        int i,j,min,temp;
        for(i=0;i<n-1;i++){
            min = i;
            for(j=i+1;j<n;j++){
                if(A[j]<A[min]){
                    min = j;
                }
            }
            //swap elements
            temp = A[min];
            A[min] = A[i];
            A[i] = temp;
        }
    }
}
