package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/25/15.
 */
public class ArrayIncreasingAndDecresingFindElement {

    /* Searches an element no in a pivoted sorted array arrp[]
   of size arr_size */
    int pivotedBinarySearch(int arr[], int arr_size, int no)
    {
        int pivot = findPivot(arr, 0, arr_size-1);

        // If we didn't find a pivot, then array is not rotated at all
        if (pivot == -1)
            return binarySearch(arr, 0, arr_size-1, no);

        // If we found a pivot, then first compare with pivot and then
        // search in two subarrays around pivot
        if (arr[pivot] == no)
            return pivot;
        if (arr[0] <= no)
            return binarySearch(arr, 0, pivot-1, no);
        else
            return binarySearch(arr, pivot+1, arr_size-1, no);
    }

    /* Function to get pivot. For array 3, 4, 5, 6, 1, 2 it will
       return 3. If array is not rotated at all, then it returns -1 */
    int findPivot(int arr[], int low, int high)
    {
        // base cases
        if (high < low)  return -1;
        if (high == low) return low;

        int mid = (low + high)/2;   /*low + (high - low)/2;*/
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid-1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid-1);
        else
            return findPivot(arr, mid + 1, high);
    }

    /* Standard Binary Search function*/
    int binarySearch(int arr[], int low, int high, int no)
    {
        if (high < low)
            return -1;
        int mid = (low + high)/2;  /*low + (high - low)/2;*/
        if (no == arr[mid])
            return mid;
        if (no > arr[mid])
            return binarySearch(arr, (mid + 1), high, no);
        else
            return binarySearch(arr, low, (mid -1), no);
    }


    /* Driver program to check above functions */
    public static void main(String args[])
    {
        ArrayIncreasingAndDecresingFindElement arrayIncAndDecFindEle = new ArrayIncreasingAndDecresingFindElement();
        // Let us search 3 in below array
        int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int arr_size = arr1.length;
        int no = 3;
        System.out.print("Index of the element is " + arrayIncAndDecFindEle.pivotedBinarySearch(arr1, arr_size, no));

        // Let us search 3 in below array
        int arr2[] = {3, 4, 5, 1, 2};
        arr_size = arr2.length;
        System.out.print("Index of the element is %d" + arrayIncAndDecFindEle.pivotedBinarySearch(arr2, arr_size, no));

        // Let us search for 4 in above array
        no = 4;
        System.out.print("Index of the element is "+ arrayIncAndDecFindEle.pivotedBinarySearch(arr2, arr_size, no));

        // Let us search 0 in below array
        int arr3[] = {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1};
        no = 0;
        arr_size = arr3.length;
        System.out.print("Index of the element is "+ arrayIncAndDecFindEle.pivotedBinarySearch(arr3, arr_size, no));

        // Let us search 3 in below array
        int arr4[] = {2, 3, 0, 2, 2, 2, 2, 2, 2, 2};
        no = 3;
        arr_size = arr4.length;
        System.out.print("Index of the element is %d\n"+arrayIncAndDecFindEle.pivotedBinarySearch(arr4, arr_size, no));

        // Let us search 2 in above array
        no = 2;
        System.out.print("Index of the element is %d\n"+ arrayIncAndDecFindEle.pivotedBinarySearch(arr4, arr_size, no));

        // Let us search 3 in below array
        int arr5[] = {1, 2, 3, 4};
        no = 3;
        arr_size = arr5.length;
        System.out.print("Index of the element is "+arrayIncAndDecFindEle.pivotedBinarySearch(arr5, arr_size, no));

    }
}
