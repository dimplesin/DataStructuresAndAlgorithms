package com.company.amazon.BookKarumanchi.DataStructures.Stacks;

/**
 * Created by v-dsindhi on 4/4/15.
 */
//Time Complexity O(n), space : O(n)
public class RemoveAdjacentDuplicates {
    public int removeAdjacentDuplicates(int[] A){
        int stkptr = -1;
        int i=0;
        while(i<A.length){
            if(stkptr == -1 || A[stkptr] != A[i]){
                stkptr++;
                A[stkptr]=A[i];
                i++;
            }else{
                while(i < A.length && A[stkptr]==A[i]){
                    i++;
                }
                stkptr--;
            }
        }
        return stkptr;
    }

    public static void main(String[] args){
        RemoveAdjacentDuplicates removeAdjacentDuplicates = new RemoveAdjacentDuplicates();
        int[] A = {1,5,6,8,8,8,0,1,1,0,6,5};
        int index = removeAdjacentDuplicates.removeAdjacentDuplicates(A);
        for(int i=0;i<=index;i++){
            System.out.println(" "+A[i]);
        }
    }
}
