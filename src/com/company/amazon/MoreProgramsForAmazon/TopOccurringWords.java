package com.company.amazon.MoreProgramsForAmazon;

import java.util.Stack;


public class TopOccurringWords {
	void postorder_stack(BTreeNode  root){
	    Stack ms = new Stack();
	    if(root == null) return ;
	 
	    BTreeNode  temp ;
	    ms.push(root);
	    BTreeNode  prev = null;
	    while(!ms.isEmpty()){
	        temp = (BTreeNode) ms.peek();
	        /* case 1. We are nmoving down the tree. */
	        if(prev == null || prev.left == temp || prev.right == temp){
	             if(temp.left != null)
	                  ms.push(temp.left);
	             else if(temp.right != null)
	                  ms.push(temp.right);
	             else {
	                /* If node is leaf node */
	                   System.out.println( temp.data);
	                   ms.pop();
	             }
	         }
	         /* case 2. We are moving up the tree from left child */
	         if(temp.left == prev){
	            if(temp.right != null)
	                ms.push(temp.right);
	            else {
	                System.out.println(temp.data);
	                ms.pop();
	            }
	         }
	 
	        /* case 3. We are moving up the tree from right child */
	         if(temp.right == prev){
	        	 System.out.println(temp.data);
	              ms.pop();
	         }
	         prev = temp;
	      }
	 
	}
}


/*using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
 
namespace SimpleTermFrequencyAnalyser
{
	class Program
	{
		static void Main(string[] args)
		{
			// Read a file into a string (this file must live in the same directory as the executable)
			string filename = "Alice-in-Wonderland.txt";
			string inputString = File.ReadAllText(filename);
			
			// Convert our input to lowercase
			inputString = inputString.ToLower();        
 
			// Define characters to strip from the input and do it
			string[] stripChars = { ";", ",", ".", "-", "_", "^", "(", ")", "[", "]",
						"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "\n", "\t", "\r" };
			foreach (string character in stripChars)
			{
				inputString = inputString.Replace(character, "");
			}
			
			// Split on spaces into a List of strings
			List<string> wordList = inputString.Split(' ').ToList();
 
			// Define and remove stopwords
			string[] stopwords = new string[] { "and", "the", "she", "for", "this", "you", "but" };
			foreach (string word in stopwords)
			{
				// While there's still an instance of a stopword in the wordList, remove it.
				// If we don't use a while loop on this each call to Remove simply removes a single
				// instance of the stopword from our wordList, and we can't call Replace on the
				// entire string (as opposed to the individual words in the string) as it's
				// too indiscriminate (i.e. removing 'and' will turn words like 'bandage' into 'bdage'!)
				while ( wordList.Contains(word) )
				{
					wordList.Remove(word);
				}
			}
			
			// Create a new Dictionary object
			Dictionary<string, int> dictionary = new Dictionary<string, int>();
 
			// Loop over all over the words in our wordList...
			foreach (string word in wordList)
			{
				// If the length of the word is at least three letters...
				if (word.Length >= 3) 
				{
					// ...check if the dictionary already has the word.
					if ( dictionary.ContainsKey(word) )
					{
						// If we already have the word in the dictionary, increment the count of how many times it appears
						dictionary[word]++;
					}
					else
					{
						// Otherwise, if it's a new word then add it to the dictionary with an initial count of 1
						dictionary[word] = 1;
					}
 
				} // End of word length check
 
			} // End of loop over each word in our input
 
			// Create a dictionary sorted by value (i.e. how many times a word occurs)
			var sortedDict = (from entry in dictionary orderby entry.Value descending select entry).ToDictionary(pair => pair.Key, pair => pair.Value);
 
			// Loop through the sorted dictionary and output the top 10 most frequently occurring words
			int count = 1;
			Console.WriteLine("---- Most Frequent Terms in the File: " + filename + " ----");
			Console.WriteLine();
			foreach (KeyValuePair<string, int> pair in sortedDict)
			{
				// Output the most frequently occurring words and the associated word counts
				Console.WriteLine(count + "\t" + pair.Key + "\t" + pair.Value);
				count++;
 
				// Only display the top 10 words then break out of the loop!
				if (count > 10)
				{
					break;
				}
			}
 
			// Wait for the user to press a key before exiting
			Console.ReadKey();
			
		} // End of Main method
 
	} // End of Program class
 
} // End of namespace
*/