package com.company.amazon.BookKarumanchi.DataStructures.Trees.GenericTreesN_aryTrees;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        switch(input){
            case '0':
                System.out.println("Not a valid input.");
                break;
            case '1':
                System.out.println(input);
                break;
            default :
                long number = getZeroOne(input);
                System.out.println(number);
                break;
        }
    }
    private static long getZeroOne(int input) {
        ArrayList<Long> arr1 = new ArrayList<Long>();
        ArrayList<Long> arr2 = new ArrayList<Long>();

        long min = Long.MIN_VALUE;
        boolean flag = false;
        long multiple_value = 10;
        long first = 0;
        long second = 1;
        arr1.add(first);
        arr1.add(second);
        while(!flag){
            for(long third : arr1){
                long num = multiple_value+third;
                if(num % input == 0){
                    min = num;
                    flag = true;
                    break;
                }
                arr2.add(third);
                arr2.add(num);
            }
            arr1.clear();
            for(long fourth : arr2) {
                arr1.add(fourth);
            }
            multiple_value *= 10;
        }
        return min;
    }
}