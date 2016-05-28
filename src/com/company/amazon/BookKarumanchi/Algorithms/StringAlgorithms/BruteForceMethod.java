package com.company.amazon.BookKarumanchi.Algorithms.StringAlgorithms;

/**
 * Created by v-dsindhi on 4/2/15.
 */
public class BruteForceMethod {
    int BruteForceStringMatch(int T[], int n, int P[], int m){
        for(int i=0;i<=n-m;i++){
            int j =0;
            while(j<m && P[j] == T[i+j]){
                j=j+1;
            }
            if(j == m) return i;
        }
        return -1;
    }
}
