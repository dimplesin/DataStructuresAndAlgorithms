package com.company.amazon.BookKarumanchi.Challenges;

/**
 * Created by v-dsindhi on 6/9/15.
 */
/**
 * Created by v-dsindhi on 6/9/15.
 */
public class MaxMin {

    public static void main(String args[]){
        int A[] = {1,5,3,3,7};
        int swapIndex=0, maxMinIndex=0;
        int swapInt = A[0];
        boolean result = true;
        for(int i=0;i<A.length-1;i++){
            if(A[i] > A[i+1]) {
                swapInt = A[i];
                swapIndex = i;
            }
        }
        for(int i=0;i<A.length;i++){
            if(A[i]<swapInt){
                maxMinIndex = i;
            }
        }

        int temp = A[maxMinIndex];
        A[maxMinIndex] = A[swapIndex];
        A[swapIndex] = temp;

        for(int i=0;i<A.length-1;i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    result = false;
                }
            }
        }
        System.out.println(result);
    }
}
