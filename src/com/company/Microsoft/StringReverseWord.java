package com.company.Microsoft;

/**
 * Created by v-dsindhi on 8/8/15.
 */
import java.util.*;
public class StringReverseWord
{
    public static void main(String[] args) {
        String a = "Neil Peart rocks YYZ";
        Stack <String> stack = new Stack <String>();
        String[] temp;
        String delimiter = " ";
        // given string will be split by the argument delimiter provided.
        temp = a.split(delimiter);
        // push substring to stack
        for(int i =0; i < temp.length ; i++)
        {
            stack.push(temp[i]);
        }
        System.out.println("\nOriginal string: " + a);
        System.out.print("Reverse word string: ");
        while(!stack.empty()) {
            System.out.print(stack.pop());
            System.out.print(" ");
        }
        System.out.println("\n");
    }


    public static  void main() {
        String s = "Neil Peart rocks YYZ";
        String[] str =s.split(" ");
        StringBuffer buffer = new StringBuffer();
        for(int i=str.length-1;i>=0;i--)
        {
            buffer.append(str[i]);
            buffer.append(" ");
        }
        System.out.println("\nOriginal string: " + s);
        System.out.println("Reverse word string:"+buffer.toString());
    }
}
