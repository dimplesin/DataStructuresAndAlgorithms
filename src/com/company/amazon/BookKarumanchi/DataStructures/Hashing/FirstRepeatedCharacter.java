package com.company.amazon.BookKarumanchi.DataStructures.Hashing;

/**
 * Created by v-dsindhi on 4/2/15.
 */
public class FirstRepeatedCharacter {

    char FirstRepeatedChar(char[] str){
        int count[] = new int[256];
        int i;
        for(i=0;i<256;++i){
            count[i] = 0;
        }
        for(i=0; i < str.length; ++i){
            if(count[str[i]]==1){
                System.out.println(str[i]);
                break;
            }else{
                count[str[i]]++;
            }
        }
        if(i == str.length){
            System.out.println("No Repeated Characters.");
        }
        return 0;
    }



}
