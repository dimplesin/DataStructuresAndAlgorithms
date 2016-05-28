package com.company.amazon.BookKarumanchi.Challenges;/*
package Challenges;

*/
/**
 * Created by v-dsindhi on 6/8/15.
 */




//given a string, find out the first non-repeating character.

/*1. design a data structure that can :
– push O(1)
        – pop O(1)
        – get min O(1)
        2. check if link list is palindrone (O(n) in time, O(1) in space)
        3. difference to story tuple in array and hashmap?*/


/*you are given n candles with size of each candle present as an element in an integer array i.e a[i] represent length of ith candle. There is a tradition according to which you celebrate by lighting a candle every night. The candles are lit such that there are k candles lit on the kth day. For ex. 1 candle on day 1 , 2 candles on day 2 and so on. Each night a candle burns 1 inch.
        you need to write a program to find out maximum number of days you can celebrate the tradition with the n candles and their lengths?

        Let me know if anything is not clear*/


//WAP for inplace removal of vowels from a char string
/*
For the example word PEEPERS:
        vowel_count=0, vowel_start_index=-1
        P is encountered first, do nothing because we haven't come across a vowel yet.
        E is encountered next, so vowel_count=1 and vowel_start_index=1 (assuming 0 based array indices. So the first E is at position number 1 in the string PEEPERS
        E is encountered again, so vowel_count=2
        P is encountered next, its a consonant so swap position of P with position held in vowel_start_index. Then increment vowel_start_index. So the string looks like PPEEERS and vowel_start_index=2
        E is encountered next (this is the third E in PEEPERS). vowel_count becomes 3.
        R is encountered. Its a consonant so swap it with character held at vowel_start_index (which is 2). So the string becomes PPREEES and increment vowel_start_index to 3
        Finally we come across S. Do the same as above and whola!! You have the string PPRSEEE with vowel_count = 3.
        Now just place a null at (n - vowel_count) = 7-3 = 4 and you have the string PPRS which is the desired output.

        #include <iostream>

bool isVowel(char a)
{
 if(a == 'a' || a == 'A' ||
    a == 'e' || a == 'E' ||
    a == 'i' || a == 'I' ||
    a == 'o' || a == 'O' ||
    a == 'u' || a == 'U')
    return true;
  else
    return false;
}

void removeLetters(std::string& s)
{
  int len = s.length();
  int vcount = 0;
  int vstart = -1;

  for(int i=0; i<len; i++)
  {
    if(isVowel(s[i]))
    {
      if(vstart == -1)
         vstart = i;
      vcount++;
    }

    if(!isVowel(s[i]) && vstart != -1)
    {
       Encountered letter is a consonant. So do swap.
         The below method for swap does not need a tmp variable
        s[i] = s[i] + s[vstart];
        s[vstart] = s[i] - s[vstart];
        s[i] = s[i] - s[vstart];
        vstart++;
        }
        }
        s = s.substr(0, len-vcount);
        }

        int main(int argc, char** argv)
        {
        std::string s = "the rain in spain is mainly from the plains.";
        removeLetters(s);
        std::cout << s << std::endl;
        return 0;
        }


*/

/*You are given n strings. You have to find whether a chain can be formed with all the strings given namely n ?

        A chain can be formed between 2 strings if last character of the 1st string matches with the first character of the second string. I hope the question is clear*/


/*

import com.sun.org.apache.xpath.internal.functions.FuncFloor;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Amazon {

    int foo(int n) {

        int d = n, s = n;

        while (d) {

            d = floor(d / 2);

            s -= d;

        }

        return s;

    }


    public static void main(String args[])
    {

        removeVowels();
        */
/*int[] len;
        int day,daycount=0;
        System.out.println("Enter the no. of candles");
        Scanner jin=new Scanner(System.in);
        int n=jin.nextInt();
        len=new int[n];
        System.out.println("Enter the length of each candle");
        for(int k=0;k<n;k++)
        {
            System.out.print("length of candle "+(k+1)+" : ");
            len[k]=jin.nextInt();
        }
        jin.close();
        here:for(day=0;day<n;day++)
        {

            System.out.println("candles that can be lit on day "+(day+1));
            for(int j=0;j<=day;j++)//to check no. candles to be lit on a particular day
            {

                int max=0;
                for(int i=1;i<n;i++)//to find out candle with max length
                {
                    if(len[i]>len[max])
                        max=i;
                }
                if(len[max]==0)//to check whether the candles are finished
                    break here;
                System.out.println(max+1);//to print the indexes of the candles lit on a particular day
                len[max]--;
            }
            daycount++;
        }
        System.out.println("Max no. of days we can celebrate the tradition : "+daycount);*//*

    }

    */
/*WAP for inplace removal of vowels from a char string*//*

    public static void removeVowels(){
        Set<Character> charSet = new TreeSet<Character>();
        charSet.add('a');
        charSet.add('e');
        charSet.add('i');
        charSet.add('o');
        charSet.add('u');
        String s = "dimple";
        String outputString = "";
        for(char c:s.toCharArray()){
            if(!charSet.contains(c)){
                outputString += c;
            }
        }
         System.out.println(outputString);
    }

    */
/*You are given n strings. You have to find whether a chain can be formed with all the strings given namely n ?

     A chain can be formed between 2 strings if last character of the 1st string matches with the first character of the second string. I hope the question is clear*//*



    */
/* Telephonic round:
1)Given an array with lengths, you have to select 3 lengths (a, b and c) for a triangle such that it satisfies condition a+b>c,b+c>a, a+c>b. Find the number of possible triangles can be created from the given array.
ex: 3 5 6 9 10
(3,9,10), (3 5 6), (5 6 10), (5 9 10), (5 6 9), (6 9 10)
so number of possible triangles is 6

2)Count Inversions in an array
Inversion Count for an array indicates – how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum.
Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j

Example:
The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).

In house Interview 1(F2F):
3)Next Greater Element
Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in array. Elements for which no greater element exist, consider next greater element as -1.

Examples:
a) For any array, rightmost element always has next greater element as -1.
b) For an array which is sorted in decreasing order, all elements have next greater element as -1.
c) For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.

Element NGE
4 –> 5
5 –> 25
2 –> 25
25 –> -1
d) For the input array [13, 7, 6, 12}, the next greater elements for each element are as follows.

Element NGE
13 –> -1
7 –> 12
6 –> 12
12 –> -1

4)Sorted Array to Balanced BST
Given a sorted array. Write a function that creates a Balanced Binary Search Tree using array elements.

Examples:

Input: Array {1, 2, 3}
Output: A Balanced BST
2
/ \
1 3

Input: Array {1, 2, 3, 4}
Output: A Balanced BST
3
/ \
2 4
/
1

Inhouse Interview 2(F2F):
5)Detect Cycle in a Directed Graph
Given a directed graph, check whether the graph contains a cycle or not. Your function should return true if the given graph contains at least one cycle, else return false. For example, the following graph contains three cycles 0->2->0, 0->1->2->0 and 3->3, so your function must return true.

6)Convert a BST to a sorted circular doubly-linked list in-place.

Telephonic Round with Hiring Manager:
Introduction about me.
Then he asked about my college project. we discussed the OO design for the project.
Then he asked me about my current company’s latest Invention
Then he asked me about Virtual memory and some in depth discusion on that.
Then he came to my current project I am working
Then he asked me why are you coming out of my current company??
Then he gave a question to solve.
7)Given an array A[] and a number x, check for pair in A[] with sum as x
Given an array A[] of n numbers and another number x, determines whether or not there exist two elements in S whose sum is exactly x.
He asked about various possible solutions for the above one.

Bar raiser round(F2F):
8)Given a binary tree, find the diameter of the tree.
The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two leaves in the tree.

After solving the above one, he added a constraint on the above problem: (i.e) To find the diameter of the tree with atmost one turn
Examples of turns in tree:
In tree1-> start from 1 and there is a turn at root 2 towards right,
In tree2-> starts from 3 goes in left and there is a turn at 1 towards right ,
In tree3-> starts from 1 goes in right and there is a turn at 3 towards left,
2 3 1
/ \ / \
1 3 1 3
\ /
2 2
    * */


/*You are given an array of positive integers. Convert it to a sorted array with minimum cost (minimum number of operations). Only valid operation are

        1) Decrement -> cost = 1

        2) Delete an element completely from the array -> cost = value of element

        For example:

        4,3,5,6, -> cost 1 //cost is 1 to make 4->3

        10,3,11,12 -> cost 3 // cost 3 to remove 3


        static ArrayList sortWithMinCost(ArrayList A) {
int sum = getSum(A);//calculate sum of list
int min_pos = min(A);//find min
long sum1= A.get(min_pos) * min_pos;//case where we replace all numbers preceding min_pos //with value of min_pos
for(int i = min_pos; i< A.size();i++){
sum1+= A.get(i) ;//add numbers after min_pos
}
cost = sum – sum1; //cost of replacing all preceding elements less that min with min
long cost1 = A.get(min_pos);//cost of removing element
if (cost <= cost1) {
// replace all elements before A[min_pos] tp A[min_pos]
// int[] newA = new int[A.length];
for (int i=0;i A.set(i, A.get(min_pos));
}
// Add all other elemensts
return A;
} else {
// remove min_pos
A.remove(min_pos);
Boolean sorted = true;
// check if sorted
for (int i = 1; i < A.size(); i++) {
if (A.get(i) < A.get(i – 1)) {
sorted = false;
break;
}
}
if (!sorted) {
return sortWithMinCost(A);
} else {
return A;
}
}
}

One of the possible greedy solution I think should work is

a. Iterate over the array starting at index 0.
b. At each step keep adding element at the end of already sorted array.
c. Cost of adding a new element is 0, if the element is greater then last element of already sorted array.
d. cost of adding a new element at position i, is min(element value, sum (element at index j – element value) 0< =j a[i]).
e. at the end we will have sorted array at min cost.


public class ConvertToSortedArrayUsingDecrementAndDelete {

	public static int arr1[] = { 4, 3, 5, 6 };
	public static int arr2[] = { 10, 3, 11, 12 };
	public static int arr3[] = { 3, 10, 7, 9, 1 };
	public static int arr4[] = { 1, 1, 1, 1000, 1 };
	public static int arr5[] = { 10, 2, 3 };

	public static void main(String[] args) {
		findPositiveArray(arr1);
		findPositiveArray(arr2);
		findPositiveArray(arr3);
		findPositiveArray(arr4);
		findPositiveArray(arr5);

	}

	private static void findPositiveArray(int input[]) {
		int tempArray[] = new int[input.length];
		tempArray[0] = input[0];
		int counter = 1;
		for (int i = 1; i < input.length; i++) {
			if (input[i] < tempArray[counter - 1]) {
				int temp = tempArray[counter - 1] - input[i];
				if (temp < input[i]) {
					tempArray[counter - 1] = input[i];
					tempArray[counter++] = input[i];
				} else {
					// do not do anything it will be considered as the deletion
					// from array
					continue;
				}
			} else {
				tempArray[counter++] = input[i];
			}
		}
		int result[] = new int[counter];
		System.arraycopy(tempArray, 0, result, 0, result.length);
		System.out.println("Input:");
		printArray(input);
		System.out.println("\nOutput:");
		printArray(result);
		System.out.println("\n------------------");
	}

	private static void printArray(int[] arrray) {
		for (int i = 0; i < arrray.length; i++) {
			System.out.print(arrray[i] + " ");
		}
	}

}

        */




/*You are given some 1000000 numbers in the range of 1 to 1000000000 not in any sorted order.The given numbers are random.
 You need to eliminate the duplicates in the given set of numbers. Consider for optimized solution

 package duplicates;

import java.util.Random;
import java.util.Scanner;

public class FindDuplicates {
	int [] arr;
	int [] found;

	public FindDuplicates(int N){
		arr= new int[N+1];
		found = new int[N+1];
	}
	public static void main(String[] args) {
		System.out.println("Enter size of array : ");
		Scanner scan = new Scanner(System.in);
		int N = Integer.parseInt(scan.nextLine());

		FindDuplicates a = new FindDuplicates(N);
		System.out.println("The random array ");
		for(int i=1;i<=N;i++){
			Random rand = new Random();
			a.arr[i] = rand.nextInt((N - 1) + 1) + 1;
			a.found[i] = 0;
			System.out.print(a.arr[i]+ " ");
		}
		System.out.println();
		System.out.println("The result ");
		for(int i=1;i<=N;i++){
			if(a.found[a.arr[i]]==0){
				System.out.print(a.arr[i]+ " ");
				a.found[a.arr[i]]=1;
			}
		}
	}
}

The idea in pseudo-code:
0) Start at N = 0
1) Take the N-th element in the list.
2) If it is not in the right place if the list had been sorted, check where it should be.
3) If the place where it should be already has the same number, you have a dupe - RETURN TRUE
4) Otherwise, swap the numbers (to put the first number in the right place).
5) With the number you just swapped with, is it in the right place?
6) If no, go back to step two.
7) Otherwise, start at step one with N = N + 1. If this would be past the end of the list, you have no dupes.


For all array indexes i from 0 to m-1 do
If array[i] < n or array[i] >= n+m => RETURN FALSE ("value out of range found")
Calculate j = array[i] - n (this is the 0-based position of array[i] in a sorted array with values from n to n+m-1)
While j is not equal to i
If list[i] is equal to list[j] => RETURN FALSE ("duplicate found")
Swap list[i] with list[j]
Recalculate j = array[i] - n
RETURN TRUE



public class StraightArray {
    static int evict(int[] a, int i) {
    	int t = a[i];
    	a[i] = a[t%a.length];
    	a[t%a.length] = t;
    	return t;
    }
    static boolean isStraight(int[] values) {
    	for(int i = 0; i < values.length; i++) {
    		while(values[i]%values.length != i) {
    			int evicted = evict(values, i);
    			if(evicted%values.length == values[i]%values.length) {
    				return false;
    			}
    		}
    	}
    	for(int i = 0; i < values.length-1; i++) {
    		int n = (values[i]%values.length)+1;
    		int m = values[(i+1)]%values.length;
    		if(n != m) {
    			return false;
    		}
    	}
    	return true;
    }
}
 */

/* you r given an 8×8 chessboard, 8 black coins and 8 white coins. What r all possible ways to place these all coins on board?
* The answer is (64 C 8)*(56 C 8), which is the same as (64 C 16)*(16 C 8) [select 16 spaces first, and then select which will be black and which will be white].
* There are C(64, 16) ways to pick 16 places where coins can be placed.

In any of the above picked 16 places, there are 16! ways to place coins. Since 8 coins are white and to be considered same. Similar logic for black coins. The number of ways reduces to (16!)/(8! * 8!)

Total number of ways to place = C(64, 16)*(16!) / (8! * 8!)
*
* */

/*  Write an iterative algorithm to find ancestors of a given node.
 * #include<iostream>
#include<stdio.h>
#include<stdlib.h>

using namespace std;

/* A binary tree node has data, pointer to left child
   and a pointer to right child
struct node
        {
        int data;
        struct node* left;
        struct node* right;
        };

/* If target is present in tree, then prints the ancestors
   and returns true, otherwise returns false.
        bool printAncestors(struct node *root, int target)
        {
  /* base cases
        if (root == NULL)
        return false;

        if (root->data == target)
        return true;

  /* If target is present in either left or right subtree of this node,
     then print this node
        if ( printAncestors(root->left, target) ||
        printAncestors(root->right, target) )
        {
        cout << root->data << " ";
        return true;
        }

  /* Else return false
        return false;
        }

 Helper function that allocates a new node with the
   given data and NULL left and right pointers.
        struct node* newnode(int data)
        {
        struct node* node = (struct node*)
        malloc(sizeof(struct node));
        node->data = data;
        node->left = NULL;
        node->right = NULL;

        return(node);
        }

  Driver program to test above functions
        int main()
        {

   Construct the following binary tree
              1
            /   \
          2      3
        /  \
      4     5
     /
    7

        struct node *root = newnode(1);
        root->left        = newnode(2);
        root->right       = newnode(3);
        root->left->left  = newnode(4);
        root->left->right = newnode(5);
        root->left->left->left  = newnode(7);

        printAncestors(root, 7);

        getchar();
        return 0;
        }
        Output:
        4 2 1

        Time Complexity: O(n) where n is the number of nodes in the given Binary Tree.


        *
 *
 * */



/* Find the same sum interval in two Binary arrays:

Given two binary arrays A and B of same size N. Find an interval (i, j)(inclusive)
such that sum of elements of A and sum of all elements of B in this interval is same.

#include <iostream>
using namespace std;

        int main()
        {
        int a[] = {0,0,1,1,0,1};
        int b[] = {1,0,1,0,0,0};

        int n = sizeof(a)/ sizeof(a[0]);
        int p = 0, q = 0, sumA = 0, sumB = 0, sum = 0;

        for(int k = 0; k < n-1; k++)
        {
        for (int j = n-1; j > 0; j--)
        {
        sumA = 0; sumB = 0;

        for(int i = k; i <= j; i++)
        {
        sumA += a[i];
        sumB += b[i];
        }
        if(sumA == sumB && j > k && (q-p) < (j-k))
        {
        p = k; q = j; sum = sumA;
        }
        }
        }

        cout << p << " " << " "  << q << "  " << sum << endl;

        return 0;
        }*/




/*
}


import java.util.Random;
        import java.util.Scanner;

public class FindDuplicates {
    int [] arr;
    int [] found;

    public FindDuplicates(int N){
        arr= new int[N+1];
        found = new int[N+1];
    }
    public static void main(String[] args) {
        System.out.println("Enter size of array : ");
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());

        FindDuplicates a = new FindDuplicates(N);
        System.out.println("The random array ");
        for(int i=1;i<=N;i++){
            Random rand = new Random();
            a.arr[i] = rand.nextInt((N - 1) + 1) + 1;
            a.found[i] = 0;
            System.out.print(a.arr[i]+ " ");
        }
        System.out.println();
        System.out.println("The result ");
        for(int i=1;i<=N;i++){
            if(a.found[a.arr[i]]==0){
                System.out.print(a.arr[i]+ " ");
                a.found[a.arr[i]]=1;
            }
        }
    }
}*/


public class Amazon {
    public static void main(String[] args) {
        int a[] = { 3, 4, 1, 3, 1, 7, 2, 2, 4 };

        System.out.println(nonRepeatingElement(a));
    }

    private static int nonRepeatingElement(int[] a) {
        int element = 0;

        for (int i = 0; i < a.length; i++) {
            element ^= a[i];
            //System.out.println(element);
        }

        return element;
    }
}