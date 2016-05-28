package com.company.amazon.BookKarumanchi.DataStructures.Hashing;

import java.util.Arrays;

/**
 * Created by v-dsindhi on 4/2/15.
 */
public class ProblemsOnHashing {

    HashTableOperations hashTableOperations = new HashTableOperations();

    //Given an array of characters, give an algorithm for removing the duplicates
    void RemoveDuplicates(char[] s, int n){
        for(int i=0; i<n;i++){
            for(int j=i+1;j<n ;){
                if(s[i] == s[j]){
                    s[j] = s[--n];
                }else{j++;}
            }
            s[i] = '\0';
        }

    }

    //Alternative solution
    //With char[] as input
    public static void removeDuplicates(char[] str, int len){
        if(str == null) return;
        if(len < 2) return;
        int tail = 1;
        int j;
        for(int i=0;i<len;++i){
            for(j =0; j <tail;++j){
                if(str[i] == str[j]) break;
            }
            if(j == tail){
                str[tail] = str[i];
                ++tail;
            }
        }
        str[tail] = 0;
    }

    //With String[] as input
    public static String removeDuplicates(String s){
        StringBuilder noDupes = new StringBuilder();
        for(int i=0;i<s.length();i++){
            String si = s.substring(i, i+1);
            if(noDupes.indexOf(si) == -1){
                noDupes.append(si);
            }
        }
        return noDupes.toString();
    }

    //Sporting Approach
    public static String RemoveDuplicates(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        System.out.println(sorted);
        return sorted;
    }

    //Can we solve this problem in single pass over given array
    void RemoveDuplicates(char[] s){
        int src, dest, current, last;
        HashTable h = new HashTable();
        current = last = 0;
        for(;s[current] != 0;current++){
            if(hashTableOperations.hashSearch(h, s[current]) != 0){
                s[last++] = s[current];
                hashTableOperations.hashInsert(h, s[current]);
            }
        }
        s[last] = '\0';
    }

    //Give an algorithm to remove the specified characters from a given string which are given in another string
    void RemoveChars(char[] str, char[] removeTheseChars){
        int srcInd, destInd;
        int auxi[] = new int[256];
        for(srcInd = 0; srcInd<256;srcInd++){
            auxi[srcInd] = 0;
        }
        srcInd = 0;
        while(!(0 == removeTheseChars[srcInd])){
            auxi[removeTheseChars[srcInd]] = 1;
            srcInd ++;
        }
        srcInd = destInd = 0;
        while (str[srcInd++] != 0 ){
            if(auxi[str[srcInd]]!=0){
                str[destInd++]=str[srcInd];
            }
        }
    }

    //Give an algorithm for finding the first non-repeated characters in a string. For example
    //the first non repeated character in the string : abzddab is z
    char FirstNonRepeatingCharacter(char[] str, int len){
        int i,j,repeated = 0;
        for(i=0;i<len;i++){
            repeated = 0;
            for(j=0;j<len;j++){
                if(i!= j && str[i] == str[j]){
                    repeated = 1;
                    break;
                }
            }
        }
        if(repeated == 0){
             return  str[i];
        }
        return '\0';
    }

    //can we improve the time complexity
    char FirstNonRepeatingCharUsingHash(char[] str, int len){
        int i, count[] =new int[256];
        for(i=0;i<len;++i){
            count[i]=0;
        }for(i=0;i<len;++i){
            count[str[i]]++;
        }
        for(i=0;i<len;++i){
            if(count[str[i]] == 1){
                System.out.println(str[i]);
                break;
            }
        }
        if(i==len) {
            System.out.println("No non repeated characters");
        }
        return 0;
    }

    //Given a string, give an algorithm for finding the first repeating letter in a string
    char FirstRepeatingCharUsinghash(char[] str,int len){
        int i, count[] = new int[256];
        for(i=0;i<len;++i){
            count[i]=0;
        }
        for(i=0;i<len;++i){
            if(count[str[i]] == 1){
                System.out.println(str[i]);
                break;
            }else{
                count[str[i]]++;
            }
        }
        if(i==len){System.out.println("No Repeated Characters");}
        return 0;
    }
}
