package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/22/15.
 */
public class StockBuySell {

    public static int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 0;
        int max = 0;
        int minElement = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++){
           if(max<prices[i]){
                max = prices[i];
                sell = i;
            }
            if(minElement > prices[i]){
                minElement = prices[i];
                buy = i;
            }
        }
        System.out.println(buy+" "+sell);
        return (max-minElement);
    }

    public static void main(String args[]){
        int price[] = {20, 180, 260, 310, 40, 535, 695};
        // function call
        int profit = maxProfit(price);

        System.out.print(profit);
        System.gc();
    }
}
