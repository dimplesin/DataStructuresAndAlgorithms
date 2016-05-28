package com.company.amazon.BookKarumanchi.Algorithms.SelectionAlgorithms;

/**
 * Created by v-dsindhi on 4/1/15.
 */
public class ProblemsOnSelection {

    //Find the largest element in an array A of size n
    void FindLargestInArray(int n, int A[]){
        int large = A[0];
        for(int i=0;i<n;i++){
            if(A[i]>large){
                large = A[i];
            }
        }
        System.out.println("Largest : "+large);
    }

    //Find the smallest and largest elements in an array A of size n
    void FindSmallestAndLargestInArray(int A[], int n){
        int small = A[0];
        int large = A[0];
        for(int i=0;i<=n-1;i++){
            if(A[i] > large){large = A[i];}
            if(A[i]<small){ small = A[i];}
        }
        System.out.println("Largest : "+ large + " and Smallest :"+small);
    }

    //Improve the previous algorithms
    void FindWithPairComparison(int A[], int n){
        int large = -1, small = -1;
        for(int i=0; i<=n-1;i=i+2){
            if(A[i] < A[i+1]){
                if(A[i] < small){
                    small = A[i];
                }
                if(A[i+1] > large){
                    large = A[i+1];
                }
            }else{
                if(A[i+1] < small ){
                    small = A[i+1];
                }
                if(A[i]>large){
                    large = A[i];
                }
            }
        }
        System.out.println("Smallest : "+small+" Largest:"+large);
    }

    //Find the k smallest elements in an array $ of n using partitioning method
    //Input positive integers n and k, where k=n array of elements S indexed from 1 to n
    // Output the k-smallest elements in S. It is returned as the value of function selection
    int Selection(int low, int high, int k, int S[]){
        int pivotpoint;
        if(low == high){
            return S[low];
        }else{
            pivotpoint = Partition(low, high, S);
            if(k == pivotpoint){
               return S[pivotpoint];
            }
            else if(k < pivotpoint){
                return Selection(low, pivotpoint-1, k, S);
            }else{
                return Selection(pivotpoint+1, high, k, S);
            }
        }
    }

    int Partition(int low, int high, int S[]){
        int i = low ,j = low, pivotitem =S[low];
        for(i=low+1;i<=high;i++){
            if(S[i] < pivotitem){
                j++;
                swap(S[i],S[j]);
            }
        }
        pivotitem = j;
        swap(S[low], S[pivotitem]);
        return pivotitem;
    }

    //Given two arrays each containing n sorted elements, give an O(log n) time algorithms to find the median of all 2n elements
    void FindMedian(int A[], int alo, int ahi, int B[], int blo, int bhi){
        int amid = alo + (ahi-alo)/2;
        int amed = A[amid];
        int bmid = blo + (bhi-blo)/2;
        int bmed = B[bmid];
        if(ahi - alo + bhi - blo < 4){
            return;
        }else if(amed < bmed){
            FindMedian(A, amid, ahi, B, blo, bmid+1);
        }else{
            FindMedian(A, alo, amid+1, B, bmid+1, bhi);
        }
    }


    private void swap(int i, int j) {
        int temp = i;
        i=j;
        j=temp;

    }
}
