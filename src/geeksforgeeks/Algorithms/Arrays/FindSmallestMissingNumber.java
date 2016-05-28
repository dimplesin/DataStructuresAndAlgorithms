package geeksforgeeks.Algorithms.Arrays;

/**
 * Created by v-dsindhi on 8/10/15.
 */
public class FindSmallestMissingNumber {

    static int findFirstMissing(int array[], int start, int end) {
        if(start  > end)
            return end + 1;
        if (start != array[start])
            return start;
        int mid = (start + end) / 2;
        if (array[mid] > mid)
            return findFirstMissing(array, start, mid);
        else
            return findFirstMissing(array, mid + 1, end);
    }

    // driver program to test above function
    public static void main(String args[])
    {
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 10};
        int n = arr.length;
        System.out.println(" First missing element is %d" +
                findFirstMissing(arr, 0, n - 1));

    }
   /* Run on IDE
    Note: This method doesn’t work if there are duplicate elements in the array.
    Time Complexity: O(Logn)*/

}
