package geeksforgeeks.Algorithms.Arrays;

/**
 * Created by v-dsindhi on 8/3/15.
 */
public class NumberOccurringOddNumberOfTimes {

    static int getOddOccurrence(int ar[], int ar_size)
    {
        int i;
        int res = 0;
        for (i=0; i < ar_size; i++)
            res = res ^ ar[i];

        return res;
    }

    /* Diver function to test above function */
    public static void main(String args[])
    {
        int ar[] = {2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
        int n = ar.length;
        System.out.println(getOddOccurrence(ar, n));

    }
   /* Run on IDE

    Time Complexity: O(n)*/

}
