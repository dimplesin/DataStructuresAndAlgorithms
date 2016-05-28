package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/23/15.
 */
public class FindPair {
    //Differnece of two elements is the number given as k
    // The function assumes that the array is sorted
    static boolean findPair(int arr[], int size, int n) {
        // Initialize positions of two elements
        int i = 0;
        int j = 1;
        // Search for a pair
        while (i<size && j<size) {
            if (i != j && arr[j]-arr[i] == n) {
                System.out.println(arr[i] + "@@@@@@" + arr[j]);
                return true;
            }else if (arr[j]-arr[i] < n)
                j++;
            else
                i++;
        }
        System.out.println("No such pair");
        return false;
    }

    public static void main(String args[]){
        int arr[] = {1,8,30,40,100};
        int n =70;
        int size = arr.length;
        findPair(arr, size, n);
    }


}
