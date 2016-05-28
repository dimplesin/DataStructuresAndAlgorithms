package com.company.amazon.BookKarumanchi.Challenges;

import java.util.HashMap;

/**
 * Created by v-dsindhi on 4/22/15.
 */
public class PaypalProblem {
    public static int landingPosition(int[] input1, String[] input2){
        //Write your code
        HashMap<String, String> checkingSquare = new HashMap<String, String>();
        if(input2.length == input1[1]){
            for(int i=0;i<input2.length;i++){
                String[] splitHash = input2[i].split("#");
                for(int j=0;j<splitHash.length;j++) {
                    checkingSquare.put(i+"~"+j, splitHash[j]);
                }
            }
        }
        System.out.println(checkingSquare);
        return -1;
    }

    static void MatrixSubSquareWithAllOnes(int L[][], int m, int n){
        int i,j,B[][] = new int[m][n], max_of_s, max_i, max_j;
        max_of_s = L[0][0]; max_i = 0; max_j=0;
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(L[i][j] > max_of_s){
                   // max_of_s = L[i][j];
                    max_i =i;
                    max_j = j;
                }
            }
        }
        System.out.println("Maximum SubMatrix");
        for(i=max_i;i>0;i--){
            for(j=max_j;j>0;j--){
                System.out.print(L[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int input1[] = {6,5};
        int max_i=0,max_j=0;
        String input2[] ={"x#o#o#o#x#o","x#o#o#o#x#x", "x#o#o#o#x#o", "x#o#x#o#o#x", "x#o#x#o#o#x" };
        int[][] cheking1s = new int[6][6];
        for(int i=0;i<input1[1];i++) {
            String[] splitHash = input2[i].split("#");
            for (int j = 0; j < splitHash.length-1; j++) {
                if(splitHash[j].contains("x")) {
                    cheking1s[i][j] = 0;
                }else{
                    cheking1s[i][j] = 1;
                }
            }
        }

        System.out.println("Maximum SubMatrix");
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                System.out.print(cheking1s[i][j]);
                if(cheking1s[i][j] > 0){
                    // max_of_s = L[i][j];
                    max_i = i;
                    max_j = j;
                }
            }
            System.out.println();
        }

        System.out.println(max_i +"   "+max_j);
    }

}
