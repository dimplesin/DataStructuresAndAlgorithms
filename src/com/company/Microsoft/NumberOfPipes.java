package com.company.Microsoft;

/**
 * Created by v-dsindhi on 8/10/15.
 */
public class NumberOfPipes {
    public static void main(String args[]){
        int arr[] = {10,10,10,15,20,35,55,60,70,75,75,80};
        System.out.println(numberOfPipes(arr, 12));
    }

    public static int numberOfPipes(int arr[], int n){
        int sum=0,count=0;
        if(n==1) return 1;
        for(int i=0;i<n;i++){
            sum += arr[i];
        }
            while (sum > 0) {
                count++;
                sum = sum - 100;
            }

        return count;
    }
}
