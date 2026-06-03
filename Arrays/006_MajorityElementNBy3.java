import java.util.*;

/*
Problem: Majority Element - More Than n/3
Platform: GeeksforGeeks - GFG 160
Difficulty: Medium

Intuition:
An element is majority if it appears more than floor(n/3) times.

Important observation:
There can be at most 2 elements that appear more than n/3 times.

Why?
If there were 3 such elements, total count would become more than n,
which is impossible.

So we use the extended Boyer-Moore Voting Algorithm.

Approach:
1. Find two possible candidates.
2. Count their actual frequencies.
3. Add only valid candidates to answer.
4. Sort the answer.

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        int n = arr.length;

        int candidate1 = 0;
        int candidate2 = 0;

        int count1 = 0;
        int count2 = 0;

        // Step 1: Find possible candidates
        for (int num : arr) {

            if (num == candidate1) {
                count1++;
            } 
            else if (num == candidate2) {
                count2++;
            } 
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } 
            else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } 
            else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify candidates
        count1 = 0;
        count2 = 0;

        for (int num : arr) {
            if (num == candidate1) {
                count1++;
            } 
            else if (num == candidate2) {
                count2++;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        if (count1 > n / 3) {
            ans.add(candidate1);
        }

        if (count2 > n / 3) {
            ans.add(candidate2);
        }

        Collections.sort(ans);

        return ans;
    }
}