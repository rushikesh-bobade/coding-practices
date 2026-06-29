# Valid Palindrome

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

A phrase is a  **palindrome**  if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string `s`, return `true` *if it is a  **palindrome**, or* `false` *otherwise*.

 

 **Example 1:** 

```
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

```

 **Example 2:** 

```
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

```

 **Example 3:** 

```
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

```

 

 **Constraints:** 

- 1 <= s.length <= 2 * 105
- s consists only of printable ASCII characters.

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 42.2 MB  
**Submitted:** 2026-06-29T18:00:37.347Z  

```java
class Solution {
    public boolean isPalindrome(String s) {
        
        int l=0;
        int r=s.length()-1;

        while(l<r){

            while(!Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }

            while(!Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }

            if(Character.toLowerCase(s.charAt(l))!=Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++;
            r--;
        }

        return true;


        //Brute force approach using String Builder
        // StringBuilder str=new StringBuilder();
        // for(char c:s.toCharArray()){
        //     if(Character.isLetterOrDigit(c)){
        //         str.append(Character.toLowerCase(c));
        //     }
        // }

        // String str1=str.toString();
        // String str2=str.reverse().toString();

        // return str1.equals(str2);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/valid-palindrome/)