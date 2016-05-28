package com.company.amazon.BookKarumanchi.Challenges;

import java.util.ArrayList;

/**
 * Created by v-dsindhi on 4/17/15.
 */
public class MaxTriangleSum {

    public void main(String args[], int a){

    }

    public static void main(String[] args){
        //Scanner scanner = new Scanner(System.in);
        String numberOfString = "5#9#6#4#6#8#0#7#1#5"; //scanner.nextLine();
        System.out.println(validtrianglesum(numberOfString));


        /*try{
            System.out.println("Overloaded methods");
        }catch(Exception e){

        }finally {
            throw new NullPointerException();
        }*/

        for(int i=1;i<=4;i++){
            for(int j =4;j>i;j--){
                System.out.print(" ");
            }
            for(int k=1;k<=i;k++){
                System.out.print(" *");
            }

            System.out.println();

            /*for(int j =4;j>i;j--){
                if(j==3){
                    for(int n=4;n>i+1;n--)
                        System.out.print(" ");
                }
                if(j==1){
                    for(int n=4;n>i+2;n--)
                        System.out.print(" ");
                }
                if(j==4){
                    System.out.print(" ");
                }
                System.out.print(" ");
            }
            for(int k=1;k<=i;k++){
                System.out.print(" *");
            }System.out.println();*/
        }






        for (int i=4;i>=1;i-=1 ) {
            System.out.print(" " );
            for (int j=i;j<4;j++ ) {
                System.out.print(" " );
            }for (int k=1;k<i;k++) {
                System.out.print(" *" );
            }System.out.println( );
        }


        /*for (int i=1;i<=6;i++ ) {
            for (int j=8;j>i;j--) {
                System.out.print(" " );
            }for (int k=1;k<=i;k++ ) {
                System.out.print(" *" );
            }System.out.println( );

        }

        for (int i=0;i<4;i+=1 ) {
            for (int j=0;j<8;j++ ) {
                if(j>i&&j<(8-(i+1))){
                    System.out.print("  ");
                }
                else
                    System.out.print(" *" );
            }
            System.out.println( );
        }
        for (int i=4;i<8;i+=1 ) {
            for (int j = 8; j > 0; j--) {
                if (j < (i + 1) && j > (8 - (i))) {
                    System.out.print("  ");
                } else
                    System.out.print(" *");
            }
            System.out.println();
        }

        for (int i=7;i>=1;i-=2 ) {
            for (int j=i;j<7;j++ ) {
                System.out.print(" " );
            }for (int k=1;k<i+1;k++) {
                System.out.print(" *" );
            }System.out.println( );
        }
        for (int i=1;i<=4;i++ ) {
            for (int j=4;j>i;j--) {
                System.out.print(" " );
            }for (int k=1;k<=i;k++ ) {
                System.out.print(" *" );
            }System.out.println( );

        }

        for (int i=0;i<4;i+=1 ) {
            for (int j=0;j<7;j++ ) {
                if(j>i&&j<(7-(i+1))){
                    System.out.print("  ");
                }
                else
                    System.out.print(" *" );
            }
            System.out.println( );
        }
        for (int i=4;i<7;i+=1 ) {
            for (int j=7;j>0;j-- ) {
                if(j<(i+1)&&j>(7-(i))){
                    System.out.print("  ");
                }
                else
                    System.out.print(" *" );
            }
            System.out.println( );
        }


        for (int i = 1, j = 7; i <= 7 && j >= 0; i++, j--) {
            for (int i2 = 0; i2 < i - 1; i2++) {
                System.out.print(" ");
            }
            for (int m = i - 1; m < j; m++) {
                System.out.print("*");
            }

            for (int j2 = j; j2 > 0; j2--) {
                System.out.print(" ");
            }
            System.out.println();
        }*/

    }
        public static String validtrianglesum(String input1)
        {
            //Write code here
            ArrayList<Integer> numPrinted = new ArrayList<Integer>();
            String[] splitString = input1.split("#");
            int i=0,j=0,k=2, maxsum = 0;
            try {
                while (i <= splitString.length) {

                    int max = 0;
                    ArrayList<Integer> numsArrays = new ArrayList<Integer>();
                    for (; j <= i; ) {
                        numsArrays.add(Integer.parseInt(splitString[j]));
                        j++;
                    }
                    i = i + k;
                    k++;
                    for (int m = 0; m < numsArrays.size(); m++) {
                        if (numsArrays.get(m) > max) {
                            max = numsArrays.get(m);
                        }
                    }
                    numPrinted.add(max);
                }


                for(int n=0;n<numPrinted.size();n++){
                    maxsum += numPrinted.get(n);
                }
                return String.valueOf(maxsum);
            }catch(Exception e){
                return "Invalid";
            }
        }
}
//5#9#6#4#6#8#0#7#1#5