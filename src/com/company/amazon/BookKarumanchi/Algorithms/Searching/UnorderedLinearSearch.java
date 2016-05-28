package com.company.amazon.BookKarumanchi.Algorithms.Searching;

/**
 * Created by v-dsindhi on 3/29/15.
 */
public class UnorderedLinearSearch {

    int UnsortedLinearSearch(int A[], int n, int data){
        for(int i=0;i<n;i++){
            if(A[i] == data){
                return i;
            }
        }
        return -1;
    }
}
