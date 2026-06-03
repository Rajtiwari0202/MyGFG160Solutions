/*
Problem: Reverse an Array
Platform: GeeksforGeeks - GFG 160
Difficulty: Easy

Intuition:
To reverse an array in-place, we swap elements from both ends.

- First element swaps with last
- Second swaps with second last
- Continue until pointers meet

This avoids using extra space.

Approach:
1. Use two pointers:
   - left = 0
   - right = n - 1

2. While left < right:
   - swap arr[left] and arr[right]
   - move left forward
   - move right backward

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    public void reverseArray(int arr[]) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            // swap
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}