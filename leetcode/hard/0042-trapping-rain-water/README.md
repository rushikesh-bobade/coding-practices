# Trapping Rain Water

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given `n` non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining.

 

 **Example 1:** 

```
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

```

 **Example 2:** 

```
Input: height = [4,2,0,3,2,5]
Output: 9

```

 

 **Constraints:** 

- n == height.length
- 1 <= n <= 2 * 104
- 0 <= height[i] <= 105

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 42.3 MB  
**Submitted:** 2026-06-28T20:35:42.458Z  

```java
class Solution {
    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left < right) {

            if (height[left] <= height[right]) {

                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
                left++;

            } else {

                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
                right--;
            }
        }

        return water;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/trapping-rain-water/)