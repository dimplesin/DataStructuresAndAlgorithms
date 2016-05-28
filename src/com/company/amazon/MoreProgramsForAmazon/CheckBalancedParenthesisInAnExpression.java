package com.company.amazon.MoreProgramsForAmazon;

import java.util.Stack;

public class CheckBalancedParenthesisInAnExpression {
	 
	/* Returns true if character1 and character2 are matching left
	   and right Parenthesis */
	static boolean isMatchingPair(char character1, char character2)
	{
	   if(character1 == '(' && character2 == ')')
	     return true;
	   else if(character1 == '{' && character2 == '}')
	     return true;
	   else if(character1 == '[' && character2 == ']')
	     return true;
	   else
	     return false;
	}
	 
	 /*Return true if expression has balanced Parenthesis */
	 static boolean areParenthesisBalanced(char exp[])
	{
	   int i = 0;
	   /* Declare an empty character stack */
	   Stack<Character> stack = new Stack<>();
	   /* Traverse the given expression to check matching parenthesis */
	   while(i <= exp.length-1)
	   {
	      /*If the exp[i] is a starting parenthesis then push it*/
	      if(exp[i] == '{' || exp[i] == '(' || exp[i] == '[')
			  stack.push(exp[i]);
	 
	      /* If exp[i] is a ending parenthesis then pop from stack and 
	          check if the popped parenthesis is a matching pair*/
	      if(exp[i] == '}' || exp[i] == ')' || exp[i] == ']')
	      {
	          /*If we see an ending parenthesis without a pair then return false*/
	         if(stack == null)
	           return false; 
	         /* Pop the top element from stack, if it is not a pair
	            parenthesis of character then there is a mismatch.
	            This happens for expressions like {(}) */
	         else if ( !isMatchingPair(stack.pop(), exp[i]) )
	           return false;
	      }
	      i++;
	   }
	    /* If there is something left in expression then there is a starting
	      parenthesis without a closing parenthesis */
	   if(stack.size() == 0)
	     return true; /*balanced*/
	   else
	     return false;  /*not balanced*/
	} 
	 
	/* UTILITY FUNCTIONS */
	/*driver program to test above functions*/
	public static void main(String args[])
	{
	  char exp[] = {'{','(',')','}','[',']'};
	  if(areParenthesisBalanced(exp))
	    System.out.println("\n Balanced ");
	  else
		  System.out.println("\n Not Balanced ");
	}
}
