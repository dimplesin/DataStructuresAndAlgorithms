package com.company.amazon.BookKarumanchi.DataStructures.Trees.ExpressionTrees;

import com.company.amazon.BookKarumanchi.DataStructures.Stacks.LLStack;
import com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees.BinaryTreeNode;

/**
 * Created by v-dsindhi on 3/21/15.
 */
public class ExpressionBinaryTrees {

    /* Algorithm for Building Expression Tree from postfix Expression */
    LLStack BuilExprTree(char postfixExpr[], int size){
        LLStack S = new LLStack();
        for(int i=0;i<size;i++){
            if(postfixExpr[i] == '+' || postfixExpr[i] == '-' || postfixExpr[i] == '*' || postfixExpr[i] == '/'){
                BinaryTreeNode newNode = new BinaryTreeNode();
                if(newNode == null){
                    System.out.println("Memory Error");
                    return null;
                }
                newNode.setData(postfixExpr[i]);
                newNode.setLeft(null);
                newNode.setRight(null);
                S.push(newNode);
            }else{
                BinaryTreeNode T2 = (BinaryTreeNode)S.pop(), T1 = (BinaryTreeNode)S.pop();
                BinaryTreeNode newNode = new BinaryTreeNode();
                if(newNode == null){
                    System.out.println("Memory Error");
                    return null;
                }
                newNode.setData(postfixExpr[i]);
                //Make T2 as right child and T1 as left child for new node
                newNode.setLeft(T1); newNode.setRight(T2);
                S.push(newNode);
            }
        }
        return S;
    }
}
