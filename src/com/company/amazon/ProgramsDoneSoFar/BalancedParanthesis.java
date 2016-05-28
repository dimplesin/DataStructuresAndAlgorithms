package com.company.amazon.ProgramsDoneSoFar;

import java.nio.BufferOverflowException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by v-dsindhi on 6/22/15.
 */
public class BalancedParanthesis {

    private static final Map<Character, Character> brackets = new HashMap<>();
    static {
        brackets.put('[', ']');
        brackets.put('{', '}');
        brackets.put('(', ')');
    }

    private BalancedParanthesis() {};

    /**
     * Returns true is parenthesis match open and close.
     * Understands [], {}, () as the brackets
     * It is clients responsibility to include only valid paranthesis as input.
     * A false could indicate that either parenthesis did not match or input including chars other than valid paranthesis
     *
     * @param str   the input brackets
     * @return      true if paranthesis match.
     */
    public static boolean isBalanced(String str) {
        if (str.length() == 0) {
            throw new IllegalArgumentException("String length should be greater than 0");
        }
        // odd number would always result in false
        if ((str.length() % 2) != 0) {
            return false;
        }

        final Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            if (brackets.containsKey(str.charAt(i))) {
                stack.push(str.charAt(i));
            } else if (stack.empty() || (str.charAt(i) != brackets.get(stack.pop()))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{}([])"));
        System.out.println(isBalanced("([}])"));
        System.out.println(isBalanced("([])"));
        System.out.println(CheckForBalancedBracketing("()[]{}[][]"));
        //String exp = "()[]{}[][]";
       // Parenthesis(exp, exp.length());
    }

    static public boolean CheckForBalancedBracketing(String IncomingString)
    {
        int BracketCount = 0;
        try
        {
                for (int Index = 0; Index < IncomingString.length(); Index++) {
                    switch (IncomingString.charAt(Index)) {
                        case '(':
                            BracketCount++;
                            continue;
                        case ')':
                            BracketCount--;
                            continue;
                        default:
                            continue;
                    }  // end of switch()
                }
        }
        catch (BufferOverflowException e)
        {
            //return false;
        }

        if (BracketCount == 0)
        {
            return true;
        }

        return false;

    }  // end of CheckForBalancedBracketing()


    public static void Parenthesis(String exp, int len){
        Stack<Integer> stk = new Stack<Integer>();
        for (int i = 0; i < len; i++)
        {
            char ch = exp.charAt(i);
            if (ch == '(')
                stk.push(i);
            else if (ch == ')')
            {
                try
                {
                    int p = stk.pop() + 1;
                    System.out.println("'(' at index "+(i+1)+" matched with ')' at index "+p);
                }
                catch(Exception e)
                {
                    System.out.println("')' at index "+(i+1)+" is unmatched");
                }
            }
        }
        while (!stk.isEmpty() )
            System.out.println("'(' at index "+(stk.pop() +1)+" is unmatched");
    }
}
