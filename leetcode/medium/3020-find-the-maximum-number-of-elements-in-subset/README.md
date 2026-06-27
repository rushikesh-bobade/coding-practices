# Find the Maximum Number of Elements in Subset

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an array of  **positive**  integers `nums`.

You need to select a subset of `nums` which satisfies the following condition:

- You can place the selected elements in a 0-indexed array such that it follows the pattern: [x, x2, x4,..., xk/2, xk, xk/2,..., x4, x2, x] (Note that k can be be any non-negative power of 2). For example, [2, 4, 16, 4, 2] and [3, 9, 3] follow the pattern while [2, 4, 8, 4, 2] does not.

Return  *the  **maximum**  number of elements in a subset that satisfies these conditions.* 

 

 **Example 1:** 

```
Input: nums = [5,4,1,2,2]
Output: 3
Explanation: We can select the subset {4,2,2}, which can be placed in the array as [2,4,2] which follows the pattern and 22 == 4. Hence the answer is 3.

```

 **Example 2:** 

```
Input: nums = [1,3,2,4]
Output: 1
Explanation: We can select the subset {1}, which can be placed in the array as [1] which follows the pattern. Hence the answer is 1. Note that we could have also selected the subsets {2}, {3}, or {4}, there may be multiple subsets which provide the same answer. 

```

 

 **Constraints:** 

- 2 <= nums.length <= 105
- 1 <= nums[i] <= 109

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 42.5 MB  
**Submitted:** 2026-06-27T19:05:18.300Z  

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumLength(int[] nums) {

        Map<Long, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put((long) num, freq.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        // Handle 1 separately
        if (freq.containsKey(1L)) {
            int count = freq.get(1L);
            ans = Math.max(ans, (count % 2 == 0) ? count - 1 : count);
        }

        for (long start : freq.keySet()) {

            if (start == 1L) continue;

            long curr = start;
            int len = 0;

            while (true) {

                int count = freq.getOrDefault(curr, 0);

                if (count < 2) {
                    if (count == 1) {
                        len++;
                    } else if (len > 0) {
                        len--;
                    }
                    break;
                }

                // We have at least two copies
                len += 2;

                // Prevent overflow
                if (curr > (long) Math.sqrt(Long.MAX_VALUE)) {
                    len--;
                    break;
                }

                long next = curr * curr;

                // Can't continue the chain
                if (!freq.containsKey(next)) {
                    len--;
                    break;
                }

                curr = next;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/)