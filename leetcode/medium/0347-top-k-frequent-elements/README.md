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
**Runtime:** 2 ms  
**Memory:** 42.8 MB  
**Submitted:** 2026-06-27T17:35:50.805Z  

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer>freqMpp=new HashMap<>();

        for(int num:nums){
            freqMpp.put(num,freqMpp.getOrDefault(num,0)+1);

        // if (freqMpp.containsKey(num)) {
        // freqMpp.put(num, freqMpp.get(num) + 1);
        // } else {
        //     freqMpp.put(num, 1);
        // }
        }

            PriorityQueue<Integer> queue = new PriorityQueue<>(
            (a, b) -> freqMpp.get(a) - freqMpp.get(b)
        );

        for (int num : freqMpp.keySet()) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] result = new int[queue.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = queue.poll();
        }
        return result;

        // HashMap <Integer,Integer> freqMpp=new HashMap<>();
        // List<Integer>[]bucket=new List[nums.length+1];
        
        // for(int num:nums){
        //     freqMpp.put(num,freqMpp.getOrDefault(num,0)+1);
        // }

        // for(int key:freqMpp.keySet()){
        //     int freq=freqMpp.get(key);
        //     if(bucket[freq]==null){
        //         bucket[freq]=new ArrayList<>();
        //     }

        //     bucket[freq].add(key);
        // }

        // int []ans=new int[k];
        // int counter=0;

        // for(int pos=nums.length;pos>0 && counter<k; pos--){
        //     if(bucket[pos]!=null){
        //         for(int n:bucket[pos]){
        //         ans[counter++]=n;
        //         if(counter==k) break;
        //         }   
        //     }
        // }
        // return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/top-k-frequent-elements/)