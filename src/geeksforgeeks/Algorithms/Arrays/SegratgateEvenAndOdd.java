package geeksforgeeks.Algorithms.Arrays;

/**
 * Created by v-dsindhi on 8/10/15.
 */
public class SegratgateEvenAndOdd {

    static void segregateEvenOdd(int arr[], int size)
    {
  /* Initialize left and right indexes */
        int left = 0, right = size-1;
        while(left < right)
        {
     /* Increment left index while we see 0 at left */
            while(arr[left]%2 == 0 && left < right)
                left++;

     /* Decrement right index while we see 1 at right */
            while(arr[right]%2 == 1 && left < right)
                right--;

            if(left < right)
            {
       /* Swap arr[left] and arr[right]*/
                swap(arr[left], arr[right]);
                left++;
                right--;
            }
        }
    }

    /* UTILITY FUNCTIONS */
    static void swap(int a, int b)
    {
        int temp = a;
        a = b;
        b = temp;
    }

    /* driver program to test */
    public static void main(String args[])
    {
        int arr[] = {12, 34, 45, 9, 8, 90, 3};
        int arr_size = 7, i = 0;

        segregateEvenOdd(arr, arr_size);

        System.out.println("array after segregation ");
        for(i = 0; i < arr_size; i++)
            System.out.println("%d "+arr[i]);


    }
    /*Run on IDE
    Time Complexity: O(n)*/

}
