package com.company.amazon.MoreProgramsForAmazon;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SubstringofStringContainingAllChars {

	// Returns false if no valid window is found. Else returns 
	// true and updates minWindowBegin and minWindowEnd with the 
	// starting and ending position of the minimum window.
	boolean minWindow( char S[],  char T[], 
	               int minWindowBegin, int minWindowEnd) {
	  int sLen = S.length;
	  int tLen = T.length;
	  int needToFind[] = new int[256];
	 
	  for (int i = 0; i < tLen; i++)
	    needToFind[T[i]]++;
	 
	  int hasFound[] = new int[256];
	  int minWindowLen = Integer.MAX_VALUE;
	  int count = 0;
	  for (int begin = 0, end = 0; end < sLen; end++) {
	    // skip characters not in T
	    if (needToFind[S[end]] == 0) continue;
	    hasFound[S[end]]++;
	    if (hasFound[S[end]] <= needToFind[S[end]])
	      count++;
	 
	    // if window constraint is satisfied
	    if (count == tLen) {
	      // advance begin index as far right as possible,
	      // stop when advancing breaks window constraint.
	      while (needToFind[S[begin]] == 0 ||
	            hasFound[S[begin]] > needToFind[S[begin]]) {
	        if (hasFound[S[begin]] > needToFind[S[begin]])
	          hasFound[S[begin]]--;
	        begin++;
	      }
	 
	      // update minWindow if a minimum length is met
	      int windowLen = end - begin + 1;
	      if (windowLen < minWindowLen) {
	        minWindowBegin = begin;
	        minWindowEnd = end;
	        minWindowLen = windowLen;
	      } // end if
	    } // end if
	  } // end for
	 
	  return (count == tLen) ? true : false;
	}
}



//Time Complexity: O(w + ws)
//Space Complexity: O(s)
//Where w is the number of words in the document, and s is the number of search terms
class Solution {
    private Map<String, Integer> snippetDataPoints = new HashMap<String, Integer>();
    private String[] words, searchTerms;
    private int shortestSnippetStart = 0, shortestSnippetEnd, currentSnippetStart = 0;

    public static String solution(String document, String[] searchTerms) {
        Solution solution = new Solution (document.split(" "), searchTerms);//document.split isnt the most efficient, but we are already over O(n), and this keeps it simple
        return solution.solve();
    }

    private Solution(String[] words, String[] searchTerms){
        this.words = words;
        this.searchTerms = searchTerms;
        shortestSnippetEnd=words.length;
    }

    private String solve(){
        for(int i=0;i<words.length;i++){
            if(searchTermsContains(words[i])){
                addToSnippet(words[i], i);
            }
        }
        StringBuilder snippet = new StringBuilder();
        for(int i = shortestSnippetStart; i<=shortestSnippetEnd; i++){
            snippet.append(words[i] + " ");
        }
        snippet.deleteCharAt(snippet.length()-1);
        return snippet.toString();
    }

    private void addToSnippet(String word, int position) {
        Integer previousPosition = snippetDataPoints.put(word, position);
        if(previousPosition == null || previousPosition <= currentSnippetStart){
            currentSnippetStart = Collections.min(snippetDataPoints.values());
        }
        if(snippetDataPoints.size() == searchTerms.length){
            determineShortestSnippet(position);
        }
    }

    private void determineShortestSnippet(int currentPositionEnd) { 
        if(shortestSnippetEnd - shortestSnippetStart > currentPositionEnd - currentSnippetStart ){
            shortestSnippetStart = currentSnippetStart;
            shortestSnippetEnd = currentPositionEnd;
        }
    }

    private boolean searchTermsContains(String word) {
        for(String searchTerm : searchTerms){
            if(searchTerm.equals(word)) return true;
        }
        return false;
    }
}

