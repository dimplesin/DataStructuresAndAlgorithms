package com.company.Microsoft;

/**
 * Created by v-dsindhi on 8/8/15.
 */
//This is a java program to perform all permutation of given list of numbers of a specific length
import java.util.Random;
import java.util.Scanner;

public class Permute_All_List_Numbers
{
    static void permute(int[] a, int k) {
        if (k == a.length) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i]);
            }
            System.out.println();
        } else {
            for (int i = k; i < a.length; i++) {
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;

                permute(a, k + 1);

                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
    }

    public static void main(String args[])
    {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int[] sequence = {1,8,3};

        for (int i = 0; i < sequence.length; i++)
            System.out.print(sequence[i] + " ");

        System.out.println("\nThe permuted sequences are: ");
        permute(sequence, 0);

        sc.close();
    }
}