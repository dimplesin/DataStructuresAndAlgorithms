package com.company.Microsoft;

/**
 * Created by v-dsindhi on 8/10/15.
 */
public class LargestSumContiguousArray {
    int MaxContiguousSumAltSol(int A[], int n){
        int sumSoFar = 0, sumEndingHere = 0;
        for(int i=0;i<n;i++){
            sumEndingHere = sumEndingHere +A[i];
            if(sumEndingHere < 0){
                sumEndingHere = 0;
                continue;
            }
            if(sumSoFar < sumEndingHere){
                sumSoFar =sumEndingHere;
            }
        }
        return sumSoFar;
    }

}
