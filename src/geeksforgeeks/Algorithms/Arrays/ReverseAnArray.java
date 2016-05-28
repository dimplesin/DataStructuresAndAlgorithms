package geeksforgeeks.Algorithms.Arrays;

/**
 * Created by v-dsindhi on 8/10/15.
 */
public class ReverseAnArray {

    /* Function to reverse arr[] from start to end*/
    static void rvereseArray(int arr[], int start, int end)
    {
        int temp;
        while(start < end)
        {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    /* Utility that prints out an array on a line */
    static void printArray(int arr[], int size)
    {
        int i;
        for (i=0; i < size; i++)
            System.out.println(arr[i]);

        System.out.println("\n");
    }

    /* Driver function to test above functions */
    public static void main(String args[])
    {
        int arr[] = {1, 2, 3, 4, 5, 6};
        printArray(arr, 6);
        rvereseArray(arr, 0, 5);
        System.out.println("Reversed array is \n");
        printArray(arr, 6);

    }
   /* Run on IDE
    Time Complexity: O(n)*/

}
