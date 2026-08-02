# Subarray Sum Equals K

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of integers `nums` and an integer `k`, return  *the total number of subarrays whose sum equals to*  `k`.

A subarray is a contiguous  **non-empty**  sequence of elements within an array.

 

 **Example 1:** 

```
Input: nums = [1,1,1], k = 2
Output: 2

```

 **Example 2:** 

```
Input: nums = [1,2,3], k = 3
Output: 2

```

 

 **Constraints:** 

- 1 <= nums.length <= 2 * 104
- -1000 <= nums[i] <= 1000
- -107 <= k <= 107

## Solution

**Language:** Java  
**Runtime:** 23 ms (beats 93.57%)  
**Memory:** 48.8 MB (beats 46.46%)  
**Submitted:** 2026-08-02T13:14:19.960Z  

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum=0;
        int count=0;

        HashMap<Integer,Integer>mpp=new HashMap<>();
        mpp.put(0,1);

        for(int num:nums){
            prefixSum+=num;
            if(mpp.containsKey(prefixSum-k)){
                count+=mpp.get(prefixSum-k);
            }
        mpp.put(prefixSum,mpp.getOrDefault(prefixSum,0)+1);
        }


        return count;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/subarray-sum-equals-k/)