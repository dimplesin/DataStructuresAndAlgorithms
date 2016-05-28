package com.company.amazon.BookKarumanchi.Challenges;

import java.util.HashMap;

/**
 * Created by v-dsindhi on 6/9/15.
 */
public class SortingStringAmazonQuestion {

    /*
    * You have n strings with their lengths. You are given an add(string s1,string s2) which would concatenate the string s2 with s1 and return s3. Optimize the cost of concatenation of all these strings into one big string.

        Ex: 1,3,2 are the lengths of given strings.

        1+3=4

        4+2=6

        total cost=10
    * */

    public static void main(String args[]){

    }

    public String add(String[] strings){
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for(String string:strings){
            hashMap.put(string, string.length());
        }
        return "";
    }
}
