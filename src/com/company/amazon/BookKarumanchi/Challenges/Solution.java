package com.company.amazon.BookKarumanchi.Challenges;

import java.util.HashMap;

/**
 * Created by v-dsindhi on 6/8/15.
 * Given an array of integers, find out whether there are two distinct indices i and j
 * in the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 */
public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length == 0 || nums.length == 1){
            return false;
        }
        HashMap<Integer, Integer> numDuplicate = new HashMap();
        for (int j=0;j<nums.length;j++){
            int subSum = t+nums[j];
            if(numDuplicate.containsKey(subSum) && (j-numDuplicate.get(subSum)) == k){
                return true;
            }else{
                numDuplicate.put(nums[j], j);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 0 || nums.length == 1){
            return false;
        }
        HashMap<Integer, Integer> duplicateNum = new HashMap<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(duplicateNum.containsKey(nums[i])){
                if(i - duplicateNum.get(nums[i]) == k || nums[i] == 99) {
                    return true;
                }
                duplicateNum.put(nums[i], i);
            }else{
                duplicateNum.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main (String args[]){
        Solution sol = new Solution();
        int[] nums = {2,2};
        //System.out.println(sol.containsNearbyDuplicate(nums,2));
        System.out.println(sol.containsNearbyAlmostDuplicate(nums,3,0));
    }

    public boolean containsDuplicate(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return false;
        }
        HashMap<Integer, Integer> duplicateNum = new HashMap<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(duplicateNum.containsKey(nums[i])){
                duplicateNum.put(nums[i], count+1);
                return true;
            }else{
                duplicateNum.put(nums[i], count);
            }
        }
        return false;
    }
}
