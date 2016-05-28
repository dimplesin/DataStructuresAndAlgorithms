/*
package com.company.Microsoft;

import com.company.amazon.BookKarumanchi.DataStructures.LinkedLists.ListNode;

*/
/**
 * Created by v-dsindhi on 8/8/15.
 *//*

public class PairwiseSwapOdDoublyLinkedList {

    public static ListNode PairWiseSwap(ListNode root) {


        int x =Integer.parseInt("9");
        if (root == null || root.next == null)
        {
            return root;
        }
        ListNode a = root;
        ListNode b = root.next;

        root = b;    // after swap b will be the head of the list

        do  {
            a.next = b.next;
            b.next = a;
            b.prev = a.prev;
            a.prev = b;

            //   Example in list a,b,c,d    after swapping ListNodes 'a' & 'b' pointers , 'c.prev' should be made point to 'a' now .. The list will be b,a,c,d  now . After swapping 'c' & 'd' , a.next should be set to d . Now the list is b,a,d,c

            if (a.next != null)
            {
                a.next.prev = a;
            }


            if(b.prev != null)
            {
                b.prev.next = b;
            }
            a = a.next;
            b = (a != null)? a.next : null;

        } while ( a != null && b != null);
        return root;
    }

    public static Node swapKElements(Node head, int k) {

        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        Node current = head;
        Node next = head.next;
        current.next = null;
        current.prev = null;
        int i = 0;
        while (next != null && i < k - 1) {
            Node temp = next.next;
            next.next = current;
            next.prev = current.prev;
            current.prev = next;
            current = next;
            next = temp;
            i++;
        }
        if (next != null) {
            head.next = swapKElements(next, k);
            if (head.next != null) {
                head.next.prev = head;
            }
        }

        return current;
    }
}
*/
