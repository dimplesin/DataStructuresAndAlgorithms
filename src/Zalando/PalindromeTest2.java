package Zalando;

import java.util.Scanner;

/**
 * Created by v-dsindhi on 4/14/16.
 */
public class PalindromeTest2 {

    public static void main(String arr[]) {

        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.next();  //Get input no
        int inputNo = 0;

        try {
            inputNo = Integer.valueOf(inputStr);
        } catch (NumberFormatException nfe) {
            System.out.println("Given String in not a number");
            return;
        }
        if (inputNo < 0) {
            System.out.println("Given number can't be negative");
            return;
        }

        System.out.println(findNextPalindromeNo(inputNo));

    }


    public static int findNextPalindromeNo(int inputNo) {

        String inputStr = String.valueOf(inputNo);
        char[] inputChar = inputStr.toCharArray();
        int length = inputChar.length;
        int middleIndex = length / 2;

        replacingNosOnIndexGreaterThanMiddleIndexWithNosOnLowerIndex(middleIndex, inputChar);

        int modifiedNo = Integer.valueOf(new String(inputChar));

        //if modified no is less than input no
        if (inputNo > modifiedNo) {

            //check if length of no is odd or even
            if (length % 2 == 0) {
                if (inputChar[middleIndex - 1] != '9') {
                    inputChar[middleIndex - 1]++;
                    inputChar[middleIndex]++;
                } else {
                    incrementNo(middleIndex - 1, middleIndex, inputChar);
                }
            } else {
                if (inputChar[middleIndex] != '9') {
                    inputChar[middleIndex]++;
                } else {
                    incrementForOddNo(middleIndex, middleIndex - 1, middleIndex + 1, inputChar);
                }
            }
            modifiedNo = Integer.valueOf(new String(inputChar));
        }

        return modifiedNo;

    }

    public static void replacingNosOnIndexGreaterThanMiddleIndexWithNosOnLowerIndex(int middleIndex, char[] inputChar){
        for (int index = 0; index < middleIndex; index++) {
            if (inputChar[index] != inputChar[inputChar.length - index - 1]) {
                inputChar[inputChar.length - index - 1] = inputChar[index];
            }
        }

    }

    public static void incrementNo(int leftIndex, int rightIndex, char[] inputChar) {
        inputChar[leftIndex] = '0';
        inputChar[rightIndex] = '0';
        if (inputChar[leftIndex - 1] != '9') {
            inputChar[leftIndex - 1]++;
            inputChar[rightIndex + 1]++;
        } else {
            incrementNo(leftIndex - 1, rightIndex + 1, inputChar);
        }

    }

    public static void incrementForOddNo(int middleIndex, int leftIndex, int rightIndex, char[] inputChar) {
        inputChar[middleIndex] = '0';
        if (inputChar[leftIndex] != '9') {
            inputChar[leftIndex]++;
            inputChar[rightIndex]++;
        } else {
            incrementNo(leftIndex, rightIndex, inputChar);
        }
    }

}