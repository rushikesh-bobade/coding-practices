# Top K Frequent Elements

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums` and an integer `k`, return  *the*  `k`  *most frequent elements*. You may return the answer in  **any order**.

 

 **Example 1:** 

 **Input:**  nums = [1,1,1,2,2,3], k = 2

 **Output:**  [1,2]

 **Example 2:** 

 **Input:**  nums = [1], k = 1

 **Output:**  [1]

 **Example 3:** 

 **Input:**  nums = [1,2,1,2,1,2,3,1,3,2], k = 2

 **Output:**  [1,2]

 

 **Constraints:** 

- 1 <= nums.length <= 105
- -104 <= nums[i] <= 104
- k is in the range [1, the number of unique elements in the array].
- It is guaranteed that the answer is unique.

 

 **Follow up:**  Your algorithm's time complexity must be better than `O(n log n)`, where n is the array's size.

## Solution

**Language:** Java  
**Runtime:** 15 ms (beats 55.09%)  
**Memory:** 47.7 MB (beats 33.09%)  
**Submitted:** 2026-09-24T17:21:34.891Z  

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

       HashMap<Integer,Integer>mpp=new HashMap<>();

       for(int num:nums){
        mpp.put(num,mpp.getOrDefault(num,0)+1);
       }

       PriorityQueue<Integer>pq=new PriorityQueue<>(
        (a,b)->mpp.get(a)-mpp.get(b)
       );

       for(int num:mpp.keySet()){
        pq.offer(num);
        if(pq.size()>k){
            pq.poll();
        }
       }

       int ans[]=new int[k];
       for(int i=0;i<k;i++){
        ans[i]=pq.poll();
       }

       return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/top-k-frequent-elements/)