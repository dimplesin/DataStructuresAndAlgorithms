package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/22/15.
 */
public class LadderSteps {

   // Ladder of n steps is given.Find the number number of ways to reach the end point.I can take either 1 step or two steps at a time.

    // A simple recursive program to find n'th fibonacci number
    static int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n-1) + fib(n-2);
    }

    // Returns number of ways to reach s'th stair
    static int countWays(int s)
    {
        return fib(s + 1);
    }

    public static void main(String args[]){
        int s=4;
      //  System.out.println(countWays(s));
        System.out.println(possForStep(s));

    }

    //non recursive
    public static long possForStep(int n) {
        long[] values = new long[n+1];
        for (int i = 0; i <= n; i++) {
            // 1 for n==0 and n==1, else values[i-1] + values[i-2];
            values[i] = (i <= 1) ?  1 : values[i-1] + values[i-2];
        }
        return values[n];
    }
}
