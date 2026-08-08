# Largest Rectangle in Histogram

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given an array of integers `heights` representing the histogram's bar height where the width of each bar is `1`, return  *the area of the largest rectangle in the histogram*.

 

 **Example 1:** 

```
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

```

 **Example 2:** 

```
Input: heights = [2,4]
Output: 4

```

 

 **Constraints:** 

- 1 <= heights.length <= 105
- 0 <= heights[i] <= 104

## Solution

**Language:** Java  
**Runtime:** 23 ms (beats 93.39%)  
**Memory:** 81.2 MB (beats 17.45%)  
**Submitted:** 2026-08-08T18:41:31.066Z  

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
    int n=heights.length;
    int maxArea=0;

    Deque<Integer>stack=new ArrayDeque<>();

    for(int i=0;i<=n;i++){
        int currHt=(i==heights.length)?0:heights[i];

        while(!stack.isEmpty() && currHt < heights[stack.peek()]){
            int height=heights[stack.pop()];
            int pse=stack.isEmpty()?-1:stack.peek();
            int width=i-pse-1;;
            maxArea=Math.max(maxArea, height*width);
        }
        stack.push(i);

    }
    return maxArea;
   }
}

```

---

[View on LeetCode](https://leetcode.com/problems/largest-rectangle-in-histogram/)