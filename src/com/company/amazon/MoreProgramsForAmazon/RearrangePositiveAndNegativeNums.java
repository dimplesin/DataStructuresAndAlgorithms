package com.company.amazon.MoreProgramsForAmazon;// A C++ program to put positive numbers at even indexes (0, 2, 4,..)
// and negative numbers at odd indexes (1, 3, 5, ..)

public class RearrangePositiveAndNegativeNums{ 
// The main function that rearranges elements of given array.  It puts 
// positive elements at even indexes (0, 2, ..) and negative numbers at 
// odd indexes (1, 3, ..).
static void rearrange(int arr[], int n)
{
    // The following few lines are similar to partition process
    // of QuickSort.  The idea is to consider 0 as pivot and
    // divide the array around it.
    int i = -1;
    for (int j = 0; j < n; j++)
    {
        if (arr[j] < 0)
        {
            i++;
            swap(arr[i], arr[j]);
        }
    }
 
    // Now all positive numbers are at end and negative numbers at
    // the beginning of array. Initialize indexes for starting point
    // of positive and negative numbers to be swapped
    int pos = i+1, neg = 0;
 
    // Increment the negative index by 2 and positive index by 1, i.e.,
    // swap every alternate negative number with next positive number
    while (pos < n && neg < pos && arr[neg] < 0)
    {
        swap(arr[neg], arr[pos]);
        pos++;
        neg += 2;
    }
}
 
// A utility function to swap two elements
static void swap(int a, int b)
{
    int temp = a;
    a = b;
    b = temp;
}
 
// A utility function to print an array
static void printArray(int arr[], int n)
{
    for (int i = 0; i < n; i++)
        System.out.println( arr[i]);
}
 
// Driver program to test above functions
public static void main(String args[])
{
    int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
    int n = arr.length;
    rearrange(arr, n);
    printArray(arr, n);
}
}


/*///Alternate solution with O(1) space
  C++ program to rearrange positive and negative integers in alternate
fashion while keeping the order of positive and negative numbers. 
#include <iostream>
#include <assert.h>
using namespace std;

//Utility function to right rotate all elements between [outofplace, cur]
void rightrotate(int arr[], int n, int outofplace, int cur)
{
char tmp = arr[cur];
for (int i = cur; i > outofplace; i--)
    arr[i] = arr[i-1];
arr[outofplace] = tmp;
}

void rearrange(int arr[], int n)
{
int outofplace = -1;

for (int index = 0; index < n; index ++)
{
    if (outofplace >= 0)
    {
        // find the item which must be moved into the out-of-place
        // entry if out-of-place entry is positive and current
        // entry is negative OR if out-of-place entry is negative
        // and current entry is negative then right rotate
        //
        // [...-3, -4, -5, 6...] -->   [...6, -3, -4, -5...]
        //      ^                          ^
        //      |                          |
        //     outofplace      -->      outofplace
        //
        if (((arr[index] >= 0) && (arr[outofplace] < 0))
            || ((arr[index] < 0) && (arr[outofplace] >= 0)))
        {
            rightrotate(arr, n, outofplace, index);

            // the new out-of-place entry is now 2 steps ahead
            if (index - outofplace > 2)
                outofplace = outofplace + 2;
            else
                outofplace = -1;
        }
    }


    // if no entry has been flagged out-of-place
    if (outofplace == -1)
    {
        // check if current entry is out-of-place
        if (((arr[index] >= 0) && (!(index & 0x01)))
            || ((arr[index] < 0) && (index & 0x01)))
        {
            outofplace = index;
        }
    }
}
}

//A utility function to print an array 'arr[]' of size 'n'
void printArray(int arr[], int n)
{
for (int i = 0; i < n; i++)
  cout << arr[i] << " ";
cout << endl;
}

//Driver program to test abive function
int main()
{
//int arr[n] = {-5, 3, 4, 5, -6, -2, 8, 9, -1, -4};
//int arr[] = {-5, -3, -4, -5, -6, 2 , 8, 9, 1 , 4};
//int arr[] = {5, 3, 4, 2, 1, -2 , -8, -9, -1 , -4};
//int arr[] = {-5, 3, -4, -7, -1, -2 , -8, -9, 1 , -4};
int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
int n = sizeof(arr)/sizeof(arr[0]);

cout << "Given array is \n";
printArray(arr, n);

rearrange(arr, n);

cout << "Rearranged array is \n";
printArray(arr, n);

return 0;
}



You are given an array of both negative and positive integers. You need to rearrange the array such that positive and negative numbers alternate.
Also, the order should be same as previous array and only O(1) auxiliary space can be used and time complexity boundation O(n). 
eg. -2 3 4 5 -1 -6 7 9 1 
result � 3 -2 4 -1 5 -6 7 9 1.
20 minutes


void alternate(int* list, int length){
	bool done = true;
	bool toggle = false;
	for (int i = 0 ; i < length; i++){
		
		for (int j = i; j < length; j++){
			int temp;
			if (!toggle){
				if(list[j] > 0){
					temp = list[i];
					list[i] = list[j];
					list[j] = temp;
					toggle = true;
					done = false;
					break;
				}
			}
			else {
				if(list[j] < 0){
					temp = list[i];
					list[i] = list[j];
					list[j] = temp;
					toggle = false;
					done = false;
					break;
				}
			}
		}
		if (!done)
			done = true;
		else
			break;
	}
}

int main (){
	int test[9];
	test[0] = -2;
	test[1] = 3;
	test[2] = 4;
	test[3] = 5;
	test[4] = -1;
	test[5] = -6;
	test[6] = 7;
	test[7] = 9;
	test[8] = 1;
	alternate(test, 9);
	for (int i = 0; i < 9; i++){
		cout << test[i] << " ";
	}
	cout << endl;
	while(1){}
}*/