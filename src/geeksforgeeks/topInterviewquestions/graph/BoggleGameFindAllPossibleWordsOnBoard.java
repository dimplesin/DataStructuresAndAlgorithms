package geeksforgeeks.topInterviewquestions.graph;

/**
 * Created by v-dsindhi on 12/12/15.
 */
public class BoggleGameFindAllPossibleWordsOnBoard {

    // Let the given dictionary be following
    static String[] dictionary = {"GEEKS", "FOR", "QUIZ", "GO"};
    static int n = dictionary.length;

    // A given function to check if a given string is present in
// dictionary. The implementation is naive for simplicity. As
// per the question dictionary is givem to us.
    static boolean isWord(String str)
    {
        // Linearly search all words
        for (int i=0; i<n; i++)
            if (str.compareTo(dictionary[i]) == 0)
                return true;
        return false;
    }

    // A recursive function to print all words present on boggle
    static void findWordsUtil(char boggle[][], boolean visited[][], int i,
                              int j, String str)
    {
        // Mark current cell as visited and append current character
        // to str
        visited[i][j] = true;
        str = str + boggle[i][j];

        // If str is present in dictionary, then print it
        if (isWord(str))
            System.out.println(str);

        // Traverse 8 adjacent cells of boggle[i][j]
        for (int row=i-1; row<=i+1 && row<3; row++)
            for (int col=j-1; col<=j+1 && col<3; col++)
                if (row>=0 && col>=0 && !visited[row][col])
                    findWordsUtil(boggle,visited, row, col, str);

        // Erase current character from string and mark visited
        // of current cell as false
        str.subSequence(0, str.length()-1);
        visited[i][j] = false;
    }

    // Prints all words present in dictionary.
    static void findWords(char boggle[][])
    {
        // Mark all characters as not visited
        boolean visited[][] = new boolean[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                visited[i][j] = false;
            }
        }

        // Initialize current string
        String str = "";

        // Consider every character and look for all words
        // starting with this character
        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++)
                findWordsUtil(boggle, visited, i, j, str);
    }

    // Driver program to test above function
    public static void main(String args[])
    {
        char boggle[][] = {{'G','I','Z'},
        {'U','E','K'},
        {'Q','S','E'}};

        System.out.println("Following words of dictionary are present\n");
        findWords(boggle);

    }
}
