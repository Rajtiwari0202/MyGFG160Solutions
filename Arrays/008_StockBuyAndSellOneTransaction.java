/*
Problem: Stock Buy and Sell – Max One Transaction Allowed
Platform: GeeksforGeeks - GFG 160
Difficulty: Easy

Intuition:
We can buy once and sell once.

To maximize profit:
- Buy at the minimum price seen so far
- Sell at current price
- Keep track of maximum profit

At every day:
profit = currentPrice - minimumPriceSoFar

Approach:
1. Maintain:
   - minPrice
   - maxProfit

2. Traverse array:
   - Update minPrice
   - Calculate current profit
   - Update maxProfit

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    public int maximumProfit(int prices[]) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {

            // Update minimum buying price
            minPrice = Math.min(minPrice, price);

            // Calculate profit if sold today
            int profit = price - minPrice;

            // Update maximum profit
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}