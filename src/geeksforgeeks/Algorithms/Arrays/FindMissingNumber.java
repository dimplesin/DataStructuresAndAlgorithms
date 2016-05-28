package geeksforgeeks.Algorithms.Arrays;

/**
 * Created by v-dsindhi on 8/10/15.
 */
public class FindMissingNumber {
    /* getMissingNo takes array and size of array as arguments*/
    static int getMissingNo(int a[], int n)
    {
        int i, total;
        total  = (n+1)*(n+2)/2;
        for ( i = 0; i< n; i++)
            total -= a[i];
        return total;
    }

    /*program to test above function */
    public static void main(String args[])
    {
        int a[] = {1,2,4,5,6};
        int miss = getMissingNo(a,5);
        System.out.println(miss);

    }
   /* Run on IDE
    Time Complexity: O(n)*/

}
