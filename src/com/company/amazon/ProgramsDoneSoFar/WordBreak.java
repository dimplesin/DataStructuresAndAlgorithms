package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/22/15.
 */
public class WordBreak {

    /* A utility function to check whether a word is present in dictionary or not.
  An array of strings is used for dictionary.  Using array of strings for
  dictionary is definitely not a good idea. We have used for simplicity of
  the program*/
    static boolean dictionaryContains(String word)
    {
        String dictionary[] = {"mobile","samsung","sam","sung","man","mango",
                "icecream","and","go","i","like","ice","cream"};
        int size = dictionary.length;
        for (int i = 0; i < size; i++)
            if (dictionary[i].compareTo(word) == 0)
                return true;
        return false;
    }

    // returns true if string can be segmented into space separated
// words, otherwise returns false
   static boolean wordBreak(String str)
    {
        int size = str.length();

        // Base case
        if (size == 0)  return true;

        // Try all prefixes of lengths from 1 to size
        for (int i=1; i<=size; i++)
        {
            // The parameter for dictionaryContains is str.substr(0, i)
            // str.substr(0, i) which is prefix (of input string) of
            // length 'i'. We first check whether current prefix is in
            // dictionary. Then we recursively check for remaining string
            // str.substr(i, size-i) which is suffix of length size-i
            if (dictionaryContains( str.substring(0, i) ) &&
                    wordBreak( str.substring(i, size - i) ))
                return true;
        }

        // If we have tried all prefixes and none of them worked
        return false;
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
        System.out.println(wordBreak("ilikesamsung"));
        System.out.println(wordBreak("iiiiiiii"));
        System.out.println(wordBreak(""));
        System.out.println(wordBreak("ilikelikeimangoiii"));
        System.out.println(wordBreak("samsungandmango"));
        System.out.println(wordBreak("samsungandmangok"));
    }
}
