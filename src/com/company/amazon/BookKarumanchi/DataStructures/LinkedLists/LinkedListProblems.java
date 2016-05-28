package com.company.amazon.BookKarumanchi.DataStructures.LinkedLists;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by v-dsindhi on 3/23/15.
 */
public class LinkedListProblems {

    //Time Complexity O(n) Space Complexity O(1)
    ListNode NthNodeFromEnd(ListNode head, int NthNode){
        ListNode pTemp = head, pNthNode = null;
        for(int count =1; count < NthNode;count++){
            if(pTemp != null){
                pTemp = pTemp.getNext();
            }
            while(pTemp != null){
                if(pNthNode == null){
                    pNthNode = head;
                }else{
                    pNthNode = pNthNode.getNext();
                }
                pTemp = pTemp.getNext();
            }
        }
        if(pNthNode != null){
            return pNthNode;
        }
        return null;
    }

    //Time Complexity O(n) Space Complexity O(1)
    boolean DoesLinkedListContainLoop(ListNode head){
        if(head == null){
            return false;
        }
        ListNode slowPtr = head, fastPtr = head;
        while(fastPtr.getNext() != null && fastPtr.getNext().getNext() != null){
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext().getNext();
            if(slowPtr == fastPtr){return true;}
        }
        return false;
    }

    //Time Complexity O(n) Space Complexity O(1)
    ListNode FindBeginOfLoop(ListNode head){
        ListNode slowPtr = head, fastPtr = head;
        boolean loopExists = false;
        if(head == null){
            return null;
        }
        while(fastPtr.getNext()!= null && fastPtr.getNext().getNext() != null){
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext().getNext();
            if(slowPtr == fastPtr){
                loopExists = true;
                break;
            }
        }
        if(loopExists){
            slowPtr = head;
            while (slowPtr!= fastPtr){
                fastPtr = fastPtr.getNext();
                slowPtr = slowPtr.getNext();
            }
            return slowPtr;
        }
        return null;
    }

    //Time Complexity O(n) Space Complexity O(1)
    int FindLoopLength(ListNode head){
        ListNode slowPtr = head, fastPtr = head;
        boolean loopExists = false;
        int counter = 0;
        if(head == null){
            return 0;
        }
        while(fastPtr.getNext() != null && fastPtr.getNext().getNext()!= null){
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext().getNext();
            if(slowPtr == fastPtr){
                loopExists = true;
                break;
            }
        }
        if(loopExists){
            fastPtr = fastPtr.getNext();
            while(slowPtr != fastPtr){
                fastPtr= fastPtr.getNext();
                counter++;
            }
            return counter;
        }
        return 0;
    }

    //Insert a node in sorted linked list
    //Time Complexity O(n) Space Complexity O(1)
    ListNode InsertInSortedList(ListNode head, ListNode newNode){
        ListNode current = head, temp = null;
        if(head == null){return newNode;}
        //Traverse the list until you find item bigger the new node value
        while(current != null && current.getData()<newNode.getData()){
            temp = current;
            current = current.getNext();
        }
        //insert new node before the big item
        newNode.setNext(current);
        temp.setNext(newNode);
        return head;
    }

    //Reverse a singly linked list
    //iterative version
    //Time Complexity O(n) Space Complexity O(1)
    ListNode ReverseList(ListNode head){
        ListNode temp = null,nextNode = null;
        while(head!=null) {
            nextNode = head.getNext();
            head.setNext(temp);
            temp = head;
            head = nextNode;
        }
        return temp;
    }

    //Time Complexity O(max(m,n)) Space Complexity O(1)
    int FindIntersectingNode(ListNode list1, ListNode list2){
        int L1=0, L2=0, diff=0;
        ListNode head1=list1, head2=list2;
        while(head1!=null){
            L1++;
            head1 = head1.getNext();
        }
        while(head2 != null){
            L2++;
            head2 = head2.getNext();
        }
        if(L1<L2){
            head1=list2;
            head2=list1;
            diff = L2-L1;
        }else{
            head1 = list1;
            head2=list2;
            diff= L1-L2;
        }
        for(int i=0;i<diff;i++){
            while(head1!=null && head2!=null){
                if(head1 == head2){
                    return head1.getData();
                }
                head1 = head1.getNext();
                head2 = head2.getNext();
            }
        }
        return 0;
    }

    //How will you find middle of linked list
    //Time Complexity O(n) Space Complexity O(1)
    ListNode FindMiddle(ListNode head){
        ListNode ptr1x = null, ptr2x = null;
        int i=0;
        while(ptr1x.getNext() != null){
            if(i == 0){
                ptr1x = ptr1x.getNext();
                i=1;
            }if(i == 1) {
                ptr1x = ptr1x.getNext();
                ptr2x = ptr2x.getNext();
                i = 0;
            }
        }
        return ptr2x;
    }

    //How will you display a linked list from the end
    //Time Complexity O(n) Space Complexity O(n)
    void PrintListFromEnd(ListNode head){
        if(head == null){
            return;
        }
        PrintListFromEnd(head.getNext());
        System.out.println(head.getData());
    }

    //Check whether the given linked list length is even or odd
    //Time Complexity O(n) Space Complexity O(1)
    int IsLinkedListLengthEven(ListNode listHead){
        while(listHead!=null && listHead.getNext()!= null){
            listHead = listHead.getNext().getNext();
        }
        if(listHead==null)return 0;
        return 1;
    }

    //Given a two sorted linked list we need to merge them into the third list in sorted order.
    //Time Complexity O(n) Space Complexity O(1)
    ListNode MergeList(ListNode a, ListNode b){
        ListNode result = null;
        if(a == null) return b;
        if(b==null) return a;
        if(a.getData() <= b.getData()){
            result = a;
            result.setNext(MergeList(a.getNext(), b));
        }else{
            result = b;
            result.setNext(MergeList(b.getNext(),a));
        }
        return result;
    }

    //Reverse the linked list in pairs. If you have list that holds 1->2->3->4->X
    //then after the function has been called the linked list would hold 2->1->4->3->X
    //Recursive version
    //Time Complexity O(n) Space Complexity O(1)
    ListNode ReversePairRecursive(ListNode head){
        ListNode temp;
        if(head == null || head.getNext() == null){
            return null;
        }else{
            //Reverse first pair
            temp = head.getNext();
            head.setNext(temp.getNext());
            temp.setNext(head);
            head = temp;
            //Call the method recursively for rest of the list
            head.getNext().setNext(ReversePairRecursive(head.getNext().getNext()));
            return head;
        }
    }

    //Iterative version
    ListNode ReversePairIterative(ListNode head){
        ListNode temp1 = null;
        ListNode temp2 = null;
        while(head != null || head.getNext() != null){
            if(temp1!=null){
                temp1.getNext().setNext(head.getNext());
            }
            temp1 = head.getNext();
            head.setNext(head.getNext().getNext());
            temp1.setNext(head);
            if(temp2 == null){
                temp2 = temp1;
            }
            head = head.getNext();
        }
        return temp2;
    }

    //Split a Circular linked list into two equal parts.
    // If the number of nodes int the list are odd then make first list one node extra than second list
    //Time Complexity O(n) Space Complexity O(1)
    void SplitList(ListNode head, ListNode head1, ListNode head2){
        ListNode slowPtr = head, fastPtr = head;
        if(head == null){ return;}
        /* If there are odd nodes in the circular list then fastPtr.getNext() becomes
        head and for even nodes fastPtr.getNext.getNext becomes head.  */
        while(fastPtr.getNext() != head && fastPtr.getNext().getNext() != head){
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
        }
        /*If there are even elements in the list then move fastPtr*/
        if(fastPtr.getNext().getNext() == head){
            fastPtr = fastPtr.getNext();
        }
        /*Set the head pointer of first half*/
        head1 = head;
        /*Set the head pointer of second half*/
        if(head.getNext() != head){
            head2 = slowPtr.getNext();
        }
        /*Make second half circular*/
        fastPtr.setNext(slowPtr.getNext());
        /*Make first half circular*/
        slowPtr.setNext(head);
    }

    //Exchange the adjacent elements in a link list
    //Time Complexity O(n) Space Complexity O(1)
    void ExchangeAdjacentNodes(ListNode head){
        ListNode curNode, temp, nextNode;
        curNode = head;
        if(curNode == null || curNode.getNext() == null){
            return;
        }
        head = curNode.getNext();
        while(curNode!= null && curNode.getNext() != null){
            nextNode = curNode.getNext();
            curNode.setNext(nextNode.getNext());
            temp = curNode.getNext();
            nextNode.setNext(curNode);
            if(temp != null && temp.getNext()!= null){
                curNode.setNext(curNode.getNext().getNext());
            }
            curNode = temp;
        }
    }

    //For a given K value (K>0) reverse blocks of k nodes in the list
    ListNode GetKPlusOneThNode(int K, ListNode head){
        ListNode Kth;
        int i;
        if(head != null) return head;
        for(i=0,Kth=head;Kth!=null && i<K;Kth=Kth.getNext(),i++);
        if(i==K && Kth!=null){
            return Kth;
        }
        return head.getNext();
    }

    int HasKNodes(ListNode head,int K){
        int i =0;
        for(i=0;head !=null && i<K ; i++, head=head.getNext());
        if(i==K){
            return 1;
        }
        return 0;
    }

    ListNode ReverseBlockOfKNodes(ListNode head, int K){
        ListNode temp, next, cur=head,newHead;
        if(K==0 || K==1){return head;}
        if(HasKNodes(cur,K-1) == 1){
            newHead = GetKPlusOneThNode(K-1,cur);
        }else{newHead = head;}
        while(cur != null && HasKNodes(cur, K)==1){
            temp = GetKPlusOneThNode(K, cur);
            int i=0;
            while(i<K){
                next = cur.getNext();
                cur.setNext(temp);
                temp = cur;
                cur = next;
                i++;
            }
        }
        return newHead;
    }

    /* Josephus circle: N people have decided to elect a leader by arranging themselves in a circle and eliminating
     every Mth person around the circle, closing ranks as each person drops out. Find which person will be the last
      one remaining with rank 1 */
    void GetJosephusPosition(int N, int M){
        ListNode p = null, q;
        p.setData(1);
        q=p;
        for(int i=0;i<=N;i++){
            p = p.getNext();
            p.setData(i);
        }
        p.setNext(q);
        for(int count = N;count>0;--count){
            for(int i=0; i<M-1;i++){
                p = p.getNext();
            }
            p.setNext(p.getNext().getNext());
        }
        System.out.println("Last player left standing (Josephus Position) is :"+p.getData());
    }

    /* Given a linked list consist of data, next pointer and also a random pointer which points to a random node of the list.
    * Give an algorithm for cloning the list
    * //Time Complexity O(n) Space Complexity O(n)
    * */
    ListNode Clone(ListNode head){
        ListNode X=head, Y;
        Map<ListNode, ListNode> HT = new HashMap<ListNode, ListNode>();
        while(X!=null){
            Y = new ListNode(0);
            Y.setData(X.getData());
            Y.setNext(null);
            //Y.setRandom(null);
            HT.put(X, Y);
            X= X.getNext();
        }
        X=head;
        while(X!=null){
            Y = HT.get(X);
            Y.setNext(HT.get(X.getNext()));
            //Y.setRandom(HT.get(X.getRandom));
            X = X.getNext();
        }
        return HT.get(head);
    }

    /*Find modular node Given a singly linked list write a function to find the last element from the beginning whose
    * n%k == 0, where n is the number of elements in the list and k is an integer constant. For example if n =19 and k =3 then
    * we should return 18th node
    * //Time Complexity O(n) Space Complexity O(1)
    * */
    ListNode modularNodes(ListNode head, int k){
        ListNode modularNode = null;
        int i=0;
        if(k<=0) return null;
        for(;head != null; head = head.getNext()){
            if(i%k == 0){
                modularNode=head;
            }
            i++;
        }
        return modularNode;
    }

    //Find modular node from end
    //Time Complexity O(n) Space Complexity O(1)
    ListNode modularNodesFromEnd(ListNode head, int k){
        ListNode modularNode = null;
        int i=0;
        if(k<=0) return null;
        for(i=0;i<k;i++){
            if(head!=null){
                head = head.getNext();
            }else{
                return null;
            }
        }
        while(head!=null){
            modularNode = modularNode.getNext();
            head = head.getNext();
        }
        return modularNode;
    }

    //Find fractional node : Given a singly linked list, write a function to find the n/kth element where is the number of elements in the list
    //Time Complexity O(n) Space Complexity O(1)
    ListNode fractionalNode(ListNode head, int k){
        ListNode fractionalNode = null;
        int i=0;
        if(k<=0) return null;
        for(;head != null; head = head.getNext()){
            if(i%k == 0){
                if(fractionalNode!=null){
                    fractionalNode = head;
                }else{
                    fractionalNode = fractionalNode.getNext();
                }
            }
            i++;
        }
        return fractionalNode;
    }

    public DLLNode FindMiddle(DLLNode head){
        DLLNode ptr1x = null, ptr2x = null;
        int i=0;
        while(ptr1x.getNext() != null){
            if(i == 0){
                ptr1x = ptr1x.getNext();
                i=1;
            }if(i == 1) {
                ptr1x = ptr1x.getNext();
                ptr2x = ptr2x.getNext();
                i = 0;
            }
        }
        return ptr2x;
    }
}
