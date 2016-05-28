package com.company.Microsoft;

import java.math.BigInteger;

/**
 * Created by v-dsindhi on 8/8/15.
 */
public class ASCIIProgram {

    private static String toASCII(int value) {
        int length = 4;
        String str="abc";
        /*StringBuilder builder = new StringBuilder(length);
        for (int i = length - 1; i >= 0; i--) {
            builder.append((char) ((value >> (8 * i)) & 0xFF));
        }
        return builder.toString();
*/
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray())
            sb.append((int)c);

        BigInteger mInt = new BigInteger(sb.toString());
        System.out.println(mInt);
        int i = 64;
        String aChar = new Character((char) i).toString();
        return aChar;
    }

    int findMin(int arr[], int low, int high)
    {
        // This condition is needed to handle the case when array is not
        // rotated at all
        if (high < low)  return arr[0];

        // If there is only one element left
        if (high == low) return arr[low];

        // Find mid
        int mid = low + (high - low)/2; /*(low + high)/2;*/

        // Check if element (mid+1) is minimum element. Consider
        // the cases like {3, 4, 5, 1, 2}
        if (mid < high && arr[mid+1] < arr[mid])
            return arr[mid+1];

        // Check if mid itself is minimum element
        if (mid > low && arr[mid] < arr[mid - 1])
            return arr[mid];

        // Decide whether we need to go to left half or right half
        if (arr[high] > arr[mid])
            return findMin(arr, low, mid-1);
        return findMin(arr, mid+1, high);
    }
}
