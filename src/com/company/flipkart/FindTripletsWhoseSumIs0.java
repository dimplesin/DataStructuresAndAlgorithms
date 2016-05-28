package com.company.flipkart;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by v-dsindhi on 7/11/15.
 */
public class FindTripletsWhoseSumIs0 {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        //sort array
        Arrays.sort(num);

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> each = new ArrayList<Integer>();
        for(int i=0; i<num.length; i++){
            if(num[i] > 0) break;

            for(int j=i+1; j<num.length; j++){
                if(num[i] + num[j] > 0 && num[j] > 0) break;

                for(int k=j+1; k<num.length; k++){
                    if(num[i] + num[j] + num[k] == 0) {

                        each.add(num[i]);
                        each.add(num[j]);
                        each.add(num[k]);
                        result.add(each);
                        each.clear();
                    }
                }
            }
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> threeSumZero(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (num.length < 3)
            return result;

        // sort array
        Arrays.sort(num);

        for (int i = 0; i < num.length - 2; i++) {
            // //avoid duplicate solutions
            if (i == 0 || num[i] > num[i - 1]) {

                int negate = -num[i];

                int start = i + 1;
                int end = num.length - 1;

                while (start < end) {
                    //case 1
                    if (num[start] + num[end] == negate) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[start]);
                        temp.add(num[end]);

                        result.add(temp);
                        start++;
                        end--;
                        //avoid duplicate solutions
                        while (start < end && num[end] == num[end + 1])
                            end--;

                        while (start < end && num[start] == num[start - 1])
                            start++;
                        //case 2
                    } else if (num[start] + num[end] < negate) {
                        start++;
                        //case 3
                    } else {
                        end--;
                    }
                }

            }
        }

        return result;
    }
}
