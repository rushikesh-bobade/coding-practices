# GCD of Odd and Even Sums

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given an integer `n`. Your task is to compute the  **GCD**  (greatest common divisor) of two values:

- sumOdd: the sum of the smallest n positive odd numbers.
- sumEven: the sum of the smallest n positive even numbers.

Return the GCD of `sumOdd` and `sumEven`.

 

 **Example 1:** 

 **Input:**  n = 4

 **Output:**  4

 **Explanation:** 

- Sum of the first 4 odd numbers sumOdd = 1 + 3 + 5 + 7 = 16
- Sum of the first 4 even numbers sumEven = 2 + 4 + 6 + 8 = 20

Hence, `GCD(sumOdd, sumEven) = GCD(16, 20) = 4`.

 **Example 2:** 

 **Input:**  n = 5

 **Output:**  5

 **Explanation:** 

- Sum of the first 5 odd numbers sumOdd = 1 + 3 + 5 + 7 + 9 = 25
- Sum of the first 5 even numbers sumEven = 2 + 4 + 6 + 8 + 10 = 30

Hence, `GCD(sumOdd, sumEven) = GCD(25, 30) = 5`.

 

 **Constraints:** 

- 1 <= n <= 10​​​​​​​00

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 83.11%)  
**Memory:** 42.9 MB (beats 6.12%)  
**Submitted:** 2026-07-15T16:06:18.531Z  

```java
class Solution {
    public int gcdOfOddEvenSums(int n) {
        //more ooptimal
        int sumOdd=n*n;
        int sumEven=n*(n+1);


        //less optimal
        // int sumOdd=0;
        // int sumEven=0;
        // int na=2*n;
        // int i=1;
        // while(na>0){
        //     if(i%2!=0){
        //         sumOdd+=i;
        //     }else{
        //         sumEven+=i;
        //     }
        //     i++;
        //     na--;
        // }

        return gcd(sumOdd,sumEven);
    }

    public int gcd(int a,int b){
    
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/gcd-of-odd-and-even-sums/)