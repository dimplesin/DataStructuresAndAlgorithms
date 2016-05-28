package com.company.amazon.MoreProgramsForAmazon;

import java.util.PriorityQueue;


public class ClosetMillionStartsToEarth {
	public Star[] findClosest(Star[] sky, int K) {
		PriorityQueue<Star> pq = new PriorityQueue<Star>();
		int N = sky.length;
		if (N <= K) 	return sky;
		for (int k = 0; k < K; k++)
			pq.add(sky[k]);
		for (int k = K; k < N; k++) {
			Star mystar = sky[k];
			if ( less(mystar, pq.peek()) ) {
				pq.remove();
				pq.add(mystar);
			}
		}
		return(Star[]) pq.toArray();
	}

	private boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	public class Star implements Comparable<Star> {
		public int id;
		public float dst;

		public int compareTo(Star other) {
			if (this.dst > other.dst) 	return 1;
			if (this.dst < other.dst) 	return -1;
			return 0;
		}
	}
}
