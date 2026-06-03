/*
Problem: Move All Zeroes to End
Platform: GeeksforGeeks - GFG 160
Difficulty: Easy

Intuition:
We want to move all zeroes to the end while maintaining
the relative order of non-zero elements.

The best way is:
- Keep a pointer 'index'
- Place every non-zero element at index
- Increment index
- After traversal, fill remaining positions with 0

This works in-place and preserves order.

Approach:
1. Traverse the array
2. Whenever a non-zero element is found:
   - place it at arr[index]
   - increment index
3. Fill remaining positions with 0

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    void pushZerosToEnd(int[] arr) {

        int index = 0;

        // Place all non-zero elements at the front
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }

        // Fill remaining positions with zeroes
        while (index < arr.length) {
            arr[index] = 0;
            index++;
        }
    }
}