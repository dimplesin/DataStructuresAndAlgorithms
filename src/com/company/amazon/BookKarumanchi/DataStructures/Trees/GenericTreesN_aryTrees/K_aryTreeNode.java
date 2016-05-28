package com.company.amazon.BookKarumanchi.DataStructures.Trees.GenericTreesN_aryTrees;

/**
 * /* A full k-ary tree where each node has either 0 or k children. Given an array which contains the preorder travesal of full k-ary tree,
 * give an algorithm for constructing the full k-ary tree. */
public class K_aryTreeNode {

    public int data;
    public K_aryTreeNode[] child;
    public K_aryTreeNode (int k) {
        child = new K_aryTreeNode[k];
    }
    public void setData(int dataInput){
        data = dataInput;
    }

    public int getChild(){
        return data;
    }

    public void setChild(int i, K_aryTreeNode childNode){
        child[i] = childNode;
    }

    public K_aryTreeNode getChild(int i){
        return child[i];
    }
   int Ind = 0;
    K_aryTreeNode BuildK_aryTree(int[] A, int n, int k){
        if(n <= 0) return null;
        K_aryTreeNode newNode = new K_aryTreeNode(k);
        if(newNode == null){
            System.out.println("Memory Error");
            return null;
        }
        newNode.setData(A[Ind]);
        for(int i=0; i<k; i++){
            if(k*Ind+i<n){
                Ind++;
                newNode.setChild(Ind, BuildK_aryTree(A, n, k));
            }
            else{ newNode.setChild(0, null);}
        }
        return newNode;
    }
}
