package com.company.amazon.BookKarumanchi.Algorithms.PriorityQueuesAndHeaps;

/**
 * Created by v-dsindhi on 7/12/15.
 */
public class PriorityQueueAndHeapUsageProblems {

    /*
        Problem : Given a big file containing billions of numbers. How can you find the 10 maximum numbers from that file

        Answer  : When we need to find max n elements, best datastructure to use is priority queues.
                  One solution is to divide the data in sets of 1000 elements, make a heap of them, and take 10 elements from each
                  one by one. Finally heapsort all the sets of 10 elements and take top 10 among those. But the problem is where
                  to store 10 elements from each heap. That may require a large amount of memory as we have billions of numbers.

                  Reusing top 10 elements of earlier heap in subsequent elements can solve this problem. That means to take first block of
                  1000 elements and subsequent blocks of 990 each. Initially heapsort first set of 1000 numbers, take max 10 elements and mix them with
                  990 elements of 2nd set. Again Heapsort these 1000 numbers, take max 10 elements and mix them with
                  990 elements of 3rd set. Repeat till last set of 990 elements and take max 10 elements from final heap.

                  Time Complexity :O(n) = n/1000 * (Complexity of heap sort 1000 elements)
                  since complexity of heap sorting 1000 elements will be constant so the O(n) = n i.e linear complexity.



        Problem : Dynamic median finding. Design a heap structure that supports finding the median.

        Answer :  In a set of n elements, median is the middle element, such that the number of elements lesser than the median is equal
                  to the number of elements larger than the median. If n is odd, we can find the median by sorting the set and taking the middle element
                  If n is even the median is usually defined as the average of the two middle elements.This algorithm even work even when some of
                  the elements in the list are equal. For example, the median of the multiset {1,1,2,3,5} is 2, and the median of the multiset {1,1,2,3,5,8}
                  is 2.5.

                  "Median heaps" are variant of heaps that give access to the median element. A median heap can be implemented  using two heaps, each containing
                  half the elements. One is a max heap, containing the smallest elements, the other is a min heap, containing the largest elements. The size of
                  the max heap may be equal to the size of min heap, if the total number of elements is even.In this case the median is the average of the
                  maximum element of max heap and the minimum element of min-heap. If there are an odd number of elements, the max heap will contain one more
                  element than the min heap. the median in this case is simply the maximum element of the max-heap.

     */
}
