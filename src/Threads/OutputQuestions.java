package Threads;

/**
 * Created by v-dsindhi on 3/30/16.
 */
public class OutputQuestions implements a,b {
    public static void main(String args[]){
        try{
            System.out.println(b.i);
            throw new OutOfMemoryError();
        }catch (Throwable e){
            e.printStackTrace();
        }
        System.out.println(b.i);
        System.out.println(b.i);
        System.out.println(b.i);
        System.out.println(b.i);
    }
}

interface a {
    int i=10;
}
interface b{
    int i=5;
}