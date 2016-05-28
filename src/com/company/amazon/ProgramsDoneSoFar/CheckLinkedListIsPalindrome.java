package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/23/15.
 */
import java.util.*;
public class CheckLinkedListIsPalindrome {
    public static void main(String [] args){
        Scanner scan=new Scanner(System.in);
        int  size=scan.nextInt();
        PalNode head = null;
        for(int i=0;i<size;i++){
            int data=scan.nextInt();
            head=insertNode(head, data);
        }
        //linkedList.printLinkedList(head);
        head=reverseList(head);
        boolean result=isLinkedListIsPalindrome(head);
        if(result)
            System.out.println("Linked List is Palindrome");
        else
            System.out.println("Linked List is not Palindrome");
    }
    public static boolean isLinkedListIsPalindrome(PalNode head){
        PalNode slow,fast;
        slow=fast=head;
        PalNode head2=null;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null)// This will happen in case of odd number of nodes
        {
            head2=slow.next;
        }
        else
            head2=slow;
        head2=reverseList(head2);
        boolean result=compareList(head, head2);
        return result;
    }
    public static boolean compareList(PalNode head1, PalNode head2){
        while(head1!=null && head2!=null){
            if(head1.data==head2.data){
                head1=head1.next;
                head2=head2.next;
            }
            else
                return false;
        }
        if(head1==null && head2==null)
            return true;
        return false;
    }
    public static PalNode reverseList(PalNode head){
        PalNode temp=null;
        PalNode next=null;
        while(head!=null){
            next=head.next;
            head.next=temp;
            temp=head;
            head=next;
        }
        return temp;
    }
    public static PalNode insertNode(PalNode head, int data){
        if(head==null)
            head=new PalNode(data);
        else
            head.next=insertNode(head.next,data);
        return head;
    }
}
class PalNode {
    int data;
    PalNode next;
    PalNode(int data){
        this.data=data;
        this.next=null;
    }
}


