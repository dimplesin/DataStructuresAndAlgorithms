package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 2/8/16.
 */
public class AddingOneToLinkedList {

    class Node{
        int data;
        Node next;
    }

    Node addOneToLinkedList(Node start){
        Node savePtr = null;
        Node current, previous;
        int flag =0;
        current = start;
        previous = current;
        if(current.next == null){
            //If this is the last node and less than 9 then just increment the value
            if(current.data < 9){
                current.data++;
                return current;
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
        return start;
    }
}
