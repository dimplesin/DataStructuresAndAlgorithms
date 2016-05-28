package com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees;

/**
 * Created by v-dsindhi on 8/24/15.
 */
public class Circle {
    //North, South, East, West directions
    static int N = 0;
    static int S =1;
    static int E =2;
    static int W =3;

    // Function to compute the new pos (x, y, dir) after completing one iteration of the string.
// It will also update the max radius.
    static void findNewPos(char str[], int origdir, int origx, int origy, double maxrad) {
        int i, len, x, y, dir;

        dir = origdir;
        x = origx;
        y = origy;

        len = str.length;
        i=0;

        //Iterate through each character
        while(i < len) {
            char c = str[i];

            switch(c) {
                case 'L': // Turn left
                    switch(dir) {
                        case 0:
                            x--;
                            dir = W;
                            break;
                        case 1:
                            x++;
                            dir = E;
                            break;
                        case 2:
                            y++;
                            dir = N;
                            break;
                        case 3:
                            y--;
                            dir = S;
                            break;
                    }
                    break;

                case 'R': // Turn right
                    switch(dir) {
                        case 0:
                            x++;
                            dir = E;
                            break;
                        case 1:
                            x--;
                            dir = W;
                            break;
                        case 2:
                            y--;
                            dir = S;
                            break;
                        case 3:
                            y++;
                            dir = N;
                            break;
                    }
                    break;

                case 'G': // Go forward
                    switch(dir) {
                        case 0:
                            y++;
                            dir = N;
                            break;
                        case 1:
                            y--;
                            dir = S;
                            break;
                        case 2:
                            x++;
                            dir = E;
                            break;
                        case 3:
                            x--;
                            dir = W;
                            break;
                    }
                    break;
            }

            // Update max radius till now
            double rad = x*x + y*y;
            if(rad > maxrad)
            maxrad = rad;
            i++;
        }

        origx = x;
        origy = y;
        origdir = dir;
    }

    // Function to compute the max radius of movement, if bounded
    static boolean findCircle(char str[]) {
        int x=0, y=0, dir=N;
        int refx, refy;
        double radius = 0, maxrad = 0;

        // Starting from origin(x=0, y=0), find new pos after single iteration
        findNewPos(str, dir, x, y, maxrad);

        refx = x;
        refy = y;

        // Find new positions after 4 more iterations
        findNewPos(str, dir, x, y, maxrad);
        findNewPos(str, dir, x, y, maxrad);
        findNewPos(str, dir, x, y, maxrad);
        findNewPos(str, dir, x, y, maxrad);

        // Are we back to position where we were after 1st iteration?
        if(x == refx && y == refy) {
           return true;
        }

        return false;
    }
    public static void main(String args[]){
        String str = "GRGL";
        System.out.println(findCircle(str.toCharArray()));
    }
}
