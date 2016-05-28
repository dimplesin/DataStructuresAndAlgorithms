package com.company.amazon.BookKarumanchi.Challenges;

/**
 * Created by v-dsindhi on 4/22/15.
 */


import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class PostfixEvaluator {

    public static void main(String args[]){
        PostfixEvaluator postfixEvaluator = new PostfixEvaluator();
        System.out.println(postfixEvaluator.evaluate("(a+b+c)*(e/f)-(g-h/i)"));
    }

    private Deque<String> args;

    public PostfixEvaluator() {
        args = new LinkedList();
    }

    public String evaluate(String expr) {
        args.clear();
        try{ Scanner scanner = new Scanner(expr);
            while (scanner.hasNext()) {
                String token = scanner.next();
                processToken(token);
            }
        }catch(Exception ec){}

        if (args.size() == 1) {
            return String.valueOf(args.pop());
        } else {
            throw new IllegalArgumentException("Invalid number of operators");
        }
    }

    private void processToken(String token) {
        if (token.equals("+")) {
            addArgs();

        } else if (token.equals("-")) {
            subArgs();

        } else if (token.equals("*")) {
            mulArgs();

        } else if (token.equals("/")) {
            divArgs();

        } else {
            try {
                String arg = token;
                args.push(arg);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid number: " + token, e);
            }
        }
    }

    private void addArgs() {
        checkArgumentsSize();
        String arg2 = args.pop();
        String arg1 = args.pop();
        args.push(arg1 + arg2);
    }

    private void subArgs() {
        checkArgumentsSize();
        String arg2 = args.pop();
        String arg1 = args.pop();
        args.push(arg1+"-"+ arg2);
    }

    private void mulArgs() {
        checkArgumentsSize();
        String arg2 = args.pop();
        String arg1 = args.pop();
        args.push(arg1 +"*"+ arg2);
    }

    private void divArgs() {
        checkArgumentsSize();
        String arg2 = args.pop();
        String arg1 = args.pop();
        args.push(arg1 +"/"+ arg2);
    }

    private void checkArgumentsSize() {
        if (args.size() < 2) {
            throw new IllegalArgumentException("Not enough parameters for operation");
        }
    }
}