package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/24/15.
 */
public class LinkedListMerge {

    ListNode MergeList(ListNode a, ListNode b){
        ListNode result = null;
        if(a == null) return b;
        if(b==null) return a;
        if(a.getData() <= b.getData()){
            result = a;
            result.setNext(MergeList(a.getNext(), b));
        }else{
            result = b;
            result.setNext(MergeList(b.getNext(),a));
        }
        return result;
    }

}

class ListNode {

    private int data;
    private ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}



/*
Given an array of integers. Write a program to find interval with largest producing maximum sum. You should print sum as well as first and last index of the interval.
What is TRIE?
Write the function for insert and search for TRIE?
DFS and BFS .
How to get the shortest path from (0 , 0) to (r , c) in a rectangular grid in which some cells are blocked.


    * Telephonic

1) Given an array which has elements in increasing order first , and then decreasing, suggest an algorithm for searching an element in it.

2) Check whether a given tree is a BST or not.

3) do not remember

F2F 1

1) Number of hops required to reach the end of an array , where the maximum hop is the value at index.
Tweaked question after this, to reach any node.

2) print the path between any two given nodes in a binary tree

F2F2
1) Project and resume discussion.
Problems faced and how you approached them.

2) A large number of emails coming into the system, at any given time find the top k issues being faced by the users. Problem reduced to find the top k trending words in a large file.

3) Implement a vector in c, using any available data structure

F2F3

1) Given a pre-order traversal of a binary tree represented by , I for internal node and L for leaf, build the tree.

2) Find the next smallest element for all the elements in a given array.

F2F4

Started off with a lengthy discussion on current project, was asked to draw a schematic of the same, and then was asked to discuss my roles and responsibilities as well as suggest what improvements could be made to it.

1) Given a 2-D array, in which all the elements are either 0’s or 1’s, and all the rows are sorted, Give an algorithm for finding the row having the maximum number of 1’s. Was asked to code and analyse time complexity as well.

2) There is a given set of colours , say [1-N]. Now , people are coming into a stadium wearing t-shirts of any of these colors. Write an algorithm to find the first person to come in, to have worn an unique color.
The question wasn’t clear to me at first, so after a few examples , got what he was trying to ask.
For eg. Suppose we have colors R G B
and the stream of people are as,
G R B G G G G
the output should be R.


Written Round :
there where 3 coding question , out of which 2 where DS related and 3 rd one was Problem solving
1. Count no of words in given string .
2. Find first non repeating character in a stream of characters
3. related to slot machine and its working

Interviews
F2F 1.
1. firstly some non technical questions where there , such as
     tell me about yourself ,
     Why Amazon etc
2. followed by 2 coding questions
     1. Given a sorted dictionary of alien language , find order of characters.
     2. find minimum number of characters needed to be added to the end of a string to make it palindrome.

F2F 2.
was a senior guy ,
1.started with discussion on previous interview questions , as I had used DP in second question so a brief discussion on DP , tried to test me that does I really know the concept of DP.
2. asked few puzzles , One should be prepared for some out of box questions as they want to check the thought process . even they change puzzles and try to get different solutions. Think loud always.

F2F 3.
was also a senior guy,
1. Started with general induction and asked about till then my interview experience and related stuff.
2. Simple Matrix multiplication problem ,with only 2 double pointer are given , we need to check sizes of both matrix , multiplication feasibility and then do multiplication .
3. Design Question from DataBase point of view , asked about table structure for the problem and had a good discussion on it , concept such as normalisation was discussed .

Telephonic 4th
He was a very senior guy from different team ,
1. Started with general introduction followed by many Behavioural hr questions .
2. Followed by Design Question, a feature of Outlook
A Server receives meeting objects from multiple senders. Meeting object contains meeting time, sent time, recipient(s), sender id,etc. When recipient comes and checks the server, he/she should get requests based on meeting time and not based on sent time. Many discussions on space complexity and time complexity.?Eg:

12 PM From: A To: B,C,D meeting time: 4 PM meeting Id: 1

12.30 PM from: A To C,D meeting time : 2 PM meeting Id:2

1:PM From B To: C meeting time: 1.30PM meeting Id:3

When C requests the server, C should get ID3 as 1st, ID2 as 2nd and ID1 as 3rd meeting.

Small set of Suggestions :
1. Practice writing code using pen and paper .
2. Try to be interactive as they are very much interested in candidate’s thought process , think loud , be confident .
3. Firstly explain the logic and when interviewer is satisfied then start coding .
4. Have few questions prepared for the interviewer as it shows interest of candidate towards the company .Do proper home work about the company.
* */