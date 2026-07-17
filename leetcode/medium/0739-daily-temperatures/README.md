# Daily Temperatures

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of integers `temperatures` represents the daily temperatures, return  *an array*  `answer`  *such that*  `answer[i]`  *is the number of days you have to wait after the*  `ith`  *day to get a warmer temperature*. If there is no future day for which this is possible, keep `answer[i] == 0` instead.

 

 **Example 1:** 

```
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

```

 **Example 2:** 

```
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]

```

 **Example 3:** 

```
Input: temperatures = [30,60,90]
Output: [1,1,0]

```

 

 **Constraints:** 

- 1 <= temperatures.length <= 105
- 30 <= temperatures[i] <= 100

## Solution

**Language:** Python  
**Runtime:** 123 ms (beats 19.71%)  
**Memory:** 35.9 MB (beats 8.97%)  
**Submitted:** 2026-07-17T12:57:55.256Z  

```py
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        res=[0]*len(temperatures)
        stack=[] #pair:[temp,index]

        for i,t in enumerate(temperatures):
            while stack and t>stack[-1][0]:
                stackT,stackInd=stack.pop()
                res[stackInd]=(i-stackInd)
            stack.append([t,i])
        return res
```

---

[View on LeetCode](https://leetcode.com/problems/daily-temperatures/)