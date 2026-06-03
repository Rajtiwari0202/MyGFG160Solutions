/*
Problem: Maximum Product Subarray
Platform: GeeksforGeeks - GFG 160
Difficulty: Medium

Intuition:
This is similar to Kadane's Algorithm, but with product.

Problem:
A negative number can turn the smallest product into the largest product.

Example:
-3 * -10 = 30

So we must track both:
1. maximum product ending here
2. minimum product ending here

Why minimum?
Because if current number is negative,
minimum product can become maximum after multiplication.

Approach:
1. Initialize:
   - maxProduct = arr[0]
   - minProduct = arr[0]
   - answer = arr[0]

2. Traverse from index 1:
   - If current number is negative, swap maxProduct and minProduct
   - Update maxProduct
   - Update minProduct
   - Update answer

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    int maxProduct(int[] arr) {

        int maxProduct = arr[0];
        int minProduct = arr[0];
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int num = arr[i];

            // Negative number flips maximum and minimum
            if (num < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            // Either start new subarray or extend previous one
            maxProduct = Math.max(num, maxProduct * num);
            minProduct = Math.min(num, minProduct * num);

            answer = Math.max(answer, maxProduct);
        }

        return answer;
    }
}