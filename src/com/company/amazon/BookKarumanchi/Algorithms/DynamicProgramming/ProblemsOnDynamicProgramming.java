package com.company.amazon.BookKarumanchi.Algorithms.DynamicProgramming;

import com.company.amazon.BookKarumanchi.Algorithms.Sorting.InsertionSort;
import com.company.amazon.BookKarumanchi.DataStructures.Trees.BinarySearchTrees.BinarySearchTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v-dsindhi on 4/3/15.
 */
public class ProblemsOnDynamicProgramming {

     //Consider the following recurrence to code
    //T(n) = i=1 to n sum 2*T(i) *T(i-1)
    int T[] = new int[10240];
    int f(int n){
        int sum = 0;
        if(n==0 || n==1){
            return 2;
        }
        for(int i=1; i <n ; i++){
            sum += 2* f(i) * f(i-1);
        }
        return sum;
    }

    //Improve the complexity
    int ImpCompf(int n){

        T[0] = T[1] = 2;
        for(int i=2;i <= n;i++){
            T[i] = 0;
            for(int j=1; j < i; i++){
                T[i] += 2* T[j] * T[j-1];
            }
        }
        return T[n];
    }

    //Improve complexity further
    int ImpComf(int n){
        T[0] = T[1] = 2;
        T[2] = 2*T[0]*T[1];
        for(int i =3; i<=n;i++){
            T[i] = T[i-1]+2 * T[i-1]*T[i-2];
        }
        return T[n];
    }

    //Maximum Value Contiguous subsequence: Given an array of n numbers. Give an algorithm for finding a contiguous subsequence A(i) ...... Aj)
    //for which the sum of elements is maximum Example {-2, 11, -4, 13, -5, 2} -> 20 and {1,-3,4,-2,-1,6} -> 7
    int MaxContiguousSum(int A[], int n){
        int maxSum =0;
        for(int i=0;i<n;i++){
            for(int j = i; j<n;j++){
                int currentSum =0;
                for(int k = i;k<=j;k++){
                    currentSum += A[k];
                }
                if(currentSum > maxSum){
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }

    //Improve the complexity
    int MaxContiguousSumImp(int A[], int n){
        int maxSum =0;
        for(int i =0; i < n;i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += A[j];
                if(currentSum > maxSum){
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }

    //Dynamic Programming
    int MaxContiguousSumDynProg(int A[], int n){
        int M[] = new int[n];
        int maxSum = 0;
        if(A[0] > 0){
            M[0] = A[0];
        }else{M[0] = 0;}
        for(int i=1;i<n;i++){
            if(M[i-1] + A[i] > 0){
                M[i] = M[i-1] + A[i];
            }else{
                M[i] = 0;
            }
        }
        maxSum = 0;
        for(int i=0;i<n;i++){
            if(M[i] > maxSum) maxSum = M[i];
        }
        return maxSum;
    }

    //Alternative Solution
    int MaxContiguousSumAltSol(int A[], int n){
        int sumSoFar = 0, sumEndingHere = 0;
        for(int i=0;i<n;i++){
            sumEndingHere = sumEndingHere +A[i];
            if(sumEndingHere < 0){
                sumEndingHere = 0;
                continue;
            }
            if(sumSoFar < sumEndingHere){
                sumSoFar = sumEndingHere;
            }
        }
        return sumSoFar;
    }

    /* Given a sequence of n numbers A(1).... A(n) give an algorithm for finding a contiguous subsequence A(i) ... A(j)
     for which the sum of elements in the subsequence is maximum. Here the condition is we should not select two contiguous numbers */
    int maxSumWithNoTwoContiguousNumbers(int A[], int n){
        int M[] = new int[n+1];int i=0;
        M[0] = A[0];
        M[1] = A[0]>A[1]?A[0]:A[1];
        for(i=2; i <n;i++){
            M[i] = M[i-1] > M[i-2]+A[i] ? M [i-1] : M[i-2]+A[i];

        }
        return M[n-1];
    }

    //Catalan Numbers: How many binary search trees are there with n vertices
    int CatalanNumber(int n){
        if(n == 0) return 1;
        int count = 0;
        for(int i=1; i<= n;i++){
            count += CatalanNumber(i-1)*CatalanNumber(n-i);
        }
        return count;
    }

    //Improve the time complexity
    int Table[] = new int [1024];
    int CatalanNumbersImp(int n){
        if(Table[n] != 1){
            return Table[n];
        }
        Table[n]=0;
        for(int i=1;i<=n;i++){
            Table[n] += CatalanNumber(i-1)*CatalanNumber(n-i);
        }
        return Table[n];
    }

    //Matrix Product Parenthesization
    /* P is the size of matrices, Matrix i has the dimension P[i-1] * P[i].
    M[i,j] is the best cost of multiplying matrices i through j
    S[i,j] saves the multiplication point and we use this for back tracing
     */
    void MatrixChainOrder(int P[], int length){
        int n = length-1;
        int M[][] = new int[n][n];
        int S[][] = new int[n][n];
        for(int i=1;i<=n;i++){
            M[i][i] = 0;
            for(int l = 2; l<= n;l++){
                for(int j=1;j<=n-l+1;j++){
                    int z = j+l-1;
                    M[j][z] = Integer.MAX_VALUE;
                    for(int k = j; k<=z-1;k++){
                        int thisCost = M[z][k] + M[k+1][z] + P[i-1]*P[k]*P[z];
                        if(thisCost < M[i][z]){
                            M[i][z] = thisCost;
                            S[i][z]= k;
                        }
                    }
                }
            }
        }
    }

    /* Making change: Given n types of coin denominations of value v1<v2<....<vn Assume v1 = 1 so that we can always make change for any amount
      * of money C. Given an algorithm which changes for an amount of money C with as few coins as possible */
    int MakingChange(int n){
        int num_denomination = n;
        int denominations[] = new int[n];
        if(n < 0){return -1;}
        if(n == 0) return 0;
        if(Table[n] != -1){
            return Table[n];
        }
        int ans = -1;
        for(int i=0;i<num_denomination;++i){
            ans = Math.min(ans, MakingChange(n-denominations[i]));
        }
        return Table[n] = ans+1;
    }

    //Longest Increasing Subsequence : Given a sequence of n numbers A1 .... An, determine a subsequence (not necessarily contiguous)
    //of maximum length in which the values in the subsequences from a strictly increasing sequence.
    int LISTable[] = new int[1024];
    int LongestIncreasingSequence(int A[], int n){
        int i,j,max=0;
        for(i=0;i<n;i++){
            LISTable[i]=1;
        }
        for(i=0;i<n;i++){
            for(j=0;j<i;j++){
                if(A[i] > A[j] && LISTable[i] < LISTable[j] + 1){
                    LISTable[i] = LISTable[j] + 1;
                }
            }
        }
        for(i=0;i<n;i++){
            if(max < LISTable[i]){
                max = LISTable[i];
            }
        }
        return max;
    }

    //li represents optimal subsequence
    int LongestIncreasingOptimalSequence(int A[], int n) {
        int i, j, max = 0;
        for (i = 0; i < n; i++) {
            LISTable[i] = 1;
        }
        for(i=n-1;i>=0;i--){
            //try picking a larger second element
            for(j=i+1;j<n;j++){
                if(A[i] < A[j] && LISTable[i] < LISTable[j] + 1){
                    LISTable[i] = LISTable[j] + 1;
                }
            }
        }
        for(i=0;i<n;i++){
            if(max < LISTable[i]){
                max = LISTable[i];
            }
        }
        return max;
    }

    /* Subset Sum : Given a sequence of n positive numbers A1 ... An
    give an algorithm which checks whether there exists a subset of a whose sum of all numbers is T? */
    static int SubsetSum(int A[], int n, int T){
        int i,j,M[][] = new int [n+1][T+1];
        M[0][0] = 0;
        for(i=1;i<=T;i++){
            M[0][i] = 0;
        }
        for(i=1;i<=n;n++){
            for(j=0;j<=T;j++){
                M[i][j]= M[i-1][j - A[i]];
            }
        }
        return M[n][T];
    }

    public static void main(String args[]){
        int A[] = {3,2,4,19,3,7,13,10,6,11};
        int T = 17;
        System.out.println("Sum    "+SubsetHalfSum(A, A.length));
    }

    /* Given a set of n integers and sum of all numbers is at most K.
    Find the subset of these n elements whose sum is exactly half of the total sum of n numbers */
    static int SubsetHalfSum(int A[], int n){
        int K = 0;int T[] = new int[100];
        for(int i=0;i<=K;i++){
            K += A[i];
        }
        T[0] = 1;
        for(int i=1;i<=K;i++){
            for(int j = K-A[i]; j>=0;j--){
                if(T[j] != 0){
                    T[j+A[i]] = 1;
                }
            }
        }
        return T[K/2];
    }

    //Improving the performance
    int SubsetHalfSumEfficient(int A[], int n){
        int K = 0;
        for(int i=0;i<n;i++){
            K += A[i];
        }
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.InsertionSort(A,n);
        T[0] = 1;
        for(int i=1;i<=K;i++){
            T[i] = 0;
            int R = 0;
            for(i=0;i<n;i++){
                for(int j=R;j >= 0;j--){
                    if(T[j] != 1){
                        T[j+A[i]]=1;
                    }
                    R = Math.min(K/2, R+A[i]);
                }
            }
        }
        return T[K/2];
    }

    /* All pairs shortest path Problem, Floyd's Algorithm Given a weighted directed graph G = (V, E), where V = {1,2,3,...., n}.
     * Find the shortest path between any pair of nodes in the graph. Assume the weights are represented as the matrix C[V][V] where C[i][j]
     * indicates the weight (or cost) between the nodes i and j. also C[i][j] = infinity or -1 there is no path from i to j */
    void Floyd(int C[][], int A[][], int n){
        int i,j,k;
        for(i=0;i<=n;i++){
            for(j=0;j<=n-1;j++){
                A[i][j] = C[i][j];
            }
        }
        for(i=0;i<=n;i++){
            A[i][i] = 0;
        }
        for(k =0;k<=n-1;k++){
            for(i=0;i<=n-1;i++){
                for(j=0;j<=n-1;j++){
                    if(A[i][k] + A[k][j] < A[i][j]){
                        A[i][j] = A[i][k] +A[k][j];
                    }
                }
            }
        }
    }

    // Binary Search Tree node Declaration
    BinarySearchTreeNode OptimalBST(int A[], int F[], int low, int high){
        int r, minTime = 0;
        BinarySearchTreeNode root = new BinarySearchTreeNode();
        if(root == null){
            System.out.println("Memory Error");
            return null;
        }
        for(r=0;r<= high-1;r++){
            root.setLeft(OptimalBST(A, F, low, r-1));
            root.setRight(OptimalBST(A, F, r+1, high));
            root.setData(A[r]);
            if(minTime > A[root.getData()]){
                minTime = A[root.getData()];
            }
        }
        return root;
    }

    //Longest Palindrome Subsequence
    int LongestPalindromeSubsequence(int A[], int n){
        int max = 1;
        int i,j,k,L[][]=new int[n][n];
        for(i=1;i<=n-1;i++){
            L[i][i]=1;
            if(A[i] == A[i+1]){
                L[i][i+1] = 1;
                max = 2;
            }else{
                L[i][i+1] = 0;
            }
        }
        for(k=3;k<=n;i++){
            for(i = 1;i<=n-k+1;i++)
            {
                j = i+k-1;
                if(A[i] == A[j]){
                    L[i][j] = 2 + L[i+1][j-1];
                    max = k;
                }else{
                    L[i][j] = Math.max(L[i+1][j-1], L[i][j-1]);
                }
            }
        }
        return max;
    }

    //Longest Palindrome substring
    int LongestPalindromeSubstring(int A[], int n){
        int max = 1;
        int i,j,k,L[][] = new int[n][n];
        for( i =1; i<= n-1;i++){
            L[i][i] = 1;
            if(A[i] == A[i+1]){
                L[i][i+1] =1;
                max = 2;
            }else{
                L[i][i+1] = 0;
            }
        }
        for(k=3;k<=n;k++){
            for(i=1;i<=n-k+1;i++){
                j=i+k-1;
                if(A[i] == A[j] && L[i+1][j-1] != 0){
                    L[i][j] = 1;
                    max = k;
                }else{
                    L[i][j] = 0;
                }
            }
        }
        return max;
    }

    /* Given a matrix with n rows and m columns. In each cell there are a number of apples .We start from the upper left corner of the matrix
     * We can go down or right one cell. Finally we need to arrive to the bottom right corner. Find the maximum number of apples
     * that we can collect. When we pass through a cell we collect all the apples left there. */
    int FindApplesCount(int A[][], int n, int m){
        int S[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                S[i][j] = A[i][j];
                if(j>0 && S[i][j]<S[i][j]+S[i][j-1]){
                    S[i][j] += S[i][j-1];
                }
                if(i>0 && S[i][j] < S[i][j]+S[i-1][j]){
                    S[i][j] += S[i-1][j];
                }
            }
        }
        return S[n][m];
    }

    /* Maximum size square sub matrix with all 1's
    * 0  1  1  0  1
    * 1  1  0  1  0
    * 0  1  1  1  0
    * 1  1  1  1  0
    * 1  1  1  1  1
    * 0  0  0  0  0 */
    void MatrixSubSquareWithAllOnes(int B[][], int m, int n){
        int i,j,L[][] = new int[m][n], max_of_s, max_i, max_j;
        for(i=0;i<m;i++){
            L[i][0] = B[i][0];
        }
        for(j=0;j<n;j++){
            L[0][j] = B[0][j];
        }
        for(i=1;i<m;i++){
            for(j=1;j<n;j++){
                if(B[i][j] == 1){
                    L[i][j] = 1;//min(L[i][j-1], L[i-1][j], L[i-1][j-1])+1;
                }else{
                    L[i][j] = 0;
                }
            }
        }
        max_of_s = L[0][0]; max_i = 0; max_j=0;
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(L[i][j] > max_of_s){
                    max_of_s = L[i][j];
                    max_i =i;
                    max_j = j;
                }
            }
        }
        System.out.println("Maximum SubMatrix");
        for(i=max_i;i>max_i-max_of_s;i--){
            for(j=max_j;j>max_j-max_of_s;j--){
                System.out.println(B[i][j]);
            }
        }
    }

    //Maximum sum sub matrix
    void FindMaximumSumSubMatrix(int A[][], int n){
        int M[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j < n;j++){
                if(j==0){
                    M[i][j] = A[j][i];
                }else{
                    M[j][i] = A[j][i] +M[j-1][i];
                }
            }
        }
        int maxSoFar = 0;
        int min, subMatrix;
        //iterate over the possible combinations applying Kadane's Alg
        for(int i=0;i<n;i++){
            for(int j = i;j<n;j++){
                min = 0;
                subMatrix = 0;
                for(int k = 0; k<n; k++){
                    if(i==0){
                        subMatrix += M[j][k];
                    }else{
                        subMatrix += M[j][k] - M[i-1][k];
                    }
                    if(subMatrix < min){
                        min = subMatrix;
                    }
                    if((subMatrix - min)> maxSoFar){
                        maxSoFar = subMatrix - min;
                    }
                }
            }
        }
    }

    //Finding Optimal Number Of Jumps To reach Last Element
    int Max = 0;
    int jump(int array[], int n){
        int answer = 0;
        int result[] = new int[n];
        int i, j;
        if(n == 0 || array[0] == 0){
            return Max;
        }
        result[0] = 0;
        for(i=1;i<n;i++){
            result[i] = Max;
            for(j=0;j<i;j++){
                //check if jump is possible
                if(array[j] >= (i-j)){
                    //check if better solution is available
                    if((result[j]+1) < result[i]){
                        result[i] = result[j]+1;
                    }
                }
            }
        }
        answer = result[n-1];
        return  answer;
    }

    int[][] LCS = new int[1024][1024];
    //Longest Common Subsequence
    int LCSLength(int X[], int m, int Y[], int n){
        //base cases
        for(int i=0; i<=m;i++){
            LCS[i][n] =0;
        }for(int j=0;j <= n;j++){
            LCS[m][j] = 0;
        }
        for(int i=m-1; i>=0;i--){
            for(int j = n-1;j >=0;j--){
                LCS[i][j] = LCS[i+1][j+1];
                if(X[i] == Y[j]){
                    LCS[i][j]++;
                }
                if((LCS[i][j+1] > LCS[i][j])){
                    LCS[i][j] = LCS[i][j+1];
                }
                if(LCS[i+1][j] > LCS[i][j]){
                    LCS[i][j] = LCS[i+1][j];
                }
            }
        }
        return LCS[0][0];
    }

    //Longest Increasing subsequence
    public Integer[] LIS(Integer[] A) {
        int[] m = new int[A.length];
        //Arrays.fill(m, 1);//not important here
        for (int x = A.length - 2; x >= 0; x--) {
            for (int y = A.length - 1; y > x; y--) {
                if (A[x] < A[y] && m[x] <= m[y]) {
                    m[x]++;//or use m[x] = m[y] + 1;
                }
            }
        }
        int max = m[0];
        for (int i = 1; i < m.length; i++) {
            if (max < m[i]) {
                max = m[i];
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < m.length; i++) {
            if (m[i] == max) {
                result.add(A[i]);
                max--;
            }
        }
        return result.toArray(new Integer[0]);
    }

    // Give an algorithm for printing the matrix elements in spiral order
    void Spiral(int[][] values, int m, int n){
        int rowStart = 0, columnStart = 0;
        int rowEnd = m-1, columnEnd = n-1;
        while(rowStart <= rowEnd && columnStart < columnEnd){
            int i = rowStart, j= columnStart;
            for(j=columnStart; j <= columnEnd;j++){System.out.println(values[i][j]);}
            for(i = rowStart+1, j--;i <= rowEnd;i++){System.out.println(values[i][j]);}
            for(j=columnEnd-1, i--; j>=columnStart;j--){System.out.println(values[i][j]);}
            for(i=rowEnd -1, j++; i >= rowStart+1;i--){System.out.println(values[i][j]);}
            rowStart++; columnStart++; rowEnd--; columnEnd--;
        }
    }

    //Give an algorithm for shuffling the desk of cards
    void Shuffle(int[] cards, int n){
        for(int i=0;i<n;i++){
            cards[i]=i;
        }
        for(int i=0; i<n;i++){
            int r = (int) (i+(Math.random()*(n-i)));
            int temp = cards[i]; cards[i]=cards[r]; cards[r] = temp;
        }
        System.out.println("Shuffled Cards");
        for(int i=0; i<n;i++){
            System.out.println(cards[i]);
        }
    }

    /* Reversal Algorithm for array rotation. Write a function rotate(A[], d, n ) that rotates A[] of size n by d elements. For Example
    * 1,2,3,4,5,6,7 becomes 3,4,6,7,1,2 after 2 rotations*/
    void leftRotate(int[] Array, int d, int n){
        reverseArray(Array, 0, d-1);
        reverseArray(Array, d, n-1);
        reverseArray(Array, 0, n - 1);
    }
    void PrintArray(int[] Array, int size){
        for(int i=0; i < size; i++){
            System.out.println(Array[i]);
        }
    }

    void reverseArray(int Array[], int start, int end){
        int temp;
        while(start < end){
            temp = Array[start];
            Array[start] = Array[end];
            Array[end] = temp;
            start++;
            end--;
        }
    }

    /* Given a string that has set of words and spaces, write a program to move the spaces to front of string,
     * you need to traverse the array only once and need to adjust the string in place */
    void mySwap(char[] A, int i, int j){
        char temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    void moveSpacesToBegin(char[] A){
        int i = A.length -1;
        boolean[] isSpace = new boolean[2];
        int j=i;
        for(;j>=0;j--){
            if(A[j] != ' ' ){
                mySwap(A, i--, j);
            }
        }
    }

    /* Improve the complexity */
    void movSpacesToBegin(char[] A){
        int n = A.length-1, count = n;
        int i = n;
        for(;i>=0;i--){
            if(A[i] == ' '){
                A[count--] = A[i];
            }
        }
        while(count >= 0){
            A[count--]=' ';
        }
    }

    /* move spaces to the end */
    void moveSpacesToEnd(char[] A){
        int count =0;
        int n = A.length-1;
        int i =0;
        for(;i<=n;i++){
            if(A[i] != ' '){
                A[count++] = A[i];
            }
        }
        while(count <= n){
            A[++count] = ' ';
        }
    }

    /* Moving zeros to end */
    void moveZerosToEnd(int[] A){
        int i=0,j=0;
        while(i <= A.length - 1){
            if(A[i] != 0){
                A[j++] = A[i];
            }
            i++;
        }
        while(j<=A.length-1){
            A[j++]=0;
        }
    }

    //improve the complexity
    void mySwap(int A[], int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    void moveZerosToEnd(int A[], int len){
        int i,j;
        for(i=0,j=0;i<len;i++){
            if(A[i]  != 0){
                mySwap(A, j++,i);
            }
        }
    }
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
