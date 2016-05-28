package geeksforgeeks.Algorithms.Arrays;

/**
 * Created by v-dsindhi on 8/10/15.
 */
public class printIntersectionOfTwoArrays {
     /* Function prints Intersection of arr1[] and arr2[]
       m is the number of elements in arr1[]
       n is the number of elements in arr2[] */
     static void printIntersection(int arr1[], int arr2[], int m, int n)
    {
        int i = 0, j = 0;
        while (i < m && j < n)
        {
            if (arr1[i] < arr2[j])
                i++;
            else if (arr2[j] < arr1[i])
                j++;
            else /* if arr1[i] == arr2[j] */
            {
                System.out.println(arr2[j++]);
                i++;
            }
        }
    }

    /* Function prints union of arr1[] and arr2[]
   m is the number of elements in arr1[]
   n is the number of elements in arr2[] */
    void printUnion(int arr1[], int arr2[], int m, int n)
    {
        int i = 0, j = 0;
        while (i < m && j < n)
        {
            if (arr1[i] < arr2[j])
                System.out.println(arr1[i++]);
            else if (arr2[j] < arr1[i])
                System.out.println( arr2[j++]);
            else
            {
                System.out.println( arr2[j++]);
                i++;
            }
        }

  /* Print remaining elements of the larger array */
        while(i < m)
            System.out.println(arr1[i++]);
        while(j < n)
            System.out.println( arr2[j++]);
    }


    /* Driver program to test above function */
    public static void main(String args[])
    {
        int arr1[] = {1, 2, 4, 5, 6};
        int arr2[] = {2, 3, 5, 7};
        int m = arr1.length;
        int n = arr2.length;
        printIntersection(arr1, arr2, m, n);

    }
    /*Run on IDE
    Time Complexity: O(m+n)*/

}
