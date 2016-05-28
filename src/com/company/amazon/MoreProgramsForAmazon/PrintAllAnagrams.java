package com.company.amazon.MoreProgramsForAmazon;

import java.util.*;

public class PrintAllAnagrams {

   public static List<String> sortWithAnagramsTogether(List<String> elements) {
      List<String> sortedElements = sort(elements);
      Map<String, List<String>> anagramMap = new LinkedHashMap<String, List<String>>();
      for (String element : sortedElements) {
         String sortedElement = sortChars(element);
         if (anagramMap.get(sortedElement) == null) {
            anagramMap.put(sortedElement, new ArrayList<String>());
         }
         anagramMap.get(sortedElement).add(element);
      }
      Map<String, List<String>> tmpMap = new LinkedHashMap<String, List<String>>();
      for (String key : anagramMap.keySet()) {
         tmpMap.put(anagramMap.get(key).get(0), anagramMap.get(key));
      }
      anagramMap = tmpMap;
      List<String> sortedWithAnagrams = new ArrayList<String>();
      List<String> mapKeys = new ArrayList<String>(anagramMap.keySet());
      Collections.sort(mapKeys);
      for (String mapKey : mapKeys) {
         for (String element : anagramMap.get(mapKey)) {
            sortedWithAnagrams.add(element);
         }
      }
      return sortedWithAnagrams;
   }

   public static String sortChars(String str) {
      char[] strChars = str.toCharArray();
      Arrays.sort(strChars);
      return String.valueOf(strChars);
   }

   public static List<String> sort(List<String> elements) {
      List<String> sortedElements = new ArrayList<String>(elements);
      Collections.sort(sortedElements);
      return sortedElements;
   }

   public static void main(String[] args) {
      List<String> elements = Arrays.asList("god", "dog", "abc", "cab", "man");
      List<String> sortedElements = sortWithAnagramsTogether(elements);
      System.out.println(sortedElements);
   }

}