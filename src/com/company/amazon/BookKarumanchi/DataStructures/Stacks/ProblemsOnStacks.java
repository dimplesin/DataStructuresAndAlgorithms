package com.company.amazon.BookKarumanchi.DataStructures.Stacks;

import java.util.Stack;

/**
 * Created by v-dsindhi on 4/4/15.
 */
public class ProblemsOnStacks {

    /* Given an array of characters formed with a's and b's. The string is marked with special character X, which respresents the middle
     * of the list. Check whether the string is palindrome */
    //Time Complexity O(n), space : O(1)
    int isPalindrome(String inputStr, int A[]){
        int i=0, j=inputStr.length();
        while(i<j && A[i] == A[j]){
            i++;j--;
        }
        if(i<j){
            System.out.println("Not a palindrome");
            return 0;
        }else{
            System.out.println("Palindrome");
            return 1;
        }
    }

    //Using stacks
    //Time Complexity O(n), space : O(n)
    boolean isPalindrome(String inputStr){
        char inputChar[] = inputStr.toCharArray();
        ArrayStack s = new ArrayStack();
        int i=0;
        while(inputChar[i] != 'X'){
            s.push(inputChar[i]);
            i++;
        }
        i++;
        while(i<inputChar.length){
            if(s.isEmpty()) return false;
            if(inputChar[i] != s.pop()){
                return false;

            }i++;
        }
        return true;
    }

    //Given a stack how to reverse the contents of stack using only stack operations
    public static void reverseStack(ArrayStack stack){
        if(stack.isEmpty()) return;
        int temp = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, temp);
    }
    private static void insertAtBottom(ArrayStack stack, int data){
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(stack, data);
        stack.push(temp);
    }

    //Finding Spans
    //Time Complexity O(n^2), space : O(1)
    int[] FindingSpans(int[] inputArray){
        int[] spans = new int[inputArray.length];
        for(int i=0;i<inputArray.length;i++){
            int span = 1;
            int j = i-1;
            while(j>0 && inputArray[j]<=inputArray[i+1]){
                span++;
                j--;
            }
            spans[i] = span;
        }
        return spans;
    }

    //Improving Complexity
    //Time Complexity O(n), space : O(n)
    int[] FindingSpansImproved(int[] inputArray){
        int spans[] = new int[inputArray.length];
        LLStack stack = new LLStack();
        int p=0;
        for(int i=0;i<inputArray.length;i++){
            while(!stack.isEmpty() && (inputArray[i]) > inputArray[(Integer)stack.top()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                p=-1;
            }else{p=(Integer)stack.top();}
            spans[i] = i-p;
            stack.push(i);
        }
        return spans;
    }

    //Time Complexity O(n), space : O(n)
    long MaxRectangleArea(int A[],int n){
        long maxArea = 0;
        if(A == null || A.length == 0){
            return maxArea;
        }
        Stack<StackItem> S = new Stack<StackItem>();
        S.push(new StackItem(Integer.MIN_VALUE, -1));
        for(int i=0;i<=n;i++){
            StackItem cur = new StackItem((i<n ? A[i]:Integer.MIN_VALUE),i);
            if(cur.height > S.peek().height){
                S.push(cur);
                continue;
            }
            while(S.size() > 1){
                StackItem prev = S.peek();
                long area = (i - prev.index)* prev.height;
                if(area > maxArea){
                    maxArea = area;
                }
                prev.height=cur.height;
                if(prev.height > S.get(S.size() - 2).height){
                    break;
                }
                S.pop();
            }
        }
        return maxArea;
    }

    /* Give an algorithm for sorting a stack in ascending order. We should not make any assumptions about how the stack is implemented. */
    //Time Complexity O(n^2), space : O(n)
    public class StackSorter{
        public LLStack sort(LLStack s){
            LLStack r = new LLStack();
            while(!s.isEmpty()){
                int tmp = (Integer) s.pop();
                while(!r.isEmpty() && (Integer)r.top() > tmp){
                    s.push(r.pop());
                }
                r.push(tmp);
            }
            return r;
        }
    }
}

class StackItem{
    public int height;
    public int index;

    StackItem(int height, int index) {
        this.height = height;
        this.index = index;
    }
}


//Largest rectangle under histogram
