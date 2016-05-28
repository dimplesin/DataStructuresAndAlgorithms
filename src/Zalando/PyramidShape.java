package Zalando;

import java.util.Scanner;

/**
 * Created by v-dsindhi on 3/5/16.
 */
public class PyramidShape {

    public static void main(String[] args) {

        int num = 10;

        for (int i = 1; i < num; i++) {

            for (int j = 1; j <= num - i; j++) {

                System.out.print(" ");
            }

            for (int k = 1; k <= i; k++) {
                System.out.print("" + k + " ");
            }

            for (int l = i - 1; l > 0; l--) {
                System.out.print("" + l + " ");
            }

            System.out.println();
        }

        //Reverse number
        int rev=0;
        while(num>0) {
            int rem = num % 10;
            rev = rem + (rev * 10);
            num = num / 10;
        }

        //Checking even odd without using operators
        int number;
        Scanner in= new Scanner(System.in);

        System.out.println("Enter a number to check even or odd");
        number=in.nextInt();

        if((number & 1)==0){
            System.out.println(+number+" is Even number");
        }else{
            System.out.println(+number+" is Odd Number");
        }

        //Using shift operators
        if( ( number >> 1) <<1==number){
            System.out.println(+number+" is Even number");
        }else{
            System.out.println(+number+" is Odd Number");
        }
    }

}
