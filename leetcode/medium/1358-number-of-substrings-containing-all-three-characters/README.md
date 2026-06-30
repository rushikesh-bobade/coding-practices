# Number of Substrings Containing All Three Characters

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s` consisting only of characters  *a*,  *b*  and  *c*.

Return the number of substrings containing  **at least**  one occurrence of all these characters  *a*,  *b*  and  *c*.

 

 **Example 1:** 

```
Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 

```

 **Example 2:** 

```
Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 

```

 **Example 3:** 

```
Input: s = "abc"
Output: 1

```

 

 **Constraints:** 

- 3 <= s.length <= 5 x 10^4
- s only consists of a, b or c characters.

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 42.6 MB  
**Submitted:** 2026-06-30T19:02:44.532Z  

```java
class Solution {
    public int numberOfSubstrings(String s) {
        int[] last = {-1, -1, -1};
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
            ans += Math.min(last[0], Math.min(last[1], last[2])) + 1;
        }

        return ans;
    }
}


/*
class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] freq = new int[3];

        int left = 0;
        int ans = 0;

        for (int right = 0; right < n; right++) {
            freq[s.charAt(right) - 'a']++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                ans += (n - right);
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return ans;
    }
}
*/
```

---

[View on LeetCode](https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/)