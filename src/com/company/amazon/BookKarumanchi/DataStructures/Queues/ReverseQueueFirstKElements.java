package com.company.amazon.BookKarumanchi.DataStructures.Queues;

import java.util.Queue;
import java.util.Stack;

/**
 * Created by v-dsindhi on 3/16/15.
 */
public class ReverseQueueFirstKElements {

    public static void reverseQueueFirstKElements(int k, Queue<Integer> q){
        if(q == null || k > q.size()){
            throw new IllegalArgumentException();
        }else if(k>0){
            Stack<Integer> s = new Stack<Integer>();
            for(int i =0; i < k; i++){
                s.push(q.remove());
            }
            while(!s.isEmpty()){
                q.add(s.pop());
            }
            for(int i=0; i < q.size() -k; i++){
                q.add(q.remove());
            }
        }
    }
}
