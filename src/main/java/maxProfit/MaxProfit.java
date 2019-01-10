package maxProfit;

import java.io.IOException;

/**
 * Best Time to Buy and Sell Stock (Java)
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class MaxProfit {

    private static int getMaxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        int temp = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - temp);
            temp = Math.min(temp, prices[i]);
        }
        return profit;
    }

    public static void main(String[] args) throws IOException {
        int[] tab = {5, 11, 3, 50, 60, 90};
        System.out.println(getMaxProfit(tab));
    }

}
