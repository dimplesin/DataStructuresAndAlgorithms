package geeksforgeeks.Algorithms.Arrays;

/**
 * Created by v-dsindhi on 8/10/15.
 */
public class MaximumAndMinimum {
    /* structure is used to return two values from minMax() */
    class pair
    {
        int min;
        int max;
    };

    static pair getMinMax(int arr[], int low, int high)
    {
        pair minmax = null, mml, mmr;
        int mid;

  /* If there is only on element */
        if (low == high)
        {
            minmax.max = arr[low];
            minmax.min = arr[low];
            return minmax;
        }

  /* If there are two elements */
        if (high == low + 1)
        {
            if (arr[low] > arr[high])
            {
                minmax.max = arr[low];
                minmax.min = arr[high];
            }
            else
            {
                minmax.max = arr[high];
                minmax.min = arr[low];
            }
            return minmax;
        }

  /* If there are more than 2 elements */
        mid = (low + high)/2;
        mml = getMinMax(arr, low, mid);
        mmr = getMinMax(arr, mid+1, high);

  /* compare minimums of two parts*/
        if (mml.min < mmr.min)
            minmax.min = mml.min;
        else
            minmax.min = mmr.min;

  /* compare maximums of two parts*/
        if (mml.max > mmr.max)
            minmax.max = mml.max;
        else
            minmax.max = mmr.max;

        return minmax;
    }

    /* Driver program to test above function */
    public static void main(String args[])
    {
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        int arr_size = 6;
        pair minmax = getMinMax(arr, 0, arr_size-1);
        System.out.println("\nMinimum element is "+ minmax.min);
        System.out.println("\nMaximum element is "+ minmax.max);
    }
    /*Run on IDE
    Time Complexity: O(n)
*/
}
