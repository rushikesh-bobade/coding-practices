# Missing And Repeating

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an unsorted array  **arr[]** of size  **n**, containing elements from the range  **1** to **n**, it is known that one number in this range is  **missing**, and another number  **occurs twice**  in the array, find both the  **duplicate** number and the  **missing** number.

**Examples:
**

```
Input: arr[] = [2, 2]
Output: [2, 1]
Explanation: Repeating number is 2 and the missing number is 1.
```

```
Input: arr[] = [1, 3, 3] 
Output: [3, 2]
Explanation: Repeating number is 3 and the missing number is 2.
```

```
Input: arr[] = [4, 3, 6, 2, 1, 1]
Output: [1, 5]
Explanation: Repeating number is 1 and the missing number is 5.
```

 **Constraints:** 
2 ≤ n ≤ 106
1 ≤ arr[i] ≤ n

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-06-26T14:34:32.910Z  

```java
import java.util.*;
import java.util.*;

class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
       ArrayList<Integer>ans=new ArrayList<>();
       HashSet<Integer>set=new HashSet<>();
       int min=Integer.MAX_VALUE;
       
       for(int i=0;i<arr.length;i++){
           if(set.contains(arr[i])){
               ans.add(arr[i]);
           }else{
               set.add(arr[i]);
           }
           
           if(arr[i]<min){
               min=arr[i];
           }
           
       }
       
       for(int i=0;i<arr.length-1;i++){
           
           if(!set.contains(1)){
               ans.add(1);
               return ans;
           }
           
           if(set.contains(min+1)){
              min++; 
           }else{
               ans.add(min+1);
               return ans;
           }
       }
       
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1)