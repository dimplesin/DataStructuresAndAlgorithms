package com.company.amazon.BookKarumanchi.Challenges;

/**
 * Created by v-dsindhi on 6/18/15.
 */
public class MinVal {

    static int[] a={0,0,0,0,0,1};

    public int returnCount(int arr[],int low,int high) {

        if(high >=low) {
            int mid = (low+high)/2;
            //System.out.println(mid);
            if(mid == 0 && a[mid]==0) {
                return mid+1;
            }
            if((mid == 0 || a[mid-1]==0)&& a[mid]==1) {
                return mid;
            }
            if (a[mid]==1) {
                return returnCount(arr,low,mid-1);
            } else {
                return returnCount(arr,mid+1,high);
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MinVal minVal = new MinVal();
        int mid = minVal.returnCount(a, 0, a.length-1);
        System.out.println(mid);
    }
}

