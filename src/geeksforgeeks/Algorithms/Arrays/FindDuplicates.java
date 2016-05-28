package geeksforgeeks.Algorithms.Arrays;

/**
 * Created by v-dsindhi on 8/10/15.
 */
public class FindDuplicates {
    static void printRepeating(int arr[], int size)
    {
        int i;
        System.out.println("The repeating elements are: \n");
        for (i = 0; i < size; i++)
        {
            if (arr[Math.abs(arr[i])] >= 0)
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            else
                System.out.println(Math.abs(arr[i]));
        }
    }

    public static void main(String args[])
    {
        int arr[] = {1, 2, 3, 1, 3, 6, 6};
        int arr_size = arr.length;
        printRepeating(arr, arr_size);

    }
    /*Run on IDE
    Note: The above program doesn’t handle 0 case (If 0 is present in array). The program can be easily modified to handle that also. It is not handled to keep the code simple.
            Output:
    The repeating elements are:
            1 3 6
    Time Complexity: O(n)
    Auxiliary Space: O(1)*/

}
