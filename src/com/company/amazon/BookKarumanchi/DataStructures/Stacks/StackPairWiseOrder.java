package com.company.amazon.BookKarumanchi.DataStructures.Stacks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by v-dsindhi on 3/16/15.
 */
public class StackPairWiseOrder {

    public static boolean checkStackPairwiseOrder(Stack<Integer> s){
        Queue<Integer> q = new LinkedList<Integer>();
        boolean pairwiseOrdered = true;
        while(!s.empty()){ q.add(s.pop());}
        while(!q.isEmpty()){ s.push(q.remove());}
        while(!s.empty()){
            int n = s.pop();
            q.add(n);
            if(!s.empty()){
                int m = s.pop();
                q.add(m);
                if(Math.abs(n-m) != 1){
                    pairwiseOrdered = false;
                }
            }
        }
        while(!q.isEmpty()){s.push(q.remove());}
        return pairwiseOrdered;
    }
}
