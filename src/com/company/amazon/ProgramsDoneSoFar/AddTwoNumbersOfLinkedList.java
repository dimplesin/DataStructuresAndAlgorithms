package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/22/15.
 */

/*
You are given two linked lists representing two non-negative numbers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class AddTwoNumbersOfLinkedList {
    //LinkedList
    static class Node{
        int data;
        Node next;

        //public Node(int data){
           // this.data = data;
        //}

        //method to add 2 lists
        public static Node addLists(Node n1 , Node n2 , int carry){
            //Boundary Condition
            if(n1 == null && n2 == null && carry == 0)
                return null;

            Node result = new Node();
            int value = carry;

            if(n1 != null)
                value += n1.data;

            if(n2 !=null)
                value += n2.data;

            result.data = value%10; //second digit of number

            //recurse
            if(n1 != null || n2 !=null || value >= 10){
                Node more = addLists(n1 == null ? null:n1.next,
                        n2 == null ? null:n2.next,
                        value >=10 ? 1 : 0);

                result.next = more;
            }
            return result;
        }

        //Utility to add new linkedlist node at the end of existing list
        public void insertAtEnd(int data){
            Node newNode = new Node();
            newNode.data = data;
            Node n = this;

            while(n.next != null){
                n = n.next;
            }
            n.next = newNode;
        }

        //Utility to display linkedlist
        public void display(){
            Node head = this;

            while(head != null){
                if(head.next !=null)
                    System.out.print(head.data+"->");
                else
                    System.out.print(head.data);
                head = head.next;
            }
        }
        public static void addOneToLinkedList(Node start){
            Node savePtr = null;
            Node current, previous;
            int flag =0;
            current = start;
            previous = current;
            if(current.next == null){
                //If this is the last node and less than 9 then just increment the value
                if(current.data < 9){
                    current.data++;
                    return;
                }
            }
            while(current.next != null){
                if(flag == 1){
                    if(current.next.data < 9){
                        flag = 0;
                        savePtr = null;
                    }
                }
                if(flag == 0 && current.next.data == 9){
                    savePtr = current;
                    flag = 1;
                }

                //Increment current to next
                current = current.next;
            }

            if(savePtr == null){
                current.data += 1;
            }else{
                if(savePtr.data == 9){
                    Node temp = new Node();
                    temp.data = 1;
                    temp.next = start;
                    start = savePtr;
                }
                while(savePtr.next !=null){
                    if(savePtr.data == 9){
                        savePtr.data = 0;
                    }else{
                        savePtr.data++;
                    }
                    savePtr = savePtr.next;
                }
            }
        }
    }


    public static void main(String args[]) {
        Node list = new Node();
        list.insertAtEnd(9);
        list.insertAtEnd(9);
        list.insertAtEnd(9);
        Node.addOneToLinkedList(list);
       // Node result = Node.addLists(list, list2, 0);
        list.display();
    }
}

/*
Input : list1: 7->1->6   (617)
          list2: 5->9->2    (295)
 Output: 2->1->9   (912)
 */