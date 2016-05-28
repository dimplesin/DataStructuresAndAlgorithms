package com.company.flipkart;

import com.company.amazon.BookKarumanchi.Challenges.HashMap;

import java.util.Map;
import java.util.Scanner;

/**
 * Created by v-dsindhi on 7/9/15.
 */
public class PrintAllPalindromeSubStrings {

    /*
    Step 1: Finding all palindromes using modified Manacher’s algorithm:
Considering each character as a pivot, expand on both sides to find the length of both even and odd length palindromes centered at the pivot character under consideration and store the length in the 2 arrays (odd & even).
Time complexity for this step is O(n^2)

Step 2: Inserting all the found palindromes in a HashMap:
Insert all the palindromes found from the previous step into a HashMap. Also insert all the individual characters from the string into the HashMap (to generate distinct single letter palindromic sub-strings).
Time complexity of this step is O(n^3) assuming that the hash insert search takes O(1) time. Note that there can be at most O(n^2) palindrome sub-strings of a string. In below C++ code ordered hashmap is used where the time complexity of insert and search is O(Logn). In C++, ordered hashmap is implemented using Red Black Tree.

Step 3: Printing the distinct palindromes and number of such distinct palindromes:
The last step is to print all values stored in the HashMap (only distinct elements will be hashed due to the property of HashMap). The size of the map gives the number of distinct palindromic continuous sub-strings.
     */


    // C++ program to find all distinct palindrome sub-strings
// of a given string

    // Function to print all distinct palindrome sub-strings of s
    static void palindromeSubStrs(String s)
    {
        Map<String, Integer> m = new HashMap<>();
        int n = s.length();

        // table for storing results (2 rows for odd-
        // and even-length palindromes
        int R[][] = new int[2][n+1];

        // Find all sub-string palindromes from the given input
        // string insert 'guards' to iterate easily over s
        s = "@" + s + "#";

        for (int j = 0; j <= 1; j++)
        {
            int rp = 0;   // length of 'palindrome radius'
            R[j][0] = 0;

            int i = 1;
            while (i <= n)
            {
                //  Attempt to expand palindrome centered at i
                while (s.charAt(i - rp - 1) == s.charAt(i + j + rp))
                    rp++;  // Incrementing the length of palindromic
                // radius as and when we find vaid palindrome

                // Assigning the found palindromic length to odd/even
                // length array
                R[j][i] = rp;
                int k = 1;
                while ((R[j][i - k] != rp - k) && (k < rp))
                {
                    R[j][i + k] = Math.min(R[j][i - k], rp - k);
                    k++;
                }
                rp = Math.max(rp - k, 0);
                i += k;
            }
        }

        // remove 'guards'
        s = s.substring(1, n);

        // Put all obtained palindromes in a hash map to
        // find only distinct palindromess
        m.put(s.substring(0), 1);
        //m[string(1, s.charAt(0))]=1;
        for (int i = 1; i <= n; i++)
        {
            for (int j = 0; j <= 1; j++)
                for (int rp = R[j][i]; rp > 0; rp--)
                    m.put(s.substring(i - rp - 1, 2 * rp + j), 1);
            m.put(s.substring(0, s.indexOf(i)), 1);
           // m[string(1, s.charAt(i))]=1;
        }

        //printing all distinct palindromes from hash map
        System.out.println("Below are " + (m.size()-1)
                + " palindrome sub-strings");

        for(Map.Entry<String, Integer> entry : m.entrySet()){
            System.out.print(entry.getKey() + " "+ entry.getValue());
        }
        /*map<string, int>::iterator ii;
        for (ii = m.begin(); ii!=m.end(); ++ii)
            cout << (*ii).first << endl;*/
    }

    // Driver program
    public static void main(String args[])
    {
        String string, sub;
        int i, c, length;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string to print it's all substrings");
        string  = in.nextLine();

        length = string.length();

        System.out.println("Substrings of \"" + string + "\" are :-");

        for( c = 0 ; c < length ; c++ )
        {
            for( i = 1 ; i <= length - c ; i++ )
            {
                sub = string.substring(c, c+i);
                System.out.println(sub);
            }
        }
    }
}
