package geeksforgeeks.topInterviewquestions.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v-dsindhi on 12/16/15.
 */
public  class MyClass {
    String get(List<Object> l){
      return "";
    }

    public static void main(String args[]){
        MyClass m = new MyClass();
        List<String> f= new ArrayList<>();
        f.add("A");
        f.add("B");
        Object array[] = new Object[6];
      //  String array[] = new String[];
        //String s = m.get(array);
    }
}

class A{
    A get(){return this;}
}

class B1 extends A{
    B1 get(){return this;}
    void message(){System.out.println("welcome to covariant return type");}


}