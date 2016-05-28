package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/24/15.
 */
public class NumberOfWaysToFillWallOfNX4 {

   public static int find_ways(int n){
        if(n == 0) return 1;
        if(n==1 || n==2 || n ==3 )
            return 1;
        return  find_ways(n-1) + find_ways(n-4);
    }

    public static void main(String args[]){
        System.out.print(find_ways(4));
    }
}
