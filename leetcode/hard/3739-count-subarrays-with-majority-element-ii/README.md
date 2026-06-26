# Count Subarrays With Majority Element II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an integer array `nums` and an integer `target`.

Return the number of  **subarrays**  of `nums` in which `target` is the  **majority element**.

The  **majority element**  of a subarray is the element that appears  **strictly more than half**  of the times in that subarray.

 

 **Example 1:** 

 **Input:**  nums = [1,2,2,3], target = 2

 **Output:**  5

 **Explanation:** 

Valid subarrays with `target = 2` as the majority element:

- nums[1..1] = [2]
- nums[2..2] = [2]
- nums[1..2] = [2,2]
- nums[0..2] = [1,2,2]
- nums[1..3] = [2,2,3]

So there are 5 such subarrays.

 **Example 2:** 

 **Input:**  nums = [1,1,1,1], target = 1

 **Output:**  10

 **Explanation:** 

 **​​​​​​​** All 10 subarrays have 1 as the majority element.

 **Example 3:** 

 **Input:**  nums = [1,2,3], target = 4

 **Output:**  0

 **Explanation:** 

`target = 4` does not appear in `nums` at all. Therefore, there cannot be any subarray where 4 is the majority element. Hence the answer is 0.

 

 **Constraints:** 

- 1 <= nums.length <= 10​​​​​​​5
- 1 <= nums[i] <= 10​​​​​​​9
- 1 <= target <= 109

## Solution

**Language:** Java  
**Runtime:** 47 ms (beats 37.71%)  
**Memory:** 115.9 MB (beats 19.67%)  
**Submitted:** 2026-06-26T19:10:32.341Z  

```java
import java.util.*;

class Solution {

    static class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 2];
        }

        void update(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;

        // Prefix sums
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        // Coordinate Compression
        int[] sorted = prefix.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> compress = new HashMap<>();

        int id = 1;
        for (int x : sorted) {
            if (!compress.containsKey(x)) {
                compress.put(x, id++);
            }
        }

        Fenwick bit = new Fenwick(id + 2);

        long ans = 0;

        for (int x : prefix) {

            int idx = compress.get(x);

            // Count previous prefix sums smaller than current
            ans += bit.query(idx - 1);

            bit.update(idx, 1);
        }

        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/count-subarrays-with-majority-element-ii/)