package com.company.amazon.MoreProgramsForAmazon;

class DLNode{
	char a;
	DLNode next, prev;
}
public class FirstNonRepeatingCharacterFromStream {
	// A C++ program to find first non-repeating character from a stream of characters
	// A linked list node
	
	 
	// A utility function to append a character x at the end of DLL.
	// Note that the function may change head and tail pointers, that
	// is why pointers to these pointers are passed.
	static void appendNode(DLNode head_ref, DLNode tail_ref, char x)
	{
	    DLNode temp = new DLNode();
	    temp.a = x;
	    temp.prev = temp.next = null;
	 
	    if (head_ref == null)
	    {
	        head_ref = tail_ref = temp;
	        return;
	    }
	    (tail_ref).next = temp;
	    temp.prev = tail_ref;
	    tail_ref = temp;
	}
	 
	// A utility function to remove a node 'temp' fromt DLL. Note that the
	// function may change head and tail pointers, that is why pointers to
	// these pointers are passed.
	static void removeNode(DLNode head_ref, DLNode tail_ref,
	                DLNode temp)
	{
	    if (head_ref == null)
	        return;
	 
	    if (head_ref == temp)
	        head_ref = (head_ref).next;
	    if (tail_ref == temp)
	        tail_ref = (tail_ref).prev;
	    if (temp.next != null)
	        temp.next.prev = temp.prev;
	    if (temp.prev != null)
	        temp.prev.next = temp.next;
	 
	    temp=null;
	}
	 
	static void findFirstNonRepeating()
	{
	    // inDLL[x] contains pointer to a DLL node if x is present in DLL.
	    // If x is not present, then inDLL[x] is null
	    DLNode inDLL[]=new DLNode[256];
	 
	    // repeated[x] is true if x is repeated two or more times. If x is
	    // not seen so far or x is seen only once. then repeated[x] is false
	    boolean repeated[] = new boolean[256];
	 
	    // Initialize the above two arrays
	    DLNode head = null, tail = null;
	    for (int i = 0; i < 256; i++)
	    {
	        inDLL[i] = null;
	        repeated[i] = false;
	    }
	 
	    // Let us consider following stream and see the process
	    char stream[] = "geeksforgeeksandgeeksquizfor".toCharArray();
	    for (int i = 0; i<stream.length; i++)
	    {
	        char x = stream[i];
	        System.out.println("Reading " +x+ " from stream ");
	 
	        // We process this character only if it has not occurred or occurred
	        // only once. repeated[x] is true if x is repeated twice or more.s
	        if (!repeated[x])
	        {
	            // If the character is not in DLL, then add this at the end of DLL.
	            if (inDLL[x] == null)
	            {
	                appendNode(head, tail, stream[i]);
	                inDLL[x] = tail;
	            }
	            else // Otherwise remove this caharacter from DLL
	            {
	                removeNode(head, tail, inDLL[x]);
	                inDLL[x] = null;
	                repeated[x] = true;  // Also mark it as repeated
	            }
	        }
	 
	        // Print the current first non-repeating character from stream
	        if (head != null)
	            System.out.println("First non-repeating character so far is " + head.a);
	        }
	}
	 
	// Driver program to test above function 
	public static void main(String args[])
	{
	    findFirstNonRepeating();
	   
	}
}
