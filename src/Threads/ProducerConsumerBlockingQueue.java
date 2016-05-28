package Threads;

/**
 * Created by v-dsindhi on 3/5/16.
 */
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Producer Class.
 */
class Producer1 implements Runnable {

    private final BlockingQueue<Integer> sharedQueue;

    public Producer1(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for(int i=1; i<=10; i++){
            try {
                System.out.println("Produced : " + i);
                //put/produce into sharedQueue.
                sharedQueue.put(i);
            } catch (InterruptedException ex) {

            }
        }
    }

}

/**
 * Consumer Class.
 */
class Consumer1 implements Runnable{

    private BlockingQueue<Integer> sharedQueue;

    public Consumer1 (BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while(true){
            try {
                //take/consume from sharedQueue.
                System.out.println("CONSUMED : "+ sharedQueue.take());
            } catch (InterruptedException ex) {

            }
        }
    }


}

/** Copyright (c), AnkitMittal JavaMadeSoEasy.com */
public class ProducerConsumerBlockingQueue {

    public static void main(String args[]){

        //Creating shared object
        BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();

        Producer1 producer=new Producer1(sharedQueue);
        Consumer1 consumer=new Consumer1(sharedQueue);

        Thread producerThread = new Thread(producer, "ProducerThread");
        Thread consumerThread = new Thread(consumer, "ConsumerThread");
        producerThread.start();
        consumerThread.start();

    }

}

/*OUTPUT

Produced : 1
Produced : 2
CONSUMED : 1
Produced : 3
CONSUMED : 2
Produced : 4
CONSUMED : 3
Produced : 5
CONSUMED : 4
Produced : 6
CONSUMED : 5
Produced : 7
CONSUMED : 6
Produced : 8
CONSUMED : 7
Produced : 9
CONSUMED : 8
Produced : 10
CONSUMED : 9
CONSUMED : 10

*/