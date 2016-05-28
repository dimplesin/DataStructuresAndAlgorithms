package com.company.amazon.Codility;

import com.company.amazon.BookKarumanchi.Challenges.HashMap;

import java.util.Map;

/**
 * Created by v-dsindhi on 1/4/16.
 */
public class TapeEquilibrium {
    class Solution {
        //100/100
        public int solution(int[] A) {
            // write your code in Java SE 8
            int N = A.length;
            int i,first=0,second=0,diff=0,temp=0;
            first=A[0];
            for(i=1; i<N; i++){
                second=second+A[i];
            }
            diff=second-first;
            if(diff<0){
                diff=diff*(-1);
            }

            for(i=1; i<N-1; i++){
                first=A[i]+first;
                second=second-A[i];
                temp=second-first;
                if(temp<0){
                    temp=temp*(-1);
                }
                if(temp<diff){
                    diff=temp;
                }
            }
            return diff;
        }
    }

    //Missing Number   80/100
    public int solution(int[] A) {
        // write your code in Java SE 8
        int i, total, n = A.length;
        total  = (n+1)*(n+2)/2;
        for ( i = 0; i< n; i++)
            total -= A[i];
        return total;
    }

    //Frog Jump   100/100
    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        int diff=Y-X;
        int rest=diff%D;
        if(rest!=0){
            return (diff/D)+1;
        }else{
            return diff/D;
        }
    }

    //FrogRiverOne 100/100
    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        int check=0;
        for(int i=1; i<=X; i++){
            check+=i;
        }

        int[] arr=new int[X+1];
        for(int i=0; i<arr.length; i++){
            arr[i]=-1;
        }

        for(int i=0; i<A.length; i++){
            if(A[i]<=X){
                arr[A[i]]--;
                if(arr[A[i]]==-2){
                    check=check-A[i];
                }
            }
            if(check==0){
                return i;
            }
        }

        return -1;
    }

    //Permutation Check  100/100
    public int solutionPermCheck(int[] A) {
        // write your code in Java SE 8
        int[] check= new int[A.length+1];
        for(int i=0; i<A.length; i++){
            if(A[i]<A.length+1){
                check[A[i]]=1;
            }
        }
        for(int i=1; i<=A.length; i++){
            if(check[i]!=1){
                return 0;
            }
        }
        return 1;
    }

    //Missing Integer   100/100
    public int solutionMissingInteger(int[] A) {
        // write your code in Java SE 8
        Map<Integer,Boolean> map=new HashMap<>();
        for(int i=0; i<A.length; i++){
            if(A[i]>0){
                map.put(A[i],true);
            }
        }
        for(int i=1; i<=A.length; i++){
            if(map.get(i)==null){
                return i;
            }
        }
        return A.length+1;
    }


    //Passing Cars
    public int passingCars(int[] A) {
        // write your code in Java SE 8
        long count = 0;
        long multiply = 0;
        for(Integer car : A)
        {
            if (car == 0)
            {
                multiply = multiply + 1;
            }
            if (multiply > 0)
            {
                if (car == 1)
                {
                    count = count + multiply;
                    if (count > 1000000000)
                    {
                        return -1;
                    }
                }
            }
        }
        return (int)count;
    }


    //CountDiv
    int countDiv(int A, int B, int K) {
        // write your code in C99
        int b = B/K;
        int a = (A > 0 ? (A - 1)/K: 0);
        if(A == 0){
            b++;
        }
        return b - a;
    }
}
