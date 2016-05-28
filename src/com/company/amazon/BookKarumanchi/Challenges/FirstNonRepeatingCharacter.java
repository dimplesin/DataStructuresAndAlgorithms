package com.company.amazon.BookKarumanchi.Challenges;

import java.util.HashMap;

/**
 * Created by v-dsindhi on 6/8/15.
 */
public class FirstNonRepeatingCharacter {
    public static void main(String args[]){
        String s = "dkxfhkhadjkhfjbsdjbasydvfyvshjdfvhjsdvfhjvasddkhfkjasbdz";
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        for(char c:s.toCharArray()){
            if(map.containsKey(c)){
                int countForChar = map.get(c);
                map.put(c, countForChar+1);
            }else{
                map.put(c, count);
            }
        }
        for(char c:s.toCharArray()){
            if(map.get(c) == 0){
                System.out.println(c);
                break;
            }
        }
    }

}
