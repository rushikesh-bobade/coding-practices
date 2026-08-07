# Reverse String

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Write a function that reverses a string. The input string is given as an array of characters `s`.

You must do this by modifying the input array in-place with `O(1)` extra memory.

 

 **Example 1:** 

```
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

```

 **Example 2:** 

```
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

```

 

 **Constraints:** 

- 1 <= s.length <= 105
- s[i] is a printable ascii character.

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 48.4 MB (beats 38.38%)  
**Submitted:** 2026-08-07T11:38:31.426Z  

```java
class Solution {
    public void reverseString(char[] s) {


        int l=0;
        int r=s.length-1;

        while(l<r){
            char temp=s[l];
            s[l]=s[r];
            s[r]=temp;

            l++;
            r--;
        }

        // for(int i=0;i<s.length/2;i++){
        //     char a=s[i];
        //     s[i]=s[s.length-1-i];
        //     s[s.length-1-i]=a;
        // }


        // int j=s.length-1;
        // for(int i=0;i<s.length/2;i++){
        //     char a=s[i];
        //     s[i]=s[j];
        //     s[j]=a;
        //     j--;
        //}
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/reverse-string/)