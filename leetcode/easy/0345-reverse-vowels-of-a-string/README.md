# Reverse Vowels of a String

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a string `s`, reverse only all the vowels in the string and return it.

The vowels are `'a'`, `'e'`, `'i'`, `'o'`, and `'u'`, and they can appear in both lower and upper cases, more than once.

 

 **Example 1:** 

 **Input:**  s = "IceCreAm"

 **Output:**  "AceCreIm"

 **Explanation:** 

The vowels in `s` are `['I', 'e', 'e', 'A']`. On reversing the vowels, s becomes `"AceCreIm"`.

 **Example 2:** 

 **Input:**  s = "leetcode"

 **Output:**  "leotcede"

 

 **Constraints:** 

- 1 <= s.length <= 3 * 105
- s consist of printable ASCII characters.

## Solution

**Language:** Java  
**Runtime:** 5 ms (beats 21.46%)  
**Memory:** 46.9 MB (beats 21.89%)  
**Submitted:** 2026-08-07T11:28:01.558Z  

```java
class Solution {
    public String reverseVowels(String s) {
        HashSet<Character>set=new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));

        char ch[]=s.toCharArray();
        int l=0;
        int r=s.length()-1;

        while(l<r){
            while(l<r && !set.contains(ch[l])){
                l++;
            }

            while(l<r && !set.contains(ch[r])){
                r--;
            }

            char temp=ch[l];
            ch[l]=ch[r];
            ch[r]=temp;

            l++;
            r--;
        }

        return new String(ch);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/reverse-vowels-of-a-string/)