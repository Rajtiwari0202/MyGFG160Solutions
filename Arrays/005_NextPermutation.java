/*
Problem: Next Permutation
Platform: GeeksforGeeks - GFG 160
Difficulty: Medium

Intuition:
We need the next lexicographically greater arrangement.

To make the number just slightly bigger:
1. Find the first decreasing element from the right.
2. Swap it with the next greater element from the right.
3. Reverse the right part to make it smallest possible.

Example:
[2, 4, 1, 7, 5, 0]

From right, find arr[i] < arr[i + 1]
1 < 7, so pivot = 1

Find element greater than 1 from right:
5 > 1

Swap:
[2, 4, 5, 7, 1, 0]

Reverse after pivot:
[2, 4, 5, 0, 1, 7]

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {

    void nextPermutation(int[] arr) {
        int n = arr.length;

        int pivot = -1;

        // Step 1: Find pivot
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                pivot = i;
                break;
            }
        }

        // If no pivot exists, array is in descending order
        if (pivot == -1) {
            reverse(arr, 0, n - 1);
            return;
        }

        // Step 2: Find next greater element from right
        for (int i = n - 1; i > pivot; i--) {
            if (arr[i] > arr[pivot]) {
                swap(arr, i, pivot);
                break;
            }
        }

        // Step 3: Reverse suffix
        reverse(arr, pivot + 1, n - 1);
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void reverse(int[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }
}