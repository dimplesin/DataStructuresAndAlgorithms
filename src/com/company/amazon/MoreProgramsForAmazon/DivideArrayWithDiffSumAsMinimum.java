package com.company.amazon.MoreProgramsForAmazon;

import java.util.Vector;

 
public class DivideArrayWithDiffSumAsMinimum {
	//An array of numbers is give. Write algorithm to divide this array
	//in two subarrays such that difference of sum between these subarrays is minimum
	static int MIN(int x,int y){
		return ( (x < y) ? x : y);
	 }

	static int abs(int x) {
	  return ((x < 0) ? (-1*x) : x);
	}

	static int divide(int[] a, int i, int X, int Y) {
	  if(i >= a.length) {
	    return abs(X-Y);
	  } else {
	    int x1 = divide(a, i+1, X+a[i], Y);
	    int x2 = divide(a, i+1, X, Y+a[i]);
	    return MIN(x1, x2);
	  }
	}

	public static void main(String args[]) {
	 int a[] = {8,9,4,5,4,7,8,9,6,7};
	  System.out.println("Min diff : "+divide(a, 0, 0, 0));
	  
	  /*if sum(A) < sum(B):
      		A.add(n)
      else:
         B.add(n)*/
	}
}
