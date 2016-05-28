package geeksforgeeks.Algorithms.Arrays;

/**
 * Created by v-dsindhi on 8/10/15.
 */
public class FindSmallestAndSecondSmallestInArray {

    /* Function to print first smallest and second smallest elements */
    static void print2Smallest(int arr[], int arr_size)
    {
        int i, first, second;

    /* There should be atleast two elements */
        if (arr_size < 2)
        {
            System.out.println(" Invalid Input ");
            return;
        }

        first = second = Integer.MAX_VALUE;
        for (i = 0; i < arr_size ; i ++)
        {
        /* If current element is smaller than first then update both
          first and second */
            if (arr[i] < first)
            {
                second = first;
                first = arr[i];
            }

        /* If arr[i] is in between first and second then update second  */
            else if (arr[i] < second && arr[i] != first)
                second = arr[i];
        }
        if (second == Integer.MAX_VALUE)
            System.out.println("There is no second smallest element\n");
        else
            System.out.println("The smallest element is "+first+"and second Smallest element is "+
                    + second);
    }


    /* Driver program to test above function */
    public static void main(String args[])
    {
        int arr[] = {12, 13, 1, 10, 34, 1};
        int n = arr.length;
        print2Smallest(arr, n);

    }
   /* Run on IDE
    Output:
    The smallest element is 1 and second Smallest element is 10
    The same approach can be used to find the largest and second largest elements in an array.
    Time Complexity: O(n)*/

}
