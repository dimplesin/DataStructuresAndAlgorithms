package com.company.amazon.MoreProgramsForAmazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FindTwoMissingNumbersFromArray {
	public void findNumbers(int[] a, int B){
	    int x=0;
	    for(int i=0; i<a.length;i++){
	        x=x^a[i];
	    }
	    for(int i=1;i<=B;i++){
	        x=x^i;
	    }
	    x = x &(~(x-1));
	    int p=0, q=0;
	    for(int i=0;i<a.length;i++){
	        if((a[i] & x) == x){
	            p=p^a[i];
	        }
	        else{
	            q=q^a[i];
	        }   
	    }
	    for(int i=1;i<=B;i++){
	        if((i & x) == x){
	            p=p^i;
	        }
	        else{
	            q=q^i;
	        }
	    }

	    System.out.println("p: "+p+" : "+q);
	}
	
	public List<Integer> find(int[] input){
		  int[] a= new int[] {1,2,3,4,5};//create a new array without missing numbers
		  List<Integer> l = new ArrayList<Integer>();//list for missing numbers
		  Map<Integer,Integer> m = new HashMap<Integer, Integer>();

		  //populate a hashmap with the elements in the new array
		  for(int i=0;i<input.length;i++){  
		   m.put(input[i], 1);
		  }
		//loop through the given input array and check for missing numbers
		 for(int i=0;i<a.length;i++){
		  if (!m.containsKey(input[i]))
		   l.add(input[i]);
		}
		 return l;
		}
}
