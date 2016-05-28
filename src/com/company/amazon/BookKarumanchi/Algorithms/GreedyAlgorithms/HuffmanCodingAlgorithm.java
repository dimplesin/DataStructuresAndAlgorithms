package com.company.amazon.BookKarumanchi.Algorithms.GreedyAlgorithms;

import com.company.amazon.BookKarumanchi.Algorithms.PriorityQueuesAndHeaps.Heap;
import com.company.amazon.BookKarumanchi.DataStructures.Trees.BinarySearchTrees.BinarySearchTreeNode;

/**
 * Created by v-dsindhi on 4/2/15.
 */
public class HuffmanCodingAlgorithm {
    Heap HuffmanCodingAlgorithm(int A[], int n){
        //Initialize a priority queue PQ, to contain the n elements in A
        Heap PQ = new Heap(0,0);
        BinarySearchTreeNode temp;
        for(int i = 1;i<n;i++){
            temp = new BinarySearchTreeNode();
           // temp.setLeft(PQ.DeleteMax());
           // temp.setRight(PQ.DeleteMax());
            temp.setData(temp.getLeft().getData() + temp.getRight().getData());
           // PQ.Insert(temp);
        }
        return PQ;
    }

    //Suppose we are given two arrays Start[1....n] and Finish[1...n] listing the start and finish times of each class.
    //Our task is to choose the largest possible subset X e {1,2,....,n} so that for any pair i,j e X. either Start[i] > Finsih[j] or Start[j] > Finish[i]
    int LargestTasks(int Start[], int n, int Finish[]){
       int count = 1;
        int X[] = new int[100];
        X[count] =1;
        for(int i=2;i<n;i++){
            if(Start[i] > Finish[i]){
                count = count +1;
                X[count] = 1;
            }
        }
        return X[count];
    }
}
