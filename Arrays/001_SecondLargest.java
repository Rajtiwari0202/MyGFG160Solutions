/*
Problem: Second Largest
Platform: GeeksforGeeks - GFG 160
Difficulty: Easy

Intuition:
We need the second largest distinct element.
The second largest should not be equal to the largest.

So we maintain two variables:
1. largest
2. secondLargest

Whenever we find a number bigger than largest:
- current largest becomes secondLargest
- current number becomes largest

Whenever we find a number smaller than largest but bigger than secondLargest:
- update secondLargest

Approach:
- Initialize largest = -1
- Initialize secondLargest = -1
- Traverse the array once
- Update largest and secondLargest carefully
- Return secondLargest

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    public int getSecondLargest(int[] arr) {
        int largest = -1;
        int secondLargest = -1;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } 
            else if (num < largest && num > secondLargest) {
                secondLargest = num;
            }
        }

        return secondLargest;
    }
}