package com.company.amazon.BookKarumanchi.Algorithms.StringAlgorithms;

import java.util.StringTokenizer;

/**
 * Created by v-dsindhi on 4/2/15.
 */
public class ProblemsOnString {

    //Give an algorithm for reversing a string
    public String ReversingString(String str){
        char temp; int start=0, end = str.length();
        for(start = 0; start < end;start++, end--){
            temp = str.charAt(start);
            //str.setCharAt(start, str.charAt(end));
            //str.setCharAt(end, temp);
        }
        return str;
    }

    //If str is constant
    public static String reverseIt(String str){
        int i, len = str.length();
        StringBuffer dest = new StringBuffer(len);
        for(i=len-1; i>=0; i--){
            dest.append(str.charAt(i));
        }
        return dest.toString();
    }

    //can we reverse the string without using any temporary variable
    String ReverseString(String str){
        int end = str.length()-1;
        int start = 0;
        while(start <end){
            //str.setCharAt(start, str.charAt(start)^str.charAt(end));
            //str.setCharAt(end, str.charAt(end)^str.charAt(start));
            //str.setCharAt(start, str.charAt(start) ^ str.charAt(end));
        }
        return str;
    }

    //Give an algorithm for reversing words in a sentence
    public static void ReversingSentence(String strLine){
        //specify a delimiter as " " space
        StringTokenizer st = new StringTokenizer(strLine, " ");
        String strReversedLine = "";
        while(st.hasMoreTokens()){
            strReversedLine = st.nextToken() + " "+strReversedLine;
        }
        System.out.println("Reversed string by word is : "+strReversedLine);
    }

    //Given a string "ABCCBCBA". Give an algorithm for recursively removing the adjacent characters if they are same
    void RemoveAdjacentPair(char[] str, int len){
        int j = 0;
        for(int i=1;i<=len;i++){
            while((str[i] == str[j]) && j >= 0){
                i++;
                j--;
            }
            str[++j] = str[i];
        }
        return;
    }

    //Given a set of characters CHARS and a input string INPUT, fint the minimum window in the str which will contain all the characters
    //on CHARS in complexity O(n)
    void MinLength(char[] input, int iplen, char[] chars, int charlen){
        int shouldfind[] ={0,};
        int hasFound[] = {0,};
        int j=0, cnt = 0,start,finish,minwindow = Integer.MAX_VALUE;
        for(int i=0;i<charlen;i++){
            shouldfind[chars[i]] += 1;
        }
        start = 0;
        finish = iplen;
        for(int i=0;i<iplen;i++){
            if(shouldfind[input[i]] != 0){
                continue;
            }
            hasFound[input[i]] += 1;

            if(shouldfind[input[i]]>= hasFound[input[i]]){
                cnt++;
            }
            if(cnt == charlen){
                while(shouldfind[input[j]] == 0 || hasFound[input[j]] > shouldfind[input[j]]){
                    if(hasFound[input[j]] > shouldfind[input[j]]){
                        hasFound[input[j]]--;
                    }
                    j++;
                }
                if(minwindow > (i-j+1)){
                    minwindow = i-j+1;
                    finish = i;
                    start = j;
                }
            }
        }
        System.out.println("Start:"+start+" and Finish:"+finish);
    }

    //We are given a 2D array of characters and a character pattern. Give an algorithm to find if pattern is present in 2D array
    //Pattern can be in any way but we can't use same character twice while matching. Return 1 if match is found, 0 if not found.
    //For example "MICROSOFT" in below matrix
    /* A  C  P  R  C                  R
     * X  S  O  P  C                  S  O  C
     * V  O  V  N  I                  O  I
     * W  G  F  M  N                  F  M
     * Q  A  T  I  T                  T
     * */

  boolean FindMatch_wrapper(char[][] mat, char[] pat, int patLen, int nrow, int ncol){
      if(patLen > nrow*ncol){
          return false;
      }
      int used[][] = {{0,},};
      return FindMatch(mat, pat, patLen, used, 0, 0, nrow, ncol, 0);

  }

    private boolean FindMatch(char[][] mat, char[] pat, int patLen, int[][] used, int x, int y, int nrow, int ncol, int level) {
        if(level == patLen){
            return true;
        }
        if(nrow == x || ncol == y){
            return false;
        }
        if(used[x][y] == 0){
            return false;
        }
        if(mat[x][y] != pat[level] && level == 0){
            if(x < (nrow - 1)){
                return FindMatch(mat, pat, patLen, used, x+1, y, nrow, ncol, level);
            }else if(y < (ncol-1)){
                return FindMatch(mat, pat, patLen, used, 0, y+1, nrow, ncol, level);
            }else {
                return false;
            }
        }else if(mat[x][y] == pat[level]){
            boolean res;
            used[x][y] = 1;
            res = (x>0 ? FindMatch(mat, pat,patLen, used, x-1, y, nrow, ncol, level+1) : false) ||
                  (res = x < nrow-1 ? FindMatch(mat, pat, patLen, used, x+1, y, nrow, ncol, level+1):false) ||
                  (res = y > 0 ? FindMatch(mat, pat, patLen, used, x, y-1, nrow, ncol, level+1) : false)||
                  (res = y < ncol-1 ? FindMatch(mat, pat, patLen, used, x, y+1, nrow, ncol, level+1): false) ||
                  (res = x < (nrow-1) && y < (ncol-1) ? FindMatch(mat, pat, patLen, used, x+1, y+1, nrow, ncol, level+1):false) ||
                  (res = x < nrow-1 && y >0 ? FindMatch(mat, pat, patLen, used, x+1, y-1, nrow, ncol, level+1) : false) ||
                  (res = x > 0 && y < ncol-1 ? FindMatch(mat, pat, patLen, used, x-1, y+1, nrow, ncol, level+1) : false) ||
                  (res = x>0 && y>0 ? FindMatch(mat, pat, patLen, used, x-1, y-1, nrow, ncol, level+1) : false);

            used[x][y] = 0;
            return res;
        }
        else {
            return false;
        }
    }
}
