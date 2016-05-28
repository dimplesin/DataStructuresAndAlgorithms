package com.company.amazon.MoreProgramsForAmazon;

public class RandomGenerator {
/**
 * Test code
 */
public static void main(String[] args) {
	RandomGenerator rand = new RandomGenerator(6);
    for (int i = 0; i < 25; i++) {
        System.out.println(rand.nextInt());
    }

}

private int max;
private int last;

// constructor that takes the max int
public RandomGenerator(int max){
    this.max = max;
    last = (int) (System.currentTimeMillis() % max);
}

// Note that the result can not be bigger then 32749
public int nextInt(){
    last = (last * 32719 + 3) % 32749;
    return last % max;
}
}


/*
 * 1. There is a stream of integers incoming. You are only concerned about finding whether a number exists in a window of k numbers. Write code to find the number with minimum number of comparisons.
2. Imagine you have four operations. �K� (types k on screen), �select all�, �copy�, �paste�. Find out maximum number of K�s possible for given number of keystrokes.
 * */
