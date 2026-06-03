/*
Problem: Rotate Array
Platform: GeeksforGeeks - GFG 160
Difficulty: Medium

Intuition:
We need to rotate the array left by d positions.

Example:
[1, 2, 3, 4, 5], d = 2

After rotation:
[3, 4, 5, 1, 2]

The optimal in-place approach uses reversal.

Key Observation:
To rotate left by d:
1. Reverse first d elements
2. Reverse remaining elements
3. Reverse entire array

Approach:
Suppose:
arr = [1, 2, 3, 4, 5]
d = 2

Step 1:
Reverse first d elements
[2, 1, 3, 4, 5]

Step 2:
Reverse remaining elements
[2, 1, 5, 4, 3]

Step 3:
Reverse whole array
[3, 4, 5, 1, 2]

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {

    // Function to reverse array from start to end
    static void reverse(int[] arr, int start, int end) {

        while (start < end) {

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    // Function to rotate array
    static void rotateArr(int arr[], int d) {

        int n = arr.length;

        // Handle cases where d > n
        d = d % n;

        // Step 1: Reverse first d elements
        reverse(arr, 0, d - 1);

        // Step 2: Reverse remaining elements
        reverse(arr, d, n - 1);

        // Step 3: Reverse whole array
        reverse(arr, 0, n - 1);
    }
}