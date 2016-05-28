package com.company.flipkart;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by v-dsindhi on 7/8/15.
 */
public class SnakeAndLadderGame {

    // C++ program to find minimum number of dice throws required to
// reach last cell from first cell of a given snake and ladder
// board
     // An entry in queue used in BFS
    class queueEntry
    {
        int v;     // Vertex number
        int dist;  // Distance of this vertex from source
    };

    // This function returns minimum number of dice throws required to
// Reach last cell from 0'th cell in a snake and ladder game.
// move[] is an array of size N where N is no. of cells on board
// If there is no snake or ladder from cell i, then move[i] is -1
// Otherwise move[i] contains cell to which snake or ladder at i
// takes to.
    int getMinDiceThrows(int move[], int N)
    {
        // The graph has N vertices. Mark all the vertices as
        // not visited
        boolean visited[] = new boolean[N];
        for (int i = 0; i < N; i++)
            visited[i] = false;

        // Create a queue for BFS
        Queue<queueEntry> q = new ArrayDeque<>();

        // Mark the node 0 as visited and enqueue it.
        visited[0] = true;
        queueEntry s = null;  // distance of 0't vertex is also 0
        q.add(s);  // Enqueue 0'th vertex

        // Do a BFS starting from vertex at index 0
        queueEntry qe = null;  // A queue entry (qe)
        while (!q.isEmpty())
        {
            qe = q.peek();
            int v = qe.v; // vertex no. of queue entry

            // If front vertex is the destination vertex,
            // we are done
            if (v == N-1)
                break;

            // Otherwise dequeue the front vertex and enqueue
            // its adjacent vertices (or cell numbers reachable
            // through a dice throw)
            q.poll();
            for (int j=v+1; j<=(v+6) && j<N; ++j)
            {
                // If this cell is already visited, then ignore
                if (!visited[j])
                {
                    // Otherwise calculate its distance and mark it
                    // as visited
                    queueEntry a = null;
                    a.dist = (qe.dist + 1);
                    visited[j] = true;

                    // Check if there a snake or ladder at 'j'
                    // then tail of snake or top of ladder
                    // become the adjacent of 'i'
                    if (move[j] != -1)
                        a.v = move[j];
                    else
                        a.v = j;
                    q.add(a);
                }
            }
        }

        // We reach here when 'qe' has last vertex
        // return the distance of vertex in 'qe'
        return qe.dist;
    }

    // Driver program to test methods of graph class
    int main()
    {
        // Let us construct the board given in above diagram
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i<N; i++)
            moves[i] = -1;

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.println("Min Dice throws required is " +getMinDiceThrows(moves, N));
        return 0;
    }
    /*Run on IDE
    Output:

    Min Dice throws required is 3
    Time complexity of the above solution is O(N) as every cell is added and removed only once from queue. And a typical enqueue or dequeue operation takes O(1) time.
*/

}


//Alternate Solution for the same


/*
======================================================================================================
          Snakes and ladders
======================================================================================================
 By Simran Bansal, 13BTCSNR008, B.Tech(C.S.E), Sem - III, Batch 13-17, simransinghbansal.blogspot.in
======================================================================================================
*/
/*
#include<stdio.h>
        #include<conio.h>
        #include<stdlib.h>
        #include<windows.h>
        struct game //Structure to store player name and position
        {
        char name[20];
        int pos;
        };
        int dice() //Fuction to return random value between 1-6
        {
        return(rand()%6+1);
        }
        void title(){printf("\t\t========================================\n\t\t\tSnakes and Ladders ?# Game\n\t\t========================================\n");} //Function to display title of game
        void rules() //Function to display list of postion of snakes and ladders
        {
        printf("\n--------Snakes at Position----------\n");
        printf("\n\tFrom 99 to 27 \n\tFrom 93 to 21\n\tFrom 90 to 50\n\tFrom 80 to 19\n\tFrom 75 to 1\n\tFrom 68 to 33\n\tFrom 60 to 36\n\tFrom 52 to 17\n\tFrom 51 to 7\n\tFrom 50 to 11\n\tFrom 48 to 9\n\tFrom 45 to 5\n\tFrom 42 to 22\n");
        printf("\n--------Ladders at Position----------\n");
        printf("\n\tFrom 8 to 26\n\tFrom 20 to 82\n\tFrom 43 to 76\n\tFrom 49 to 92\n\tFrom 62 to 95\n\tFrom 63 to 85\n\tFrom 81 to 100\n");
        }
        int dice_roll(int *n) //Function, which return the value of snakes and ladders
        {
        switch (*n)
        {
        //Snakes
        case 99: printf("\nOops.............!\n");getch();return *n=27;
        case 93: printf("\nOops.............!\n");getch();return *n=21;
        case 90: printf("\nOops.............!\n");getch();return *n=50;
        case 80: printf("\nOops.............!\n");getch();return *n=19;
        case 75: printf("\nOops.............!\n");getch();return *n=1;
        case 68: printf("\nOops.............!\n");getch();return *n=33;
        case 60: printf("\nOops.............!\n");getch();return *n=36;
        case 52: printf("\nOops.............!\n");getch();return *n=17;
        case 51: printf("\nOops.............!\n");getch();return *n=7;
        case 50: printf("\nOops.............!\n");getch();return *n=11;
        case 48: printf("\nOops.............!\n");getch();return *n=9;
        case 45: printf("\nOops.............!\n");getch();return *n=5;
        case 42: printf("\nOops.............!\n");getch();return *n=22;
        //Ladders
        case 8: printf("\nYipe.............!\n");getch();return *n=26;
        case 20: printf("\nYipe.............!\n");getch();return *n=82;
        case 43: printf("\nYipe.............!\n");getch();return *n=76;
        case 49: printf("\nYipe.............!\n");getch();return *n=92;
        case 61: printf("\nYipe.............!\n");getch();return *n=95;
        case 63: printf("\nYipe.............!\n");getch();return *n=85;
        case 81: printf("\nYipe.............!\n");getch();return *n=100;
default: return *n;
        }
        }
        int main() //Main function
        {
        SetConsoleTitle("Snakes and Ladders Game:simransinghbansal.blogspot.in");system("color 2E");system("mode 100,40"); //Console attributes
        void title(),rules();
        int n,i,dice(),temp,max=0,dice_roll(int *n);
        title();
        gp:{printf("\nEnter the no. of players: ");} scanf("%d", &n);
        if(n<2||n>4){printf("\n2-4 Players are required to start the game!.....\n");goto gp;}
        struct game player[n]; printf("\n----------Enter the player names----------\n\n");
        for(i=0;i<n;i++)
        {
        printf("Enter the name of player %d: ",i+1); scanf("%s",&player[i].name);player[i].pos=0;
        }printf("\n-------------Record Updated---------------\n");getch();system("cls");title();rules();
        while(max!=1)
        {
        for(i=0;i<n;i++)
        {
        temp=dice();
        (player[i].pos)=temp+player[i].pos;
        printf("\nTurn of player %s: ",player[i].name);getch();printf("%d\n",temp);
        dice_roll(&(player[i].pos));
        printf("\nCurrent Position of player %s is %d\n",player[i].name,(player[i].pos));
        getch();system("cls");title();rules();
        if((player[i].pos)>=100)
        {
        getch();system("cls");title();
        printf("\n\t\t========================================\n\t\t\tCongrats %s! You Won....\n\t\t========================================\n",player[i].name);
        getch();
        max=1;
        }
        }
        }
        }*/
