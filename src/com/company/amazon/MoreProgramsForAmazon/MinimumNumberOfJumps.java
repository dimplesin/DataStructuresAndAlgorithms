package com.company.amazon.MoreProgramsForAmazon;

public class MinimumNumberOfJumps {

	// Returns minimum number of jumps to reach arr[h] from arr[l]
	static int minJumps(int arr[], int l, int h)
	{
	   // Base case: when source and destination are same
	   if (h == l)
	     return 0;
	 
	   // When nothing is reachable from the given source
	   if (arr[l] == 0)
	     return Integer.MAX_VALUE;
	 
	   // Traverse through all the points reachable from arr[l]. Recursively
	   // get the minimum number of jumps needed to reach arr[h] from these
	   // reachable points.
	   int min = Integer.MAX_VALUE;
	   for (int i = l+1; i <= h && i <= l + arr[l]; i++)
	   {
	       int jumps = minJumps(arr, i, h);
	       if(jumps != Integer.MAX_VALUE && jumps + 1 < min)
	           min = jumps + 1;
	   }
	 
	   return min;
	}
	 
	// Returns minimum number of jumps to reach arr[n-1] from arr[0]
	int minJumps(int arr[], int n)
	{
	    int jumps[] = new int[n];  // jumps[n-1] will hold the result
	    int i, j;
	 
	    if (n == 0 || arr[0] == 0)
	        return Integer.MAX_VALUE;
	 
	    jumps[0] = 0;
	 
	    // Find the minimum number of jumps to reach arr[i]
	    // from arr[0], and assign this value to jumps[i]
	    for (i = 1; i < n; i++)
	    {
	        jumps[i] = Integer.MAX_VALUE;
	        for (j = 0; j < i; j++)
	        {
	            if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE)
	            {
	                 jumps[i] = Math.min(jumps[i], jumps[j] + 1);
	                 break;
	            }
	        }
	    }
	    return jumps[n-1];
	}
	
	// Driver program to test above function
	public static void main(String args[])
	{
	  int arr[] = {1, 3, 6, 1, 0, 9};
	  int n = arr.length;
	  System.out.println("Minimum number of jumps to reach end is : "+minJumps(arr, 0, n-1));
	}

}

/*
 * There is a given set of colours , say [1-N]. Now , people are coming into a stadium wearing t-shirts of any of these colors. Write an algorithm to find the first person to come in, to have worn an unique color.
The question wasn�t clear to me at first, so after a few examples , got what he was trying to ask.
For eg. Suppose we have colors R G B
and the stream of people are as,
G R B G G G G
the output should be R.
 * */
