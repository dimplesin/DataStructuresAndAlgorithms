package com.company.amazon.BookKarumanchi.Algorithms.Searching;

/**
 * Created by v-dsindhi on 3/29/15.
 */
public class BinarySearch {

    //Iterative Binary Search Algorithm
    int BinarySearchIterative(int A[], int n, int data){
        int low = 0,high = n - 1, mid;
        while(low <= high){
            mid = low + (high - low)/2;
            if(A[mid] == data){
                return mid;
            }else if (A[mid] < data){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }

    // Recursive Binary Search Algorithm
    int BinarySearchRecursive(int A[], int low, int high, int data){
        int mid = low + (high - low)/2;
        if(A[mid] == data) {
            return mid;
        }else if(A[mid] < data){
            return BinarySearchRecursive(A, mid + 1, high, data);
        }else{
            return BinarySearchRecursive(A, low, mid-1,data);
        }
    }
}
