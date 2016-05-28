package com.company.amazon.ProgramsDoneSoFar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by v-dsindhi on 6/26/15.
 */
/*
 Given a array of positive integers, find all possible triangle triplets that can be formed from this array.
eg: 9 8 10 7
ans: 9 8 10, 9 8 7, 9 10 7, 7 8 10
Note : array not sorted
 */
public class TriangleTriplet {


    public void triangleTriplet(int a[])
    {
        int n=a.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=0;j<n;j++)
                {
                    if(i!=j && j!=k && i!=k)
                        if(a[i]+a[j]>a[k]  && a[j]+a[k]>a[i] && a[i]+a[k]>a[j])
                        {
                            System.out.println(a[i]+" "+a[j]+" "+a[k]);
                        }
                }
            }
        }
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int a[]={9,8,7,10};

        new TriangleTriplet().triangleTriplet(a);

    }


    //Alternative ways : -------------

    int getAllTriangles(int input[])
    {
        if(input.length<3)
            return 0;
        int count=0;
        Arrays.sort(input); //assume merge sort
        for(int i=0;i<input.length-2;i++)
        {
            for(int j=i+1;j<input.length-1;j++)
            {
                int index=BinarySearch(input,j,input.length-1); //returns the index of that number
                if(index!=-1)
                    count=count+index-j;
            }
        }
        return count;
    }

    int BinarySearch(int input[],int low,int high)
    {
        if(low>high)
            return -1;
        int k=input[low]-input[high];
        int mid=(low+high)/2;
        if(k<input[mid] && k>=input[mid+1] && mid+1<=high)
            return mid;
        else if(k<input[mid-1] && k>=input[mid] && mid-1>=low)
            return mid-1;
        else if(k<input[mid])
            return BinarySearch(input,mid+1,high);
        else
            return BinarySearch(input,low,mid-1);
    }


    public List<List<Integer>> findAll (int [] triplets ){
        Arrays.sort(triplets);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        find (triplets,0,0,list,result);
        return result;
    }

    private void find (int [] triplets ,int index , int count, List<Integer> list,List<List<Integer>> result){
        if (count == 3) {
            if (isValid (list)) {
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                tmp.addAll(list);
                result.add(tmp);
            }
        }else{
            for (int i = index ; i < triplets.length ;++i ) {
                if (count < 3) {
                    list.add(triplets[i]) ;
                    find (triplets, i+1 ,count + 1, list,result);
                    list.remove(list.size() -1);
                }
            }
        }
    }

    private boolean isValid (List<Integer> list) {
        return list.get(0) + list.get(1) > list.get(2) &&
                list.get(1) - list.get(0) < list.get(2);
    }
}