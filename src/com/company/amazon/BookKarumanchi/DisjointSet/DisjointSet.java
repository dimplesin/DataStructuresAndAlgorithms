package com.company.amazon.BookKarumanchi.DisjointSet;

/**
 * Created by v-dsindhi on 3/26/15.
 */
public class DisjointSet {

    public int[] S;
    public int size;

    public void MAKESET(int size){
        S = new int[size];
        for(int i=size-1;i>=0;i--){
            S[i]=i;
        }
    }

    public int FIND(int X){
        if(!(X >= 0 && X < size))
            return -1;
        if(S[X] == X)
            return X;
        else
            return FIND(S[X]);
    }

    public int UNION(int root1, int root2){
        if(FIND(root1) == FIND(root2)){
            return 1;
        }
        if(!(root1 >= 0 && root1 < size) && (root1 >= 0 && root1 < size))
            return 0;

        S[root1] = root2;
        return 0;
    }

    public void MAKESETSECOND(int size){
        for(int i=size-1;i>=0;i--){
            S[i] = -1;
        }
    }

    public int FINDSECOND(int X){
        if(!(X >= 0 && X < size)){
            return 0;
        }if(S[X] == -1){
            return X;
        }else{
            return FINDSECOND(S[X]);
        }
    }

    public void UNIONBySize(int root1, int root2){
        if(FIND(root1) == FIND(root2)){
            return;
        }if( S[root2] < S[root1]){
            S[root1] = root2;
            S[root2] += S[root1];
        }else{
            S[root2] = root1;
            S[root1] += S[root2];
        }
    }

    //UNION By Height
    public void UNIONByHeight(int root1, int root2){
        if(FIND(root1) == FIND(root2)){
            return;
        }if(S[root2] < S[root1]){
            S[root1] = root2;
        }else{
            if(S[root2] == S[root2])
                S[root1]--;
            S[root2] = root1;
        }
    }

}
