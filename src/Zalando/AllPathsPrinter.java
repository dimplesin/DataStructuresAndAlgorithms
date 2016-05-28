package Zalando;

/**
 * Created by v-dsindhi on 2/5/16.
 */
public class AllPathsPrinter {
    int [][] array;
    int rowCount;
    int colCount;
    public AllPathsPrinter(int [][]array){
        this.array = array;
        rowCount = array.length;
        colCount = array[0].length;
    }
    public void printAllPaths(int currX, int currY, String path){
        if(currX == rowCount-1){
            for(int j=currY;j<=colCount-1;j++){
                path = path + array[currX][j];
            }
            System.out.println("Path : " + path);
            return;
        }
        if(currY == colCount-1){
            for(int i=currX;i<=rowCount-1;i++){
                path = path + array[i][currY];
            }
            System.out.println("Path : " + path);
            return;
        }
        path = path + array[currX][currY];
        printAllPaths(currX+1, currY, path);
        printAllPaths(currX, currY + 1, path);
    }
    /*public static void main(String args[]){
        int [][] ar = new int[][]{{1, 2, 3}, {4, 5, 6}, {8,9,0}};
        AllPathsPrinter allPathsPrinter = new AllPathsPrinter(ar);
        allPathsPrinter.printAllPaths(0,0,"");
    }*/

    private static void printArray(int arr[]){
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    public static void print(int arr[][],int row, int col,int result[],int pos){
        if(row == arr.length-1 && col == arr[0].length-1){
            result[pos] = arr[row][col];
            printArray(result);
            return;
        }
        if(row >= arr.length || col >= arr[0].length){
            return;
        }

        result[pos] = arr[row][col];
        print(arr, row, col + 1, result, pos + 1);
        print(arr, row + 1, col, result, pos + 1);
    }

    public static void main(String args[]){
        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7,8,9}};
        int result[] = new int[arr.length + arr[0].length-1];
        print(arr, 0, 0, result, 0);
    }
}