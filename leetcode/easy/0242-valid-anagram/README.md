# Valid Anagram

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.

 

 **Example 1:** 

 **Input:**  s = "anagram", t = "nagaram"

 **Output:**  true

 **Example 2:** 

 **Input:**  s = "rat", t = "car"

 **Output:**  false

 

 **Constraints:** 

- 1 <= s.length, t.length <= 5 * 104
- s and t consist of lowercase English letters.

 

 **Follow up:**  What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

## Solution

**Language:** Java  
**Runtime:** 5 ms (beats 61.66%)  
**Memory:** 44.4 MB (beats 75.04%)  
**Submitted:** 2026-07-28T09:33:12.677Z  

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }


        //Approach 1 : TC=O(N log n),SC=O(N)
        // char [] sArr=s.toCharArray();
        // char [] tArr=t.toCharArray();

        // Arrays.sort(sArr); //O(n log n)
        // Arrays.sort(tArr); 

        // // for(int i=0;i<s.length();i++){
        // //     if(sArr[i]!=tArr[i]){
        // //         return false;
        // //     }
        // // }
        // // return true;
        // return Arrays.equals(sArr,tArr);

        //Approach 2 : TC=O(N); SC:O(1)
        char []arr=new char[26];

        for(int i=0;i<t.length();i++){
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                return false;
            }
        }
        return true;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/valid-anagram/)