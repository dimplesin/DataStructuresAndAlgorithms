package com.company.amazon.ProgramsDoneSoFar;

import com.company.amazon.BookKarumanchi.Challenges.HashMap;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by v-dsindhi on 7/3/15.
 */
public class MyExample {

    public static void main(String[] args){
        MyDataStructure myDataStructure = new MyDataStructure();
        myDataStructure.Insert(3);
        myDataStructure.Insert(5);
        myDataStructure.Insert(10);
        myDataStructure.Delete(10);
        myDataStructure.Insert(12);
        myDataStructure.Insert(18);
        myDataStructure.Insert(19);
        System.out.println(myDataStructure.getRandomKey());
    }
}
class MyDataStructure{

    ArrayList<Integer> contents = new ArrayList();
    HashMap<Integer, Integer> indices = new HashMap<Integer, Integer>();
    Random R = new Random();

    //Selects random element in constant time
    Integer getRandomKey(){
        return contents.get(R.nextInt(contents.size()));
    }

    //adds new element in constant time
    void Insert(int n){
        indices.put(n, contents.size());
        contents.add(n);
    }

    //removes element in constant time
    void Delete(int n){
        int index = indices.get(n);   //1
        contents.set(index, contents.get(contents.size()-1));
        contents.remove(index);   //10
        indices.put(contents.get(contents.size()-1),index);
        indices.remove(n);    //10
        System.out.println(indices);
    }
}