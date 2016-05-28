package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/22/15.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import java.util.*;
public class nextBigI
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter an integer value");
        int n=Integer.parseInt(br.readLine());
        nextBigI.big(n);
    }
    static void big(int a)
    {
        String n=a+"";
        char c[]=n.toCharArray();
        for(int i=c.length-1;i>=1;i--)
        {
            if (c[i-1]>c[i])
            {
                continue;
            }
            else
            {
                //swap
                int index=nextBigI.check(c,c[i-1]);
                char temp=c[i-1];
                c[i-1]=c[index];
                c[index]=temp;

                Arrays.sort(c,i,c.length);

                break;
            }

        }nextBigI.print(c);
    }
    static void print(char c[])
    {
        for(int m=0;m<c.length;m++)
        {
            System.out.print(c[m]);
        }
    }
    static int check(char a[],int j)
    {
        int k;
        for( k=a.length-1;k>=0;k--)
        {
            if(a[k]>j)
                break;
        }
        return k;
    }


}