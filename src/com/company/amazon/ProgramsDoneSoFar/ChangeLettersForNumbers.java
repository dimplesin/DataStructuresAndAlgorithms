package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/22/15.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChangeLettersForNumbers{
    private static final String[] tensNames = {
            "ten",
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety"
    };

    private static final String[] numNames = {
            "",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    };

    private static final String[] units = {
            "hundred",
            "thousand"
    };

    private static int indexOfNumber = 0;

    public static boolean useLoop(String[] arr, String targetValue) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(targetValue))
            {
                indexOfNumber = i;
                return true;
            }
        }
        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String input = null;
        do
        {
            try{
                //Read from console.
                BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                input = bufferRead.readLine();
                //Search for and.
                int intIndex = input.indexOf(" and");
                String[] array;
                int result = 1;

                if(intIndex == - 1)
                {
                    array = input.split(" ");
                    for (int i = 0; i < array.length; i++)
                    {
                        if(useLoop(numNames,array[i].toLowerCase()))
                        {
                            result = result + indexOfNumber;
                        }
                        else if(useLoop(tensNames,array[i].toLowerCase()))
                        {
                            result =(result + indexOfNumber)*10;
                        }
                        else if(useLoop(units,array[i].toLowerCase()))
                        {
                            switch(indexOfNumber)
                            {
                                case 0 :result = result*100;break;
                                case 1 :result = result*1000;break;
                            }
                        }
                    }
                    System.out.println("Final:"+result);
                }
                else
                {
                    System.out.println("as");
                    array = input.split(" ");
                    for (int i = 0; i < array.length; i++) {
                        if(array[i].equals("and")) {
                        }
                        else
                        {
                            System.out.print(" "+array[i]);
                        }
                    }
                }
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }while(input != null);
    }

}
