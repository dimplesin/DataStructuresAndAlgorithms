package com.company.Microsoft;
//Following is C implementation of recursive approach to print all possible word corresponding to a n digit input number. Note that input number is represented as an array to simplify the code.


public class FindPossibleWordsPhoneDigits{
    // hashTable[i] stores all characters that correspond to digit i in phone
    static String[] hashTable = {"", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"};

     // A recursive function to print all possible words that can be obtained
// by input number[] of size n.  The output words are one by one stored
// in output[]
     static void  printWordsUtil(int number[], int curr_digit, char output[], int n)
    {
        // Base case, if current output word is prepared
        int i;
        if (curr_digit == n)
        {
            System.out.println( output);
            return ;
        }

        // Try all 3 possible characters for current digir in number[]
        // and recur for remaining digits
        for (i=0; i<hashTable.length; i++)
        {
            try {
                output[curr_digit] = hashTable[number[curr_digit]].charAt(i);
                printWordsUtil(number, curr_digit + 1, output, n);
                if (number[curr_digit] == 0 || number[curr_digit] == 1)
                    return;
            }catch(StringIndexOutOfBoundsException se){}
        }
    }

    static // A wrapper over printWordsUtil().  It creates an output array and
// calls printWordsUtil()
    void printWords(int number[], int n)
    {
        char result[] = new char[n+1];
        result[n] ='\0';
        printWordsUtil(number, 0, result, n);
    }

    //Driver program
    public static void main(String args[])
    {
        int number[] = {2, 3, 4};
        int n = number.length;
        printWords(number, n);
    }
}