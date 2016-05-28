package com.company.amazon.MoreProgramsForAmazon;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
 
public class VerticalOrder {
    public static TreeMap<Integer, ArrayList> ht = new TreeMap<Integer, ArrayList>();;
    public static int  level;
    public ArrayList<Integer> al;
    public int vertical(VerticalNode root, int level, boolean leftCall){
        if(root!=null){
            level = vertical(root.right,++level, true);
            if(ht.get(level)!=null){
                ArrayList x = ht.get(level) ;
                x.add(root.data);
                ht.put(level, x);
            }else{
                al = new ArrayList<Integer>();
                al.add(root.data);
                ht.put(level, al);
            }
            vertical(root.left,--level,false);
            return level;
        }else if(leftCall){
            return --level;
        }else{
            return ++level;
        }
    }
    public void printResult(TreeMap ht){
        Set<Integer> i = ht.keySet();
        for(int keys:i){
            System.out.println(ht.get(keys));
        }
    }
    public static void main(String args[]){
        VerticalNode root = new VerticalNode(1);
        root.left = new VerticalNode(2);
        root.right = new VerticalNode(3);
        root.left.left = new VerticalNode(4);
        root.left.right = new VerticalNode(5);
        root.right.left = new VerticalNode(6);
        root.right.right = new VerticalNode(7);
 
        VerticalOrder p = new VerticalOrder();
        p.vertical(root, 0, false);
        p.printResult(ht);
 
    }
}
class VerticalNode{
    int data;
    VerticalNode left;
    VerticalNode right;
    public VerticalNode (int data){
        this.data = data;
        left = null;
        right = null;
    }
}
