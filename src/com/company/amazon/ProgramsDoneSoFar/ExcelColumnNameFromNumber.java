package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/22/15.
 */
public class ExcelColumnNameFromNumber{

        static void printString(int n)
        {
            char str[] = new char[n];  // To store result (Excel column name)
            int i = 0;  // To store current index in str which is result
            //String str = "";
            while (n>0)
            {
                // Find remainder
                int rem = n%26;

                // If remainder is 0, then a 'Z' must be there in output
                if (rem==0)
                {
                    str[i++] = 'Z';
                    n = (n/26)-1;
                }
                else // If remainder is non-zero
                {
                    str[i++] = (char) ((rem-1) + 'A');
                    n = n/26;
                }
            }
            str[i] = '\0';

            // Reverse the string and print result
            String reverse = new StringBuilder(new String(str)).reverse().toString();
            System.out.println(reverse.toString());

        }

    public static void main(String args[]){
        printString(26);
        printString(51);
        printString(52);
        printString(80);
        printString(676);
        printString(702);
        printString(705);
    }
}
