package com.company.amazon.BookKarumanchi.Algorithms.Sorting;

/**
 * Created by v-dsindhi on 3/29/15.
 */
public class QuickSort {

    void QuickSort(int A[], int low, int high){
        int pivot;
        /* Termination Condition */
        while(high > low){
            pivot = Partition(A, low, high);
            QuickSort(A, low, pivot-1);
            QuickSort(A, pivot+1, high);
        }
    }
    int Partition(int A[], int low, int high){
        int left, right, pivot_item = A[low];
        left = low;
        right = high;
        while(left <right){
            /* Move left while item is less than pivot */
            while(A[left] <= pivot_item){
                left++;
            }
            /* Move right while item is greater than pivot */
            while(A[right] >pivot_item){
                right--;
            }
            if(left < right){
                //swap(A, left, right);
            }

        }
        /* Right is final position for the pivot*/
        A[low] = A[right];
        A[right] = pivot_item;
        return right;
    }
}
