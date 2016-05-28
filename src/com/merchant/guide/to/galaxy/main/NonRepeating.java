package com.merchant.guide.to.galaxy.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v-dsindhi on 6/12/15.
 */
public class NonRepeating {
    public static void Rangeexample(int n1, int n2){
        if(n1<n2){
            System.out.println(n1++);
            Rangeexample(n1++, n2);
        }else if(n1>n2){
            System.out.println(n1--);
            Rangeexample(n1--, n2);
        }

    }

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        for(int i=1;i<30;i++){
            numbers.add(i);
        }
        //add duplicate number into the list
        numbers.add(22);
        int total =0, highestNumber = 0;

        total = total - (highestNumber*(highestNumber+1)/2);
        highestNumber = numbers.size() - 1;

        // FindDuplicateInArray dn = new FindDuplicateInArray();
        // System.out.println("Duplicate Number: "+dn.findDuplicateNumber(numbers));

        System.out.println("Duplicate is : " + total + " Highest is" + highestNumber);


        for(int i=4;i>=0;i--){
            for(int j=i;j<=4;j++){
                System.out.print(" ");
            }
            for(int k=1;k<=i;k++){
                System.out.print(" *");
            } System.out.println();
        }

       /* for(int i=1;i<=8;i++){
            for(int j=8;j>i;j--){
                System.out.print(" ");
            }
            for(int k = 1;k<=i;k++){
                System.out.print(" *");
            }System.out.println();

            for(int l=1;l<=8;l++){
                for(int j=8;j>l;j--){
                    System.out.print(" ");
                }
                for(int k = 1;k<=l;k++){
                    System.out.print(" *");
                }System.out.println();
            }
        }*/


        for(int i=1;i<=4;i++){
            for(int j =4;j>i;j--){
                System.out.print(" ");
            }
            for(int k=1;k<=i;k++){
                System.out.print(" *");
            }

            System.out.print(" ");

            for(int j =4;j>i;j--){
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
            }System.out.println();
        }






        for (int i=10;i>=1;i-=2 ) {
            for (int j=i;j<10;j++ ) {
                System.out.print(" " );
            }for (int k=1;k<i;k++) {
                System.out.print(" *" );
            }System.out.println( );
        }


        for (int i=1;i<=6;i++ ) {
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
        /*String s = "ad asda asd asd    adasd";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                    i++;
                }
            }
            result.append(c);
        }
        System.out.println(result.toString());*/
       // int a[] = { 3, 4, 1, 3, 1, 7, 2, 2, 4 };

        //System.out.println(nonRepeatingElement(a));
    }

    private static int nonRepeatingElement(int[] a) {
        int element = 0;

        for (int i = 0; i < a.length; i++) {
            element ^= a[i];
            //System.out.println(element);
        }

        return element;
    }

    private static void commonEleemntsInArray(int[] a, int[] b) {
        int i = 0, j = 0;

        while (i < a.length && j < b.length) {

            if (a[i] > b[j]) {
                j++;
            } else if (b[j] > a[i]) {
                i++;
            } else {
                System.out.println(a[i]);
                i++;
                j++;
            }
        }

    }
}