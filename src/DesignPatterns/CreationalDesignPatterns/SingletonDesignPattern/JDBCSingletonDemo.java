package DesignPatterns.CreationalDesignPatterns.SingletonDesignPattern;

/**
 * Created by v-dsindhi on 1/30/16.
 */
class A{
    private static A obj = new A(); // Early, instance will be created at load time.

    private A(){}

    public static A getA(){
        return obj;
    }

    public void doSomething(){
        //Write your code here.
    }
}

class B{
    private static B obj;
    private B(){}

    public static B getB(){
        if(obj == null){
            synchronized (B.class){
                if(obj==null){
                    obj = new B(); // instance will be created at request time.
                }
            }
        }
        return obj;
    }

    public void doSomething(){
        //Write your code here.
    }
}
public class JDBCSingletonDemo {
}
