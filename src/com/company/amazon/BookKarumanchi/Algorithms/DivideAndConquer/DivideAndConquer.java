package com.company.amazon.BookKarumanchi.Algorithms.DivideAndConquer;

/**
 * Created by v-dsindhi on 4/2/15.
 */
public class DivideAndConquer {

    //Given an infinite array in which the first n cells contains integers in sorted and rest of the cells are filled with some special
    //symbols (say, $). Assume we do not know the the n value. Give an algorithm that takes an integer K as input and finds a position
    //in the array containing K, if such a position exists. In O(log n) time.
    int FindInInfiniteSeris(int A[]){
        int mid = 0, l = 1, r = 1;
        while(A[r] != '$') {
            l = r;
            r = r * 2;
        }
        while((r-1) >1){
            mid = l+(r-l)/2;
            if(A[mid] == '$'){
                r = mid;
            }else{
                l = mid;
            }
        }
        return r;
    }
    /* Given a sorted array of non-repeated integers A[1..n] check whether there is an index i for which A[i] = i */
    int IndexSearcher(int A[], int l,int r){
        int mid = l+(r-l)/2;
        if(r-l <= l){
            if(A[l] == l || A[r] == r ){
                return 1;
            }else { return 0;}
        }
        if(A[mid] < mid){
            return IndexSearcher(A, mid+1, r);
        }else if(A[mid] > mid){
            return IndexSearcher(A, l, mid -1);
        }
        return mid;
    }

    //Stock Pricing Stratrgy Problem
    void StockStrategy(int A[], int n, int buyDateIndex,int sellDateIndex){
        int profit = 0;
        buyDateIndex = 0; sellDateIndex = 0;
        for(int i = 1; i < n;i++){ // indicates buy date
            for(int j = i;j <n; j++) {  //indicates sell date
                if(A[j] - A[i] >profit){
                    profit = A[j] - A[i];
                    buyDateIndex = i;
                    sellDateIndex = j;
                }
            }
        }
    }

   // Maximum Value Contiguous Subsequence
    int MaxSumRec(int A[], int left, int right){
        int MaxLeftBorderSum = 0, MaxRightBorderSum = 0, LeftBorderSum = 0, RightBorderSum = 0;
        int mid = left + (right - left)/2;
        if(left == right) { //Base Case
            return A[left] > 0 ? A[left] : 0;
        }
        int MaxLeftSum = MaxSumRec(A, left, mid);
        int MaxRightSum = MaxSumRec(A, mid +1, right);
        for(int i=mid;i>= left;i--){
            LeftBorderSum += A[i];
            if(LeftBorderSum > MaxLeftBorderSum){
                MaxLeftBorderSum = LeftBorderSum;
            }
        }
        for(int j = mid+1; j < right; j++){
            RightBorderSum += A[j];
            if(RightBorderSum > MaxRightBorderSum){
                MaxRightBorderSum = RightBorderSum;
            }
        }
        return Math.max(MaxLeftSum + MaxRightSum, MaxLeftBorderSum + MaxRightBorderSum);
    }

    int MaxSubsequenceSum(int A[], int n){
        return n >0 ? MaxSumRec(A, 0, n-1) : 0;
    }

    /* Given an array of 2n integers in the following format a1 a2 a3.....an b1 b2 b3 ..... bn Shuffle the array to a1b1 a2b2 a3b3 .... anbn
     * without any extra memory */
    void ShuffleArray(int A[], int l, int r){
        //Array Center
        int c = (l+r)/2, q=l+(l+c)/2;
        if(l == r){
            return;
        }
        for(int k = l, i=q; i<=c;i++,k++){
            int tmp = A[i];
            A[i] = A[c+k];
            A[c+k] = tmp;
        }
        ShuffleArray(A, l, c);
        ShuffleArray(A, c+1, r);
    }

    //To calculate K^n give an algorithm
    int Exponential(int k, int n){
        int a = 0;
        if(k == 0){
            return 1;
        }
        else{
            if(n%2 == 1){
                a = Exponential(k, n-1);
                return a*k;
            }else{
                a = Exponential(k, n/2);
                return a*a;
            }
        }
    }
 }
