package com.company.amazon.BookKarumanchi.Algorithms.StringAlgorithms;

/**
 * Created by v-dsindhi on 11/25/15.
 */
public class KMPSearch {

    static void KMPSearch(char pat[], char txt[])
    {
        int[] M = new int[pat.length];
        int[] N = new int[txt.length];

        // create lps[] that will hold the longest prefix suffix
        // values for pattern
        int[] lps = new int[M.length];
        int j  = 0;  // index for pat[]

        // Preprocess the pattern (calculate lps[] array)
        computeLPSArray(pat, M, lps);

        int i = 0;  // index for txt[]
        while (i < N.length)
        {
            if (pat[j] == txt[i])
            {
                j++;
                i++;
            }

            if (j == M.length)
            {
                System.out.println("Found pattern at index " +  (i-j));
                j = lps[j-1];
            }

            // mismatch after j matches
            else if (i < N.length && pat[j] != txt[i])
            {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j-1];
                else
                    i = i+1;
            }
        }
        lps=null; // to avoid memory leak
    }

    static void computeLPSArray(char pat[], int M[], int lps[])
    {
        int len = 0;  // length of the previous longest prefix suffix
        int i;

        lps[0] = 0; // lps[0] is always 0
        i = 1;

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M.length)
        {
            if (pat[i] == pat[len])
            {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                if (len != 0)
                {
                    // This is tricky. Consider the example
                    // AAACAAAA and i = 7.
                    len = lps[len-1];

                    // Also, note that we do not increment i here
                }
                else // if (len == 0)
                {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    // Driver program to test above function
    public static void main(String args[])
    {
        char txt[] = "ABABDABACDABABCABAB".toCharArray();
        char pat[] = "ABABCABAB".toCharArray();
        KMPSearch(pat, txt);
    }
}
