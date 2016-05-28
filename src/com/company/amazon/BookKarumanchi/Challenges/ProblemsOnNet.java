package com.company.amazon.BookKarumanchi.Challenges;

import java.util.Scanner;

/**
 * Created by v-dsindhi on 4/7/15.
 */
public class ProblemsOnNet {

    //http://www.techgig.com/codegladiators/openparticipation/question/MTA5MkAjJEAjJDk3ODk3QCMkQCMkMTY1Nzk3NEAjJEAjJDE0Mjg0NjUzMDI=/1
    public static int PalindromeLengthPuzzle(String[] input1)
    {
        StringBuilder string = new StringBuilder();
        for(int i=0;i<input1.length;i++){
            string.append(input1[i].substring(0,1));
        }
        String inputStr = string.toString(), reverse = "";

        int[][] arr = new int[inputStr.length() + 1][inputStr.length() + 1];
        // reverse string a
        String b = new StringBuffer(inputStr).reverse().toString();

        // complete the Longest common subsequence array
        for (int i = 0; i < inputStr.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (inputStr.charAt(i) == b.charAt(j)) {
                    arr[i + 1][j + 1] = arr[i][j] + 1;
                } else {
                    arr[i + 1][j + 1] = Math.max(arr[i + 1][j], arr[i][j + 1]);
                }
            }
        }
        String str = "";
        int x = inputStr.length();
        int y = b.length();
        //trace back form bottom of LCS array
        while (x > 0 && y > 0) {
            if (arr[x][y] == arr[x - 1][y]) {
                x--;
            } else if (arr[x][y] == arr[x][y - 1]) {
                y--;
            } else {
                if (inputStr.charAt(x - 1) == b.charAt(y - 1)) {
                    str += inputStr.charAt(x - 1);
                    x--;
                    y--;
                }
            }
        }
        // return the largest palindrome
        return str.length();
    }

    /*public static void main (String[] arg){
        String[] students = {"Bharti", "Bharat", "Akash", "Bhavya", "Chand", "Brijesh", "Chetak", "Arvind" , "Bhavana"};
        ProblemsOnNet problemsOnNet = new ProblemsOnNet();

        //System.out.println(problemsOnNet.longestPalindrome(inputStr));
        //System.out.println(problemsOnNet.PalindromeLengthPuzzle(students));
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the length of numbers");
        int length = scan.nextInt();
        int[] A = new int[length];
        for(int i =0 ;i<A.length;i++){
            System.out.println("Enter the number "+i+" : ");
            A[i] = scan.nextInt();
        }
        BruteForce(A.length, A, 42);
    }*/



    public static void BruteForce(int n, int[] A, int K){
        for(int i=0;i<n;i++){
                if(A[i] != K){
                    System.out.println(A[i]);
                }else{
                    break;
                }
            }
    }



    //Write a function that adds two numbers. You should not use + or any arithmetic operators.
    //Iterative Version
    public static int addIterative(int a, int b){
        while (b != 0){
            int carry = (a & b) ; //CARRY is AND of two bits

            a = a ^b; //SUM of two bits is A XOR B

            b = carry << 1; //shifts carry to 1 bit to calculate sum
        }
        return a;
    }


    //Recursive Version
    public static int add(int a, int b){
        if(b == 0) return a;
        int sum = a ^ b; //SUM of two integer is A XOR B
        int carry = (a & b) << 1;  //CARRY of two integer is A AND B
        return add(sum, carry);
    }


    //Palindrome check for integers.
      public static void main(String[] args)
        {

            System.out.println("Please Enter a number : ");
            int givennumber = new Scanner(System.in).nextInt();
            int number=givennumber;
            int reverse=0;
            while (number != 0) {
                int remainder = number % 10;
                reverse = reverse * 10 + remainder;
                number = number / 10;
            }
            if(givennumber == reverse)
                System.out.println("Result:Palindrome");
            else
                System.out.println("Result:Not Palindrome");
        }

    }

