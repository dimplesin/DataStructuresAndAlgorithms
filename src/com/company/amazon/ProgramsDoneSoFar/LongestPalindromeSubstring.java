package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/22/15.
 */
public class LongestPalindromeSubstring {


    //Longest Palindrome substring
    static int LongestPalindromeSubstring(char A[], int n){
        int max = 1;
        int i,j,k,L[][] = new int[n][n];
        for( i =1; i<= n-1;i++){
            L[i][i] = 1;
            if(A[i] == A[i+1]){
                L[i][i+1] =1;
                max = 2;
            }else{
                L[i][i+1] = 0;
            }
        }
        for(k=3;k<=n;k++){
            for(i=1;i<=n-k+1;i++){
                j=i+k-1;
                if(A[i] == A[j] && L[i+1][j-1] != 0){
                    L[i][j] = 1;
                    max = k;
                }else{
                    L[i][j] = 0;
                }
            }
        }
        return max;
    }


    public static int PalindromeLengthPuzzle(String[] input1)
    {
        StringBuilder string = new StringBuilder();
        for(int i=0;i<input1.length;i++){
            string.append(input1[i].substring(0,1));
        }
        String inputStr = string.toString(), reverse = "";

        int[][] arr = new int[inputStr.length() + 1][inputStr.length() + 1];
        // reverse string a
        String b = new StringBuffer(inputStr).reverse().toString();

        // complete the Longest common subsequence array
        for (int i = 0; i < inputStr.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (inputStr.charAt(i) == b.charAt(j)) {
                    arr[i + 1][j + 1] = arr[i][j] + 1;
                } else {
                    arr[i + 1][j + 1] = Math.max(arr[i + 1][j], arr[i][j + 1]);
                }
            }
        }
        String str = "";
        int x = inputStr.length();
        int y = b.length();
        //trace back form bottom of LCS array
        while (x > 0 && y > 0) {
            if (arr[x][y] == arr[x - 1][y]) {
                x--;
            } else if (arr[x][y] == arr[x][y - 1]) {
                y--;
            } else {
                if (inputStr.charAt(x - 1) == b.charAt(y - 1)) {
                    str += inputStr.charAt(x - 1);
                    x--;
                    y--;
                }
            }
        }
        // return the largest palindrome
        return str.length();
    }

    public static void main(String args[]){
        char[] str = "forgeeksskeegfor".toCharArray();
        System.out.println(PalindromeExampleForAmazon(str, str.length));
        System.out.println("    Without DP:    " +longestPalSubstr(str));
    }


    public static int PalindromeExampleForAmazon(char[] str,int n){
        boolean table[][] = new boolean[n][n];
        // All substrings of length 1 are palindromes
        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;

        // check for sub-string of length 2.
        int start = 0;
        for (int i = 0; i < n-1; ++i)
        {
            if (str[i] == str[i+1])
            {
                table[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for lengths greater than 2. k is length
        // of substring
        for (int k = 3; k <= n; ++k)
        {
            // Fix the starting index
            for (int i = 0; i < n-k+1 ; ++i)
            {
                // Get the ending index of substring from
                // starting index i and length k
                int j = i + k - 1;

                // checking for sub-string from ith index to
                // jth index iff str[i+1] to str[j-1] is a
                // palindrome
                if (table[i+1][j-1] && str[i] == str[j])
                {
                    table[i][j] = true;

                    if (k > maxLength)
                    {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }

        System.out.println("Longest palindrome substring is: ");
        printSubStr( str, start, start + maxLength - 1 );

        return maxLength; // return length of LPS
    }


    // A utility function to print a substring str[low..high]
    static void printSubStr( char[] str, int low, int high )
    {
        for( int i = low; i <= high; ++i )
            System.out.print(str[i]);
    }

    //Without DP
    static int longestPalSubstr(char str[])
    {
        int maxLength = 1;  // The result (length of LPS)

        int start = 0;
        int len = str.length;

        int low, high;

        // One by one consider every character as center point of
        // even and length palindromes
        for (int i = 1; i < len; ++i)
        {
            // Find the longest even length palindrome with center points
            // as i-1 and i.
            low = i - 1;
            high = i;
            while (low >= 0 && high < len && str[low] == str[high])
            {
                if (high - low + 1 > maxLength)
                {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }

            // Find the longest odd length palindrome with center
            // point as i
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len && str[low] == str[high])
            {
                if (high - low + 1 > maxLength)
                {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
        }

        System.out.println("Longest palindrome substring is: ");
        printSubStr(str, start, start + maxLength - 1);

        return maxLength;
    }
}
