package com.company.amazon.BookKarumanchi.DataStructures.Stacks;

import java.util.StringTokenizer;

/**
 * postfix evaluator of expressions, uses a stack internally
 * @author manuel
 * @version 2
 */
public class PostfixEvaluation {
    private static final char ADD = '+', SUBTRACT = '-';
    private static final char MULTIPLY = '*', DIVIDE = '/';

    private ArrayStack stack;

    /**
     *  Sets up this evalutor by creating a new stack.
     */
    public PostfixEvaluation() {
        stack = new ArrayStack();
    }

    /**
     *  Evaluates the specified postfix expression. If an operand is
     *  encountered, it is pushed onto the stack. If an operator is
     *  encountered, two operands are popped, the operation is
     *  evaluated, and the result is pushed onto the stack.
     */

    public boolean isValid(String expr) {
        // to be completed
        return true;
    }

    /**
     * evaluates a postfix expresssion
     * @param expr expression in string format tokens separated
     * by space
     * @return integer results of expression evaluation
     * @precondition expression must be valid (isValid() == true)
     */
    public int evaluate(String expr) {
        assert (isValid(expr));

        stack = new ArrayStack();
        int op1, op2, result = 0;
        String token;
        StringTokenizer tokenizer = new StringTokenizer(expr);

        while (tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();

            if (isOperator(token)) {
                op2 = ((Integer) stack.pop()).intValue();
                op1 = ((Integer) stack.pop()).intValue();
                result = evalSingleOp(token.charAt(0), op1, op2);
                stack.push(new Integer(result));
            }
            else
                stack.push(new Integer(Integer.parseInt(token)));
        }

        result = ((Integer) stack.pop()).intValue();
        return result;
    }

    /**
     *  Determines if the specified token is an operator.
     */
    private boolean isOperator(String token) {
        return (
                token.equals("+")
                        || token.equals("-")
                        || token.equals("*")
                        || token.equals("/"));
    }

    /**
     *  Evaluates a single expression consisting of the specified
     *  operator and operands.
     */
    private int evalSingleOp(char operation, int op1, int op2) {
        int result = 0;

        switch (operation) {
            case ADD :
                result = op1 + op2;
                break;
            case SUBTRACT :
                result = op1 - op2;
                break;
            case MULTIPLY :
                result = op1 * op2;
                break;
            case DIVIDE :
                result = op1 / op2;
        }

        return result;
    }
}