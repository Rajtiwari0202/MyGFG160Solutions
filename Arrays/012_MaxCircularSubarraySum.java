/*
Problem: Max Circular Subarray Sum
Platform: GeeksforGeeks - GFG 160
Difficulty: Hard

Intuition:
There are two possible answers:

1. Normal maximum subarray sum
   - This is simple Kadane's Algorithm.

2. Circular maximum subarray sum
   - This means the subarray wraps around.
   - To get this, remove the minimum sum subarray from total sum.

Formula:
circularSum = totalSum - minimumSubarraySum

Final answer:
max(normalMaxSum, circularSum)

Important:
If all numbers are negative, circularSum becomes 0,
which is invalid because subarray must be non-empty.
So in that case, return normalMaxSum.

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {

    public int maxCircularSum(int arr[]) {

        int totalSum = 0;

        int currentMax = 0;
        int maxSum = arr[0];

        int currentMin = 0;
        int minSum = arr[0];

        for (int num : arr) {

            totalSum += num;

            // Kadane for maximum subarray sum
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            // Kadane for minimum subarray sum
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);
        }

        // If all numbers are negative
        if (maxSum < 0) {
            return maxSum;
        }

        int circularSum = totalSum - minSum;

        return Math.max(maxSum, circularSum);
    }
}