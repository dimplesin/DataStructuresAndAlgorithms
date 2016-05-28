package com.company.amazon.MoreProgramsForAmazon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vishal.naik
 * java-fries.com
 */
public class SmallestStrFinderProblem {

    public static void main(String[] args) {
	long start = System.currentTimeMillis();
	String str1 = "spqrstrupvqw";
	String str2 = "sprt";
	String str3 = "q";

	findSmallestSubString(str1, str2, str3);
	System.out.println("Time taken: "
		+ (System.currentTimeMillis() - start));
    }

    /**
     * Finds the smallest substring in str1 which contains all the characters in
     * str2 (in any order) and not those in str3.
     * 
     * @param str1 , not null
     * @param str2 , not null
     * @param str3 , not null
     */
    private static void findSmallestSubString(String str1, String str2,
	    String str3) {
	char[] str3Chars = str3.toCharArray();

	List<String> possibleSearchStrs = findPossibleSearchStrings(str1, str2,
		str3Chars);

	int minLength = Integer.MAX_VALUE;
	String minStr = "";

	for (String word : possibleSearchStrs) {
	    char[] wordChars = word.toCharArray();

	    // Iterate over characters of word.
	    for (int i = 0; i < wordChars.length; i++) {
		
		// Create substring of word starting at current character to str2.length,
		// Increment substring's length by one, on every iteration.
		for (int j = i + str2.length(); j < wordChars.length; j++) {
		    String subStr = word.substring(i, j);
		    
		    if (containsString2(subStr, str2)) {
			if (j - i < minLength) {
			    minLength = j - i;
			    minStr = subStr;
			}
		    }
		}
	    }
	}
	if (minStr.isEmpty()) {
	    System.out.println("No Solution found.");
	} else {
	    System.out.println(minStr);
	}
    }

    /**
     * Finds all possible search strings
     * 
     * @param str1 , not null
     * @param str2 , not null
     * @param str3Chars , not null
     * @return
     */
    private static List<String> findPossibleSearchStrings(String str1,
	    String str2, char[] str3Chars) {
	List<String> possibleSearchStrs = new ArrayList<String>();
	possibleSearchStrs.add(str1);

	for (int i = 0; i < str3Chars.length; i++) {
	    List<String> tempStore = new ArrayList<String>();
	    for (String word : possibleSearchStrs) {
		String[] wordSplit = word.split(String.valueOf(str3Chars[i]));
		for (int j = 0; j < wordSplit.length; j++) {
		    if (wordSplit[j].length() >= str2.length()) {
			tempStore.add(wordSplit[j]);
		    }
		}
	    }
	    possibleSearchStrs.clear();
	    possibleSearchStrs.addAll(tempStore);
	}
	return possibleSearchStrs;
    }

    /**
     * Checks if str2 is contained in subStr.
     * 
     * @param subStr , not null
     * @param str2 , not null
     * @return
     */
    private static boolean containsString2(String subStr, String str2) {
	char[] str2Chars = str2.toCharArray();
	for (int i = 0; i < str2Chars.length; i++) {
	    if (!subStr.contains(String.valueOf(str2Chars[i]))) {
		return false;
	    }
	}
	return true;
    }
}