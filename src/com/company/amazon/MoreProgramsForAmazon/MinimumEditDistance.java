package com.company.amazon.MoreProgramsForAmazon;

public class MinimumEditDistance {

    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        // len1+1, len2+1, because finally return dp[len1][len2]
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        //iterate though, and check last char
        for (int i = 0; i < len1; i++) {
            char c1 = word1.charAt(i);
            for (int j = 0; j < len2; j++) {
                char c2 = word2.charAt(j);

                //if last two chars equal
                if (c1 == c2) {
                    //update dp value for +1 length
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int replace = dp[i][j] + 1;
                    int insert = dp[i][j + 1] + 1;
                    int delete = dp[i + 1][j] + 1;

                    int min = replace > insert ? insert : replace;
                    min = delete > min ? min : delete;
                    dp[i + 1][j + 1] = min;
                }
            }
        }

        return dp[len1][len2];
    }


// Dynamic Programming implementation of edit distance


    // Change these strings to test the program
    String STRING_X = "SUNDAY";
    String STRING_Y = "SATURDAY";

    int SENTINEL = -1;
    int EDIT_COST = 1;


    int min(int a, int b) {
        return a < b ? a : b;
    }

    // Returns Minimum among a, b, c
    int Minimum(int a, int b, int c) {
        return min(min(a, b), c);
    }

    // Strings of size m and n are passed.
// Construct the Table for X[0...m, m+1], Y[0...n, n+1]
    int EditDistanceDP(char X[], char Y[]) {
        // Cost of alignment
        int cost = 0;
        int leftCell, topCell, cornerCell;

        int m = X.length + 1;
        int n = Y.length + 1;

        // T[m][n]
        int T[][] = new int[m][n];

        // Initialize table
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                T[i][j] = SENTINEL;

        // Set up base cases
        // T[i][0] = i
        for (int i = 0; i < m; i++)
            T[i][0] = i;

        // T[0][j] = j
        for (int j = 0; j < n; j++)
            T[0][j] = j;

        // Build the T in top-down fashion
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // T[i][j-1]
                leftCell = T[i][j - 1];
                leftCell += EDIT_COST; // deletion

                // T[i-1][j]
                topCell = T[i - 1][j];
                topCell += EDIT_COST; // insertion

                // Top-left (corner) cell
                // T[i-1][j-1]
                cornerCell = T[i - 1][j - 1];

                // edit[(i-1), (j-1)] = 0 if X[i] == Y[j], 1 otherwise
                if (X[i] == Y[i]) {
                    T[i - 1][j - 1] = 0;
                } else {
                    T[i - 1][j - 1] = 1;
                }
                //cornerCell += (X[i-1] != Y[j-1]); // may be replace

                // Minimum cost of current cell
                // Fill in the next cell T[i][j]
                T[i][j] = Minimum(leftCell, topCell, cornerCell);
            }
        }

        // Cost is in the cell T[m][n]
        cost = T[m][n] - 1;
        T = null;
        return cost;
    }

    // Recursive implementation
    int EditDistanceRecursion(char X[], char Y[], int m, int n) {
        // Base cases
        if (m == 0 && n == 0)
            return 0;

        if (m == 0)
            return n;

        if (n == 0)
            return m;

        // Recurse
        int left = EditDistanceRecursion(X, Y, m - 1, n) + 1;
        int right = EditDistanceRecursion(X, Y, m, n - 1) + 1;
        int corner = EditDistanceRecursion(X, Y, m - 1, n - 1) + 1;

        return Minimum(left, right, corner);
    }

    int main() {
        char X[] = STRING_X.toCharArray(); // vertical
        char Y[] = STRING_Y.toCharArray(); // horizontal

        System.out.println("Minimum edits required to convert  into is "
                + X + Y + EditDistanceDP(X, Y));
        System.out.println("Minimum edits required to convert %s into %s is %d by recursion\n"+
                X+ Y+EditDistanceRecursion(X, Y, X.length, Y.length));

        return 0;
    }
}