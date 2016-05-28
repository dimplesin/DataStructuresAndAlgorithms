package com.company.amazon.BookKarumanchi.Challenges;

import java.util.Scanner;

/**
 * Created by v-dsindhi on 9/24/15.
 */
public class TrianglePrintUpAndDown {
    /*public static void main(String args[]){
        for(int i=1;i<=4;i++){
            for(int j=4;j>i;j--){
                System.out.print(" ");
            }
            for(int k=1;k<=i;k++){
                System.out.print(" *");
            }
            System.out.println();
        }
        for(int i=3;i>0;i--){
            for(int j=4;j>i;j--){
                System.out.print(" ");
            }
            for(int k=1;k<=i;k++){
                System.out.print(" *");
            }
            System.out.println();
        }
    }*/

   /* public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int [][] array  = new int[N][N];
        int sumFirstDiagonal = 0, secondDiagonal = 0, result = 0 ;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                array[i][j] = input.nextInt();
            }
        }

        //Sum of first diagonal
        int i=-1,j=-1;
        while(i<N-1 && j<N-1){
            sumFirstDiagonal += array[i+1][j+1];
            i++;j++;
        }

        //Sum of first diagonal
        int k=-1,l=N;
        while(k<N-1 && l>=0){
            secondDiagonal += array[k+1][l-1];
            k++;l--;
        }
        result = Math.abs(sumFirstDiagonal-secondDiagonal);
        System.out.print(result);

    }*/

    /*public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int [] array  = new int[N];
        for(int i=0;i<N;i++){
                array[i] = input.nextInt();
        }
        double positiveCount=0, negativeCount = 0, zeroCount=0;
        for(int i=0;i<N;i++){
            if(array[i] < 0){
                negativeCount++;
            }else if (array[i]>0){
                positiveCount++;
            }else if(array[i] == 0){
                zeroCount++;
            }
        }
        DecimalFormat df = new DecimalFormat("#0.000");
        double positiveCountfrac = 0, negativeCountFrac = 0, zeroCountFrac = 0;
        positiveCountfrac = positiveCount/N;
        negativeCountFrac = negativeCount/N;
        zeroCountFrac = zeroCount/N;

        System.out.println(df.format(positiveCountfrac));
        System.out.println(df.format(negativeCountFrac));
        System.out.println(df.format(zeroCountFrac));
    }*/

    public static void main(String args[]){
          /*   #
               ##
              ###
             ####
            #####
         */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0; i<N;i++){
            for(int k=N-1;k>i;k--){
                System.out.print(" ");
            }
            for(int j=0;j<=i;j++){
                System.out.print("#");
            }
            System.out.println();
        }
    }

   /* public static void main(String args[]) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String dateInput=sc.next();
        SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm:ssa");
        Date date = parseFormat.parse(dateInput);
        System.out.println(displayFormat.format(date));
    }*/

    /*public static void main(String args[]){
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        BigInteger fact= BigInteger.ONE;

        for (int i = 2; i <= n; i++){

            fact = fact.multiply(new BigInteger(String.valueOf(i)));

        }

        System.out.println(fact);
    }*/

//Library Fine
    /*public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        int day,month,year;
        day=in.nextInt();
        month=in.nextInt();
        year=in.nextInt();
        int daye, monthe,yeare;
        daye=in.nextInt();
        monthe=in.nextInt();
        yeare=in.nextInt();
        int fine=0;
        if((day>daye && month==monthe && year==yeare))
            fine=15*(day-daye);
        if((month>monthe && year==yeare))
            fine=500*(month-monthe);
        if(year>yeare)
            fine=10000;
        System.out.println(fine);
    }*/

    /*public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int numberOfClasses = sc.nextInt();
        int numberOfStudents = 0;
        int expectedStudents = 0;
        int studentArrivalTime = 0;
        String array[] = new String[numberOfClasses];
        for(int i=0;i<numberOfClasses;i++){
            int numberOfStudentsArrivedOnTime = 0;
            numberOfStudents = sc.nextInt();
            expectedStudents = sc.nextInt();
            for(int j=0;j<numberOfStudents;j++){
                studentArrivalTime = sc.nextInt();
                if(studentArrivalTime<=0){
                    numberOfStudentsArrivedOnTime++;
                }
            }
            if(expectedStudents<=numberOfStudentsArrivedOnTime){
                array[i] = "NO";
            }else if(expectedStudents>numberOfStudentsArrivedOnTime){
                array[i] = "YES";
            }
        }
        for(int k=0;k<array.length;k++){
            System.out.println(array[k]);
        }
    }

    private static String removeDuplicateCharactersFromWord(String word) {

        String result = "";

        for (int i = 0; i < word.length(); i++) {
            if (!result.contains("" + word.charAt(i))) {
                result += "" + word.charAt(i);
            }
        }

        return result;
    }

    */

    /*TestOne[] tOne = new TestOne[10];
    TestOne[][] tTwo = new TestOne[5][];
    if(tOne[0] == null){
        tTwo[0] = new TestOne[10];
        tTwo[1] = new TestOne[10];
        tTwo[2] = new TestOne[10];
        tTwo[3] = new TestOne[10];
        tTwo[4] = new TestOne[10];

    }*/
    /*public static void main(String[] args) {
        *//* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. *//*
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> oddNumbersMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> evenNumbersMap = new HashMap<Integer, Integer>();
        int N = sc.nextInt();
        int count = 0;
        int array[] = new int[N];
        for(int i=0;i<N;i++){
            array[i] = sc.nextInt();
        }
        for(int i=0;i<N-1;i++){
            if(i==0 && array[i]/2!=0){
                evenNumbersMap.put(i,array[i]);
            } else if(i==1 && array[i]/2==0){
                oddNumbersMap.put(i, array[i]);
            }else if((i!=0 && i!=1) && (array[i]/2 == 0 && Math.abs(i/2) != 0)){
                evenNumbersMap.put(i, array[i]);
            }else if((i!=0 && i!=1) && (array[i]/2 != 0 && Math.abs(i/2) == 0)){
                oddNumbersMap.put(i, array[i]);
            }else{
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] =temp;
                count++;
            }
        }
        System.out.println(count);
    }*/

    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for(int i = 0; i < testCases; i++){
            System.out.println( solve( in.nextInt() ) );
        }
    }

    private static String solve(int n){


        long combos = (long)Math.pow(2,n);
        for(long i = combos-1; i>=0; i--){
            String toStr = String.format("%"+n+"s", Long.toBinaryString(i)).replace(' ', '0');

            String modified = toStr.replace("0","3").replace("1","5");
            int threes =0;
            for( int j=0; j<modified.length(); j++ ) {
                if( modified.charAt(j) == '3' ) {
                    threes++;
                }
            }
            if(threes%5==0) {
                int fives =0;
                for( int k=0; k<modified.length(); k++ ) {
                    if( modified.charAt(k) == '5' ) {
                        fives++;
                    }
                }
                if(fives%3==0) return modified;
            }
        }
        return "-1";
    }*/

    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int height = 1;
            if (n == 0) {
                System.out.println(height);
            } else {
                while(n>0) {
                    height = height + height;
                    n--;
                    if (n > 0) {
                        height++;
                        n--;
                    }
                }
                System.out.println(height);
            }
        }
    }*/

}
