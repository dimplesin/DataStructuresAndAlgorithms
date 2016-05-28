package com.company.amazon.BookKarumanchi.Algorithms.Sorting;

import com.company.amazon.BookKarumanchi.DataStructures.LinkedLists.ListNode;
import com.company.amazon.BookKarumanchi.Algorithms.PriorityQueuesAndHeaps.Heap;

/**
 * Created by v-dsindhi on 3/29/15.
 */
public class ProblemsOnSorting {
    Heap heap = new Heap(0,0);
    //Given an array A[0.....n-1] of n numbers containing repetition of some number.
    // Give an algorithm for checking whether there are repeated elements or not.
    // Assume that we are not allowed to use additional space.
    boolean CheckDuplicatesInArray(int A[], int n){
        for(int i = 0; i < n; i++){
            for(int j = i+1; j<n;j++){
                if(A[i] == A[j]){
                    return true;
                }
            }
        }
        return false;
    }

    //Can we improve the time Complexity?
    boolean CheckDuplicates(int A[], int n){
        //for heap sort algorithm
        heap.Heapsort(A,n);
        for(int i =0;i<n-1;i++){
            if(A[i] == A[i+1])
                return true;
        }
        return false;
    }

    /* Given an Array where each element of the array represents a vote in the election. Assume that each vote is given
     * as an integer representing the ID of the chosen candidate. Give an algorithm for determining who wins he election. */
    int CheckWhoWinsTheElection(int A[], int n){
        int i,j,counter=A[0],maxCounter=0,candidate = 0;
        for(i=0;i<n;i++){
            candidate = A[i];
            counter = 0;
            for(j = i+1; j<n;j++){
                if(A[i] == A[j]){
                    counter++;
                }
                if(counter > maxCounter){
                    maxCounter = counter;
                    candidate = A[i];
                }
            }
        }
        return candidate;
    }

    //Improving the Time Complexity
    int CheckWhoWinsTheElectionComp(int A[], int n){
        int i,j,currentCounter=1, maxCounter =1;
        int currentCandidate, maxCandidate;
        currentCandidate = maxCandidate = A[0];
        heap.Heapsort(A, n);
        for(i=0;i<n;i++){
            if(A[i] == currentCandidate){
                currentCounter ++;
            }else {
                currentCandidate = A[i];
                currentCounter = 1;
            }
            if(currentCounter > maxCounter){
                maxCounter = currentCounter;
            }else{
                maxCandidate = currentCandidate;
                maxCounter = currentCounter;
            }
        }
        return maxCandidate;
    }

    /* Let A and B be two arrays of n elements each. Given a number K, give an O(nlogn) time algorithm for determining whether
     there exists a E A and b E B such that a + b = K*/
    int Find(int A[], int B[], int n,int K){
        int i,c;
        heap.Heapsort(A,n);
        for(i=0;i<n;i++){
            c = K-B[i];
            //if(BinarySearch(A, c)){
              return 1;
            //}
        }
        return 0;
    }

    /* How do we find the number which appeared the maximum number of times in an array */
    void NumberAppearedMaxTime(int A[], int n){
       QuickSort quickSort = new QuickSort();
        quickSort.QuickSort(A, 0,n);
        int i,count=1,Number=A[0],j=1;
        for(i=1;i<n;i++){
            if(A[j] == A[i]){
                count++;
                Number = A[j];
            }
            j = i;
        }
        System.out.println("Number:"+Number+", count:"+count);
    }

    /* Which sorting method is better for LinkedList */
    ListNode LinkedListMergeSort(ListNode first){
        MergeSort mergeSort = new MergeSort();
        ListNode list1HEAD = null;
        ListNode list1TAIL = null;
        ListNode list2HEAD = null;
        ListNode list2TAIL = null;
        if(first == null || first.getNext() == null){
            return first;
        }
        while(first!=null){
            //Append(first, list1HEAD, list1TAIL);
            if (first != null){
                //Append(first, list2HEAD,list2TAIL);
            }
        }
        list1HEAD = LinkedListMergeSort(list1HEAD);
        list2HEAD = LinkedListMergeSort(list2HEAD);
        //Merge(list1HEAD,list2HEAD);
        return list1HEAD;
    }

    void Qsort(ListNode first, ListNode last){
        ListNode lesHEAD = null, lesTAIL = null;
        ListNode equHEAD = null, equTAIL = null;
        ListNode larHEAD = null, larTAIL = null;
        ListNode current = first;
        int pivot,info;
        if(current == null){
            return;
        }
        pivot = current.getData();
        //Append(current, equHEAD, equTAIL);
        while(current!= null){
            info = current.getData();
            if(info <pivot){
                //Append(current, lesHEAD, lesTAIL);
            }else if(info > pivot){
                //Append(current, larHEAD, larTAIL);
            }else{
                //Append(current, equHEAD, equTAIL);
            }
        }
        Qsort(lesHEAD, lesTAIL);
        Qsort(larHEAD, larTAIL);
        //Join(lesHEAD,lesTAIL,equHEAD,equTAIL);
        //Join(equHEAD,equTAIL,larHEAD, larTAIL);
        first = lesHEAD;
        last = larTAIL;
    }

    /* There are two sorted arrays A and B. First one is of size m+n containing only m elements. Another one is
     * of size n and contains n elements. Merge these two arrays into the first array of size m+n elements such
     * that the output is sorted */
    void Merge(int A[], int m, int B[], int n){
        int count = m;
        int i = n-1, j = count -1, k = m - 1;
        for(;k>=0;k--){
            if(B[i] > A[j] || j < 0){
                A[k] = B[i];
                i--;
                if(i<0){
                    break;
                }
            }else{
                A[k] = A[j];
                j--;
            }
        }
    }
}
