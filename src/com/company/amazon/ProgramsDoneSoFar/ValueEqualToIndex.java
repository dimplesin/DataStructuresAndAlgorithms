package com.company.amazon.ProgramsDoneSoFar;

import java.util.Arrays;

/**
 * Created by v-dsindhi on 6/23/15.
 */
public class ValueEqualToIndex {

    public static int valueToIndex(int n[], int k){
        Arrays.sort(n);
        int low  = 0;
        int high = n.length - 1;
        int mid;
        while(low <= high) {
            mid = (low + high) / 2;

            // change X[mid] to X[mid] - mid
            if (n[mid] - k == 0)
                return n[mid];

                // change here too
            else if (n[mid] - mid < 0)
                low = mid + 1;

            else
                high = mid - 1;
        }
        return 0; // no such index exists...return an invalid index.
    }

    public static void main(String args[]){
        int n[] = {2, 5, 1, 2, 4, 1, 6, 5, 2, 2};
        System.out.println(printPairs(n,n.length, 9));
    }


    static int printPairs(int arr[], int arr_size, int sum)
    {
        int i, temp;
        int count =0;
        boolean binMap[] = new boolean[arr_size]; /*initialize hash map as 0*/
        for(i = 0; i < arr_size; i++)
        {
            temp = sum - arr[i];
            if(temp >= 0 && binMap[temp])
            {
                count++;
            }
            binMap[arr[i]] = true;
        }
        return count;
    }
}
