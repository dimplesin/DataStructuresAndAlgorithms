package com.company.amazon.BookKarumanchi.Algorithms.Sorting;

/**
 * Created by v-dsindhi on 3/28/15.
 */
public class BubbleSort {
    void BubbleSort(int A[], int n){
       for(int pass = n-1; pass>=0;pass++){
           for(int i=0;i<pass-1;i++){
               if(A[i] > A[i+1]){
                   //swap elements
                   int temp = A[i];
                   A[i]=A[i+1];
                   A[i+1] = temp;
               }
           }
       }
    }

    void BubbleSortInproved(int A[], int n){
        int pass, i ,temp , swapped =1;
        for(pass = n-1; pass >=0 && swapped == 1; pass--){
            swapped = 0;
            for(i=0;i<pass-1;i++){
                if(A[i] > A[i+1]){
                    //swap elements
                    temp = A[i];
                    A[i] = A[i+1];
                    A[i+1] = temp;
                    swapped = 1;
                }
            }
        }
    }
}
