# Pascal's Triangle

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an integer `numRows`, return the first numRows of  **Pascal's triangle**.

In  **Pascal's triangle**, each number is the sum of the two numbers directly above it as shown:

 

 **Example 1:** 

```
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

```

 **Example 2:** 

```
Input: numRows = 1
Output: [[1]]

```

 

 **Constraints:** 

- 1 <= numRows <= 30

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 43.7 MB (beats 15.76%)  
**Submitted:** 2026-07-12T20:28:41.206Z  

```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();

        for(int i=1;i<=numRows;i++){
            ans.add(generateRow(i));
        }

        return ans;
    }

    public List<Integer> generateRow(int n){
        List<Integer>temp=new ArrayList<>();
        long res=1;
        
        temp.add(1);
        for(int i=1;i<n;i++){
            res=res*(n-i);
            res=res/i;
            temp.add((int)res);
        }
        return temp;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/pascals-triangle/)