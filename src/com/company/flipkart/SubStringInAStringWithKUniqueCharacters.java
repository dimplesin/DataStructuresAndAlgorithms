package com.company.flipkart;

import com.company.amazon.BookKarumanchi.Challenges.HashMap;

import java.util.Map;

/**
 * Created by v-dsindhi on 7/9/15.
 */
public class SubStringInAStringWithKUniqueCharacters {

    // C++ program to find the longest substring with k unique
// characters in a given string
    static int MAX_CHARS =  26;

    // This function calculates number of unique characters
// using a associative array count[]. Returns true if
// no. of characters are less than required else returns
// false.
    static boolean isValid(int count[], int k)
    {
        int val = 0;
        for (int i=0; i<MAX_CHARS; i++)
            if (count[i] > 0)
                val++;

        // Return true if k is greater than or equal to val
        return (k >= val);
    }

    //Time Complexity O(n)
    // Finds the maximum substring with exactly k unique chars
    static void kUniques(String s, int k)
    {
        int u = 0; // number of unique characters
        int n = s.length();

        // Associative array to store the count of characters
        int count[] = new int[MAX_CHARS];
        //memset(count, 0, sizeof(count));

        // Traverse the string, Fills the associative array
        // count[] and count number of unique characters
        for (int i=0; i<n; i++)
        {

            if (count[s.charAt(i)-'a']==0)
                u++;
            count[s.charAt(i)-'a']++;
        }

        // If there are not enough unique characters, show
        // an error message.
        if (u < k)
        {
            System.out.println("Not enough unique characters");
            return;
        }

        // Otherwise take a window with first element in it.
        // start and end variables.
        int curr_start = 0, curr_end = 0;

        // Also initialize values for result longest window
        int max_window_size = 1, max_window_start = 0;

        // Initialize associative array count[] with zero
        //memset(count, 0, sizeof(count));

        count[s.charAt(0)-'a']++;  // put the first character

        // Start from the second character and add
        // characters in window according to above
        // explanation
        for (int i=1; i<n; i++)
        {
            // Add the character 's[i]' to current window
            count[s.charAt(i)-'a']++;
            curr_end++;

            // If there are more than k unique characters in
            // current window, remove from left side
            while (!isValid(count, k))
            {
                count[s.charAt(curr_start)-'a']--;
                curr_start++;
            }

            // Update the max window size if required
            if (curr_end-curr_start+1 > max_window_size)
            {
                max_window_size = curr_end-curr_start+1;
                max_window_start = curr_start;
            }
        }

        System.out.println( "Max sustring is : "
                + s.substring(max_window_start, max_window_size)
                + " with length " + max_window_size);
    }

    // Driver function
    public static void main(String args[])
    {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println(maxSubStringKUniqueChars(s, k));

    }



    //Time Complexity  = O(n*k)
    public static String maxSubStringKUniqueChars(String s, int k) {
        int maxLen = 0;
        String maxSubstring = null;
        int m = 0;

        // declare a map to track the right most position of the two characters
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // if map contains 2 characters, process
            if (map.size() == k && !map.containsKey(c)) {
                if (i - m > maxLen) {
                    maxLen = i - m;
                    maxSubstring = s.substring(m, i);
                }

                int leftMost = s.length();
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (entry.getValue() < leftMost) {
                        leftMost = entry.getValue();
                    }
                }

                m = leftMost + 1;
                map.remove(s.charAt(leftMost));
            }

            map.put(c, i);
        }

        if (map.size() == k && maxLen == 0) {
            return s;
        }

        return maxSubstring;
    }



    //Time Complexity O(n)
    public static String maxSubStringKUniqueCharsArray(String s, int k) {
        //declare a counter
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int maxLen = 0;
        String maxSubstring = null;

        for (int i = 0; i < s.length(); i++) {
            //add each char to the counter
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }

            if(map.size() == k+1){
                //get maximum
                int range = i-start;
                if(range > maxLen){
                    maxLen = range;
                    maxSubstring = s.substring(start, i);
                }

                //move left cursor toward right, so that substring contains only k chars
                char first = s.charAt(start);
                while(map.size()>k){
                    int count = map.get(first);
                    if(count>1){
                        map.put(first,count-1);
                    }else{
                        map.remove(first);
                    }
                    start++;
                }
            }
        }

        if (map.size() == k && maxLen == 0) {
            return s;
        }

        return maxSubstring;
    }
}


