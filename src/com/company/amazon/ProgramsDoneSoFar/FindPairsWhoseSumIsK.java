package com.company.amazon.ProgramsDoneSoFar;

import java.util.Arrays;

/**
 * Created by v-dsindhi on 6/23/15.
 */
public class FindPairsWhoseSumIsK {
    static int pairs(int[] a,int k) {
  /* Complete this function */
        int temp;
        int len=a.length;
        int count=0;
        int beg;
        int mid;
        int end;
        int midVal;
        Arrays.sort(a);
        for(int i=0;i<len-1;i++){
            temp=k-a[i]; // For difference a[i]+k
            beg=i+1;
            end=len-1;
            for(int l=beg;l<len;l++){
                mid=(beg+end)/2;
                midVal=a[mid];
                if(midVal==temp){
                    System.out.println(a[i]+","+midVal);
                    count++;
                    break;
                }
                else if(midVal>temp){
                    end=mid-1;
                }
                else{
                    beg=mid+1;
                }
            }

        }
        return count;
    }

    public static void main(String args[]){
        int arr[] = {1,2, 3,4,7,8,9,11};
        pairs(arr, 7);
    }

}
