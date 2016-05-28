package com.company.amazon.MoreProgramsForAmazon;

public class LargestSubArrayWithEqualNumberOf0and1 {
	 // A simple program to find the largest subarray with equal number of 0s and 1s
	 
	// This function Prints the starting and ending indexes of the largest subarray 
	// with equal number of 0s and 1s. Also returns the size of such subarray.
	static int findSubArray(int arr[], int n)
	{
	    int sum = 0;
	    int maxsize = -1, startindex = 0;
	 
	    // Pick a starting point as i
	    for (int i = 0; i < n-1; i++)
	    {
	        sum = (arr[i] == 0)? -1 : 1;
	 
	        // Consider all subarrays starting from i
	        for (int j = i+1; j < n; j++)
	        {
	            if(arr[j] == 0){
	            	sum += -1;
	            }else{ sum += 1;}
	 
	            // If this is a 0 sum subarray, then compare it with
	            // maximum size subarray calculated so far
	            if(sum == 0 && maxsize < j-i+1)
	            {
	                maxsize = j - i + 1;
	                startindex = i;
	            }
	        }
	    }
	    if ( maxsize == -1 )
	        System.out.println("No such subarray");
	    else
	        System.out.println( startindex+" "+ (startindex+maxsize-1));
	 
	    return maxsize;
	}
	 
	/* Driver program to test above functions*/
	public static void main(String args[])
	{
	    int arr[] =  {1, 0, 0, 1, 0, 1, 1};
	    int size = arr.length;
	 
	    findSubArray(arr, size);
	   // return 0;
	}
}
