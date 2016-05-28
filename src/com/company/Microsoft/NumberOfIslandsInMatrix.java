package com.company.Microsoft;
public class NumberOfIslandsInMatrix {
    static int ROW = 5;
    static int COL=5;
    // A function to check if a given cell (row, col) can be included in DFS
    public static boolean isSafe(int M[][], int row, int col, boolean visited[][]) {
        return (row >= 0) && (row < ROW) &&     // row number is in range
                (col >= 0) && (col < COL) &&     // column number is in range
                (M[row][col]==1 && !visited[row][col]); // value is 1 and not yet visited
    }

    // A utility function to do DFS for a 2D boolean matrix. It only considers
// the 8 neighbors as adjacent vertices
    static void DFS(int M[][], int row, int col, boolean visited[][]) {
        // These arrays are used to get row and column numbers of 8 neighbors
        // of a given cell
        int rowNbr[] = {-1, -1, -1,  0, 0,  1, 1, 1};
        int colNbr[] = {-1,  0,  1, -1, 1, -1, 0, 1};
        // Mark this cell as visited
        visited[row][col] = true;
        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited) )
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
    }

    // The main function that returns count of islands in a given boolean
// 2D matrix
    static int countIslands(int M[][]) {
        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        boolean visited[][] =new boolean[ROW][COL];
        //memset(visited, 0, sizeof(visited));
        for (int i = 0; i < ROW; ++i) {
            for (int j = 0; j < COL; ++j) {
                visited[i][j] = false;
            }
        }
        // Initialize count as 0 and travese through the all cells of
        // given matrix
        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (M[i][j]!=1 && !visited[i][j]){// If a cell with value 1 is not
                    DFS(M, i, j, visited);     // Visit all cells in this island.
                    ++count;                   // and increment island count
                }
        return count;
    }

    // Driver program to test above function
    public static void main(String args[])
    {
        int M[][]= {  {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };

        System.out.println("Number of islands is: " +  countIslands(M));

    }
}

/*

    public static int CountLand(char[,] s)
    {
        int result = 0;
        int count = 0;

        for (int x = 0; x < s.GetLength(0); x++)
        {
            for (int y = 0; y < s.GetLength(1); y++)
            {
                if (s[x, y] == 'L')
                {
                    count = CountContiguous(s, x, y);
                    if (count > result)
                    {
                        result = count;
                    }
                }
            }
        }

        return result;
    }

    private static int CountContiguous(char[,] s, int x, int y)
    {
        if (x < 0 || x > s.GetLength(0) - 1 || y < 0 || y > s.GetLength(1) - 1 || s[x, y] != 'L')
        {
            return 0;
        }
        else
        {
            s[x, y] = 'A';
            return 1 + CountContiguous(s, x - 1, y) + CountContiguous(s, x + 1, y) + CountContiguous(s, x, y - 1) + CountContiguous(s, x, y + 1);
        }
    }

    public static void Test()
    {
        char[,] s = {{'L', 'L', 'L', 'L'},
            {'L', 'L', 'W', 'L'},
            {'L', 'W', 'L', 'W'},
            {'W', 'W', 'L', 'L'}};
        Console.WriteLine(CountLand(s)); //8
    }*/
