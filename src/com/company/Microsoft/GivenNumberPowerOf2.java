package com.company.Microsoft;

/**
 * Created by v-dsindhi on 8/15/15.
 */
public class GivenNumberPowerOf2 {

    /* Function to check if x is power of 4*/
    static boolean isPowerOfFour(int n, int power)
    {
        if(n == 0)
            return false;
        while(n != 1)
        {
            if(n%power != 0)
                return false;
            n = n/power;
        }
        return true;
    }

    /*Driver program to test above function*/
    public static void main(String args[])
    {
        int test_no = 63;
        int power = 4;
        if(isPowerOfFour(test_no, power))
            System.out.println( test_no+ " is a power of "+power );
        else
            System.out.println( test_no+ " is not a power of "+power);
    }
}
