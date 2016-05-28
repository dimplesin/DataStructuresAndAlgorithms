package com.company.flipkart;

/**
 * Created by v-dsindhi on 7/14/15.
 */
public class FindLeftAndRightNeighborsOfAGivenNode {

    /*This can be solve by storing the ancestors path to the node. Then we can Print the neighbours accordingly.
            Algo-> Store the ancestoral path in an array or say vector.
    Now from the root start printing the nodes which are neighbours to this node
    Here is a working code for the same

    void PrintNodes(node* temp,node* Node,vector<node*>v,int n){//To Print the Neighbour //Nodes
        if(!temp) return;
        if(n==0){
            if(temp==Node) return;
            if(temp) cout<<temp->data<<"->";
            return;
        }
        PrintNodes(temp->left,Node,v,n-1);
        PrintNodes(temp->right,Node,v,n-1);
        return;
    }
    bool StoreNodePath(node* root,node* Node,vector<node*>&v){//Function for storing //the Ancestors path
        if(!root|| !Node) return false;
        if(root==Node) return true;
        if(StoreNodePath(root->left,Node,v) || StoreNodePath(root->right,Node,v)){
            v.push_back(root);
            return true;
        }
        return false;
    }
    void printNeighbours(struct node *root, node* node){ //Initial Call to this Function
*//* base cases *//*
        if(node==root) return;
        if ( root == NULL )*/
       /*     return ;
        int n;
        vector<struct node*>v;
        bool found = StoreNodePath(root,node,v);
        if(!found) return;
        else{
            n=v.size();
            struct node* temp=v.back();
            PrintNodes(temp,node,v,n);*/
        }
/*    }
}*/



