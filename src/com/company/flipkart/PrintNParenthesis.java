package com.company.flipkart;

import java.util.ArrayList;

/**
 * Created by v-dsindhi on 7/11/15.
 */
public class PrintNParenthesis {


    static ArrayList<Character> str = new ArrayList<>();
    /* Wrapper over _printParenthesis()*/
    static void printParenthesis(int n)
    {
        if(n > 0)
            _printParenthesis(0, n, 0, 0);
        return;
    }

    static void _printParenthesis(int pos, int n, int open, int close)
    {
        if(close == n)
        {
            for(int i=0;i<str.size();i++) {
                System.out.print(str.get(i));
            }
            System.out.println();
            return;
        }
        else
        {
            if(open > close) {
                str.add(pos, '}');
                _printParenthesis(pos+1, n, open, close+1);
            }
            if(open < n) {
                str.add(pos, '{');
                _printParenthesis(pos+1, n, open+1, close);
            }
        }
    }

    /* driver program to test above functions */
    public static void  main(String args[])
    {
        int n = 2;
        printParenthesis(n);

    }
}
