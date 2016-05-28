package geeksforgeeks.Algorithms.Arrays;

/**
 * Created by v-dsindhi on 8/10/15.
 */


//Since each row is sorted, we can use
// Binary Search to count of 1s in each
// row. We find the index of first
// instance of 1 in each row.
// The count of 1s will be equal to
// total number of columns minus the
// index of first 1.
public class FindRowWithMaximumNumberOf1s {

    /* A function to find the index of first index of 1 in
    a boolean array arr[] */
    static int first(int arr[], int low, int high)
    {
        if(high >= low)
        {
            // get the middle index
            int mid = low + (high - low)/2;

            // check if the element at middle index is first 1
            if ( ( mid == 0 || arr[mid-1] == 0) && arr[mid] == 1)
                return mid;

                // if the element is 0, recur for right side
            else if (arr[mid] == 0)
                return first(arr, (mid + 1), high);

            else // If element is not first 1, recur for left side
                return first(arr, low, (mid -1));
        }
        return -1;
    }

    // The main function that returns index of row with
    // maximum number of 1s.
    static int rowWithMax1s(int mat[][])
    {
        int max_row_index = 0, max = -1; // Initialize max values

        // Traverse for each row and count number
        // of 1s by finding the index
        // of first 1
        int i, index;
        for (i = 0; i < 4; i++)
        {
            index = first (mat[i], 0, 4-1);
            if (index != -1 && 4-index > max)
            {
                max = 4 - index;
                max_row_index = i;
            }
        }

        return max_row_index;
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        int mat[][] = { {0, 0, 0, 1},
                        {1, 1, 1, 1},
                        {0, 1, 1, 1},
                        {0, 1, 1, 0} };

        RowWithMaximumOnes(mat);

        //System.out.println("Index of row with maximum 1s is :"+
        // rowWithMax1s(mat));
    }

    public static void RowWithMaximumOnes(int[][] arr){
        int[] rows = new int[arr.length];int count=0,maxCount=0, index=0;
        for(int i=0;i<arr.length;i++){
            count =0;
            for(int j=0;j<arr.length;j++) {
                if (arr[i][j] == 1) {
                    count++;
                }
            }
            if(maxCount<count){
                maxCount = count;
                index=i;
            }
        }
        System.out.println(index);
    }

    /*Run on IDE
    Output:
    Index of row with maximum 1s is 2
    Time Complexity: O(mLogn) where m is number of rows and n is number of columns in matrix.*/

}
