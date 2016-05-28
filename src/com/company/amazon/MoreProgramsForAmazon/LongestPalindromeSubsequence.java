package com.company.amazon.MoreProgramsForAmazon;//Following is simple recursive implementation of the LPS problem. The implementation simply follows the recursive structure mentioned above.
 
public class LongestPalindromeSubsequence{ 
static // Returns the length of the longest palindromic subsequence in seq
int lps(char[] seq, int i, int j)
{
   // Base Case 1: If there is only 1 character
   if (i == j)
     return 1;
 
   // Base Case 2: If there are only 2 characters and both are same
   if (seq[i] == seq[j] && i + 1 == j)
     return 2;
 
   // If the first and last characters match
   if (seq[i] == seq[j])
      return lps (seq, i+1, j-1) + 2;
 
   // If the first and last characters do not match
   return Math.max( lps(seq, i, j-1), lps(seq, i+1, j) );
}
 
/* Driver program to test above functions */
public static void main(String args[])
{
    char seq[] = "GEEKSFORGEEKS".toCharArray();
    int n = seq.length;
    System.out.println("The lnegth of the LPS is "+lps(seq, 0, n-1));
}
}