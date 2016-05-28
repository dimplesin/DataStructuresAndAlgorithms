package com.company.flipkart;

/**
 * Created by v-dsindhi on 7/14/15.
 */
public class FindMissingNumberInDuplicateElements {

    public static void missingNumbers(int[] a, int n){
        for(int i = 1;i<n;i++){

            int t = a[i] > 0 ? a[i] : a[i]*-1;
            if( a[t] > 0 )
                a[t] = a[t]*-1;
        }

        for(int i =1;i<n;i++){
            if(a[i] >= 0){
                System.out.println(i);
            }
        }
    }

    public static void main(String args[]){
        int a[] = new int[100];
        for(int i=1;i<100;i++){
            if(i != 10) {
                a[i] = i;
            }
        }
        missingNumbers(a, a.length);
    }
}
