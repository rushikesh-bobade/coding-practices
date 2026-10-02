# Container With Most Water

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `ith` line are `(i, 0)` and `(i, height[i])`.

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return  *the maximum amount of water a container can store*.

 **Notice**  that you may not slant the container.

 

 **Example 1:** 

```
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

```

 **Example 2:** 

```
Input: height = [1,1]
Output: 1

```

 

 **Constraints:** 

- n == height.length
- 2 <= n <= 105
- 0 <= height[i] <= 104

## Solution

**Language:** Java  
**Runtime:** 5 ms (beats 82.58%)  
**Memory:** 77.4 MB (beats 48.93%)  
**Submitted:** 2026-10-02T20:19:38.836Z  

```java
class Solution {
    public int maxArea(int[] height) {
        int most=0;
        int left=0,right=height.length-1;

       while(left<right){
        int h=Math.min(height[left],height[right]);
        int w= right-left;
        int area=h*w;
        most=Math.max(area,most);

        if(height[left]<height[right]){
            left++;
        }else{
            right --;
        }
       }





        //Brute force approach
        // for(int i=0;i<height.length;i++){
        //     for(int j=i+1;j<height.length;j++){
        //         int heightt = Math.min(height[i],height[j]);
        //         int width=j-i;
        //         int count=heightt*width;
        //         most=Math.max(count,most);
        //     }
            
        // }
        return most;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/container-with-most-water/)