package com.company.amazon.MoreProgramsForAmazon;

public class AddTwoNumbersWithoutUsingPlusOperator {

	static int Add(int x, int y)
	{
	    // Iterate till there is no carry  
	    while (y != 0)
	    {
	        // carry now contains common set bits of x and y
	        int carry = x & y;  
	 
	        // Sum of bits of x and y where at least one of the bits is not set
	        x = x ^ y; 
	 
	        // Carry is shifted by one so that adding it to x gives the required sum
	        y = carry << 1;
	    }
	    return x;
	}
	 
	public static void main(String args[])
	{
	    System.out.println(Add(19, 32));
	}
	
	int AddRecursive(int x, int y)
	{
	    if (y == 0)
	        return x;
	    else
	        return AddRecursive( x ^ y, (x & y) << 1);
	}
}
