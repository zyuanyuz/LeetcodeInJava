package problems.easy;

/**
 * leetcode 122 BestTimetoBuyandSellStockII Easy
 */
public class BestTimetoBuyandSellStockII{
     //Runtime: 1 ms, faster than 95.26% of Java online submissions for Best Time to Buy and Sell Stock II.
    //Memory Usage: 36.9 MB, less than 100.00% of Java online submissions for Best Time to Buy and Sell Stock II.
    public int maxProfit(int[] prices) {
        int profit = 0;
        boolean isHold = false;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1] && !isHold) {
                profit = profit - prices[i];
                isHold = true;
            } else if (prices[i] > prices[i + 1] && isHold) {
                profit = profit + prices[i];
                isHold = false;
            }
        }
        if (isHold) {
            profit = profit + prices[prices.length - 1];
        }
        return profit;
    }
}