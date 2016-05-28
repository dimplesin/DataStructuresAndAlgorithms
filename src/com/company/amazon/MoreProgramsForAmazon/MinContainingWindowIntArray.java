package com.company.amazon.MoreProgramsForAmazon;

import java.util.*;

public class MinContainingWindowIntArray {
    public static void main(String[] args) {
        int[] list = { 1, 43, 4, 23, 1, 3, 5, 9, 1, 12, 4, 3, 4 };
        int[] find = { 1, 4, 3 };

        int[] window = findMinContainingWindow(list, find);

        if (window == null) {
            System.out.println("No window found.");
        } else {
            System.out.print("The following window is smallest: [");

            for (int i = window[0]; i <= window[1]; ++i) {
                System.out.print(list[i] + ((i == window[1]) ? "]\n" : ", "));
            }
        }
    }

    public static int[] findMinContainingWindow(int[] haystack, int[] needle) {
        if (haystack == null || needle == null) {
            return null;
        }

        int n = haystack.length;
        int k = needle.length;

        if (n == 0 || k == 0 || k > n) {
            return null;
        }

        Map<Integer, ArrayList<Integer>> haystackValueToIndexMap = new HashMap<Integer, ArrayList<Integer>>();

        for (int i = 0; i < n; ++i) {
            int haystackValue = haystack[i];

            if (haystackValueToIndexMap.containsKey(haystackValue)) {
                List<Integer> occurrenceList = haystackValueToIndexMap.get(haystackValue);
                occurrenceList.add(i);
            } else {
                ArrayList<Integer> occurrenceList = new ArrayList<Integer>();
                occurrenceList.add(i);
                haystackValueToIndexMap.put(haystackValue, occurrenceList);
            }
        }

        ArrayList<ArrayList<Integer>> orderedOccurrenceIndices = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < k; ++i) {
            int needleValue = needle[i];

            if (haystackValueToIndexMap.containsKey(needleValue)) {
                orderedOccurrenceIndices.add(haystackValueToIndexMap.get(needleValue));
            } else {
                return null;
            }
        }

        int[] sublistPointer = new int[k];
        int minWindowSize = n + 1;
        int startIndex = -1;
        int endIndex = -1;

        for (sublistPointer[0] = 0; sublistPointer[0] < orderedOccurrenceIndices.get(0).size(); ++sublistPointer[0]) {
            for (int sublistIndex = 1; sublistIndex < k; ++sublistIndex) {
                int numPossibleOccurrences = orderedOccurrenceIndices.get(sublistIndex).size();

                while (sublistPointer[sublistIndex] < numPossibleOccurrences &&
                    orderedOccurrenceIndices.get(sublistIndex).get(sublistPointer[sublistIndex]) <= orderedOccurrenceIndices.get(sublistIndex - 1).get(sublistPointer[sublistIndex - 1])) {
                    ++sublistPointer[sublistIndex];
                }

                if (sublistPointer[sublistIndex] == numPossibleOccurrences) {
                    return (startIndex == -1) ? null : new int[] { startIndex, endIndex };
                }
            }

            int currentStartIndex = orderedOccurrenceIndices.get(0).get(sublistPointer[0]);
            int currentEndIndex = orderedOccurrenceIndices.get(k - 1).get(sublistPointer[k - 1]);
            int windowSize = currentEndIndex - currentStartIndex;

            if (windowSize < minWindowSize) {
                minWindowSize = windowSize;
                startIndex = currentStartIndex;
                endIndex = currentEndIndex;
            }
        }

        return (startIndex == -1) ? null : new int[] { startIndex, endIndex };
    }
}
