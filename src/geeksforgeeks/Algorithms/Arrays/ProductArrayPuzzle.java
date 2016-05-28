package geeksforgeeks.Algorithms.Arrays;

/**
 * Created by v-dsindhi on 8/10/15.
 */
public class ProductArrayPuzzle {
    /* Function to print product array for a given array
     arr[] of size n */
    static void productArray(int arr[], int n)
    {
  /* Allocate memory for temporary arrays left[] and right[] */
        int left[] = new int[n];
        int right[] = new int[n];

  /* Allocate memory for the product array */
        int prod[] = new int[n];

        int i, j;

  /* Left most element of left array is always 1 */
        left[0] = 1;

  /* Rightmost most element of right array is always 1 */
        right[n-1] = 1;

  /* Construct the left array */
        for(i = 1; i < n; i++)
            left[i] = arr[i-1]*left[i-1];

  /* Construct the right array */
        for(j = n-2; j >=0; j--)
            right[j] = arr[j+1]*right[j+1];

  /* Construct the product array using
    left[] and right[] */
        for (i=0; i<n; i++)
            prod[i] = left[i] * right[i];

  /* print the constructed prod array */
        for (i=0; i<n; i++)
            System.out.println("%d " + prod[i]);

        return;
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        int arr[] = {10, 3, 5, 6, 2};
        int n = arr.length;
        System.out.println("The product array is: ");
        productArray(arr, n);

    }
    /*Run on IDE
    Time Complexity: O(n)
    Space Complexity: O(n)
    Auxiliary Space: O(n)*/

}
