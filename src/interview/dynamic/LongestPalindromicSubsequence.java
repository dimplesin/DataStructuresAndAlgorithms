package interview.dynamic;

import com.company.amazon.BookKarumanchi.Challenges.HashMap;

import java.util.Map;
import java.util.Scanner;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 */
public class LongestPalindromicSubsequence {

   /* public int calculate(char []str){
        int T[][] = new int[str.length+1][str.length+1];
        for(int i=0; i < str.length; i++){
            T[1][i] = 1;
        }
        for(int c = 2; c <= str.length; c++){
            for(int i = 1; i <= str.length-c+1; i++){
                if(str[i-1] == str[i-1 + c-1] && c == 2){
                    T[c][i] = 2;
                }else if(str[i-1] == str[i+c-2]){
                    T[c][i] = T[c-2][i+1] + 2;
                }else{
                    T[c][i] = Math.max(T[c - 1][i + 1], T[c - 1][i]);
                }
            }
        }
        return T[str.length][1];
    }*/
    
    public int calculateRecursive(char str[],int start,int len){
        if(len == 1){
            return 1;
        }
        if(len ==0){
            return 0;
        }
        if(str[start] == str[start+len-1]){
            return 2 + calculateRecursive(str,start+1,len-2);
        }else{
            return Math.max(calculateRecursive(str, start + 1, len - 1), calculateRecursive(str, start, len - 1));
        }
    }
    
   /* public static void main(String args[]){
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        String str = "GEEKSFORGEEKS";
        int  r = lps.calculate(str.toCharArray());
        int r1 = lps.calculateRecursive(str.toCharArray(), 0, str.length());
        System.out.print(r + " " + r1);
    }*/

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int numberOfTestCase = sc.nextInt();
        Map<Integer, String> mapOfStrings = new HashMap<>();
        for(int i=0;i<=2*numberOfTestCase;i++){
            mapOfStrings.put(i, sc.nextLine());
        }
        int k=1;
        System.out.println(mapOfStrings);
        for(int j=0;j<numberOfTestCase;j++){
            int firstString = calculate(mapOfStrings.get(k).toCharArray());
            int secondString = calculate(mapOfStrings.get(k+1).toCharArray());
            int lengthOfLongestPalindrome = firstString+secondString;
            System.out.println(lengthOfLongestPalindrome);
            k+=2;
        }
    }

    public static int calculate(char []str){
        int T[][] = new int[str.length+1][str.length+1];
        for(int i=0; i < str.length; i++){
            T[1][i] = 1;
        }
        for(int c = 2; c <= str.length; c++){
            for(int i = 1; i <= str.length-c+1; i++){
                if(str[i-1] == str[i-1 + c-1] && c == 2){
                    T[c][i] = 2;
                }else if(str[i-1] == str[i+c-2]){
                    T[c][i] = T[c-2][i+1] + 2;
                }else{
                    T[c][i] = Math.max(T[c - 1][i + 1], T[c - 1][i]);
                }
            }
        }
        return T[str.length][1];
    }
}
