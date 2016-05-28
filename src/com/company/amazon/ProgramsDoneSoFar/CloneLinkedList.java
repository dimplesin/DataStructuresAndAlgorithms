package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/22/15.
 */
    // Java program to clone a linked list with random pointers
    import java.util.HashMap;
    import java.util.Map;

    // Linked List Node class
    class CloneNode
    {
        int data;//Node data
        CloneNode next, random;//Next and random reference
        //CloneNode constructor
        public CloneNode(int data)
        {
            this.data = data;
            this.next = this.random = null;
        }
    }

    // linked list class
    class LinkedList
    {
        CloneNode head;//Linked list head reference
        // Linked list constructor
        public LinkedList(CloneNode head)
        {
            this.head = head;
        }
        // push method to put data always at the head
        // in the linked list.
        public void push(int data)
        {
            CloneNode CloneNode = new CloneNode(data);
            CloneNode.next = this.head;
            this.head = CloneNode;
        }
        // Method to print the list.
        void print()
        {
            CloneNode temp = head;
            while (temp != null)
            {
                CloneNode random = temp.random;
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
            CloneNode origCurr = this.head, cloneCurr = null;
            // Hash map which contains node to node mapping of
            // original and clone linked list.
            Map<CloneNode, CloneNode> map = new HashMap<CloneNode, CloneNode>();
            // Traverse the original list and make a copy of that
            // in the clone linked list.
            while (origCurr != null)
            {
                cloneCurr = new CloneNode(origCurr.data);
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
    public class CloneLinkedList
    {
        // Main method.
        public static void main(String[] args)
        {
            // Pushing data in the linked list.
            LinkedList list = new LinkedList(new CloneNode(5));
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
