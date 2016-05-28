package com.company.amazon.BookKarumanchi.Algorithms.BitwiseProgramming;

/**
 * Created by v-dsindhi on 4/2/15.
 */
public class BitManipulation {

    // Give an algorithm for printing the matrix elements in spiral order
    void Spiral(int[][] values, int m, int n){
        int rowStart = 0, columnStart = 0;
        int rowEnd = m-1, columnEnd = n-1;
        while(rowStart <= rowEnd && columnStart < columnEnd){
            int i = rowStart, j= columnStart;
            for(j=columnStart; j <= columnEnd;j++){System.out.println(values[i][j]);}
            for(i = rowStart+1, j--;i <= rowEnd;i++){System.out.println(values[i][j]);}
            for(j=columnEnd-1, i--; j>=columnStart;j--){System.out.println(values[i][j]);}
            for(i=rowEnd -1, j++; i >= rowStart+1;i--){System.out.println(values[i][j]);}
            rowStart++; columnStart++; rowEnd--; columnEnd--;
        }
    }

    //Give an algorithm for shuffling the desk of cards
    void Shuffle(int[] cards, int n){
        for(int i=0;i<n;i++){
            cards[i]=i;
        }
        for(int i=0; i<n;i++){
            int r = (int) (i+(Math.random()*(n-i)));
            int temp = cards[i]; cards[i]=cards[r]; cards[r] = temp;
        }
        System.out.println("Shuffled Cards");
        for(int i=0; i<n;i++){
            System.out.println(cards[i]);
        }
    }

    /* Reversal Algorithm for array rotation. Write a function rotate(A[], d, n ) that rotates A[] of size n by d elements. For Example
    * 1,2,3,4,5,6,7 becomes 3,4,6,7,1,2 after 2 rotations*/
    void leftRotate(int[] Array, int d, int n){
        reverseArray(Array, 0, d-1);
        reverseArray(Array, d, n-1);
        reverseArray(Array, 0, n-1);
    }
    void PrintArray(int[] Array, int size){
        for(int i=0; i < size; i++){
            System.out.println(Array[i]);
        }
    }

    void reverseArray(int Array[], int start, int end){
        int temp;
        while(start < end){
            temp = Array[start];
            Array[start] = Array[end];
            Array[end] = temp;
            start++;
            end--;
        }
    }

    /* Given a string that has set of words and spaces, write a program to move the spaces to front of string,
     * you need to traverse the array only once and need to adjust the string in place */
    void mySwap(char[] A, int i, int j){
        char temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    void moveSpacesToBegin(char[] A){
        int i = A.length -1;
        boolean[] isSpace = new boolean[2];
        int j=i;
        for(;j>=0;j--){
            if(A[j] != ' ' ){
                mySwap(A, i--, j);
            }
        }
    }

    /* Improve the complexity */
    void movSpacesToBegin(char[] A){
        int n = A.length-1, count = n;
        int i = n;
        for(;i>=0;i--){
            if(A[i] == ' '){
                A[count--] = A[i];
            }
        }
        while(count >= 0){
            A[count--]=' ';
        }
    }

    /* move spaces to the end */
    void moveSpacesToEnd(char[] A){
        int count =0;
        int n = A.length-1;
        int i =0;
        for(;i<=n;i++){
            if(A[i] != ' '){
                A[count++] = A[i];
            }
        }
        while(count <= n){
            A[++count] = ' ';
        }
    }

    /* Moving zeros to end */
    void moveZerosToEnd(int[] A){
        int i=0,j=0;
        while(i <= A.length - 1){
            if(A[i] != 0){
                A[j++] = A[i];
            }
            i++;
        }
        while(j<=A.length-1){
            A[j++]=0;
        }
    }

    //improve the complexity
    void mySwap(int A[], int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    void moveZerosToEnd(int A[], int len){
        int i,j;
        for(i=0,j=0;i<len;i++){
            if(A[i]  != 0){
                mySwap(A, j++,i);
            }
        }
    }
}
