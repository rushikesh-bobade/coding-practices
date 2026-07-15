# Merge Intervals

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of `intervals` where `intervals[i] = [starti, endi]`, merge all overlapping intervals, and return  *an array of the non-overlapping intervals that cover all the intervals in the input*.

 

 **Example 1:** 

```
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

```

 **Example 2:** 

```
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

```

 **Example 3:** 

```
Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping.

```

 

 **Constraints:** 

- 1 <= intervals.length <= 104
- intervals[i].length == 2
- 0 <= starti <= endi <= 104

## Solution

**Language:** Java  
**Runtime:** 12 ms (beats 9.93%)  
**Memory:** 49 MB (beats 74.90%)  
**Submitted:** 2026-07-15T12:14:59.564Z  

```java
class Solution {
    public int[][] merge(int[][] intervals) {
//More optimal

    List<int[]>list=new ArrayList<>();

    Arrays.sort(intervals,Comparator.comparingInt(o->o[0]));

    int row=0;
    int start=intervals[0][0];
    int lastend=intervals[0][1];

    for(int i=1;i<intervals.length;i++){
        if(intervals[i][0]<=lastend){
            lastend=Math.max(lastend,intervals[i][1]);
        }else{
            list.add(new int []{start,lastend});
            start=intervals[i][0];
            lastend=intervals[i][1];
        }
    }

    list.add(new int[]{start,lastend});

return list.toArray(new int[0][]);





            // less optimal
    //     Arrays.sort(intervals,Comparator.comparingDouble(o->o[0]));

    //     int ans[][]=new int[intervals.length][2];
    //     int row=0;

    //     int start=intervals[0][0];
    //     int lastend=intervals[0][1];

    //     for(int i=1;i<intervals.length;i++){

    //         if(intervals[i][0]<=lastend){
    //             lastend=Math.max(lastend,intervals[i][1]);
    //         }else{ 
    //             ans[row][0]=start;
    //             ans[row][1]=lastend;
    //             row++;

    //             start=intervals[i][0];
    //             lastend=intervals[i][1];
    //         }

    //     }

    // // Save the last interval
    //     ans[row][0]=start;
    //     ans[row][1]=lastend;
    //     row++;
        

    // return Arrays.copyOf(ans, row);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/merge-intervals/)