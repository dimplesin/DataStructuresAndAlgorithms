package com.company.amazon.ProgramsDoneSoFar;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by v-dsindhi on 6/26/15.
 */
public class MaximumOfAllSubarrayofSizeK {

    static void printKMax(int arr[], int n, int k) {
        int j, max;
        for (int i = 0; i <= n-k; i++) {
            max = arr[i];
            for (j = 1; j < k; j++) {
                if (arr[i+j] > max)
                    max = arr[i+j];
            }
            System.out.print(" "+max);
        }
    }

    public static void main(String args[])
    {
        int arr[] =  {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int n = arr.length;
        int k = 3;
        printKMax(arr, n, k);
        //List<Integer> integerList=maxList(arr, k);
        /*for(Integer a:integerList){
            System.out.print(a+" ");
        }*/

    }

    public static List<Integer> maxList(int[] a, int k)   {
        if (k <= 0) {
            throw new IllegalArgumentException("The value of k should atleast be 1.");
        }

        final Deque<Integer> deque = new ArrayDeque<>();
        final List<Integer> result = new ArrayList<>();

        int i;
        for (i = 0; i < k; i++) {
            while (!deque.isEmpty() && a[deque.peek()] <= a[i]) {
                deque.removeFirst();
            }
            deque.addLast(i);
        }


        for (; i < a.length; i++) {
            result.add(a[deque.peek()]);

            while (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && a[deque.peek()] <= a[i]) {
                deque.removeFirst();
            }

            deque.addLast(i);
        }

        result.add(a[deque.peek()]);
        return result;
    }
}