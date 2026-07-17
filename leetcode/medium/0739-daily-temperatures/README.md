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

**Language:** Java  
**Runtime:** 63 ms (beats 50.41%)  
**Memory:** 107.7 MB (beats 23.23%)  
**Submitted:** 2026-07-17T12:44:48.270Z  

```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int result[]=new int[n];

        Stack<Integer>st=new Stack<>();

        for(int i=0;i<n;i++){

            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                int idx=st.pop();
                result[idx]=i-idx;
            }
            st.push(i);
        }


        return result;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/daily-temperatures/)