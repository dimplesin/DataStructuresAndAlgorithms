package com.company.Microsoft;

/**
 * Created by v-dsindhi on 8/1/15.
 */
public class CloneALinkedListWithRandomPointer {

    /*
    The idea is to use Hashing. Below is algorithm.
1. Traverse the original linked list and make a copy in terms of data.
2. Make a hash map of key value pair with original linked list node and copied linked list node.
3. Traverse the original linked list again and using the hash map adjust the next and random reference of cloned linked list nodes.

A Java based approach of the above idea is below.

// Java program to clone a linked list with random pointers
import java.util.HashMap;
import java.util.Map;

// Linked List Node class
class Node
{
    int data;//Node data
    Node next, random;//Next and random reference

    //Node constructor
    public Node(int data)
    {
        this.data = data;
        this.next = this.random = null;
    }
}

// linked list class
class LinkedList
{
    Node head;//Linked list head reference

    // Linked list constructor
    public LinkedList(Node head)
    {
        this.head = head;
    }

    // push method to put data always at the head
    // in the linked list.
    public void push(int data)
    {
        Node node = new Node(data);
        node.next = this.head;
        this.head = node;
    }

    // Method to print the list.
    void print()
    {
        Node temp = head;
        while (temp != null)
        {
            Node random = temp.random;
            int randomData = (random != null)? random.data: -1;
            System.out.println("Data = " + temp.data +
                               ", Random data = "+ randomData);
            temp = temp.next;
        }
    }

    // Actual clone method which returns head
    // reference of cloned linked list.
    public LinkedList clone()
    {
        // Initialize two references, one with original
        // list's head.
        Node origCurr = this.head, cloneCurr = null;

        // Hash map which contains node to node mapping of
        // original and clone linked list.
        Map<Node, Node> map = new HashMap<Node, Node>();

        // Traverse the original list and make a copy of that
        // in the clone linked list.
        while (origCurr != null)
        {
            cloneCurr = new Node(origCurr.data);
            map.put(origCurr, cloneCurr);
            origCurr = origCurr.next;
        }

        // Adjusting the original list reference again.
        origCurr = this.head;

        // Traversal of original list again to adjust the next
        // and random references of clone list using hash map.
        while (origCurr != null)
        {
            cloneCurr = map.get(origCurr);
            cloneCurr.next = map.get(origCurr.next);
            cloneCurr.random = map.get(origCurr.random);
            origCurr = origCurr.next;
        }

        //return the head reference of the clone list.
        return new LinkedList(map.get(this.head));
    }
}

// Driver Class
class Main
{
    // Main method.
    public static void main(String[] args)
    {
        // Pushing data in the linked list.
        LinkedList list = new LinkedList(new Node(5));
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);

        // Setting up random references.
        list.head.random = list.head.next.next;
        list.head.next.random =
            list.head.next.next.next;
        list.head.next.next.random =
            list.head.next.next.next.next;
        list.head.next.next.next.random =
            list.head.next.next.next.next.next;
        list.head.next.next.next.next.random =
            list.head.next;

        // Making a clone of the original linked list.
        LinkedList clone = list.clone();

        // Print the original and cloned linked list.
        System.out.println("Original linked list");
        list.print();
        System.out.println("\nCloned linked list");
        clone.print();
    }
}
Run on IDE
Output:

Original linked list
Data = 1, Random data = 3
Data = 2, Random data = 4
Data = 3, Random data = 5
Data = 4, Random data = -1
Data = 5, Random data = 2

Cloned linked list
Data = 1, Random data = 3
Data = 2, Random data = 4
Data = 3, Random data = 5
Data = 4, Random data = -1
Data = 5, Random data = 2
Time complexity : O(n)
Auxiliary space : O(n)



You are given a Double Link List with one pointer of each node pointing to the next node just like in a single link list. The second pointer however CAN point to any node in the list and not just the previous node. Now write a program in O(n) time to duplicate this list. That is, write a program which will create a copy of this list.

Let us call the second pointer as arbit pointer as it can point to any arbitrary node in the linked list.

ArbitLinked List1

Arbitrary pointers are shown in red and next pointers in black

Figure 1

Method 1 (Uses O(n) extra space)
This method stores the next and arbitrary mappings (of original list) in an array first, then modifies the original Linked List (to create copy), creates a copy. And finally restores the original list.

1) Create all nodes in copy linked list using next pointers.
3) Store the node and its next pointer mappings of original linked list.
3) Change next pointer of all nodes in original linked list to point to the corresponding node in copy linked list.
Following diagram shows status of both Linked Lists after above 3 steps. The red arrow shows arbit pointers and black arrow shows next pointers.

ArbitLinked List2

Figure 2

4) Change the arbit pointer of all nodes in copy linked list to point to corresponding node in original linked list.
5) Now construct the arbit pointer in copy linked list as below and restore the next pointer of nodes in the original linked list.

       copy_list_node->arbit =
                      copy_list_node->arbit->arbit->next;
       copy_list_node = copy_list_node->next;
6) Restore the next pointers in original linked list from the stored mappings(in step 2).

Time Complexity:  O(n)
Auxiliary Space:  O(n)



Method 2 (Uses Constant Extra Space)
Thanks to Saravanan Mani for providing this solution. This solution works using constant space.
1) Create the copy of node 1 and insert it between node 1 & node 2 in original Linked List, create the copy of 2 and insert it between 2 & 3.. Continue in this fashion, add the copy of N afte the Nth node
2) Now copy the arbitrary link in this fashion

     original->next->arbitrary = original->arbitrary->next;  /*TRAVERSE
TWO NODES*/
   /* This works because original->next is nothing but copy of original and Original->arbitrary->next is nothing but copy of arbitrary.
    3) Now restore the original and copy linked lists in this fashion in a single loop.

            original->next = original->next->next;
    copy->next = copy->next->next;
    4) Make sure that last element of original->next is NULL.

    Time Complexity: O(n)
    Auxiliary Space: O(1)

     */
}
