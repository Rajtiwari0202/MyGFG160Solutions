import java.util.*;

/*
Problem: Minimize the Heights II
Platform: GeeksforGeeks - GFG 160
Difficulty: Medium

Intuition:
Each tower must be either increased by k or decreased by k.

To minimize the difference between max and min height:
- Small towers should generally be increased
- Large towers should generally be decreased

So first sort the array.

Then try every possible partition:
- elements from 0 to i-1 are increased by k
- elements from i to n-1 are decreased by k

For each partition, calculate possible minimum and maximum.

Approach:
1. Sort the array.
2. Initial answer = arr[n - 1] - arr[0]
3. Smallest possible height = arr[0] + k
4. Largest possible height = arr[n - 1] - k
5. Traverse from i = 1 to n - 1:
   - arr[i - 1] + k may become max
   - arr[i] - k may become min
6. Skip if arr[i] - k becomes negative.
7. Update answer.

Time Complexity: O(N log N)
Space Complexity: O(1)
*/

class Solution {
    int getMinDiff(int[] arr, int k) {
        int n = arr.length;

        Arrays.sort(arr);

        int ans = arr[n - 1] - arr[0];

        for (int i = 1; i < n; i++) {

            // Height cannot become negative
            if (arr[i] - k < 0) {
                continue;
            }

            int minHeight = Math.min(arr[0] + k, arr[i] - k);
            int maxHeight = Math.max(arr[i - 1] + k, arr[n - 1] - k);

            ans = Math.min(ans, maxHeight - minHeight);
        }

        return ans;
    }
}