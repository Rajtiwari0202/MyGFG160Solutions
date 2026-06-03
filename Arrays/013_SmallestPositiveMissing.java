/*
Problem: Smallest Positive Missing
Platform: GeeksforGeeks - GFG 160
Difficulty: Medium

Intuition:
The smallest missing positive number must be in the range:

1 to n + 1

where n is the size of the array.

So we try to place every number x at its correct index:

x should be placed at index x - 1

Example:
1 should be at index 0
2 should be at index 1
3 should be at index 2

After rearranging, the first index where arr[i] != i + 1
gives the missing positive number.

Approach:
1. Traverse the array.
2. While arr[i] is in range 1 to n
   and not already at correct position:
   swap arr[i] with arr[arr[i] - 1]
3. Traverse again.
4. First index where arr[i] != i + 1 is answer.
5. If all are placed correctly, answer is n + 1.

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    public int missingNumber(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n; i++) {

            while (
                arr[i] >= 1 &&
                arr[i] <= n &&
                arr[i] != arr[arr[i] - 1]
            ) {
                int correctIndex = arr[i] - 1;

                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}