package com.company.Microsoft;

/**
 * Created by v-dsindhi on 8/1/15.
 */
public class FindRepeatingAndMissingInArray {

    /*
    Find the repeating and the missing | Added 3 new methods
Given an unsorted array of size n. Array elements are in range from 1 to n. One number from set {1, 2, …n} is missing and one number occurs twice in array. Find these two numbers.

Examples:

  arr[] = {3, 1, 3}
  Output: 2, 3   // 2 is missing and 3 occurs twice

  arr[] = {4, 3, 6, 2, 1, 1}
  Output: 1, 5  // 5 is missing and 1 occurs twice
Method 1 (Use Sorting)
1) Sort the input array.
2) Traverse the array and check for missing and repeating.

Time Complexity: O(nLogn)

Thanks to LoneShadow for suggesting this method.

Method 2 (Use count array)
1) Create a temp array temp[] of size n with all initial values as 0.
2) Traverse the input array arr[], and do following for each arr[i]
……a) if(temp[arr[i]] == 0) temp[arr[i]] = 1;
……b) if(temp[arr[i]] == 1) output “arr[i]” //repeating
3) Traverse temp[] and output the array element having value as 0 (This is the missing element)

Time Complexity: O(n)
Auxiliary Space: O(n)

Method 3 (Use elements as Index and mark the visited places)
Traverse the array. While traversing, use absolute value of every element as index and make the value at this index as negative to mark it visited. If something is already marked negative then this is the repeating element. To find missing, traverse the array again and look for a positive value.

#include<stdio.h>
#include<stdlib.h>

void printTwoElements(int arr[], int size)
{
    int i;
    printf("\n The repeating element is");

    for(i = 0; i < size; i++)
    {
        if(arr[abs(arr[i])-1] > 0)
            arr[abs(arr[i])-1] = -arr[abs(arr[i])-1];
        else
            printf(" %d ", abs(arr[i]));
    }

    printf("\nand the missing element is ");
    for(i=0; i<size; i++)
    {
        if(arr[i]>0)
            printf("%d",i+1);
    }
}

/* Driver program to test above function
    int main()
    {
        int arr[] = {7, 3, 4, 5, 5, 6, 2};
        int  n = sizeof(arr)/sizeof(arr[0]);
        printTwoElements(arr, n);
        return 0;
    }
    Run on IDE
    Time Complexity: O(n)

    Thanks to Manish Mishra for suggesting this method.

            Method 4 (Make two equations)
    Let x be the missing and y be the repeating element.

    1) Get sum of all numbers.
    Sum of array computed S = n(n+1)/2 – x + y
    2) Get product of all numbers.
    Product of array computed P = 1*2*3*…*n * y / x
    3) The above two steps give us two equations, we can solve the equations and get the values of x and y.

    Time Complexity: O(n)

    Thanks to disappearedng for suggesting this solution.

    This method can cause arithmetic overflow as we calculate product and sum of all array elements. See this for changes suggested by john to reduce the chances of overflow.

    Method 5 (Use XOR)
    Let x and y be the desired output elements.
    Calculate XOR of all the array elements.

            xor1 = arr[0]^arr[1]^arr[2].....arr[n-1]
    XOR the result with all numbers from 1 to n

    xor1 = xor1^1^2^.....^n
    In the result xor1, all elements would nullify each other except x and y. All the bits that are set in xor1 will be set in either x or y. So if we take any set bit (We have chosen the rightmost set bit in code) of xor1 and divide the elements of the array in two sets – one set of elements with same bit set and other set with same bit not set. By doing so, we will get x in one set and y in another set. Now if we do XOR of all the elements in first set, we will get x, and by doing same in other set we will get y.

    #include <stdio.h>
    #include <stdlib.h>

    /* The output of this function is stored at *x and *y
    void getTwoElements(int arr[], int n, int *x, int *y)
    {
        int xor1;   /* Will hold xor of all elements and numbers from 1 to n */
        int set_bit_no;  /* Will have only single set bit of xor1
        int i;
        *x = 0;
        *y = 0;

        xor1 = arr[0];

  /* Get the xor of all array elements elements
        for(i = 1; i < n; i++)
            xor1 = xor1^arr[i];

  /* XOR the previous result with numbers from 1 to n
        for(i = 1; i <= n; i++)
            xor1 = xor1^i;

  /* Get the rightmost set bit in set_bit_no
        set_bit_no = xor1 & ~(xor1-1);

  /* Now divide elements in two sets by comparing rightmost set
   bit of xor1 with bit at same position in each element. Also, get XORs
   of two sets. The two XORs are the output elements.
   The following two for loops serve the purpose
        for(i = 0; i < n; i++)
        {
            if(arr[i] & set_bit_no)
            *x = *x ^ arr[i]; /* arr[i] belongs to first set
            else
            *y = *y ^ arr[i]; /* arr[i] belongs to second set
        }
        for(i = 1; i <= n; i++)
        {
            if(i & set_bit_no)
            *x = *x ^ i; /* i belongs to first set
            else
            *y = *y ^ i; /* i belongs to second set
        }

  /* Now *x and *y hold the desired output elements
    }

    /* Driver program to test above function
    int main()
    {
        int arr[] = {1, 3, 4, 5, 5, 6, 2};
        int *x = (int *)malloc(sizeof(int));
        int *y = (int *)malloc(sizeof(int));
        int  n = sizeof(arr)/sizeof(arr[0]);
        getTwoElements(arr, n, x, y);
        printf(" The two elements are %d and %d", *x, *y);
        getchar();
    }
    Run on IDE
    Time Complexity: O(n)
     */
}
