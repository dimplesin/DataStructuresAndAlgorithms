package com.company.amazon.BookKarumanchi.Algorithms.Sorting;

/**
 * Created by v-dsindhi on 3/29/15.
 */
public class BucketSort {
    private final int BUCKETS=10;
    void BucketSort(int A[], int array_size){
        int i,j,k;
        int buckets[] = new int[BUCKETS];
        for(j=0;j<BUCKETS;j++){buckets[j] = 0;}
        for(i=0;i<array_size;i++){ ++buckets[A[i]];}
        for(i=0,j=0; j<BUCKETS;j++){
            for(k=buckets[j];k>0;--k){
                A[i++] = j;
            }
        }
    }

}


//treeSort
//RadixSort
//Randamoised Quick Sort
//Topological Sort


