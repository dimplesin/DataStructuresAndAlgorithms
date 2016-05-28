package com.company.Microsoft;

/**
 * Created by v-dsindhi on 8/15/15.
 */
public class PrintNumberGuessed {

    static void printRepeating(int arr[], int size)
    {
        int S = 0;  /* S is for sum of elements in arr[] */
        int P = 1;  /* P is for product of elements in arr[] */
        int x,  y;   /* x and y are two repeating elements */
        int D;      /* D is for difference of x and y, i.e., x-y*/
        int n = size - 2,  i;

  /* Calculate Sum and Product of all elements in arr[] */
        for(i = 0; i < size; i++)
        {
            S = S + arr[i];
            P = P*arr[i];
        }

        S = S - n*(n+1)/2;  /* S is x + y now */
        P = P/fact(n);         /* P is x*y now */

        D = (int) Math.sqrt(S * S - 4 * P); /* D is x - y now */

        x = (D + S)/2;
        y = (S - D)/2;

        System.out.println("The two Repeating elements are" + x + "    " + y);
    }

    static int fact(int n)
    {
        return (n == 0)? 1 : n*fact(n-1);
    }

    public static void main(String args[])
    {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int arr_size = arr.length;
        printRepeating(arr, arr_size);

    }
    /*Run on IDE
    Time Complexity: O(n)
    Auxiliary Space: O(1)
*/
}
