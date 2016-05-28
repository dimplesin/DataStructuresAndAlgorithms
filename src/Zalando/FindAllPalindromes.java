package Zalando;

/**
 * Created by v-dsindhi on 2/4/16.
 */
import java.util.Scanner;

public class FindAllPalindromes {
    static String longestPalindrome;
    public String oldPalindrome="";
    static int longest;

    public void allSubstrings(String s){
        for(int i=0;i<s.length();i++){
            for(int j=1;j<=s.length()-i;j++){
                String subString=s.substring(i, i+j);
                palindrome(subString);
            }
        }
    }
    public void palindrome(String sub){
        //System.out.println("String to b checked is "+sub);
        StringBuilder sb=new StringBuilder();
        sb.append(sub);     // append string to string builder
        sb.reverse();
        if(sub.equals(sb.toString())){                        // palindrome condition
            System.out.println("the given String :"+sub+" is a palindrome");
            longestPalindrome(sub);
        }
        else{
            //System.out.println("the string "+sub+"iss not a palindrome");
        }
    }
    public void longestPalindrome(String s){
        if(s.length()>longest){
            longest=s.length();
            longestPalindrome=s;

        }
        else if (s.length()==longest){
            oldPalindrome=longestPalindrome;
            longestPalindrome=s;

        }
    }

    public static void main(String[] args) {
        FindAllPalindromes fp=new FindAllPalindromes();

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String ::");
        String s=sc.nextLine();
        fp.allSubstrings(s);
        sc.close();
        if(fp.oldPalindrome.length()>0){
            System.out.println(longestPalindrome+" and "+fp.oldPalindrome+":is the longest palindrome");
        }
        else{
            System.out.println(longestPalindrome+" :is the longest palindrome`````");
        }}
}