package com.company.amazon.MoreProgramsForAmazon;

import java.util.Arrays;

public class AnagramsSort {

	private static void sort(String[] input) {
		for (int i = 0; i < input.length - 1; i++) {
			// put correct value to index i
			for (int j = i + 1; j < input.length; j++) {
				if (input[i].compareTo(input[j]) > 0) {
					swap(input, i, j);
				}
			}
			// place anagrams follow index i
			int anagramCount = 0;
			char[] anagramKey = toAnagramKey(input[i]);
			for (int j = i + 1; j < input.length; j++) {
				if (isAnagram(anagramKey, input[j])) {
					anagramCount++;
					swap(input, i + anagramCount, j);
				}
			}
			if (anagramCount > 0) {
				Arrays.sort(input, i + 1, i + anagramCount + 1);
				i += anagramCount;
			}
		}
	}

	private static boolean isAnagram(char[] anagramKey, String string) {
		if (string.length() != anagramKey.length) {
			return false;
		}
		return Arrays.equals(toAnagramKey(string), anagramKey);
	}

	private static char[] toAnagramKey(String string) {
		char[] arr = string.toCharArray();
		Arrays.sort(arr);
		return arr;
	}

	private static void swap(String[] input, int i, int j) {
		String temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

	public static void main(String[] args) {
		String[] input = { "god", "dog", "abc", "cab", "man"};
		String[] expected = {"abc", "cab", "dog", "god", "man"};
		sort(input);
		System.out.println(Arrays.toString(input));
		if(!Arrays.equals(input, expected)) {
			throw new AssertionError();
		}
	}

}