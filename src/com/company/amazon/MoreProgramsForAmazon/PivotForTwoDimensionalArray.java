package com.company.amazon.MoreProgramsForAmazon;

import java.util.ArrayList;

/**
 * Created by v-dsindhi on 6/30/15.
 */
public class PivotForTwoDimensionalArray {

    public void qsortOnLastRow(int[][] matrix, int left, int right) {
        if (left < right) {
            int i = partition(matrix, left, right);
            qsortOnLastRow(matrix, left, i - 1);
            qsortOnLastRow(matrix, i + 1, right);
        }
    }

    public int partition(int[][] matrix, int left, int right) {
        int lastrow = matrix.length - 1;
        int pivotValue = matrix[lastrow][left];
        int i = left;
        for (int j = left + 1; j <= right; j++) {
            if (matrix[lastrow][j] <= pivotValue) {
                i++;
                swapColumns(matrix, i, j);
            }
        }
        swapColumns(matrix, left, i);
        return i;
    }

    public void swapColumns(int[][] matrix, int c0, int c1) {
        if (c0 != c1) {
            for (int i = 0; i < matrix.length; i++) {
                int t = matrix[i][c0];
                matrix[i][c0] = matrix[i][c1];
                matrix[i][c1] = t;
            }
        }
    }

    public static String[][] quickSort(String[][] data,int column) {
        //1st step, create ArrayLists needed and compare the data by the pivot to determine which ArrayList to be filled.
        ArrayList<String[]> hiData = new ArrayList<String[]>();
        ArrayList<String[]> loData = new ArrayList<String[]>();
        String[][] loDataArr = new String[loData.size()][4];
        String[][] hiDataArr = new String[hiData.size()][4];
        ArrayList<String[]> pivots = new ArrayList<String[]>();
        String[] pivot = {data[0][0],data[0][1],data[0][2],data[0][3]};
        for(String[] row : data) {
            if(row[column].compareTo(pivot[column])<0)
                loData.add(row);
            else if (row[column].compareTo(pivot[column])>0)
                hiData.add(row);
            else pivots.add(row);
        }

        if(loData.size()>0) {
            for(int i=0;i<loData.size();i++)
                loDataArr[i]=loData.get(i);
            if(loData.size()>1)
                loDataArr = quickSort(loDataArr,column);
        }
        if(hiData.size()>0) {
            for(int i=0;i<hiData.size();i++)
                hiDataArr[i]=hiData.get(i);
            if(hiData.size()>1)
                hiDataArr = quickSort(hiDataArr,column);
        }
        String result[][] = new String[hiData.size()+loData.size()+pivots.size()][4];
        int j=0;
        for(String[] row : loDataArr) {
            result[j]=row;
            j++;
        }
        for(String[] row : pivots) {
            result[j]=row;
            j++;
        }
        for(String[] row : hiDataArr) {
            result[j]=row;
            j++;
        }
        return result;
    }

    public static void main(String args[]){
        String dataArray[][] = {
                { "Flintstones", "Fred", "Wilma", "Pebbles", "Dino" },
                { "Rubbles", "Barney", "Betty", "Bam Bam" },
                { "Jetsons", "George", "Jane", "Elroy", "Judy", "Rosie", "Astro" },
                { "Scooby Doo Gang", "Scooby Doo", "Shaggy", "Velma", "Fred", "Daphne" } };

        for(int i=0;i<dataArray.length;i++){
            for(int j=0;j<dataArray.length;j++){
                System.out.println(dataArray[i][j]);
            }
        }
        String result[][] = quickSort(dataArray, 3);
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result.length;j++){
                System.out.println(result[i][j]);
            }
        }
    }
}
