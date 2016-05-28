package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/26/15.
 */
public class FindTrianglePairs {

    public static void findTrPairs(int[] arr,int origin,int elIndex,int runnerInd){
        if(elIndex>=arr.length-1||origin>=arr.length) return;
        if(elIndex<=arr.length && runnerInd<=arr.length && origin<=arr.length && elIndex!=runnerInd){
            if(arr[origin]+arr[elIndex]>arr[runnerInd]){
                System.out.println("{"+arr[origin]+","+arr[elIndex]+","+arr[runnerInd]+"}");
            }
            if(elIndex+1==runnerInd) runnerInd++;
            if(runnerInd<=arr.length-1){
                findTrPairs(arr,origin,++elIndex,runnerInd);
            }
            else{
                elIndex = origin+2;
                runnerInd = origin+3;
                findTrPairs(arr,++origin,elIndex,runnerInd);
            }

        }
        else if(origin<arr.length && elIndex<arr.length-1){
            elIndex = origin+2;
            runnerInd = origin+3;
            findTrPairs(arr,++origin,elIndex,runnerInd);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {3,5,6,9,10};//3 5 6 9 10
        findTrPairs(arr, 0, 1, 2);
    }
}
