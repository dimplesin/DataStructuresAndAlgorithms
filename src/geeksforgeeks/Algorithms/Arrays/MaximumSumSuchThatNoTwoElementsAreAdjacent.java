package geeksforgeeks.Algorithms.Arrays;

/**
 * Created by v-dsindhi on 8/10/15.
 */
public class MaximumSumSuchThatNoTwoElementsAreAdjacent {

    /*Function to return max sum such that no two elements
     are adjacent */
    static int FindMaxSum(int arr[], int n)
    {
        int incl = arr[0];
        int excl = 0;
        int excl_new;
        int i;

        for (i = 1; i < n; i++)
        {
     /* current max excluding i */
            excl_new = (incl > excl)? incl: excl;

     /* current max including i */
            incl = excl + arr[i];
            excl = excl_new;
        }

   /* return max of incl and excl */
        return ((incl > excl)? incl : excl);
    }

    /* Driver program to test above function */
    public static void main(String[] args)
    {
        int arr[] = {5, 5, 10, 100, 10, 5};
        System.out.println(FindMaxSum(arr, 6));

    }
   /* Run on IDE
    Time Complexity: O(n)*/

}
