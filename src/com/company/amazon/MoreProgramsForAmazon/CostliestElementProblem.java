package com.company.amazon.MoreProgramsForAmazon;

import java.util.Arrays;


public class CostliestElementProblem<E extends Comparable>{
		private int N, size;
		private E[] heap;
		
		public CostliestElementProblem(int maxSize) {
			this.size = 0;
			this.N = maxSize;
			this.heap = (E[]) new Object[N+1]; 
			Arrays.fill(this.heap, null);
		}
		
		public void add(E item) {
			if (size == N)	throw new IndexOutOfBoundsException("Heap is full");
			heap[++size] = item;
			swim(size);	
		}

		public E remove() {
			if (size == 0)	throw new IndexOutOfBoundsException("Heap is empty");
			E item = heap[1];
			heap[1] = heap[size]; 	// replace 1st with last
			heap[size--] = null; 		// decrement size, avoid loitering
			sink(1);				// sink replaced item
			return item;
		}

		public int size() { return this.size;}
		public boolean isEmpty() {return this.size == 0;}
		
		private void sink(int i) {
			while (2*i < size) {
				int j = 2*i;
				if (j <= size && less(j, j+1)) 	j++;
				if ( less(i, j) ) 		swap(i, j);
				else 				break;
				i = j;
			}
		}
		private void swim(int i) {
			while (i > 1 && less(i/2, i)) {
				swap(i, i/2);
				i /= 2;
			}
		}
		private boolean less (int i, int j) { return heap[i].compareTo(heap[j]) < 0; }
		
		private void swap(int i, int j) {
			E aux = heap[i];
			heap[i] = heap[j];
			heap[j] = aux;
		}
	
}
