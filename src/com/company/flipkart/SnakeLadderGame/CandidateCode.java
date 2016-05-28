package com.company.flipkart.SnakeLadderGame;

/**
 * Created by v-dsindhi on 9/20/15.
 */
public class CandidateCode {

    public static int minimum_possible_cost(String input1){
        String rows[] = input1.split("#");
        String columns[] = null;
        for(int i=0;i<rows.length;i++){
            columns = rows[i].split("@");
        }
        String matrix[][] = new String[rows.length][columns.length];
        for(int i=0;i<rows.length;i++){
            for(int j=0;j<columns.length;j++){
                matrix[i][j] = columns[j];
                System.out.println(matrix[i][j]);
            }
        }

        return 0;
    }

    public static void main(String args[]){
        String input1 = "-1@10@-1#10@2@10#-1@10@-1";
        System.out.println(minimum_possible_cost(input1));
    }
}
