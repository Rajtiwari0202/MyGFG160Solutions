/*
Problem: Stock Buy and Sell – Multiple Transaction Allowed
Platform: GeeksforGeeks - GFG 160
Difficulty: Medium

Intuition:
We can complete multiple transactions.

Key observation:
Whenever price increases from one day to next,
we should take that profit.

Why?
Because all increasing segments together produce
maximum possible profit.

Example:
[100, 180, 260, 310]

Profit:
(180 - 100) +
(260 - 180) +
(310 - 260)

= 310 - 100

So adding all positive differences gives maximum profit.

Approach:
1. Traverse array from day 1
2. If today's price > yesterday's price:
   add the difference to profit
3. Return total profit

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    public int maximumProfit(int prices[]) {

        int profit = 0;

        for (int i = 1; i < prices.length; i++) {

            // If price increases, take profit
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
}