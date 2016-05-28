package com.company.flipkart;/*
package com.company.flipkart;

*/

import com.company.amazon.BookKarumanchi.Challenges.HashMap;

import java.util.*;

/**
 * Created by v-dsindhi on 7/15/15.
 *//*

public class FlipkartQuestions {


    abc
            bef



    a < b

    Input ( abc, bef)

    List of sorted words.
    Total number of characters
    Ordering among these characters


    add
            ball
    dad
    Hashmap(Key


                    a d b l
                    a  b d



                    add

                    bd
                    dad
                    db
                    dd

                    a d
                    a b
                    b d

                    a b d
                    a d b



                    1     8     9
                    8    11   2
                    3    44   9

                    0,1   1,0
                    8+8
            find path from left most top to right most bottom that contains the maximum sum

                    1+8+9+2+9 =

                    1+8+11+2+9 =

                    1+8+11+44+9 =

                    1+8+11+2+9 =

                    1+8+3+44+9 =


                    1   8
                    8   11   2
                    3    44   9

                    1   8
                    8  11
                    3   44  9


                    1  8



                    8+11+44 =

                    3+44 =



                    Program :

                    public class PathFromLeftMostToRightMost{


        public static void main(String args[]){

            Scanner sc = new Sc
            int [][] arr = new int [n][n];


        }

        public int[][] numberOfPath(int[][] arr, int m, int n){
//count path to reach any cell in my first column is 1
            for(int i=0;i<m;i++)
                count[i][0] = 1;

//count of paths to reach any cell in first column is 1
            for(int j=0;j<n;i++{
                count[0][j] = 1;
            }

//Calculate the count of paths for other cells in bottom-up manner
            for(int i=1; i < m;i++){
                for(int j = 1; j<n;j++){
                    count[i][j] = count[i-1][j]+count[i][j-1];
                }
            }
            return count[m-1][n-1];
        }


        O(mn)











    }



    // Returns count of possible paths to reach cell at row number m and column
// number n from the topmost leftmost cell (cell at 1, 1)
    int numberOfPaths(int m, int n)
    {
            // Create a 2D table to store results of subproblems
            int count[m][n];
         
            // Count of paths to reach any cell in first column is 1
            for (int i = 0; i < m; i++)
                count[i][0] = 1;
         
            // Count of paths to reach any cell in first column is 1
            for (int j = 0; j < n; j++)
                count[0][j] = 1;
         
            // Calculate count of paths for other cells in bottom-up manner using
            // the recursive solution
            for (int i = 1; i < m; i++)
            {
                for (int j = 1; j < n; j++)
         
                    // By uncommenting the last part the code calculatest he total
                    // possible paths if the diagonal Movements are allowed
                    count[i][j] = count[i-1][j] + count[i][j-1]; //+ count[i-1][j-1];
         
            }
            return count[m-1][n-1];
    }


    int minCost(int arr[m][n], int m, int n)
    {
             int i, j;
         
             // Instead of following line, we can use int tc[m+1][n+1] or
             // dynamically allocate memoery to save space. The following line is
             // used to keep te program simple and make it working on all compilers.
             int tc[R][C]; 
         
             tc[0][0] = arr[0][0];
         
             */
/* Initialize first column of total cost(tc) array *//*

             for (i = 1; i <= m; i++)
                tc[i][0] = tc[i-1][0] + arr[i][0];
         
             */
/* Initialize first row of tc array *//*

             for (j = 1; j <= n; j++)
                tc[0][j] = tc[0][j-1] + arr[0][j];
         
             */
/* Construct rest of the tc array *//*

             for (i = 1; i <= m; i++)
                for (j = 1; j <= n; j++)
                    tc[i][j] = max(tc[i-1][j-1], tc[i-1][j], tc[i][j-1]) + arr[i][j];
         
             return tc[m][n];
    }

*/
public class FlipkartQuestions {
    private static int[] searchMinSumPair(int[] inputArray) {
        int l, r , min_sum, sum = 0, min_l, min_r;
        int n = inputArray.length;
	/* Array should have at least two elements*/
        if(n < 2)
        {
            return null;
        }

        int[] result = new int[2];
	/* Sort the elements */
        Arrays.sort(inputArray, 0, n-1);

	/* Start looking for the pair  */
        l = 0; r = n-1;
        min_sum = inputArray[l] + inputArray[r];
        min_l = l;
        min_r = r;

        while(l < r)
        {
            sum = inputArray[l] + inputArray[r];

		/*If abs(sum) is less then update the result items*/
            if(Math.abs(sum) < Math.abs(min_sum))
            {
                min_sum = sum;
                min_l = l;
                min_r = r;
            }
            if(sum < 0)
                l++;
            else
                r--;

        }
        result[0] = inputArray[min_l];
        result[1] = inputArray[min_r];
        return result;
    }

    static boolean validate(String identifier){

        char[] identifierValidate = identifier.toCharArray();
        boolean isValidString = false;
        if(identifierValidate[0] >= '0' &&  identifierValidate[0] <= '9'){
            isValidString = false;
        }
       else if(identifierValidate[0] == '$' || identifierValidate[0] == '_'){
            isValidString = true;
        }
        return isValidString;
    }

    public static void main(String[] args)
    {//start main

       int i=0;
        while(true){
            if(i++==4){
                break;
            }i++;
        }
        System.out.println("i="+(i++));

    }//end main


    static int[] sortArray(int[] arr){
        HashMap<Integer,String> charsNumberMap = new HashMap<Integer,String>();
        charsNumberMap.put(0, "Zero");
        charsNumberMap.put(1, "One");
        charsNumberMap.put(2, "Two");
        charsNumberMap.put(3, "Three");
        charsNumberMap.put(4, "Four");
        charsNumberMap.put(5, "Five");
        charsNumberMap.put(6, "Six");
        charsNumberMap.put(7, "Seven");
        charsNumberMap.put(8, "Eight");
        charsNumberMap.put(9, "Nine");

        HashMap<String, Integer> charsStringMap = new HashMap<String, Integer>();
        charsStringMap.put( "Zero", 0);
        charsStringMap.put("One", 1);
        charsStringMap.put("Two", 2);
        charsStringMap.put("Three", 3);
        charsStringMap.put("Four", 4);
        charsStringMap.put("Five", 5);
        charsStringMap.put( "Six", 6);
        charsStringMap.put("Seven", 7);
        charsStringMap.put("Eight", 8);
        charsStringMap.put("Nine", 9);

        List<String> arrayStrings = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            arrayStrings.add(charsNumberMap.get(arr[i]));
        }
        Collections.sort(arrayStrings);
        for(int i=0;i<arr.length;i++){
            arr[i] = charsStringMap.get(arrayStrings.get(i));
        }
        return arr;
    }



    public static void minimumCoins(int amount) {
        int coins[] = { 1, 2, 5, 10, 20};
        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                if ((amount - coins[i]) >= 0) {
                    amount -= coins[i];
                }
            }
        }
        System.out.println(coins.length);
    }


    public static void convertIt(int number, int base)
    {if ( base <= 1 || base > 16)
        return;

        char[] array = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                'B', 'C', 'D', 'E', 'F' };
        String convertedNum = "";

        do {
            convertedNum += array[number % base];
            number = number / base;
        } while (number != 0);

        convertedNum = new StringBuilder(convertedNum).reverse().toString();
        System.out.println(convertedNum);

    }//end while
}//end method



