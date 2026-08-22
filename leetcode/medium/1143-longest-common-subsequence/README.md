# Longest Common Subsequence

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given two strings `text1` and `text2`, return  *the length of their longest  **common subsequence**.* If there is no  **common subsequence**, return `0`.

A  **subsequence**  of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

- For example, "ace" is a subsequence of "abcde".

A  **common subsequence**  of two strings is a subsequence that is common to both strings.

 

 **Example 1:** 

```
Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.

```

 **Example 2:** 

```
Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

```

 **Example 3:** 

```
Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

```

 

 **Constraints:** 

- 1 <= text1.length, text2.length <= 1000
- text1 and text2 consist of only lowercase English characters.

## Solution

**Language:** Java  
**Runtime:** 26 ms (beats 25.89%)  
**Memory:** 53.8 MB (beats 69.58%)  
**Submitted:** 2026-08-22T19:15:46.313Z  

```java
//Memoization

class Solution {
    int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        dp=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return f(n-1,m-1,text1,text2);
    }

    public int f(int n,int m, String s, String t){

        //Base case :if n or m becames less and goes to negative while decreaseing i.e. triming
        if(n<0||m<0){
            return 0;
        }

        if(dp[n][m]!=-1){ //if already existed in the dp
            return dp[n][m];
        }

        if(s.charAt(n)==t.charAt(m)){//if matched
            dp[n][m]=1+f(n-1,m-1,s,t);
        }else{
            dp[n][m]=Math.max(f(n-1,m,s,t),f(n,m-1,s,t));//if not matched
        }

        return dp[n][m];
    }
}





// Tabulation Method
// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length(), m = text2.length();
//         int[][] dp = new int[n + 1][m + 1];
//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= m; j++) {
//                 if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
//                     dp[i][j] = dp[i - 1][j - 1] + 1;
//                 } else {
//                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                 }
//             }
//         }
//         return dp[n][m];
//     }
// }

```

---

[View on LeetCode](https://leetcode.com/problems/longest-common-subsequence/)