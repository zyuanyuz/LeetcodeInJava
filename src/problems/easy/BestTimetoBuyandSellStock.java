package problems.easy;

/**
 * leetcode 121 BestTimetoBuyandSellStock Easy
 */
public class BestTimetoBuyandSellStock{
    // Runtime: 169 ms, faster than 13.34% of Java online submissions for Best Time
    // to Buy and Sell Stock.
    // Memory Usage: 37.8 MB, less than 98.23% of Java online submissions for Best
    // Time to Buy and Sell Stock.
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > maxProfit) {
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        return maxProfit;
    }
}