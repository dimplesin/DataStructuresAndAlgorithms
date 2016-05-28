package com.company.amazon.BookKarumanchi.Algorithms.Searching;

import com.company.amazon.BookKarumanchi.Algorithms.Sorting.InsertionSort;

/**
 * Created by v-dsindhi on 3/30/15.
 */
public class ProblemsOnSearching {

    /* Given an array of n number, give an algorithm  for checking whether there are any duplicate element in the array or not */
    void CheckDuplicatesBruteForce(int A[], int n){
        for(int i=0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(A[i] == A[j]){
                    System.out.println("Duplicates exists:"+A[i]);
                    return;
                }
            }
        }
        System.out.println("No duplicates in given array");
    }

    //Can we improve the complexity?
    void CheckDuplicatesSorting(int A[], int n){
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.InsertionSort(A, n);
        for(int i = 0; i < n-1; i++){
            if(A[i] == A[i+1]){
                System.out.println("Duplicate exists:"+A[i]);
                return;
            }
        }
        System.out.println("No duplicates in given array");
    }

    //Alternative way
    void CheckDuplicates(int A[], int n){
        for(int i=0;i<n;i++){
            if(A[Math.abs(A[i])] < 0){
                System.out.println("Duplicates exists:"+A[i]);
                return;
            }
        }
        System.out.println("No duplicates in given array");
    }

    /* Given an array of n numbers. Give an algorithm for finding the element which appears maximum number of times in the array. */
    int CountMaximumDuplicatesBruteForce(int A[], int n){
        int counter = 0,max = 0;
        for(int i=0;i<n;i++){
            counter = 0;
            for(int j=0;j<n;j++){
                if(A[i] == A[j]){
                    counter++;
                }
            }
            if(counter >max){
                max = counter;
            }
        }
        return max;
    }

    //Max Repetition
    int MaxRepititions(int A[],int n){
        int i=0,max=0,maxIndex=0;
        for(i=0;i<n;i++){
            A[A[i]%n] += n;
        }
        for(i=0;i<n;i++){
            if(A[i]/n > max){
                max = A[i]/n;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

     //Finding the missing number
    int FindMissingNumber(int A[],int n){
        int i,j,found = 0;
        for(i=1;i<n;i++){
            found = 0;
            for(j=0;j<n;j++){
                if(A[j] == i){
                    found=1;
                }
                if(found != 1){
                    return i;
                }
            }
        }
        return -1;
    }

    //If the sum of the numbers goes beyond maximum allowed integer then there can be integer overflow and we may not get correct answer.
    int FindMissingNumberOverflow(int A[],int n){
        int i,X=0,Y=0;
        for(i=0;i<n;i++){
            X ^= A[i];
        }for(i=1;i<n;i++){
            Y ^= i;
        }
        return X^Y;
    }

    //Find the two repeating elements in a given array
    void PrintRepeatedElements(int A[],int n){
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(A[i] == A[j]){
                    System.out.println(A[i]);
                }
            }
        }
    }

    //Alternative way of solving
    void PrintRepeatedElementsUsingXOR(int A[],int size){
        int XOR = A[0];
        int i, right_most_set_bit_no, X=0,Y=0;
        /* Compute XOR for all elements in A[] */
        for(i=1;i<size;i++){ XOR^=A[i];}
        /* Compute XOR of all elements {1,2.....n} */
        for(i=0;i<=size-1;i++){XOR ^= i;}
        //Get the rightmost set bit in right_most_set_bit_no
        right_most_set_bit_no = XOR & ~(XOR-1);
        /*Now divide elements in two sets by comparing rightmost set*/
        for(i=0;i<size;i++){
            if(A[i] != 0 && right_most_set_bit_no != 0){
                X = X ^ A[i]; /*XOR first set in A[]*/
            }else { Y = Y^A[i];} // XOR of second set in A[]
        }
        for(i=1;i<=size;i++){
            if(i != 0 && right_most_set_bit_no != 0){
                  X = X ^ i;
            }else{
                Y = Y ^ i;
            }
        }

        System.out.println("Values X: "+X+" and Y:"+Y);
    }

    /* Given an array of n elements. Find two elements in the array such that there sum is equal to given element K */
    void BruteForceSearch(int A[], int n, int K){
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(A[i] + A[j] == K){
                    System.out.println("Items Found, i:"+i+" j:"+j);
                    return;
                }
            }
        }
        System.out.println("Items not found: No such elements.");
    }

    //Improving time complexity
    void Search(int A[], int n, int K){
        int i,j,temp;
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.InsertionSort(A, n);
        for(i=0,j=n-1;i<j;){
            temp = A[i] + A[j];
            if(temp == K){
                System.out.println("Items Found, i:"+i+" j:"+j);
            }else if(temp <K){
                i = i+1;
            }else{j = j-1;}
        }
        return;
    }

    //Given an array A of n elements. Find three elements, i,j and k in the array such that A[i]2 + A[j]2 = A[k]2?
    void SearchThreeElements(int A[], int n, int K) {
        int i, j, temp;
        boolean res;
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.InsertionSort(A, n);
        for (i = 0; i < n; i++) {
            A[i] = A[i] * A[i];
        }
        for (i = n; i > 0; i--) {
            res = false;
            if (res) {
                System.out.println(FindMissingNumber(A, n));
            }
        }
    }

    //Find two elements whose sum is closet to the zero
    void TwoElementsWithMinSum(int A[], int n){
        int i,j,min_sum, sum, min_i,min_j,inv_count = 0;
        if(n < 2){
            System.out.println("Invalid Input");
            return;
        }
        /*Initialization of values*/
        min_i = 0;
        min_j = 0;
        min_sum = A[0] + A[1];
        for(i=0;i<n-1;i++){
            for(j=i+1;j<n;j++){
                sum = A[i]+A[j];
                if(Math.abs(min_sum) > Math.abs(sum)){
                    min_sum = sum;
                    min_i = i;
                    min_j = j;
                }
            }
        }
        System.out.println("The two elements are "+A[min_i]+" and "+A[min_j]);
    }

    //Improve the time complexity
    void TwoElementsWithMinimumSum(int A[], int n){
        int i=0, j = n-1, temp, positiveClosest = Integer.MAX_VALUE, negativeClosest = Integer.MIN_VALUE;
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.InsertionSort(A, n);
        while(i<j){
            temp = A[i]+A[j];
            if(temp > 0){
                if(temp < positiveClosest){
                    positiveClosest = temp;
                    j--;
                }else if (temp < 0){
                    if(temp < negativeClosest){
                        negativeClosest = temp;
                        i++;
                    }
                }else{
                    System.out.println("Closest sum: %d" + A[i] + A[j]);
                }
            }
        }
       // return (Math.abs(negativeClosest) > positiveClosest : positiveClosest:negativeClosest);
    }

    //Given an array of n elements. Find three elements in the array such that their sum is equal to given element K
    void BruteForceSearchThreeEle(int A[], int n, int data){
        for(int i=0;i<n;i++){
            for(int j=i+1;i<n;i++){
                for(int k = j+1;k<n;k++){
                    if(A[i]+A[j]+A[k] == data){
                        System.out.println("Items Found, i: "+i+" ,j: "+j+" and k: "+k);
                        return;
                    }
                }
            }
        }
        System.out.println("Items not found, no such elements.");
    }

    //Using Sorting Technique
    void SearchThreeEle(int A[], int n, int data){
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.InsertionSort(A, n);
        for(int k=0;k<n;k++){
            for(int i=k+1,j=n-1;i<j;){
                if(A[i]+A[j]+A[k] == data){
                    System.out.println("Items Found, i: "+i+" ,j: "+j+" and k: "+k);
                    return;
                }else if(A[k]+A[i]+A[j]<data){
                    i=i+1;
                }else{
                    j=j-1;
                }
            }
        }
    }

    //Let us assume that the given array is sorted but starts with negative numbers and ends with positive numbers.
    //In this array find the starting index of positive numbers.Assume that we know the length of the input array. Design a O(log n) number.
    int Search(int A[], int n){
        int mid,first=0,last=n-1;
        while(first<last){
            // if the current array has size 1
            if(first == last){ return A[first];}
            //if the current array has size 2
            else if(first == last-1){return Math.max(A[first],A[last]);}
            //if the current array has size 3 or more
            else{
                mid = first + (last-first)/2;
                if(A[mid-1] < A[mid] && A[mid] >A[mid+1]){
                    return A[mid];
                }else if(A[mid-1] < A[mid] && A[mid] < A[mid+1]){
                    first = mid+1;
                }else if(A[mid-1] > A[mid] && A[mid] > A[mid+1]){
                    last = mid-1;
                }else{
                    return Integer.MIN_VALUE;
                }
            }
        }
        return Integer.MIN_VALUE;
    }

    // Given a sorted array of n integers that has been rotated an unknown number of times,
    // give a O(log n) algorithm that finds an element in the array.
    int FindPivot(int A[],int start, int finish){
        int mid;
        if(finish - start == 0){
            return start;
        }else if(start == finish-1){
            if(A[start] >= A[finish]){
                return start;
            }else{
                return finish;
            }
        }else{
            mid = start +(finish-start)/2;
            if(A[start] >= mid){
                return FindPivot(A,start, mid);
            }else{
                return FindPivot(A,mid,finish);
            }
        }
    }
    int SearchData(int A[],int n, int x){
        int pivot = FindPivot(A,0,n-1);
        if(A[pivot] == x) return pivot;
        if(A[pivot] <= x){
            return BinarySearch(A,0,pivot-1,x);
        }else{
            return BinarySearch(A,pivot+1, n-1, x);
        }
    }
    int BinarySearch(int A[], int low, int high, int x){
        if(high >= low){
            int mid = low+(high-low)/2;
            if(x == A[mid]) return mid;
            if(x > A[mid]){
                return BinarySearch(A, mid+1, high, x);
            }else {
                return BinarySearch(A, low, mid - 1, x);
            }
        }
        return -1;
    }

    //Alternative Solution to solve in one scan
    int BinarySearchRotated(int A[], int start, int finish, int data){
        if(start > finish) return -1;
        int mid = start + (finish - start)/2;
        if(data == A[mid]) return mid;
        else if(A[start] <= A[mid]){
            if(data >= A[start] && data < A[mid]){
                return BinarySearchRotated(A, start, mid-1, data);
            }else{
                return BinarySearchRotated(A, mid+1, finish, data);
            }
        }else{
            if(data > A[mid] && data <= A[finish]){
                return BinarySearchRotated(A, mid+1, finish, data);
            }else{
                return BinarySearchRotated(A, start, mid -1, data);
            }
        }
    }

    //Given a sorted array A of n elements, possibly with duplicates, find the index of the first occurrence of a number in O(log n) time
    int BinarySearchFirstOccurrence(int A[], int low, int high, int data){
        if(high > low){
            int mid = low+(high-low)/2;
            if((mid == low && A[mid] == data) || (A[mid] == data && A[mid-1] < data)){
                return mid;
            }else if (A[mid] >= data){
                return BinarySearchFirstOccurrence(A, low, mid - 1, data);
            }else{
                return BinarySearchFirstOccurrence(A, mid+1, high, data);
            }
        }
        return -1;
    }

    //Given a sorted array A of n elements, possibly with duplicates. Find the index of the last occurrence of a number in O(log n) time.
    int BinarySearchLastOccurrence(int A[], int low, int high, int data){
        if(high >= low){
            int mid = low + (high - low)/2;
            if((mid == high && A[mid]==data) || (A[mid] == data && A[mid+1]>data)){
                return mid;
            }else if(A[mid] <= data){
                return BinarySearchLastOccurrence(A, mid+1, high, data);
            }else{
                return BinarySearchLastOccurrence(A, low, mid-1, data);
            }
        }
        return -1;
    }

    //Given a sorted array of n elements, possibly with duplicates. Find the number of occurrences of a number
    int LinearSearchCount(int A[], int n, int data){
        int count = 0;
        for (int i=0;i<n;i++){
            if(A[i] == data){
                count++;
            }
        }
        return count;
    }

    //An element is a majority if it appears more than n/2 times. Give an array of n element as an argument and identifies a majority.
    int majorityNum(int A[],int n){
        int majNum, count=0,element = -1;
        for(int i=0;i<n;i++){
            if(count == 0){
                element = A[i];
                count = 1;
            }else if(element == A[i]){
                count ++;
            }else{
                count--;
            }
        }
        return element;
    }

    //Given an array with 2n+1 integer elements, n elements appear twice in arbitrary places
    // in the array and a single integer only once somewhere inside.
    // Find the lonely integer with O(n) operations and O(1) extra memory
    int Solution(int A[], int n){
        int i,res;
        for(i=res=0; i < (2*n+1);i++){
            res = res ^ A[i];
        }
        return res;
    }


    //Separate Even or Odds
    void DutuchNationalFlag(int A[], int n){
        int left = 0, right = n-1;
        while(left < right){
            /* Increment left index while we see 0 at left*/
            while(A[left]%2 == 0 && left < right){
                left ++;
            }
            /* Decrement right index while we see 1 at right*/
            while(A[right]%2 == 1 && left < right){
                right --;
            }
            if(left < right){
                /* Swap A[left] and A[right] */
                swap(A[left], A[right]);
                left ++;
                right--;
            }
        }
    }

    //Separate 0's and 1's in an array We are given an array of 0's and 1's in random order.
    // Separate 0's on left and 1's on right side of the array. Traverse the array only once.
    //Input array  : {0,1,0,1,0,0,1,1,1,0}
    //Output array : {0,0,0,0,0,1,1,1,1,1}
    void Separate0and1(int A[], int n){
        /* Initialize left and right indexes */
        int left = 0, right = n-1;
        while(left < right){
            /* Increment left index when we see 0 at left */
            while(A[left] == 0 && left < right){
                left++;
            }
            /* Decrement right index when we see 1 at right */
            while(A[right] == 1 && left < right){
                right--;
            }
            /* If left is smaller than right then there is a 1 at left */
            if(left < right){
                A[left] = 0;
                A[right] = 1;
                left++;
                right--;
            }
        }
    }

    //Sort an array of 0's, 1's and 2's
    void Sorting012sDutuchFlagProblem(int A[], int n){
        int low = 0, mid = 0, high = n-1;
        while(mid < high){

            switch(A[mid]){
                case 0:
                    swap(A[low], A[mid]);
                    low++; mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(A[mid], A[high]);
                    high--;
                    break;
            }
        }
    }

    // Given a number n, give an algorithm for finding the number of trailing zeros in n!
    int NumberOfTrailingZerosInNumber(int n){
        int i, count=0;
        if(n<0){
            return -1;
        }
        for(i=5;n/i > 0;i*=5){
            count += n/i;
        }
        return count;
    }

    //Given an array of 2n integers in the following format a1, a2, a3 and b1, b2, b3
    // Shuffle the array to a1b1a2b2a3b3....anbn without any extra memory
    void ShuffleArray(){
        int n = 4, A[] = {1,3,5,7,2,4,6,8};
        for(int i=0,q=1,k=n;i<n;i++,q++,k++){
            for(int j=k;j>i+q;j--){
                int tmp = A[j-1];
                A[j-1] = A[j];
                A[j] = tmp;
            }
        }
        for(int i=0; i < 2*n;i++){
            System.out.println(A[i]);
        }
    }

    //Given an array A[], find the maximum j - i such that A[j] <A[i]. For example, Input {34,8,10,3,2,80,30,1} and Output :6 {j=7,i=1}
    int maxIndexDiff(int A[],int n){
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

    //given an array of elements, how do you check whether the list is pairwise sorted or not?
    // A list is considered pairwise sorted if each successive pair of numbers is in sorted order
    public boolean isPairWiseSorted(int A[], int n){
        if(n == 0 || n == 1){
            return true;
        }
        for(int i=0;i<n-1;i += 2){
            if(A[i] > A[i+1]){
                return false;
            }
        }
        return true;
    }

    private void swap(int i, int j) {
        int temp = i;
        i=j;
        j=temp;
    }


    public static void main(String args[]){
        ProblemsOnSearching problemsOnSearching =new ProblemsOnSearching();
        problemsOnSearching.ShuffleArray();
    }
}
