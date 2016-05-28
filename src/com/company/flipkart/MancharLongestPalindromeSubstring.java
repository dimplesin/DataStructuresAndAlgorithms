package com.company.flipkart;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by v-dsindhi on 7/12/15.
 */
//Special Note: Use Manacher's algorithm to find all the palindromic substring or the longest palindromic substring very simply in O(n) time!


public class MancharLongestPalindromeSubstring {

    public static void main(String args[]){
        String in = "abaaa";
        System.out.println(LongestPalindrome(in));
    }

    public static String preprocess(String in){
        StringBuffer sb = new StringBuffer();
        sb.append("#");
        for(int i=0; i<in.length(); i++){
            sb.append(in.charAt(i));
            sb.append("#");
        }
        return sb.toString();
    }

    public static String LongestPalindrome(String in){
		/*Preprocess the string to insert special character  ‘#’ in the spaced between characters in input and the two outside edges. This is done merely to make the computation identical for both odd and even length input string. */

        String S = preprocess(in);
        int C = 0; //contains center of current palindrome
        int R = 0; //contains the right edge of current palindrome
        int[] P = new int[S.length()];

        // P[i] contains the length of longest palindrome (in S not original in) centered at i
        for(int i=0;i<P.length; i++)
            P[i] = 0;
        // for each position find longest palindrome centered at the position, save length in P
        for(int i=0; i<S.length(); i++){
            int i_mirror = 2*C-i; // as C - i_mirror = i - C due to symmetric property

			/*When R-i > P[i_mirror] then palindrome at center i_prime contained completely within palindrome centered at C.   Else R-i <= P[i_mirror] means that the palindrome at ceter i_mirror  doesn’t fully contained in the palindrome centered at C. Then palindrome at i is extendable past R*/

            P[i] = (R>i) ? Math.min(P[i_mirror], R - i) : 0;

            // if palindrome centered at i is extendable past R then extend R to the right edge of newly extended palindrome
            while(S.charAt(i+P[i]+1) == S.charAt(i-P[i]-1))
                P[i]++;
            // If palindrome centered at i extend past R then update Center to i
            if(i+P[i] > R){
                C = i;
                R = i+P[i];
            }
        }
        return extractLongest(in, P);
    }

    public static String extractLongest(String in, int[] P){
        int longestCenter = 0;
        int longestLength = 0;
        int longestLongest = 0;
        for(int i=0; i<P.length; i++){
            if(P[i] > longestLength){
                longestLongest = P[i];
                longestCenter = i;
            }
        }

        return in.substring((longestCenter-longestLength-1)/2, longestLength);
    }

    public Set<String> allPalindromicSubstring(String in, int[] P){
        HashSet<String> all = new HashSet<String>();

        for(int i=0; i<P.length;  i++)
            if(P[i] != 0)
                all.add(in.substring((i-P[i]-1)/2, P[i]));

        return all;
    }
}
