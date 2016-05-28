package com.company.amazon.MoreProgramsForAmazon;

/**
 * Created by v-dsindhi on 6/30/15.
 */
public class RotationMatrix {

    static int index_of_rows;
    static int index_of_columns;
    static int number_of_rows;
    static int number_of_columns;

    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}};
        index_of_rows = matrix.length -1;
        index_of_columns = matrix[0].length -1;
        number_of_rows = matrix.length;
        number_of_columns = matrix[0].length;


        RotateMatrix rm = new RotateMatrix();

        rm.printGrid(matrix);//before rotation
        rm.rotate360CW(matrix,rm);

    }

    public int[][] rotate90CW(int[][] matrix, RotateMatrix rm) {

        int[][] newMatrix = new int[number_of_rows][number_of_columns];
        int totalNumber = (number_of_rows) * (number_of_columns);
        int[] intArray = createSingleArray(matrix,totalNumber);


        int a =0;
        for(int c=number_of_columns; c>=0; c--)
        {
            for(int r=0; r<=number_of_rows; r++)
            {
                newMatrix[r][c] = intArray[a];
                a++;
            }
        }
        rm.printGrid(newMatrix);
        return newMatrix;
    }

    public int[] createSingleArray(int[][] matrix, int totalNumber) {
        int a=0;
        int[] intArray = new int[totalNumber];

        for(int b=0;b<=index_of_rows; b++)
        {
            for(int c=0; c<=index_of_columns;c++)
            {
                intArray[a] = matrix[b][c];
                a++;
            }
        }
        return intArray;
    }

    public void printGrid(int[][] matrix) {
        StringBuilder sb = new StringBuilder("--------------------------");

        for(int i =0; i<=index_of_rows; i++)
        {
            System.out.println(sb.toString());//print each row
            sb.delete(0, sb.length());//Then clear the row and build the next
            for(int j=0; j<=index_of_columns;j++)
            {
                sb.append(matrix[i][j]+",");
            }
        }
        System.out.println(sb.toString());

    }

    public int[][] rotate180CW(int[][] matrix, RotateMatrix rm)
    {
        return rm.rotate90CW(rm.rotate90CW(matrix, rm), rm);
    }

    public int[][] rotate270CW(int[][] matrix, RotateMatrix rm)
    {
        return rm.rotate90CW(rm.rotate90CW(rm.rotate90CW(matrix, rm), rm),rm);
    }

    public int[][] rotate360CW(int[][] matrix, RotateMatrix rm)
    {
        return rm.rotate90CW(rm.rotate90CW(rm.rotate90CW(rm.rotate90CW(matrix, rm), rm),rm),rm);
    }

}