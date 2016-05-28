package geeksforgeeks.Algorithms.Arrays;

/**
 * Created by v-dsindhi on 8/10/15.
 */
public class MaxIndexDiffProblem {
    //Given an array A[], find the maximum j - i such that A[j] <A[i]. For example, Input {34,8,10,3,2,80,30,1} and Output :6 {j=7,i=1}
    static int maxIndexDiff(int A[], int n){
        int maxDiff = -1;
        int i,j;
        for(i=0;i<n;++i){
            for(j = n-1;j>i;j--){
                if(A[j] > A[i] && maxDiff < (j-i)){
                    maxDiff = j-i;
                }
            }
        }
        return maxDiff;
    }
    public static void main(String args[]){
        int arr[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
        int n = arr.length;
        int maxDiff = maxIndexDiff(arr, n);
        System.out.println(maxDiff);

    }
}
