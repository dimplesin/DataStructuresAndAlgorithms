package geeksforgeeks.Algorithms.Arrays;

/**
 * Created by v-dsindhi on 8/10/15.
 */
public class SumClosetToZero {
    /* Function to print pair of elements having minimum sum */
    static void minAbsSumPair(int arr[], int n)
    {
        // Variables to keep track of current sum and minimum sum
        int sum, min_sum = Integer.MAX_VALUE;

        // left and right index variables
        int l = 0, r = n-1;

        // variable to keep track of the left and right pair for min_sum
        int min_l = l, min_r = n-1;

  /* Array should have at least two elements*/
        if(n < 2)
        {
            System.out.println("Invalid Input");
            return;
        }

  /* Sort the elements */
        quickSort(arr, l, r);

        while(l < r)
        {
            sum = arr[l] + arr[r];

    /*If abs(sum) is less then update the result items*/
            if(Math.abs(sum) < Math.abs(min_sum))
            {
                min_sum = sum;
                min_l = l;
                min_r = r;
            }
            if(sum < 0)
                l++;
            else
                r--;
        }

        System.out.println(" The two elements whose sum is minimum are"
                + arr[min_l] + " " + arr[min_r]);
    }

    /* Driver program to test above function */
    public static void main(String args[])
    {
        int arr[] = {1, 60, -10, 70, -80, 85};
        int n = arr.length;
        minAbsSumPair(arr, n);

    }

    /* FOLLOWING FUNCTIONS ARE ONLY FOR SORTING
        PURPOSE */
    static void exchange(int a, int b)
    {
        int temp;
        temp = a;
        a   = b;
        b   = temp;
    }

    static int partition(int arr[], int si, int ei)
    {
        int x = arr[ei];
        int i = (si - 1);
        int j;

        for (j = si; j <= ei - 1; j++)
        {
            if(arr[j] <= x)
            {
                i++;
                exchange(arr[i], arr[j]);
            }
        }

        exchange (arr[i + 1], arr[ei]);
        return (i + 1);
    }

    /* Implementation of Quick Sort
    arr[] --> Array to be sorted
    si  --> Starting index
    ei  --> Ending index
    */
    static void quickSort(int arr[], int si, int ei)
    {
        int pi;    /* Partitioning index */
        if(si < ei)
        {
            pi = partition(arr, si, ei);
            quickSort(arr, si, pi - 1);
            quickSort(arr, pi + 1, ei);
        }
    }
    /*Run on IDE

    Time Complexity: complexity to sort + complexity of finding the optimum pair = O(nlogn) + O(n) = O(nlogn)*/

}
