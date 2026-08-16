# House Robber

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and  **it will automatically contact the police if two adjacent houses were broken into on the same night**.

Given an integer array `nums` representing the amount of money of each house, return  *the maximum amount of money you can rob tonight  **without alerting the police***.

 

 **Example 1:** 

```
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

```

 **Example 2:** 

```
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

```

 

 **Constraints:** 

- 1 <= nums.length <= 100
- 0 <= nums[i] <= 400

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 42.6 MB  
**Submitted:** 2026-08-16T15:47:21.698Z  

```java
//Maximum sum of non-adjacent elements

class Solution {
    public int rob(int[] nums) {
        // int prev2 = 0;
        // int prev1 = 0;
        // for (int n : nums) {
        //     int curr = Math.max(prev1, prev2 + n);
        //     prev2 = prev1;
        //     prev1 = curr;
        // }
        // return prev1;

        int n=nums.length;
        ArrayList<Integer>dp=new ArrayList<>(Collections.nCopies(n,-1));
        return f(n-1,nums,dp);
    }

    public int f(int idx, int[] nums, ArrayList<Integer> dp) {
        if (idx == 0)
            return nums[0];
        if (idx < 0)
            return 0;

        if (dp.get(idx) != -1) {
            return dp.get(idx);
        }
        int pick = nums[idx] + f(idx - 2, nums, dp);
        int notPick = 0 + f(idx - 1, nums, dp);

        dp.set(idx, Math.max(pick, notPick));
        return dp.get(idx);
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/house-robber/)