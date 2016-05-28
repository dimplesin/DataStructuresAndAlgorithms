package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/24/15.
 */
public class DetectAndRemoveLoop {

    /* This function detects and removes loop in the list
  If loop was there in the list then it returns 1,
  otherwise returns 0 */
    static int detectAndRemoveLoop(ListNode list)
    {
        ListNode slow_p = list, fast_p = list;

        while (slow_p !=null && fast_p!=null && fast_p.getNext() != null)
        {
            slow_p = slow_p.getNext();
            fast_p  = fast_p.getNext().getNext();

        /* If slow_p and fast_p meet at some point then there
           is a loop */
            if (slow_p == fast_p)
            {
                removeLoop(slow_p, list);

            /* Return 1 to indicate that loop is found */
                return 1;
            }
        }

    /* Return 0 to indeciate that ther is no loop*/
        return 0;
    }

    /* Function to remove loop.
     loop_node --> Pointer to one of the loop nodes
     head -->  Pointer to the start node of the linked list */
    static void removeLoop(ListNode loop_node, ListNode head)
    {
        ListNode ptr1;
        ListNode ptr2;

   /* Set a pointer to the beging of the Linked List and
      move it one by one to find the first node which is
      part of the Linked List */
        ptr1 = head;
        while(true)
        {
     /* Now start a pointer from loop_node and check if it ever
       reaches ptr2 */
            ptr2 = loop_node;
            while(ptr2.getNext() != loop_node && ptr2.getNext() != ptr1)
            {
                ptr2 = ptr2.getNext();
            }

     /* If ptr2 reahced ptr1 then there is a loop. So break the
        loop */
            if(ptr2.getNext() == ptr1)
                break;

     /* If ptr2 did't reach ptr1 then try the next node after ptr1 */
            else
                ptr1 = ptr1.getNext();
        }

   /* After the end of loop ptr2 is the last node of the loop. So
     make next of ptr2 as NULL */
        ptr2.setNext(null);
    }

    /* UTILITY FUNCTIONS */
/* Given a reference (pointer to pointer) to the head
  of a list and an int, pushes a new node on the front
  of the list. */
    static void push(ListNode head_ref, int new_data)
    {
    /* allocate node *//* put in the data  */
        ListNode new_node =new ListNode(new_data);


    /* link the old list off the new node */
        new_node.setNext(head_ref);

    /* move the head to point to the new node */
        head_ref    = new_node;
    }

    /* Function to print linked list */
    static void printList(ListNode node)
    {
        while(node != null)
        {
            System.out.println(node.getData());
            node = node.getNext();
        }
    }

    /* Drier program to test above function*/
    public static void main(String args[])
    {
    /* Start with the empty list */
       ListNode head = new ListNode(10);

        push(head, 4);
        push(head, 15);
        push(head, 20);
        push(head, 50);
        push(head, 30);
        push(head, 12);

    /* Create a loop for testing */
        head.getNext().getNext().getNext().setNext(head.getNext().getNext());

        detectAndRemoveLoop(head);

        System.out.println("Linked List after removing loop \n");
        printList(head);
    }

}
