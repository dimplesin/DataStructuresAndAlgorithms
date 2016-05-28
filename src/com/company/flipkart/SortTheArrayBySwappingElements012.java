package com.company.flipkart;

/**
 * Created by v-dsindhi on 7/13/15.
 */
public class SortTheArrayBySwappingElements012 {

    // C program to sort an array with 0,1 and 2
// in a single pass

    /* Function to swap *a and *b */
        // Sort the input array, the array is assumed to
// have values in {0, 1, 2}
    static void sort012(int a[], int arr_size)
    {
        int lo = 0;
        int hi = arr_size - 1;
        int mid = 0;

        while (mid <= hi)
        {
            switch (a[mid])
            {
                case 0:
                    swap(a[lo++], a[mid++]);
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(a[mid], a[hi--]);
                    break;
            }
        }
    }

    /* UTILITY FUNCTIONS */
    static void swap(int a, int b)
    {
        int temp = a;
        a = b;
        b = temp;
    }

    /* Utility function to print array arr[] */
    static void printArray(int arr[], int arr_size)
    {
        int i;
        for (i = 0; i < arr_size; i++)
            System.out.println( arr[i]);

    }

    /* driver program to test */
    public static void main(String args[])
    {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int arr_size = arr.length;
        int i;

        sort012(arr, arr_size);

        System.out.println("array after segregation ");
        printArray(arr, arr_size);


    }
    //Time Complexity: O(n)
}
