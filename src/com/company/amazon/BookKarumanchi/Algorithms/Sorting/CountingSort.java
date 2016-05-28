package com.company.amazon.BookKarumanchi.Algorithms.Sorting;

/**
 * Created by v-dsindhi on 3/29/15.
 */
public class CountingSort {

    void CountingSort(int A[], int n,int B[], int K){
        int C[] = new int[K];
        int i,j;
        //Complexity O(K)
        for(i=0;i<K;i++){
            C[i] = 0;
        }
        //Complexity: O(n)
        for(j=0;j<n;j++){
            C[A[j]] = C[A[j]] + 1;
            //C[i] now contains the number of elements equal to i
        }
        //Complexity :O(K)
        for(i=1;i<K;i++){
            C[i] = C[i]+C[i-1];
            // C[i] now contains the number of elements <= 1
        }
        //Complexity :O(n)
        for(j=n-1;j>=0;j--){
            B[C[A[j]]] = A[j];
            C[A[j]] = C[A[j]] - 1;
        }
    }
}
