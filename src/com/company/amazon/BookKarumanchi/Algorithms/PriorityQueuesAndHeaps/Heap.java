package com.company.amazon.BookKarumanchi.Algorithms.PriorityQueuesAndHeaps;

import com.company.amazon.BookKarumanchi.DataStructures.Queues.DoubleEndQueue;

/**
 * Created by v-dsindhi on 3/26/15.
 */
public class Heap {

    public int[] array;
    public int count;
    public int capacity;
    public int heap_type;

    public Heap(int capacity, int heap_type){
        this.heap_type = heap_type;
        this.count = 0;
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    public Heap(){

    }
    public int Parent(int i){
        if(i <= 0 || i >= this.count){
            return -1;
        }
        return i-1/2;
    }

    public int LeftChild(int i){
        int left = 2 * i + 1;
        if( left >= this.count )
            return -1;
        return left;
    }

    public int RightChild(int i) {
        int right = 2 * i + 2;
        if(right >= this.count)
            return -1;
        return right;

    }
    public boolean isEmpty(){
        if(this.count == 0){
            return true;
        }
        return false;
    }
    public int GetMaximum(int i) {
        if(this.count == 0){
            return -1;
        }
        return this.array[0];
    }
    //Heapifying the element at location i
    public void PercolateDown(int i){
        int l, r, max, temp;
        l = LeftChild(i);
        r = RightChild(i);
        if(l != -1 && this.array[l] >= this.array[i]){
            max = l;
        }else {max = i;}
        if(r != -1 && this.array[r] >= this.array[i]){
            max = r;
        }
        if(max != i){
            //Swap this.array[i] with this.array[max]
            temp = this.array[i];
            this.array[i] = this.array[max];
            this.array[max] = temp;
        }
        PercolateDown(max);
    }

    //Deleting an element
    public int DeleteMax(){
        if(this.count == 0) return -1;
        int data = this.array[0];
        this.array[0] = this.array[this.count - 1];
        this.count --;
        PercolateDown(0);
        return data;
    }

    //Inserting an element
    public int Insert(int data){
        int i = 0;
        if(this.count == this.capacity)
            ResizeHeap();
        this.count++;
        i = this.count - 1;
        while(i >= 0 && data > (int)this.array[(i-1)/2]){
            this.array[i] = this.array[(i-1)/2];
            i = i-1/2;
        }
        this.array[i] = data;
        return data;
    }

    public void ResizeHeap(){
        int[] array_old = new int[this.capacity];
        System.arraycopy(this.array, 0, array_old, 0, this.count-1);
        this.array = new int[this.capacity * 2];
        if(this.array == null){
            System.out.println("Memory Error");
            return;
        }
        for(int i = 0; i < this.capacity; i++){
            this.array[i] = array_old[i];
        }
        this.capacity *= 2;
        array_old = null;
    }

    //Destroying Heap
    public void DestroyHeap(){
        this.count = 0;
        this.array = null;
    }

    //Heapifying the Array
    public void BuildHeap(Heap h, int A[], int n){
        if(h == null) return;
        while(n > this.capacity){
            h.ResizeHeap();
        }
        for(int i=0; i< n;i++){
            h.array[i] = A[i];
        }
        this.count = n;
        for(int i = (n-1)/2; i >= 0; i--){
            h.PercolateDown(i);
        }
    }

    //Heapsort
    public void Heapsort(int A[], int n) {
        Heap h = new Heap(n, 0);
        int old_size, i, temp;
        BuildHeap(h, A, n);
        old_size = h.count;
        for (i = n - 1; i > 0; i--) { //h.array[0] is the largest
            temp = h.array[0];
            h.array[0] = h.array[h.count - 1];
            h.count--;
            h.PercolateDown(i);
        }
        h.count = old_size;
    }


    /* given a min heap, give an algorithm for finding the maximum element. */
    public int FindMaxInMinHeap(Heap h){
        int Max = -1;
        for(int i = (h.count+1)/2; i < h.count; i++){
            if(h.array[i] > Max){
                Max = h.array[i];
            }
        }
        return Max;
    }

    /* Give an algorithm for deleting the ith indexed element in a given min-heap */
    public int Delete(Heap h, int i){
        int key;
        if(this.count < i){
            System.out.println("Wrong position"); return -1;
        }
        key = h.array[i];
        h.array[i]=h.array[h.count-1];
        h.count--;
        h.PercolateDown(i);
        return key;
    }

    /* Give an algorithm for finding the kth smallest element in min-heap
    * Time Complexity   O(klogn)*/
    public int FindKthLargestElement(Heap h, int k){
        //Just delete first k-1 elements and return the k-th element.
        for(int i=0;i<k-1;i++){
            h.Delete(h, i);
        }
        return h.Delete(h,k);
    }

    //improving time complexity
    Heap HOrig, HAux;
    int FindKthLargestEle(int k){
        int heapElement;
        int count=1;
        HAux.Insert(HOrig.DeleteMax());
        while(true){
            //returning the maximum element and delete it from the HA heap
            heapElement = HAux.DeleteMax();
            if(++count == k){
                return heapElement;
            }else{
                //insert the left and right children in HO into the HA
                HAux.Insert(HOrig.LeftChild(count));
                HAux.Insert(HOrig.RightChild(count));
            }
        }
    }

    //How do we implement stack using heap
    Heap PQ;int c=0;
    void Push(int element){
        PQ.Insert(element);
        c--;
    }
    int Pop(){
        return DeleteMax();
    }
    int Top(){
        return PQ.GetMaximum(c);
    }
    int Size(){
        return PQ.Size();
    }
    boolean isEmptyStack(){
        return PQ.isEmpty();
    }

    //Implement Queue using heap
    //Maximum sum in sliding window
    void MaxSlidingWindow(int A[], int n, int w, int B[]){
        DoubleEndQueue Q = new DoubleEndQueue();
        for(int i=0;i<w;i++){
            while(!Q.isEmpty() && A[i] >= A[Q.peakRear()]){
                Q.removeRear();
            }
            Q.insertRear(i);
        }
        for(int i=w;i<n;i++){
            B[i-w]=A[Q.peakFront()];
            while(!Q.isEmpty() && A[i] >= A[Q.peakRear()])
                Q.removeRear();
            while(!Q.isEmpty() && Q.peakFront() <= i-w)
                Q.removeFront();
            Q.insertRear(i);
        }
        B[n-w] = A[Q.peakFront()];
    }
}
