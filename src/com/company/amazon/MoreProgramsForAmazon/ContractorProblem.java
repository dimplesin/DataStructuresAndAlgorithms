package com.company.amazon.MoreProgramsForAmazon;

import java.util.Arrays;


public class ContractorProblem {
	/*
	 *There is a 12 km road and a contractor who is in-charge of repairing it. 
	 * Contractor updates you about the work which is done in patches. 
	 * Like �Road between 3.2 km to 7.9 km repaired �, �Road between 1.21 km to 3.2 km repaired�. 
	 * You have a manager who enquires about the longest continuous patch so far. 
	 */
	 

	boolean acompare(updates a, updates b){
	return a.start < b.start;	
	}
	void longestContinuousPatch(updates inputs[],int numberOfInputs){
			//Arrays.sort(inputs,inputs+numberOfInputs,acompare);
			//for(int i=0;i<numberOfInputs;i++){
				//	printf("%f %f",inputs[i].start, inputs[i].end);
			//}
			
			float iStart =inputs[0].start, iEnd = inputs[0].end;
			int prev = 0;
			for(int i=0;i<numberOfInputs-1 ;i++){
				
					if(inputs[i].end == inputs[i+1].start){
						if(inputs[prev].end != inputs[i].start)
							iStart = inputs[i].start;
						iEnd = inputs[i+1].end;
					}
					prev = i;
				
			}
			System.out.println(iStart +"****"+ iEnd);
		
	}


	boolean dupAtKdistance(int arr, int len){
		
		//use hash set 
		/*run a loop until length of arr
		 * if(set.contains(arr[i])
		 * return true;
		 * 
		 * set.add(arr[i]);
		 * 
		 * 
		 */ 
		
		return true;
	}


	void minimizeTransactions(int arr,int row, int col){
		
		
		
	return;	
	}
}
