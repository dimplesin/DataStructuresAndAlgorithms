package com.company.Microsoft;

/**
 * Created by v-dsindhi on 8/15/15.
 */
public class PairWiseSwapForDLL {

    class Node{
        Node Next;
        Node Prev;
        int data;
    }

    public Node SwapPairWise(Node list)
    {
        Node nextList=null,prev=null,next=null,cur=null;
        if(list!=null)
        {
            cur=list;
        }
        else
        {
            return null;
        }
        list=cur.Next;
        while(cur!=null)
        {
            nextList=cur.Next.Next;
            prev=cur.Prev;
            next=cur.Next;
            next.Next=cur;
            cur.Prev=next;
            cur.Next=nextList;
            if(nextList!=null)
            {
                nextList.Prev=cur;
            }
            next.Prev=prev;
            if(prev!=null)
            {
                prev.Next=next;
            }
            cur=nextList;
        }

        return list;
    }
}
