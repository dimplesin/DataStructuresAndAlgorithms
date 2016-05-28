package com.company.amazon.MoreProgramsForAmazon;

public class RotateMatrix {

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

    public static void rotateByNinetyToLeft(int[][] m) {

        int e = m.length - 1;
        int c = e / 2;
        int b = e % 2;
        for (int r = c; r >= 0; r--) {
            for (int d = c - r; d < c + r + b; d++) {
                int t   = m[c - r][d];
                m[c - r][d] = m[d][e - c + r];
                m[d][e - c + r] = m[e - c + r][e - d];
                m[e - c + r][e - d] = m[e - d][c - r];
                m[e - d][c - r] = t;
            }
        }
    }
    
    private static int[][] rotateMatrixBy90Degree(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i];
				matrix[first][i] = matrix[last - offset][first];
				matrix[last - offset][first] = matrix[last][last - offset];
				matrix[last - offset][last] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
		System.out.println("Matrix After Rotating 90 degree:-");
		//printMatrix(matrix, n);
		return matrix;

	}
}
