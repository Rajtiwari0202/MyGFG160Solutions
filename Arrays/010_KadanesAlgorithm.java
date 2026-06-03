/*
Problem: Kadane's Algorithm
Platform: GeeksforGeeks - GFG 160
Difficulty: Medium

Intuition:
We need the maximum sum subarray.

At every index:
- Either extend the current subarray
- Or start a new subarray from current element

If current sum becomes worse than starting fresh,
we restart from current element.

Kadane’s Algorithm efficiently tracks:
1. currentSum
2. maximumSum

Approach:
1. Initialize:
   - currentSum = arr[0]
   - maxSum = arr[0]

2. Traverse from index 1:
   currentSum =
   max(arr[i], currentSum + arr[i])

3. Update maxSum

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {

    int maxSubarraySum(int[] arr) {

        int currentSum = arr[0];
        int maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {

            // Either continue current subarray
            // or start fresh from current element
            currentSum = Math.max(arr[i], currentSum + arr[i]);

            // Update answer
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}