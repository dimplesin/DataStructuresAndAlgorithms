package com.company.amazon.BookKarumanchi.Challenges;


/**
 * Created by v-dsindhi on 5/21/15.
 */
public class TallyTestTechGig {

    public static void main(String args[]){

        int i=0,j=0;
        boolean t = true,r;
        r = (t & 0 < (i+=1));
        r = (t && 0 < (i+-2));
        r = (t | 0 < (j+=1));
        r = (t || 0 < (j+=2));
        System.out.println(i + " "+j);
        int[] arr = {1,3,12,4};
        int size = arr.length;
        int sum = 14;
        int result = minimumBottles(17);
           System.out.println("Result : " + result);
    }

    void test(int x){
        switch (x){
            case 1:
            case 2:
            case 0:
            default:
            case 4:

        }
    }

    static void op(boolean a, boolean b){
        boolean c= a != b;
        boolean d = a ^ b;
        boolean e = c == d;
        System.out.println(e);
    }

    public static String triplet_sum(int[] input1, int input2, int input3){
        for (int i = 0; i < input2-2; i++)
        {
            for (int j = i+1; j < input2-1; j++)
            {
                for (int k = j+1; k < input2; k++)
                {
                    if (input1[i] + input1[j] + input1[k] == input3)
                    {
                        return "True";
                    }
                }
            }
        }
        return "False";
    }

    public static int minimumBottles(int input1){
        int a[] = {1,5,7,10};
        int sum = 0, result = 0;
        int[] temp = new int[a.length];
        for(int i = a.length - 1; i > -1; i --){
            temp[a.length - i -1] = a[i];
        }
        a = temp;
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] + sum <= input1)
            {
                sum += a[i];
                result++;
            }
        }
        return result;
    }
}
